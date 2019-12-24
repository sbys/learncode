package Aop;

import jdk.nashorn.api.scripting.ClassFilter;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class BeanContainer {
    private Map<String, Class> beanDefinition=new HashMap<>();
    private Aspect aspect;

    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }

    public void add(String key, Class<?> classname){
        this.beanDefinition.put(key,classname);
    }
    public Object getBean(String key) throws IllegalAccessException, InstantiationException {
        Object object=this.beanDefinition.get(key).newInstance();
        if(object.getClass().getName().matches(this.aspect.getPointCut().getClassPattern()))
        object= Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new AdviceInvocationHandler(aspect,object));
        return object;
    }

}
