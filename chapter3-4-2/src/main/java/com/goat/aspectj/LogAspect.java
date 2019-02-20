package com.goat.aspectj;

import com.goat.annotation.Log;
import com.goat.domain.OperLog;
import com.goat.util.HttpContextUtils;
import com.goat.util.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by 64274 on 2019/2/4.
 * @ Description: 操作日志记录处理
 * @ author  山羊来了
 * @ date 2019/2/4---14:46
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    /**配置织入点*/
    @Pointcut("@annotation(com.goat.annotation.Log)")
    public void logPointCut(){}

    /**
     * 前置通知 用于拦截操作
     * @param rvt 切点
     */
    @AfterReturning(returning="rvt",pointcut = "logPointCut()")
    public void afterExec(JoinPoint rvt){
        handleLog(rvt, null);
    }

    @Async
    protected void handleLog(final JoinPoint joinPoint, final Exception e){
        try
        {
            Log controllerLog = null;
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            if (method != null){ // 是否存在注解，如果存在就获取
                controllerLog = method.getAnnotation(Log.class);
            }
            // 获得注解
            if (controllerLog == null) return;

            // *========数据库日志=========*//
            OperLog operLog = new OperLog();
            String className = joinPoint.getTarget().getClass().getName();  // 设置方法名称
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            getControllerMethodDescription(controllerLog, operLog);  // 处理设置注解上的参数

            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            // 请求的方法参数名
            LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
            String[] paramNames = u.getParameterNames(method);
            if (args != null && paramNames != null) {
                String params = "";
                for (int i = 0; i < args.length; i++) {
                    params += "  " + paramNames[i] + ": " + args[i];
                }
                System.out.println(params); // 获取 参数值
            }
            System.out.println(operLog); // 保存数据库
        }
        catch (Exception exp){
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param log
     * @param operLog
     * @return 方法描述
     * @throws Exception
     */
    public void getControllerMethodDescription(Log log, OperLog operLog)  {
        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        operLog.setOperIp(IPUtils.getIpAddr(request));// 设置IP地址
        operLog.setAction(log.action()); // 设置action动作
        operLog.setTitle(log.title()); // 设置标题
        operLog.setChannel(log.channel()); // 设置channel
        operLog.setOperTime(new Date()); // 设置操作时间
    }
}
