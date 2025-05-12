package com.RestOfPattern;

//생성자 만들고 등급 추가하자.
public class WithGradeScore extends ScoreDecorator {
    

    public WithGradeScore(ReportComponent component) {
        super(component);
    }

    @Override
    public String getReport() {
        return component.getReport() + " 등급: "+ "A";
    }
}
