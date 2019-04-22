package _HaiTong.Y19_4_2.Student;

import java.util.List;

public class StudentControl implements Averange,Max {

    @Override
    public double averange(List<Student> students) {
        double sum=0;
        for (Student student : students) sum += student.sJava;
        return sum/students.size();
    }

    @Override
    public double max(List<Student> students) {
        double max=0;
        for (Student student : students)
            if(student.getsJava()>max)
                max = student.getsJava();
        return max;
    }
}
