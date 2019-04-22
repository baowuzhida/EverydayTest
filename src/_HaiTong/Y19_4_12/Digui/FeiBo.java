package _HaiTong.Y19_4_12.Digui;

public class FeiBo {
    public static void main(String[] args) {
        System.out.println(fibo(10));
        ;
    }
    private static int fibo(int i){
        if(i==1||i==2){
            return 1;
        }else
            return fibo(i-1)+fibo(i-2);
    }
}
