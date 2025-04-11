package Work.WorkShop04.student;

public class Student {

    private String name;
    private int korean;
    private int english;
    private int math;
    private int science;



    public Student()
    {

    }
    public  Student(String name, int korean, int english, int math, int science)
    {
        this.setName(name);
        this.setKorean(korean);
        this.setEnglish(english);
        this.setMath(math);
        this.setScience(science);

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }



    public double getAvg()
    {
        double avg= (this.korean+this.english+this.math+this.science)/4.0;
        return avg;
    }
    public String getGrade()
    {
        if(this.getAvg()>=90&&this.getAvg()<=100)
            return "A";
        if (this.getAvg()>=70&&this.getAvg()<90)
            return "B";
        if (this.getAvg()>=50&&this.getAvg()<70)
            return "C";
        if (this.getAvg()>=30&&this.getAvg()<50)
            return "D";
        else
            return "F";
    }


}
