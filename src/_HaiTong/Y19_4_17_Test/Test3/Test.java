package _HaiTong.Y19_4_17_Test.Test3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1,19,"1aaa",80));
        students.add(new Student(1,19,"1aaa",80));
        for (int i = 2; i <8 ; i++) {
            students.add(new Student(i,18+i,i+"aaa",80+i));
        }

        Set<Student> stuSet = new HashSet<Student>(students);



        List<Student> newStu = new ArrayList<Student>(stuSet);
        newStu.sort(new StuComparator());//成绩排序
        newStu.remove(0);//去首
        newStu.remove(newStu.size()-1);//去尾

        newStu.sort(new newComparator());
        newStu.forEach(System.out::println);
    }
}
