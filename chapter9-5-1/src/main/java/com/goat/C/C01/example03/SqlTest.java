package com.goat.C.C01.example03;

/*** 测试类*/
public class SqlTest {

	public static void main(String[] args) {
		QueryUtil query = new QueryUtil();
		query.findUserInfos(new String[]{"SQL1","MySQL1","ORACLE1"},new SqlStrategy1());
		query.findUserInfos(new String[]{"SQL2","MySQL2","ORACLE2"},new SqlStrategy2());
	}

}
