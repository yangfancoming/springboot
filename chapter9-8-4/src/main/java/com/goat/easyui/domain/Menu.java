package com.goat.easyui.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    /**
     *  easyui tree 属性
     id：节点ID，对加载远程数据很重要。
     text：显示节点文本。
     state：节点状态，'open' 或 'closed'，默认：'open'。如果为'closed'的时候，将不自动展开该节点。
     checked：表示该节点是否被选中。
     attributes: 被添加到节点的自定义属性。
     children: 一个节点数组声明了若干节点。
    */
	private static final long serialVersionUID = 7187628714679791771L;
	public static final String TYPE_MENU = "0";
	public static final String TYPE_BUTTON = "1";

    @TableId(value = "MENU_ID",type = IdType.AUTO)
    @TableField(value = "MENU_ID")
    @JsonProperty("id")
	private Long menuId;

    @TableField(value = "PARENT_ID")
	private Long parentId; // 该字段不能为 null 或 ""  必须 有数

    @TableField(value = "MENU_NAME") // 菜单名称
    @JsonProperty("text")
	private String menuName;

    @TableField(value = "URL") // 菜单地址
	private String url;

    @TableField(value = "PERMS") // 权限标识
	private String perms;

    @TableField(value = "ICON") // 图标
    @JsonProperty("iconCls")
	private String icon;

    @TableField(value = "STATE") // 展开状态 0 关闭 1 展开
    private String state;

    @TableField(value = "TYPE")
	private String type; // 1 按钮   0 菜单

    @TableField(value = "ORDER_NUM") // 排序
	private Long orderNum;

    @TableField(value = "CREATE_TIME") // 创建时间
	private Date createTime;

    @TableField(value = "MODIFY_TIME") // 修改时间
	private Date modifyTime;

    @TableField(exist = false)
    private List<Menu> children;

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? "" : menuName.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? "" : url.trim();
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms == null ? "" : perms.trim();
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? "" : icon.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? "" : type.trim();
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

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}