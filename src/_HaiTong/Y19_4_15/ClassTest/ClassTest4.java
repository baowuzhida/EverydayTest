package _HaiTong.Y19_4_15.ClassTest;

import java.io.*;

public class ClassTest4 {

    /*
     * 编写一个程序实现文件内容比较功能： 1) 由用户输入2个文件名，实现比较2个文件中对应位置的内容是否相同。
     * 2) 最后统计文件中对应位置相同字符的数量，最后在控制台中输出相同的内容。（注意如果不是连续的相同内容输出的时候要换行）
     * */
    public static void main(String[] args) {
        File f1 = new File("d.txt");
        File f2 = new File("e.txt");
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try {
            br1 = new BufferedReader(new FileReader(f1));
            br2 = new BufferedReader(new FileReader(f2));
            String s1;
            String s2;
            while ((s1 = br1.readLine()) != null && (s2 = br2.readLine()) != null) {
                for (int i = 0; i < (s1.length() > s2.length() ? s2.length() : s1.length()); i++) {
                    char str1 = s1.charAt(i);
                    char str2 = s2.charAt(i);
                    if (str1 == str2)
                        System.out.print(str2);
                    else
                        System.out.println(" ");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
