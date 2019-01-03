package com.goat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author yuanqi.jing 返回消息模板DTO
 */
@JsonIgnoreProperties(value={"enMsg"})
public class ValidMessageDTO {

	private boolean valid; // 消息状态
	private String msg; // 消息提示
	private Object data; // 消息数据
	private String fieldId; //
	private String enMsg;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getEnMsg() {
		return enMsg;
	}

	public void setEnMsg(String enMsg) {
		this.enMsg = enMsg;
	}

	/*
	 * public String toJson(){
	 * 
	 * return JSONObject.fromObject(this).toString(); }
	 */

}
