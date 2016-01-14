# -*- coding: utf-8 -*-
import MySQLdb
import time
from WindPy import w

#数据库连接
conn = ''
cur = ''

#证券编号
trade_code = '600388.SH'
#时间格式
ISOTIMEFORMAT='%Y-%m-%d %X'

#历史最新时间
beginTime = ''
#获取当前时间
endTime = time.strftime(ISOTIMEFORMAT, time.localtime())

try:
    conn = MySQLdb.connect(host='127.0.0.1',user='root',passwd='root',db='MyChartTest',port=3306)
    cur = conn.cursor()

    conn.set_character_set('utf8')

    #获取历史最新时间
    cur.execute("select date_add(max(time), interval 1 minute) from bwsi where trade_code = '" + trade_code + "'" )
    beginTime =  cur.fetchone()[0]

    #调用wind接口
    w.start();
    data=w.wsi(trade_code, "open,high,low,close,volume,amt", beginTime, endTime, "BarSize=1")
    w.close();

    if data.ErrorCode == 0:
        t = 0
        j = len(data.Fields)

        print data.Codes
        print data.Fields

        volume_idx = data.Fields.index('volume')
        amt_idx = data.Fields.index('amount')
        values = []
        for time in data.Times:
            value = [u'龙净环保',data.Codes[0],time]
            print time,
            i = 0
            while i < j:
                print data.Data[i][t],
                value.append(data.Data[i][t])
                i += 1

            #计算某时点均价
            average = data.Data[amt_idx][t] / (data.Data[volume_idx][t] if data.Data[volume_idx][t] != 0 else 1)

            print average
            value.append(average)

            values.append(value)
            t += 1
            
        #数据持久化  
        cur.executemany('insert into bwsi(sec_name,trade_code,time,open,high,low,close,volume,amt,average) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)
        conn.commit()
        
    elif data.ErrorCode == -40520007:
        print u'wind信息:无数据'
    else:
        print u'wind返回错误信息:' + str(data.ErrorCode)

except MySQLdb.Error,e:
    print "Mysql Error %d: %s" % (e.args[0],e.args[1])

finally:
    cur.close()
    conn.close()
    
