package aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(WebAspect.class);
    String logstr=null;
    @Pointcut("execution(* services.StudentService.*(..))")
    public void student(){}

    @Before("student()")
    public void beforeStudent(JoinPoint joinPoint){
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
    @After("student()")
    public void afterStudent(JoinPoint joinPoint){
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
