package com.goat.C.C01.example03;


/**
 * @author Jeff Lee
 * @since 2015-7-19 19:19:19
 * SQL策略实现类1 
 */
public class SqlStrategy1 implements SqlStrategy {

	@Override
	public String getSQL(String[] userNames) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user_info WHERE ");
		for (String name : userNames) {
			sql.append("username = '");
			sql.append(name);
			sql.append("' OR ");
		}
		// 出去冗余的OR
		sql.delete(sql.length() - " OR ".length() , sql.length());
		return sql.toString();
	}

}
