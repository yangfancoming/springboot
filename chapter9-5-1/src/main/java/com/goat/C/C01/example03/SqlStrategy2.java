package com.goat.C.C01.example03;


/**
 * SQL策略实现类2
 */
public class SqlStrategy2 implements SqlStrategy {

	@Override
	public String getSQL(String[] userNames) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user_info WHERE ");
		boolean orNeed = false;
		for (String name : userNames) {
			if (orNeed)// WHERE后不需要OR
				sql.append(" OR ");
			sql.append("username = '");
			sql.append(name);
			sql.append("'");
			orNeed = true;
		}
		
		return sql.toString();
	}

}
