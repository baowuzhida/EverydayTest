package _HaiTong.Y19_4_17_Test.Test1;

public class Test {
    public static void main(String[] args) {
        Work work1 = new Work("zzz",19,2000);
        System.out.println(work1.equals(work1));
        Work work2 = new Work("aaa",20,3000);
        System.out.println(work1.equals(work2));
    }
}
