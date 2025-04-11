package Work.WorkShop09.com.student;

public class Student {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Student(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Student() {
    }

    public String studentInfo()
    {
        return "Name: " + name + ", Age: " + age + ", Height: " + height + ", Weight: " + weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
