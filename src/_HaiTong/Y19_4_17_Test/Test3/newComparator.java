package _HaiTong.Y19_4_17_Test.Test3;

import java.util.Comparator;

public class newComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getId()!=o2.getId())
            return o1.getId()-o2.getId();
        else if(!o1.getName().equals(o2.getName()))
            return o1.getName().compareTo(o2.getName());
        else
            return o1.getAge()-o2.getAge();
    }
}
