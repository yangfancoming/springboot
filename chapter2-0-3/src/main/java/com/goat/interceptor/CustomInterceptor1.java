
package com.goat.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * http://localhost:8203/random1
     * @Date:   2018/11/12
*/
public class CustomInterceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        System.out.println("CustomInterceptor1拦截器开始工作，拦截到当前请求地址：" + httpServletRequest.getRequestURL().toString());
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
//        System.out.println("CustomInterceptor1.postHandle:" + o + ", modelAndView:" + modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)  {
        // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
//        System.out.println("CustomInterceptor1.afterCompletion:" + o);
        System.out.println("afterCompletion清理资源...");
        // 清理session
        HttpSession session = httpServletRequest.getSession();
        Map<String, Object> map = (Map<String, Object>) session.getAttribute("map1");
        if (! CollectionUtils.isEmpty(map)) {
            session.removeAttribute("map1");
            System.out.println("清理map1...");
        }
        System.out.println("afterCompletion资源清理完成...");
    }
}
