package com.goat.C.C01.example03;


/**
 * @author Jeff Lee
 * @since 2015-7-19 19:45:57
 * 数据库操作工具类
 */
public class QueryUtil {
	
	/**
	 * 根据名称数组获取用户组
	 * @param userNames 名称数组
	 * @param sqlStrategy 策略
	 */
	public void findUserInfos(String[] userNames,SqlStrategy sqlStrategy) {
		// 数据库驱动
		// 连接

		// 策略中获取SQL
		String sql = sqlStrategy.getSQL(userNames);
		System.out.println("SQL: " + sql);
		
		// 读数据
		// 封装对象返回
	}
}
