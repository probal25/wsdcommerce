package ws.probal.wsdcommerce.common.logger;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationTracingAspect extends TraceLoggerAspect {

    @Pointcut("execution(* ws.probal.wsdcommerce.api..*(..)))")
    public void controllerAspect() {
    }

    @Pointcut("execution(* ws.probal.wsdcommerce.service..*(..)))")
    public void serviceAspect() {
    }

    @Around("controllerAspect()")
    public Object logController(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }

    @Around("serviceAspect()")
    public Object logService(ProceedingJoinPoint joinPoint) throws Throwable {
        return trace(joinPoint);
    }
}
