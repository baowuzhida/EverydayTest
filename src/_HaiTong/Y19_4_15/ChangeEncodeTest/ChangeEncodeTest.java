package _HaiTong.Y19_4_15.ChangeEncodeTest;

import java.io.*;

public class ChangeEncodeTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File("1.txt"));
            fos = new FileOutputStream(new File("2.txt"));
            InputStreamReader isr = new InputStreamReader(fis,"GBK");
            OutputStreamWriter opsw = new OutputStreamWriter(fos,"UTF-8");
            int data = -1;
            while ((data = isr.read())!=-1){
                fos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
