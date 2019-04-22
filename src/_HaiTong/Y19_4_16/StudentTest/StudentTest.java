package _HaiTong.Y19_4_16.StudentTest;

import java.util.Arrays;
import java.util.Comparator;

public class StudentTest {
    public static void main(String[] args) {
        Student[] students = new Student[2];
        students[0] = new Student("tom", 19, "man");
        students[1] = new Student("jack", 20, "man");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Student s : students) {
            System.out.println(s);

        }
    }
}
