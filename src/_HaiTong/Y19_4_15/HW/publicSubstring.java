package _HaiTong.Y19_4_15.HW;

public class publicSubstring {
    public static void main(String[] args) {
        char[] s1 = "123456wasedfww12345".toCharArray();
        char[] s2 = "132wasdddwqdwcf123456".toCharArray();
        char[][] s3 = new char[s1.length][s2.length];
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j])
                    s3[i][j] = s1[i];
                else
                    s3[i][j] = '0';
            }
        }
        String same = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                int k = i, l = j;
                while (k < s1.length && l < s2.length && s3[k][l] != '0') {
                    sb.append(s3[k][l]);
                    k++;
                    l++;
                }
                if (sb.length() > same.length()){
                    same = sb.toString();
                }
                sb =new StringBuilder();
            }
        }
        System.out.println(same);

      /* swejava
        s1000000
        j0001000
        a0000100
        v0000010
        */
    }
}
