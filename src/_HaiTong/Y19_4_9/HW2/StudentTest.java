package _HaiTong.Y19_4_9.HW2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Student student = new Student();
        for (int i =0;i<5;i++) {
            student.setAge(19);
            student.setName("zzz");
            student.setScore(100);
            hashMap.put(i+1,student);
        }
        Set<Map.Entry> ms =hashMap.entrySet();
        for (Map.Entry entry : ms) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
