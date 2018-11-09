package com.goat.domain;

/**
 * @ClassName: MesDto
 * @Description: 从mes接口获取信息的dto
 * @author yuanqi.jing
 * @date 2018年1月22日 上午11:51:02
 * 
 */
public class MesDto<T> {

	private T message;
	private boolean result;

	public T getMessage() {
		return message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
