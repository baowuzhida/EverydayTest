package _HaiTong.Y19_4_18.ThreadTest;

public class Producter extends Thread {
    private Basket basket;

    public Producter(Basket basket) {
        this.basket = basket;
    }

    @Override
    public void run() {
        basket.pushApple();//生产
    }
}
