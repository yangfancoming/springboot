package com.goat.domain;


import java.io.Serializable;

public class RestResponse<T> implements Serializable {

	/** @Fields serialVersionUID : TODO */
	private static final long serialVersionUID = -3720728948596761669L;

	/** @Fields data : 数据体 */
	private T data;
	/** @Fields code : 返回代码 */
	private String errmsg = "";
	/** @Fields status : 状态，1:失败，0：成功 */
	private String errcode;

	/**
	 * @Title：ok
	 * @Description: 返回正确状态
	 * @date 2015年3月18日 下午1:49:37
	 * @param data
	 * @return
	 */
	public static <T> RestResponse<T> ok() {
		return errCode(ErrCode.OK);
	}

	/**
	 * @Title：ok
	 * @Description: 返回正确状态
	 * @date 2015年3月18日 下午1:49:37
	 * @param data
	 * @return
	 */
	public static <T> RestResponse<T> ok(T data) {
		RestResponse<T> rp = ok();
		rp.setData(data);
		return rp;
	}

	/**
	 * @Title：error
	 * @Description: 返回错误，添加错误代码
	 * @date 2015年3月18日 下午1:49:53
	 * @param code
	 * @return
	 */
	public static <T> RestResponse<T> error(ErrCode errCode) {
		RestResponse<T> rp = errCode(errCode);
		return rp;
	}
	/***
	 * 自己定义错误提示消息,不新加枚举
	 * @author zheng.guo
	 * @param errMsg
	 * @return
	 */
	public static <T> RestResponse<T> error(String errMsg) {
		ErrCode errCode=ErrCode.ERR_MSG_CUSTOM;
		errCode.setMsg(errMsg);
		return error(errCode);
	}

	public static <T> RestResponse<T> errCode(ErrCode errCode) {
		RestResponse<T> rp = new RestResponse<T>();
		rp.setErrmsg(errCode.getMsg());
		rp.setErrcode(errCode.getCode());
		return rp;
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

}
