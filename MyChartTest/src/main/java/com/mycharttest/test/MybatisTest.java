package com.mycharttest.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mycharttest.pojo.Bwsi;

public class MybatisTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//mybatis鐨勯厤缃枃浠�
        String resource = "conf.xml";
        //浣跨敤绫诲姞杞藉櫒鍔犺浇mybatis鐨勯厤缃枃浠讹紙瀹冧篃鍔犺浇鍏宠仈鐨勬槧灏勬枃浠讹級
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        //鏋勫缓sqlSession鐨勫伐鍘�
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //浣跨敤MyBatis鎻愪緵鐨凴esources绫诲姞杞絤ybatis鐨勯厤缃枃浠讹紙瀹冧篃鍔犺浇鍏宠仈鐨勬槧灏勬枃浠讹級
        //Reader reader = Resources.getResourceAsReader(resource); 
        //鏋勫缓sqlSession鐨勫伐鍘�
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //鍒涘缓鑳芥墽琛屾槧灏勬枃浠朵腑sql鐨剆qlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 鏄犲皠sql鐨勬爣璇嗗瓧绗︿覆锛�
         * me.gacl.mapping.userMapper鏄痷serMapper.xml鏂囦欢涓璵apper鏍囩鐨刵amespace灞炴�鐨勫�锛�
         * getUser鏄痵elect鏍囩鐨刬d灞炴�鍊硷紝閫氳繃select鏍囩鐨刬d灞炴�鍊煎氨鍙互鎵惧埌瑕佹墽琛岀殑SQL
         */
        String statement = "com.mycharttest.mapper.BwsiMapper.queryBwsi";//鏄犲皠sql鐨勬爣璇嗗瓧绗︿覆
        //鎵ц鏌ヨ杩斿洖涓�釜鍞竴user瀵硅薄鐨剆ql
        Bwsi bwsi = session.selectOne(statement, 1);
        System.out.println(bwsi);
	}

}
