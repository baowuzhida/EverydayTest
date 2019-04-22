package _HaiTong.Y19_4_17_Test.Test2;

public class Fan implements ISwitch {
    @Override
    public void on() {
        System.out.println("Fan on");
    }

    @Override
    public void off() {
        System.out.println("Fan ff");
    }
}
