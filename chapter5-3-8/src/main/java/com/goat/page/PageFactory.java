
package com.goat.page;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.goat.httpUtil.HttpContext;

import javax.servlet.http.HttpServletRequest;

/**
 * BootStrap Table默认的分页参数创建
 * doit 为什么 会因为这里引用 0-1-0 项目  package报错就报错  但是 2-3-2 项目也引用0-1-0 为啥就不报错？
 * 难道是因为 2-3-2 和 0-1-0 都是 springboot 的子模块  5-3-8 是root 模块？
 */
public class PageFactory<T> {

    public Page<T> defaultPage() {
        HttpServletRequest request = HttpContext.getRequest();
        int limit = Integer.valueOf(request.getParameter("limit"));     //每页多少条数据
        int offset = Integer.valueOf(request.getParameter("offset"));   //每页的偏移量(本页当前有多少条)
        String sort = request.getParameter("sort");         //排序字段名称
        String order = request.getParameter("order");       //asc或desc(升序或降序)
        return null;
    }
}
