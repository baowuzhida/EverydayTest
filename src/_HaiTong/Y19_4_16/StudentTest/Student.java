package _HaiTong.Y19_4_16.StudentTest;

public class Student {
    private String Name;
    private int age;
    private String sex;

    public Student() {
    }

    public Student(String name, int age, String sex) {
        Name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
