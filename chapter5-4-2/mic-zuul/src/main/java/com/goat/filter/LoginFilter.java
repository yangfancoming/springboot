package com.goat.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by forezp on 2017/4/8.
 */
@Component
public class LoginFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(LoginFilter.class);

    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前   适用登录
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    // 配置过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 配置是否需要过滤：true/需要，false/不需要
    @Override
    public boolean shouldFilter() {
        return true;
    }


    // 过滤器的具体业务代码
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext(); // 通过 Zuul 得到 HttpServletRequest
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token"); // 校检 请求信息
        if(accessToken == null) {
//        if(accessToken != null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                HttpServletResponse response = ctx.getResponse();
                response.setContentType("text/html; charset=UTF-8");
                ctx.getResponse().getWriter().write("token is empty");// 返回 响应信息
            }catch (Exception e){}
            return null;
        }
        log.info("ok");
        return null;
    }


}
