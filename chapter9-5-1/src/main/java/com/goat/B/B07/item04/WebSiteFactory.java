package com.goat.B.B07.item04;

import java.util.HashMap;

/**
 * 网站工厂类
 */
public class WebSiteFactory {

	private HashMap<String, ConcreteWebSite> pool = new HashMap<>();
	
	//获得网站分类
	public WebSite getWebSiteCategory(String key) {
		if(!pool.containsKey(key)) {
			pool.put(key, new ConcreteWebSite(key));
		}
		return pool.get(key);
	}
	
	//获得网站分类总数
	public int getWebSiteCount() {
		return pool.size();
	}
	
}
