package _HaiTong.Y19_4_16.LambdaTest;

import java.util.*;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();
        list.add("asd");
        list.add("zxc");
        list.add("qwe");
//        list.sort((s1,s2)->s1.compareTo(s2));
        list.sort(String::compareTo);

        list.forEach(System.out::println);
        list.forEach(s-> System.out.println(s));

        Map<String,Integer> map = new HashMap();
        map.put("123",123);
        map.put("223",223);
        map.put("323",323);
        map.put("423",423);
        map.put("523",523);
        map.forEach((k,v)-> System.out.println(k+" "+v+" "));

        Student[] students = new Student[5];
        students[0] = new Student("tom", 19, "man");
        students[1] = new Student("jack", 20, "man");
        students[2] = new Student("dick", 25, "man");
        students[3] = new Student("mimi", 18, "man");
        students[4] = new Student("lilu", 22, "man");
        //过滤
        Predicate<Student> predicate = student -> student.getAge()>19;
        Arrays.stream(students).filter(predicate).forEach(System.out::println);
    }
}
