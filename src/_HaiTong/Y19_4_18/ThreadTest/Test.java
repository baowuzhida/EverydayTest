package _HaiTong.Y19_4_18.ThreadTest;

public class Test {
    public static void main(String[] args) {
        Basket basket=new Basket();
        Customer customer=new Customer(basket);
        Producter producter=new Producter(basket);
        customer.start();
        producter.start();
    }
}
