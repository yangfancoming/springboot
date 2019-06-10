package com.goat.doit.system.shiro;


import com.goat.doit.system.model.Permission;
import com.goat.doit.system.service.PermissionService;
import com.goat.doit.util.CoreConst;
import com.goat.doit.util.SpringContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service
public class ShiroService {
    @Autowired
    private PermissionService permissionService;
    /**
     * 初始化权限
     */
    public Map<String, String> loadFilterChainDefinitions() {
        // 权限控制map.从数据库获取
        Map<String, String> chainDefinition = new LinkedHashMap<>();
        chainDefinition.put("/toLogin", "anon");
        chainDefinition.put("/login", "anon");
        chainDefinition.put("/logout", "anon");
        chainDefinition.put("/error/**", "anon");
        chainDefinition.put("/css/**", "anon");
        chainDefinition.put("/js/**", "anon");
        chainDefinition.put("/img/**", "anon");
        chainDefinition.put("/libs/**", "anon");
        chainDefinition.put("/favicon.ico", "anon");
        chainDefinition.put("/verificationCode", "anon");
        /**
         授权过滤器 如果 指定了未授权界面 那么 直接跳到指定的页面(403) 如果未指定未授权界面  那么直接报错 401 Unauthorized
         授权认证会调用 doGetAuthorizationInfo 函数
         * */
        //        chainDefinition.put("/hello/add", "perms[hello:add]");
        //        chainDefinition.put("/hello/edit", "perms[hello:edit]");
        chainDefinition.put("/**", "authc");   // 过滤链定义，从上向下顺序执行，一般将 /** 放在最为下边  这是一个坑呢，一不小心代码就不好使了;
        
        List<Permission> permissionList = permissionService.selectAll(CoreConst.STATUS_VALID);
        for(Permission permission : permissionList){
            if (StringUtils.isNotBlank(permission.getUrl())&& StringUtils.isNotBlank(permission.getPerms())) {
                String perm = "perms[" + permission.getPerms()+ "]";
                chainDefinition.put(permission.getUrl(),perm+",kickout");
            }
        }
        chainDefinition.put("/**", "user,kickout");
        return chainDefinition;
    }

    /**
     * 重新加载权限
     */
    public void updatePermission() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = SpringContextHolder.getBean(ShiroFilterFactoryBean.class);
        synchronized (shiroFilterFactoryBean) {

            AbstractShiroFilter shiroFilter;
            try {
                shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean .getObject();
            } catch (Exception e) {
                throw new RuntimeException(  "get ShiroFilter from shiroFilterFactoryBean error!");
            }

            PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter .getFilterChainResolver();
            DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver .getFilterChainManager();

            // 清空老的权限控制
            manager.getFilterChains().clear();
            shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
            shiroFilterFactoryBean.setFilterChainDefinitionMap(loadFilterChainDefinitions());

            // 重新构建生成
            Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
            for (Map.Entry<String, String> entry : chains.entrySet()) {
                String url = entry.getKey();
                String chainDefinition = entry.getValue().trim().replace(" ", "");
                manager.createChain(url, chainDefinition);
            }
        }
    }
}
