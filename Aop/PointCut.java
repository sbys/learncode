package Aop;

public class PointCut {
    private String classPattern;
    private String methodPattern;
    public  PointCut(String classPattern,String methodPattern){
        this.classPattern=classPattern;
        this.methodPattern=methodPattern;
    }

    public String getClassPattern() {
        return classPattern;
    }

    public String getMethodPattern() {
        return methodPattern;
    }
}
