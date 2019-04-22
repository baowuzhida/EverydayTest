package _HaiTong.Y19_4_15.ClassTest;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ClassTest3 {
    /*
     *  读取文件character.txt文件中所有的字符，例如“asdascveasrgdfsdf”，获取该字符串中每一个字母出现的次数。
     *  要求：按照字母表的顺序进行打印，打印结果是：a(2)b(1)...
     * */
    public static void main(String[] args) {
        TreeMap<Character, Integer> treeMap = new TreeMap<Character, Integer>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("c.txt")));
            String data = br.readLine();
            for (int i = 0;i<data.length();i++) {
                char s = data.charAt(i);
                if (treeMap.containsKey(s))
                    treeMap.put(s, treeMap.get(s) + 1);
                else
                    treeMap.put(s, 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key=" + key + " value=" + value);
        }

    }
}
