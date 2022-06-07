package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP는 @Aspect 어노테이션을 적어줘야한다.
 * Spring Bean으로 등록해야하는데 @Component로 등록해도되지만. SpringConfig에 직접 등록 하는것이 좋다.
 * 그럼 SpringConfig에 등록이된것을보고 아~ aop가 쓰이는구나~~~
 */
@Aspect
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("Start: " + joinPoint.toString());
    try{
        // 다음 메소드로 진행됨. joinPoint.proceed()
        return joinPoint.proceed();
    } finally{
        long finish = System.currentTimeMillis();
        long timeMs = finish - start;
        System.out.println("End: " + joinPoint.toString() + " " + timeMs +"ms");
    }

    }
}
