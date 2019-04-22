package _HaiTong.Y19_4_17_Test.Test4;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        File file = new File("test.txt");//test文件初始信息为：1
        for (int i = 0; i < 10; i++) {
            read(file);
        }

    }

    private static void read(File file) {
        FileInputStream fio = null;
        int x = 0, flag = 0;
        try {
            fio = new FileInputStream(file);
            x = fio.read();
            if (x > '5')
                throw new NotRegisteredException();//超出五次
            else {
                System.out.println("当前是第" + (char) (x) + "次运行本程序，还可以试用" + ('5' - (char) x) + "次");
                flag = 1;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotRegisteredException e) {
            e.printStackTrace();
        } finally {
            if (null != fio) {
                try {
                    fio.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (flag == 1)
            write(file, x);
    }

    ;

    private static void write(File file, int x) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write((char) (x + 1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    ;
}
