package _HaiTong.Y19_4_15.BufferInputTest;

import java.io.*;

public class BufferInputTest {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;
        String str = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File("1.txt")));
            while ((str = br.readLine()) != null) {
                if ("over".equals(str)) {
                    break;
                } else
                    System.out.println(str);
                bw.write(str);
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
