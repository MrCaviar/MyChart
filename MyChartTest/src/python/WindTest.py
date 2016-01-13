# -*- coding: utf-8 -*-
import MySQLdb
from WindPy import w

w.start();
data=w.wsi("600388.SH", "open,high,low,close,volume,amt", "2016-01-13 09:00:00", "2016-01-13 15:00:00", "")
w.close();

if data.ErrorCode == 0:
    t = 0
    j = len(data.Fields)

    print data.Codes
    print data.Fields

    volume_idx = data.Fields.index('volume')
    amt_idx = data.Fields.index('amount')
    values = []
        
    try:
        conn = MySQLdb.connect(host='127.0.0.1',user='root',passwd='root',db='MyChartTest',port=3306)
        cur = conn.cursor()

        conn.set_character_set('utf8')
        for time in data.Times:
            value = [u'龙净环保',data.Codes[0],time]
            print time,
            i = 0
            while i < j:
                print data.Data[i][t],
                value.append(data.Data[i][t])
                i += 1

            #计算某时点均价
            average = data.Data[amt_idx][t] / data.Data[volume_idx][t]
            print average
            value.append(average)

            values.append(value)
            t += 1
            
        cur.executemany('insert into bwsi(sec_name,trade_code,time,open,high,low,close,volume,amt,average) values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)',values)

        conn.commit()
        cur.close()
        conn.close()

    except MySQLdb.Error,e:
        print "Mysql Error %d: %s" % (e.args[0],e.args[1])
