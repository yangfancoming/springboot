package com.goat.easyui.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("t_user")
public class User implements Serializable {

	private static final long serialVersionUID = -4852732617765810959L;

	/**
     private Long userId;
     private String username;
     private String password;
     private Long deptId;
     private String deptName;
     private String email;
     private String mobile;
     private String status = STATUS_VALID;
     private Date crateTime;
     private Date modifyTime;
     private Date lastLoginTime;
     private String ssex;
     private String theme;
     private String avatar;
     private String description;
	*/
	/**
	 * 账户有效
	 */
	public static final String STATUS_VALID = "1";
	/**
	 * 账户锁定
	 */
	public static final String STATUS_LOCK = "0";
	public static final String SEX_UNKNOW = "2";
	public static final String DEFAULT_THEME = "green";
	public static final String DEFAULT_AVATAR = "default.jpg";

    @TableId(value = "USER_ID",type = IdType.AUTO)
    @TableField(value = "USER_ID")
	private Long userId;

    @TableField(value = "USERNAME")
	private String username;

    @TableField(value = "PASSWORD")
	private String password;

    @TableField(value = "DEPT_ID")
	private Long deptId;

    @TableField(exist = false)
	private String deptName;

    @TableField(value = "EMAIL")
    private String email;

    @TableField(value = "MOBILE")
    private String mobile;

    @TableField(value = "STATUS")
    private String status = STATUS_VALID;

    @TableField(value = "CRATE_TIME")
    private Date crateTime;

    @TableField(value = "MODIFY_TIME")
    private Date modifyTime;

    @TableField(value = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    @TableField(value = "SSEX")
    private String ssex;

    @TableField(value = "THEME")
    private String theme;

    @TableField(value = "AVATAR")
    private String avatar;

    @TableField(value = "DESCRIPTION")
    private String description;

    @TableField(exist = false)
	private String roleName;

	/**
	 * @return USER_ID
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return USERNAME
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * @return PASSWORD
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * @return DEPT_ID
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return EMAIL
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	/**
	 * @return MOBILE
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	/**
	 * @return STATUS
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * @return CRATE_TIME
	 */
	public Date getCrateTime() {
		return crateTime;
	}

	/**
	 * @param crateTime
	 */
	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
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

	/**
	 * @return LAST_LOGIN_TIME
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return SSEX
	 */
	public String getSsex() {
		return ssex;
	}

	/**
	 * @param ssex
	 */
	public void setSsex(String ssex) {
		this.ssex = ssex == null ? null : ssex.trim();
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}