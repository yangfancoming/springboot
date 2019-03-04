package com.goat.aop;


import com.goat.annotation.Log;
import com.goat.domain.OperLog;
import com.goat.service.OperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;


@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    OperLogService operLogService;

    /**配置织入点*/
    @Pointcut("@annotation(com.goat.annotation.Log)")
    public void logPointCut(){}

    /**
     * @param joinPoint 切点
     * @param rvt  被切方法 返回值
     */
    @AfterReturning(returning="rvt", pointcut = "logPointCut()")
    public void afterExec(JoinPoint joinPoint, Object rvt){
        handleLog(joinPoint, rvt);
    }

    /**
     *  @AfterThrowing 拦截的方法 报异常后 进入该方法 注意如果异常方法中 try catch 了  则 不会进入该方法
     * @param ex  异常信息
     * @param
     */
    @AfterThrowing(throwing="ex",pointcut = "logPointCut()")
    public void afterThrowing(JoinPoint joinPoint,Throwable ex){
        System.out.println("哥是 异常增强。。。。。。。。。。。" + ex);
        errorLog(joinPoint, ex);
    }
    protected void errorLog(final JoinPoint joinPoint, Throwable ex){
        try {
            Log controllerLog = null;
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            if (method != null){ // 是否存在注解，如果存在就获取
                controllerLog = method.getAnnotation(Log.class);
            }
            // 获得注解
            if (controllerLog == null) return;
            OperLog operLog = new OperLog();
            String className = joinPoint.getTarget().getClass().getName();  // 设置类名称
            String methodName = joinPoint.getSignature().getName();  // 设置方法名称
            operLog.setMethod(className + "." + methodName + "()");
            getControllerMethodDescription(controllerLog, operLog);  // 处理设置注解上的参数
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
            //            operLog.setOperParam(args[0].toString()); // 设置 请求 ip
            operLog.setCode(args[1].toString());// 设置 线程记录编号
            operLog.setStatus("1"); // 设置运行状态为 失败
            operLog.setErrorMsg(ex.getMessage());
            operLogService.save(operLog);// 保存数据库
        }
        catch (Exception exp){
            log.error("==通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }


    protected void handleLog(final JoinPoint joinPoint, Object rvt){
        try {
            System.out.println(rvt);
            Log controllerLog = null;
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            if (method != null){ // 是否存在注解，如果存在就获取
                controllerLog = method.getAnnotation(Log.class);
            }
            // 获得注解
            if (controllerLog == null) return;
            OperLog operLog = new OperLog();
            String className = joinPoint.getTarget().getClass().getName();  // 设置类名称
            String methodName = joinPoint.getSignature().getName();  // 设置方法名称
            operLog.setMethod(className + "." + methodName + "()");
            getControllerMethodDescription(controllerLog, operLog);  // 处理设置注解上的参数
            // 请求的方法参数值
            Object[] args = joinPoint.getArgs();
//            operLog.setOperParam(args[0].toString()); // 设置 请求 ip
            operLog.setCode(args[1].toString());// 设置 线程记录编号


            if (rvt instanceof AsyncResult){ // sos 获取返回 数据条数
                Future<List<Object>> temp = (Future<List<Object>>) rvt;
                operLog.setRecords(temp.get().size());
            }

            operLogService.save(operLog);// 保存数据库
        }
        catch (Exception exp){
            log.error("==通知异常==");
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
        operLog.setAction(log.action()); // 设置action动作
        operLog.setTitle(log.title()); // 设置标题
        operLog.setOperTime(new Date()); // 设置操作时间
        operLog.setCode(log.code());//设置 料仓编号
        operLog.setStatus("0");//设置 运行状态 正常
    }
}
