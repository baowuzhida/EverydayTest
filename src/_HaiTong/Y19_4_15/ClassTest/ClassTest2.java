package _HaiTong.Y19_4_15.ClassTest;

import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class ClassTest2 {
    /*
     * 题目有以下字符串： chenhao zhangsan zhangsan chenhao lisi wangwu zhaoliu xiaoqiang Haha 按长度升序排序（长度一致按ASCII码自然升序）
     * 排序后的集合对象以序列化方式保存到二进制文件，再从文件以反序列化读取到控制台显示
     * */
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()!=o2.length())
                    return o1.length()-o2.length();
                return o1.compareTo(o2);
            }
        });
        ts.add("chenhao");
        ts.add("zhangsan");
        ts.add("zhangsan");
        ts.add("chenhao");
        ts.add("lisi");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("b.txt")));
            for (String tss : ts)
                oos.writeObject(tss);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != oos)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("b.txt")));
            Object str = null;
            int i=0;
            while (i<ts.size()){
                str=ois.readObject();
                System.out.println((String)str);
                i++;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
