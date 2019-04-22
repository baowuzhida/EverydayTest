package _HaiTong.Y19_4_2.Student;
/*
编写类Student的成员变量：sNo 表示学号；sName表示姓名；sSex表示性别；sAge表示年龄；sJava：表示Java课程成绩。
需要有参无参构造方法和getter、setter方法。创建五个该类的对象，从键盘输入每个学生的信息，保存到一个学生数组，计算并输出这五个学生Java语言成绩的平均值，最大值。
（求学生数组的平均值，最大值封装方法）
*/

public class Student {
    int sNo;
    String sName;
    String sSex;
    int sAge;
    double sJava;

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public int getsAge() {
        return sAge;
    }

    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public double getsJava() {
        return sJava;
    }

    public void setsJava(double sJava) {
        this.sJava = sJava;
    }
}
