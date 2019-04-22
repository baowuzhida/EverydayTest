package _HaiTong.Y19_4_18.ThreadTest;

public class Customer extends Thread {
    private Basket basket;

    public Customer(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.popApple();//拿苹果
    }
}
