package Aop;

public class Aspect {
    private Advice advice;
    private PointCut pointCut;

    public Aspect(Advice advice,PointCut pointCut) {
        this.advice=advice;
        this.pointCut=pointCut;
    }

    public Advice getAdvice() {
        return advice;
    }

    public PointCut getPointCut() {
        return pointCut;
    }
}
