package com.sec03;
/*

이름 세 과목 총점, 평균으ㅜㄹ 구현하는 클래스를 만들자.
- U_Score
- 이름      국어     영어   수학    총점
- 홍길동    100     90     100
- 정길동    90      90     90
- 박길동    80      80     80

 */




public class U_Score {
    String name;
    int kor;
    int eng;
    int mat;
    int tot;
    int avg;

    public U_Score() {
//        super();
    }

    U_Score(String name, int kor, int eng, int mat) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        this.tot = this.kor+this.eng+this.mat;
        this.avg = this.tot/3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getTot() {
        return tot;
    }

    public void setTot(int tot) {
        this.tot = this.getKor()+this.getEng()+this.getMat();
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = getTot()/3;
    }

    @Override
    public String toString() {
//        return "U_Score{" +
//                "name='" + name + '\'' +
//                ", kor=" + kor +
//                ", eng=" + eng +
//                ", mat=" + mat +
//                ", tot=" + tot +
//                ", avg=" + avg +
//                '}';

        return String.format("U_Score [getName()=%s, getKor() = %d, getEng() = %d, getMat() = %d, getTot() = %d, getAvg() = %d]\n ",
                this.getName(), this.getKor(), this.getEng(), this.getMat(), this.getTot(), this.getAvg());
    }


    public static void main(String[] args) {
        U_Score a1 = new U_Score("홍길동", 100, 100, 100);
        U_Score b1 = new U_Score("정길동", 90,90,90);
        U_Score c1 = new U_Score("박길동", 80,80,80);

        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);

        System.out.println("=================================");
        System.out.printf("%10s %10s %10s\n", a1.getName(),b1.getName(),c1.getName());
        int tot = a1.getTot()+b1.getTot()+c1.getTot();
        System.out.printf(" total_Score = %10d \n", tot);

    }
}
