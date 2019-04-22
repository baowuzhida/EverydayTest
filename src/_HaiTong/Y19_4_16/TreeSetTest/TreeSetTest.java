package _HaiTong.Y19_4_16.TreeSetTest;


import java.io.*;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<Student>(new MyComparator());
        set.add(new Student("ZZZ", 19, "MAN"));
        set.add(new Student("XXX", 23, "MAN"));
        set.add(new Student("CCC", 17, "MAN"));
        set.add(new Student("VVV", 21, "MAN"));
//        for (Student s : set) {
//            System.out.println(s);
//
//        }
        ObjectOutputStream oos = null;
        OutputStreamWriter osw = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("1.txt")));
            osw = new OutputStreamWriter(oos, "GBK");
            oos.writeObject(set);
//            for (Student s : set) {
//                oos.writeObject(s);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != oos) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        TreeSet<Student> sets = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("1.txt")));
            sets = (TreeSet<Student>) ois.readObject();
            for (Student s : sets) {
                System.out.println(s + "     SETS");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }
}
