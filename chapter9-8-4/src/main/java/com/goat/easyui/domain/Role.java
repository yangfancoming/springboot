package com.goat.easyui.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.io.Serializable;
import java.util.Date;

@TableName("t_role")
public class Role implements Serializable {

    /**
     private Long roleId;
     private String roleName;
     private String remark;
     private Date crateTime;
     private Date modifyTime;
     */

	private static final long serialVersionUID = -1714476694755654924L;

    @TableId(value = "ROLE_ID",type = IdType.AUTO)
    @TableField(value = "ROLE_ID")
	private Long roleId;

    @TableField(value = "ROLE_NAME")
	private String roleName;

    @TableField(value = "REMARK")
	private String remark;

    @TableField(value = "CREATE_TIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

    @TableField(value = "MODIFY_TIME")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date modifyTime;


	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}