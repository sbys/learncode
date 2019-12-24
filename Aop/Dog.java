package Aop;

public class Dog implements Animal {

    @Override
    public void say(String content) {
        System.out.println(content);
    }
}
