package _HaiTong.Y19_4_18.ThreadTest;

public class Apple {
    private int name;

    public Apple() {
    }

    public Apple(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}
