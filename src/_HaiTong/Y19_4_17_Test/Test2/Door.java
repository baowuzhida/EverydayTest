package _HaiTong.Y19_4_17_Test.Test2;

public class Door implements ISwitch {
    @Override
    public void on() {
        System.out.println("Door on");
    }

    @Override
    public void off() {
        System.out.println("Door off");
    }
}
