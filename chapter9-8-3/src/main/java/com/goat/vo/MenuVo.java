package com.goat.vo;

import java.io.Serializable;
import java.util.List;

public class MenuVo implements Serializable {

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

     id: 'menuId' //数据状态的字段名称，默认：code
     ,name: 'menuName' //成功的状态码，默认：0
     ,alias: 'perms' //状态信息的字段名称，默认：msg
     ,children: 'menuId' //数据总数的字段名称，默认：count
     // ,href: 'rows' //数据列表的字段名称，默认：data
     // ,spread: 'rows' //数据列表的字段名称，默认：data
    */

	private Long id;
    private Long parentId; // 该字段不能为 null 或 ""  必须 有数

	private String name;

	private String alias;

	private List<MenuVo> children;

	private String href;

	private Boolean spread;

    public MenuVo() {
    }

    public MenuVo(Long id, Long parentId, String name, String alias, List<MenuVo> children, String href, Boolean spread) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.alias = alias;
        this.children = children;
        this.href = href;
        this.spread = spread;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<MenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuVo> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }
}