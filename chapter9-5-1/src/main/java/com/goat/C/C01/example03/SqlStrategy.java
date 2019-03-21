package com.goat.C.C01.example03;

/** * SQL策略接口  */
public interface SqlStrategy {
	/**
	 * 根据名称数组获取用户组
	 * @param userNames 名称数组
	 * @return
	 */
	String getSQL(String[] userNames);
}
