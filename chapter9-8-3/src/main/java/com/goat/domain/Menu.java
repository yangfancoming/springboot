package com.goat.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("t_menu")
public class Menu implements Serializable {

    /**
     private Long menuId;
     private Long parentId;
     private String menuName;
     private String url;
     private String perms;
     private String icon;
     private String type;
     private Long orderNum;
     private Date createTime;
     private Date modifyTime;
    */
	private static final long serialVersionUID = 7187628714679791771L;
	public static final String TYPE_MENU = "0";
	public static final String TYPE_BUTTON = "1";

    @TableId(value = "MENU_ID",type = IdType.AUTO)
    @TableField(value = "MENU_ID")
	private Long menuId;

    @TableField(value = "PARENT_ID")
	private Long parentId;

    @TableField(value = "MENU_NAME")
	private String menuName;

    @TableField(value = "URL")
	private String url;

    @TableField(value = "PERMS")
	private String perms;

    @TableField(value = "ICON")
	private String icon;

    @TableField(value = "TYPE")
	private String type; // 1 按钮   0 菜单

    @TableField(value = "ORDER_NUM")
	private Long orderNum;

    @TableField(value = "CREATE_TIME")
	private Date createTime;

    @TableField(value = "MODIFY_TIME")
	private Date modifyTime;

	/**
	 * @return MENU_ID
	 */
	public Long getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 */
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return PARENT_ID
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return MENU_NAME
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? "" : menuName.trim();
	}

	/**
	 * @return URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url == null ? "" : url.trim();
	}

	/**
	 * @return PERMS
	 */
	public String getPerms() {
		return perms;
	}

	/**
	 * @param perms
	 */
	public void setPerms(String perms) {
		this.perms = perms == null ? "" : perms.trim();
	}

	/**
	 * @return ICON
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon == null ? "" : icon.trim();
	}

	/**
	 * @return TYPE
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type == null ? "" : type.trim();
	}

	/**
	 * @return ORDER_NUM
	 */
	public Long getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum
	 */
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return CREATE_TIME
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return MODIFY_TIME
	 */
	public Date getModifyTime() {
		return modifyTime;
	}

	/**
	 * @param modifyTime
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}