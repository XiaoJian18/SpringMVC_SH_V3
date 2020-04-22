package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NeedHomeworkAspect {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(WebAspect.class);
    String logstr=null;
    @Pointcut("execution(* services.NeedHomeworkService.*(..))")
    public void needhomewrk(){}

    @Before("needhomewrk()")
    public void beforeNeedhomewrk(JoinPoint joinPoint){
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
    @After("needhomewrk()")
    public void afterNeedhomewrk(JoinPoint joinPoint){
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
}
