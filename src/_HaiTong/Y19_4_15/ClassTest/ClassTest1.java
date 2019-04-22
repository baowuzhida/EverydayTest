package _HaiTong.Y19_4_15.ClassTest;

import java.io.*;

public class ClassTest1 {

    /*
     * 通过代码创建一个文件a.txt 然后写一个方法，控制台循环输入内容，然后通过gbk的编码格式保存到 a.txt中（要求可以追加），直到输入exit结束
     * 再写一个方法，要求用字符缓冲流读取a.txt中的内容到控制台打印出来
     * */
    public static void main(String[] args) {
        inputA();
        outputA();
    }

    private static void inputA() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String str = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("a.txt")),"GBK"));
            while ((str = br.readLine()) != null) {
                if ("exit           ".equals(str)) {
                    break;
                } else
                    System.out.println(str);
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void outputA() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("a.txt")));
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
