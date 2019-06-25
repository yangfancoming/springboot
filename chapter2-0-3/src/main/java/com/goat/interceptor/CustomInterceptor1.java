
package com.goat.interceptor;

import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
     * @Description:  三器模型中的 拦截器 类似于 AOP 思想
     * @author: Goat
     *    http://localhost:8203/random1
     * @Date:   2018/11/12
*/
public class CustomInterceptor1 implements HandlerInterceptor {

    /** 预处理 类似于 AOP 的前置增强 */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        System.out.println("CustomInterceptor1 preHandle:，拦截到当前请求地址：" + httpServletRequest.getRequestURL().toString());
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    /**  AOP 的后置增强 */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        // 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
        System.out.println("CustomInterceptor1 postHandle:" + o + ", modelAndView:" + modelAndView);
    }

    /**  视图渲染完毕后执行  */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)  {
        // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
//        System.out.println("CustomInterceptor1.afterCompletion:" + o);
        System.out.println("CustomInterceptor1 afterCompletion1  清理资源...");
        // 清理session
        HttpSession session = httpServletRequest.getSession(false);
        if (session == null) return;
        Map<String, Object> map = (Map<String, Object>) session.getAttribute("map1");
        if (! CollectionUtils.isEmpty(map)) {
            session.removeAttribute("map1");
            System.out.println("清理map1...");
        }

    }
}
