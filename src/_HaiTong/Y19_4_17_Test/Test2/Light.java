package _HaiTong.Y19_4_17_Test.Test2;

public class Light implements ISwitch {
    @Override
    public void on() {
        System.out.println("Light on");
    }

    @Override
    public void off() {
        System.out.println("Light off");
    }
}
