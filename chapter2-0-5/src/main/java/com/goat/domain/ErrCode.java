package com.goat.domain;

public enum ErrCode {
	/**
	 * OK
	 */
	OK("0", "OK"),
	/**
	 * 系统错误
	 */
	ERR("10000", "系统错误"),
	/**
	 * 参数错误
	 */
	ERR_ARGUMENT("10002", "参数错误"),
	/**
	 * 传递null值
	 */
	ERR_NULL("10003", "传递null值"),
	
    ERR_PERMISSION("10004", "权限不足"),
	
    ERR_FILE_UPLOAD_ERROR("10005", "文件上传失败"),
    
    ERR_FILE_SAVE_ERROR("10006","保存文件失败。"),
    /**
     * 用户名已存在
     */
    ERR_USER_USERNAME_ERROR("10007","用户名已存在"),
    /**
     * 用户不存在
     */
    ERR_USER_ERROR("10008","用户不存在"),
    /**
     * 新密码与原密码相同
     */
    ERR_USER_NEWPASSWORD_ERROR("10009","新密码与原密码相同"),
    /**
     * 登录密码与支付密码相同
     */
    ERR_USER_LOGINPASSWORD_PAYMENTPASSWORD_ERROR("10010","登录密码与支付密码相同"),
    /**
     * 用户名或密码错误
     */
    ERR_USER_USERNAME_OR_LOGINPASSWORD_ERROR("10011","用户名或密码错误"),
    /**
     * 企业不存在
     */
    ERR_ENTERPRISE_ERROR("10012","企业不存在"),
	   /**
     * 用户没有登录
     */
    ERR_USER_NOT_LOGIN_ERROR("1001","用户没有登录"),
	
    /**
     * 验证码错误
     */
    ERR_CAPTCHA_ERROR("10013","验证码错误"),
    /**
     * 两次输入的登录密码不一致
     */
    ERR_LOGINPASSWORD_NOT_SAME_ERROR("10014","两次输入的登录密码不一致"),
    /**
     * 两次输入的支付密码不一致
     */
    ERR_PAYMENTPASSWORD_NOT_SAME_ERROR("10015","两次输入的支付密码不一致"), 
    /**
     * 原密码输入错误
     */
    ERR_OLDPASSWORD_ERROR("10016","原密码输入错误"), 
    ERR_LOGIN_OUT_TIME("10017","您没有登录，请从新登录"), 
   /**
     * 验证码错误
     */
	ERR_SMSCODE_ERROR("10018","验证码错误"),
    /**
     * 原密码输入错误
     */
	ERR_SMSCODE_ERROR_OUT_TIME("10019","验证码已经过期"),
    /**
     * 此账号未绑定此手机号
     */
    ERR_USERNAME_TEL("10020","此账号未绑定此手机号"),
    /**
     * 请上传图片
     */
    ERR_FILE_NO_UPLOAD_ERROR("10021","请上传图片"), 
    /**
     * 请选择商品
     */
    ERR_CHOOSE_GOODS("10022","请选择商品"), 
    /**
     * 登录账号不可修改
     */
    ERR_USERNAME_CHANGE("10023","登录账号不可修改"),
    /**
     * 订单出现异常状态
     */
    ERR_ORDERID_ERROR("10024","订单出现异常状态"),
    /**
     * 库存不足
     */
    ERR_HAS_INVENTORY_SHORTAGE_ERROR("10025","商品购买数量少于大宗起购量"),
    /**
     * 库存不足
     */
    ERR_INVENTORY_SHORTAGE_ERROR("10032","库存不足"),
    /**
     * 商品不存在
     */
    ERR_COMMODITY_ERROR("10026","商品不存在"),
    /**
     * 订单中含有下架商品
     */
    ERR_HAS_TAKEDOWNS_ERROR("10027","订单中含有下架商品！无法进行支付！"),

    /**
     * 请选择大宗用户
     */
    ERR_CHOOSE_PURCHASE("10028","请选择用户"),
    /**
     * 请选择业务员
     */
    ERR_CHOOSE_PRINCIPAL("10031","请选择业务员"),
    /**
     * 请选择业务员
     */
    ERR_REFUND_FAILURE_ERROR("10029","退款失败"),
    /**
     * 此账号为当前登录账号,不可删除
     */
    ERR_USER_DELETE_ERROR("10030","此账号为当前登录账号,不可删除"),
    /**
     * 业务员有绑定客户,请先解绑
     */
    ERR_PRINCIPAL_HAS_PURCHASE("10031","业务员有绑定客户,请先解绑"),
    
    /**
     * 业务员有绑定客户,请先解绑
     */
    ERR_REFUND_COMPLETE_ERROR("10032","您选择的商品中含有无剩余数量的商品，无法进行退款！"),
    /**
     * 
     */
    ERR_REFUND_SURPASSES_ERROR("10033","退款金额过多！"),
    
    ERR_WEPAY_EXCEPTION_ORDERPAID("ORDERPAID","该订单已支付"),
    
    
    ERR_APP_WEPAY_EXCEPTION_THROW_EXCEPTION_ERROR("10036","APP支付出现异常！"),
    
    ERR_INSUFFICIENT_PURCHASE_QUANTITY_ERROR("10034","购买量未达到您所选择的促销方式要求！"),
    
    ERR_AUDIT_END_ERROR("10035","您选择的商品中含有已审核的商品，请确认后操作！"),
	
	ERR_CANNOT_FIND_RECORD("10040","没有找到记录."),
	ERR_SAVE_FAILED("10041","更新失败."),
	ERR_DELETE_FAILED("10042","删除失败."),
	ERR_MSG_CUSTOM("20000","自己定义提示的消息."), 
	ERROR_GOODS_DETAIL_TOO_MUCH("30001","您输入的物品编码，在数据库中存在重复情况，请与管理员联系！"), 
	ERROR_MATERIAL_TOO_MUCH("30002","你输入的物料编码在数据库中存在重复现象，请与管理员联系！"), 
	ERROR_GOODS_DETAIL_NOT_IN_WAREHOUSE("30003","物品已经不在库中！"), 
	ERROR_SEND_TRAY_COMMAND_ERROR_EMPTY("30004","没有找到发送的指令！"),
    //"物料" + upn + "已经在仓库，库位码：" + mscm.getLocation() + ",不能入库！"
    ERROR_MATERIAL_TYPE_WAREHOUSE_STOCK_IS_IN_WAREHOUSE_ERROR("70001","已经有了！");
	
	
	
	
	private String code;
	private String msg;

	private ErrCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
