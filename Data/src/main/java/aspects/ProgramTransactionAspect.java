package aspects;

import Utils.TransactionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProgramTransactionAspect {

    @Autowired(required = false)
    private TransactionUtil transactionUtil;

    @Pointcut("execution(* example.controller.*.*(..))")
    public void addTransaction(){

    }

    //异常通知：给添加事务的方法回滚事务，当方法抛出异常时
    @AfterThrowing("addTransaction()")
    public void rollbackTransaction(){

        //获取当前事务，然后回滚
        transactionUtil.rollback();
    }

    @Around("addTransaction()")
    public Object around(ProceedingJoinPoint joingPoint) throws Throwable{
        transactionUtil.begin();
        Object object = joingPoint.proceed();
        transactionUtil.commit();
        return object;
    }
}