package _HaiTong.Y19_4_12;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/4/12.
 */
public class Demo1 {
    public static void main(String[] args) {
        File in = new File("D:\\src.mp3");
        File out = new File("D:\\des.mp3");
        File select = new File("D:\\JJJ");

        List<String> list = new ArrayList<String>();
//        copyFile(in, out);
        selectFile(select, ".java", list);

        try {
            FileOutputStream javaop = new FileOutputStream(new File("D:\\JJJ\\123.txt"));
            for (String s : list) {
                javaop.write(s.getBytes());
                javaop.write("\r\n" .getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * @param in
     * @param out
     */
    public static void copyFile(File in, File out) {
        if (!in.exists())
            return;
        FileInputStream fin = null;
        FileOutputStream fou = null;
        try {
            fin = new FileInputStream(in);
            fou = new FileOutputStream(out);
            int data = -1;
            while ((data = fin.read()) != -1) {
                fou.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fou != null)
                fou.close();
            if (fin != null)
                fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param src
     * @param end
     * @param list
     */
    public static void selectFile(File src, String end, List<String> list) {
        if (null == src || null == end || null == list || !src.exists()) {
            return;
        }
        if (src.isFile()) {
            if (src.getName().endsWith(end)) {
                list.add(src.getAbsolutePath());
            }
        } else {
            File[] files = src.listFiles();
            for (File f : files) {
                selectFile(f, end, list);
            }
        }
    }


    public static void deleteFile(File src, String end, List<String> list) {
        if (null == src || null == end || null == list || !src.exists()) {
            return;
        }
        if (src.isFile()) {
            if (src.getName().endsWith(end)) {
                src.delete();
            }
        } else {
            File[] files = src.listFiles();
            for (File f : files) {
                deleteFile(f, end, list);
            }
        }
    }
}
