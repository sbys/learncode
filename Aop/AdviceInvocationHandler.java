package Aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AdviceInvocationHandler implements InvocationHandler {
    private Aspect aspect;
    private Object trueo;

    public AdviceInvocationHandler(Aspect aspect,Object trueo) {
        super();
        this.trueo=trueo;
        this.aspect=aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object re=null;
        if(method.getName().equals(aspect.getPointCut().getMethodPattern()))
        {
            aspect.getAdvice().doSomethingBefore(trueo,method,args);
            re=method.invoke(trueo,args);
            aspect.getAdvice().doSomethingAfter(trueo,method,args);

        }else
            re=method.invoke(trueo,args);
        return re;
    }
}
