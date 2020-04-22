package aspects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class WebAspect {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(WebAspect.class);
    String logstr=null;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")//连接点是@RequestMapping注解的方法
    private void webPointcut() {}
    @Before("execution(* example.controller.*.*(..))")
    public void beforeProcess(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsstr=null;
        for (int i = 0; i < args.length; i++) {
             argsstr+=args[i];
                   }
        logstr="\n该操作所在类"+className+"\n该操作所在方法"+methodName+"\n该操作中的参数"+argsstr;
        logstr+="\n该操作开始了\n";
        logger.info(logstr);


    }
    @After("execution(* example.controller.*.*(..))")
    public void afterProcess(JoinPoint joinPoint)
    {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsstr=null;
        for (int i = 0; i < args.length; i++) {
            argsstr+=args[i];
        }
        logstr="\n该操作所在类"+className+"\n该操作所在方法"+methodName+"\n该操作中的参数"+argsstr;
        logstr+="\n该操作结束了\n";
        logger.info(logstr);

    }
    @AfterThrowing(pointcut = "webPointcut()", throwing = "e")
    public void handleThrowing(JoinPoint joinPoint, Exception e) {//controller类抛出的异常在这边捕获
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsstr=null;

        for (int i = 0; i < args.length; i++) {
            argsstr+=args[i];
        }
        logstr="\n该异常所在类"+className+"\n该异常所在方法"+methodName+"\n该异常中的参数"+argsstr+"\n该异常的信息是"+e.getMessage();
        logstr+="\n抛出了该异常\n";
        logger.info(logstr);

    }






}
