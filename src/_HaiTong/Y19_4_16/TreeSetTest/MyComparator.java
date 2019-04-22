package _HaiTong.Y19_4_16.TreeSetTest;

import java.io.Serializable;
import java.util.Comparator;

public class MyComparator implements Comparator<Student>,Serializable {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
