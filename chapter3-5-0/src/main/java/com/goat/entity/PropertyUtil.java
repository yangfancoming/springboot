package com.goat.entity;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertyUtil {
	
	public static Logger logger = Logger.getLogger(PropertyUtil.class);
	
	/**
	 * 配置文件信息
	 */
	private static Properties props;
	
	/**
	 * 返回配置文件信息
	 * @param key KEY
	 * @return value
	 */
	public static String PropertiesInfo(String key){
		if(props == null){
			props   =  new  Properties();
			try{
				props.load(PropertyUtil.class.getResourceAsStream("/common.properties"));
			}catch(Exception e){
				logger.error("读取配置文件OaInfoConfig.properties出错！");
			}
			if(props.isEmpty()){
			  logger.error("配置文件OaInfoConfig.properties不存在！");
			   return "";
			}
		}
		return props.get(key).toString();

	}
	
	public static void main(String[] args) {
		String str = PropertiesInfo("memAddr");
		System.out.println(str);
	}
}
