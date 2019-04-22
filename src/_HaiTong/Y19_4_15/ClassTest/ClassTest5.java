package _HaiTong.Y19_4_15.ClassTest;

import java.io.*;
import java.util.*;

public class ClassTest5 {
    /*
    * 如在E盘下有一个Test.txt文本文件内容是
#刘德华#89#77#60
#张信哲#76#97#70
#周杰伦#89#88#90
#随便啦#87#70#80
要求通过java读取文本并把文本中的每一行后面的三个成绩相加,
最后按从大到小的顺序输出到另一个文本文件中.
输出后的文本文件内容应为:`
#周杰伦#267
#张信哲#243
#随便啦#237
#刘德华#226
    * */
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        File f1 = new File("f.txt");
        BufferedReader br1 = null;
        File f2 = new File("g.txt");
        BufferedWriter br2 = null;
        try {
            br1 = new BufferedReader(new FileReader(f1));
            String s1;
            while ((s1 = br1.readLine()) != null) {
                String[] l1 = s1.split("#");
                Integer count = 0;
                for (int i=2;i<l1.length;i++) {
                    count += Integer.valueOf(l1[i]);
                }
                tm.put(l1[1],count);
            }
            br2 = new BufferedWriter(new FileWriter(f2));
            if (br2 != null) {
                List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(tm.entrySet());
                Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
                    //升序排序
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return  o2.getValue().compareTo(o1.getValue());
                    }
                });
                for (Map.Entry<String, Integer> entry : tm.entrySet()) {
                    String key = entry.getKey().toString();
                    String value = entry.getValue().toString();

                    br2.write("#" + key + "#" + value + "#");
                    br2.newLine();
                    System.out.println("#" + key + "#" + value + "#");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null!=br2) {
                try {
                    br2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
