package _HaiTong.Y19_4_17_Test.Test2;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        ISwitch door = new Door();
        ISwitch light = new Light();
        ISwitch fan = new Fan();
        person.open(door);
        person.close(door);
        person.open(light);
        person.close(light);
        person.open(fan);
        person.close(fan);
    }
}
