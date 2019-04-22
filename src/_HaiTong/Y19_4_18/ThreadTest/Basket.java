package _HaiTong.Y19_4_18.ThreadTest;

import java.util.LinkedList;

public class Basket {
    private LinkedList<Apple> linkedList;

    public Basket() {
        this.linkedList = new LinkedList<Apple>();
    }

    //生产苹果
    public void push(Apple apple) {
        if (linkedList.size() == 5) {//已经放了五个
            this.notify();//先通知消费者来消费
            try {
                this.wait();//释放锁,需要等待其他线程来唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(200);//不会释放锁，到时间自动开启
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        linkedList.addFirst(apple);
        System.out.println("放入" + apple);
    }


    //消费一个苹果
    public void pop() {
        if (linkedList.size() == 0) {
            notify();//通知生产者生产
            try {
                wait();//释放锁
            } catch (InterruptedException e) {

            }
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Apple apple = linkedList.remove();
        System.out.println("eating apple:" + apple);
    }

    public synchronized void pushApple() {//同步方法锁的是这个类this
        for (int i = 1; i <= 20; i++) {
            Apple apple = new Apple(i);
            push(apple);
        }
        notify();//唤醒线程
    }

    public synchronized void popApple() {
        for (int i = 1; i <= 20; i++) {
            pop();
        }
    }
}
