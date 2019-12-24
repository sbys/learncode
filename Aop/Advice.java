package Aop;

import java.lang.reflect.Method;

public interface Advice {
    void doSomethingBefore(Object o, Method method,Object[] args);
    void doSomethingAfter(Object o,Method method,Object[]args);
}
