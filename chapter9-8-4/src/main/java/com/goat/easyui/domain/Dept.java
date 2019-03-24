package com.goat.easyui.domain;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

@TableName("t_dept")
public class Dept implements Serializable {

	private static final long serialVersionUID = -7790334862410409053L;

    @TableId(value = "MENU_ID",type = IdType.AUTO)
	private Long deptId;
    @TableField(value = "PARENT_ID") // 菜单地址
	private Long parentId;

    @TableField(value = "DEPT_NAME")
	private String deptName;

    @TableField(value = "ORDER_NUM")
	private Long orderNum;

    @TableField(value = "CREATE_TIME")
	private Date createTime;


	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}