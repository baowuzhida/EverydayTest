package _HaiTong.Y19_4_2.Printer;

public abstract class Printer implements print{

    private String message;

    public Printer(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

}
