package com.RestOfPattern;

public class AdaptorScore extends Score{

    public AdaptorScore(int korean, int english, int math) {
        super(korean, english, math);
    }
}

class OldScoreSystem{
    public int getSum()
    {
        return 270;
    }

    public double getAvg()
    {
        return 90.0;
    }

}

class ScoreAdaptor extends Score{
    private OldScoreSystem oldScoreSystem;

    public ScoreAdaptor(OldScoreSystem oldScoreSystem) {
        super(0,0 ,0 );
        this.oldScoreSystem = oldScoreSystem;
    }

    public int getTotal()
    {
        return oldScoreSystem.getSum();
    }


    public double getAverage()
    {
        return oldScoreSystem.getAvg();
    }
}



//놓침 ㅋㅋ
