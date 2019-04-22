package _HaiTong.Y19_4_2.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Student> students = new LinkedList<Student>();
        for(int i =0;i<5;i++) {
            Student student = new Student();
            student.setsNo(input.nextInt());
            student.setsName(input.next());
            student.setsSex(input.next());
            student.setsAge(input.nextInt());
            student.setsJava(input.nextDouble());
            students.add(student);
        }
        StudentControl studentControl = new StudentControl();
        double a = studentControl.averange(students);
        double m = studentControl.max(students);
        System.out.println("Averange = "+a+"   Max = "+m);
    }
}
