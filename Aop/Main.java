package Aop;

import java.lang.reflect.Method;

public class Main {
    public static void main(String []args) throws InstantiationException, IllegalAccessException {
        BeanContainer beanContainer=new BeanContainer();
        beanContainer.setAspect(new Aspect(new Advice() {
            @Override
            public void doSomethingBefore(Object o, Method method, Object[] args) {
                System.out.println("要叫了");
            }

            @Override
            public void doSomethingAfter(Object o, Method method, Object[] args) {
                System.out.println("叫完了");
            }


        },new PointCut("Aop.*","say")));
        beanContainer.add("dog",Dog.class);
        Animal d=(Animal)beanContainer.getBean("dog");
        d.say("wang");
    }
}
