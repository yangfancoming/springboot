package com.goat.filter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.http.HttpStatus;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 在实际的项目中，对同一个url多个角色都有访问权限很常见，shiro默认的RoleFilter没有提供支持，
 比如上面的配置，如果我们配置成下面这样，那用户必须同时具备admin和manager权限才能访问，显然这个是不合理的
 所以自己实现一个role filter，只要任何一个角色符合条件就通过，只需要重写AuthorizationFilter中两个方法就可以了：
 触发条件： 当请求的url 在配置池中 有 anyRole[admin,manager] 对应 时  进入该 过滤器
*/
public class AnyRolesAuthorizationFilter  extends AuthorizationFilter {
	
	@Override
    protected void postHandle(ServletRequest request, ServletResponse response){
		request.setAttribute("anyRolesAuthFilter.FILTERED", true);
	}

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue)  {
        System.out.println("进入 AnyRolesAuthorizationFilter---isAccessAllowed() 。。。。。。。。。。。。。。");
    	Boolean afterFiltered = (Boolean)(servletRequest.getAttribute("anyRolesAuthFilter.FILTERED"));
        if( BooleanUtils.isTrue(afterFiltered))
        	return true;
        
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] rolesArray = (String[]) mappedValue;
        if (rolesArray == null || rolesArray.length == 0) { //没有角色限制，有权限访问
            return true;
        }
        for (String role : rolesArray) {
            if (subject.hasRole(role)) //若当前用户是rolesArray中的任何一个，则有权限访问
                return true;
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) {
        System.out.println("进入 AnyRolesAuthorizationFilter---onAccessDenied() 。。。。。。。。。。。。。。");
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setStatus(HttpStatus.SC_UNAUTHORIZED);
        return false;
    }

}
