package com.RestOfPattern;


interface ReportComponent{
    String getReport();
}

class BaseScore implements ReportComponent {
    private int kor, eng, mat;

    public BaseScore(int kor, int eng, int mat) {
        super();
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    @Override
    public String getReport() {
        int tot = kor+eng+mat;
        double avg = tot/3.0;
        return "총점: "+tot+" 평균 "+avg;
    }
}



//기능 추가

abstract class ScoreDecorator implements ReportComponent {

    protected ReportComponent component;

    public ScoreDecorator(ReportComponent component) {
        super();
        this.component = component;
    }
}


public class DecoratorScore {
}
