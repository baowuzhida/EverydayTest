package _HaiTong.Y19_4_17_Test.Test3;

import java.util.Comparator;

public class StuComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.getScore()-o2.getScore());
    }
}
