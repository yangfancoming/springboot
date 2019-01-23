package com.goat.C.C01.example03;

/**
 * @author Jeff Lee
 * @since 2015-7-19 19:46:12 {@link}
 * 测试类
 */
public class SqlTest {

	public static void main(String[] args) {
		QueryUtil query = new QueryUtil();
		query.findUserInfos(new String[]{"SQL1","MySQL1","ORACLE1"},new SqlStrategy2());
		query.findUserInfos(new String[]{"SQL2","MySQL2","ORACLE2"},new SqlStrategy2());
	}

}
