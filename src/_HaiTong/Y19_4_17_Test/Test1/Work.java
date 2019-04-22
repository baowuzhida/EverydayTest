package _HaiTong.Y19_4_17_Test.Test1;

import java.util.Objects;

public class Work {
    private String name;
    private int age;
    private double salary;

    public Work() {
    }

    public Work(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //如果当前对象和o指向的的地址相同（是同一个）则返回true
        if (o == null || getClass() != o.getClass()) return false;//如果o为null或者不是work类则返回false
        Work work = (Work) o;//将o强制转换为work类型
        return age == work.age &&
                Double.compare(work.salary, salary) == 0 &&
                Objects.equals(name, work.name);//如果o的age，name，salary均与当前类相同则返回true 否则返回false
    }
}
