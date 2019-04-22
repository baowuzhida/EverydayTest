package _HaiTong.Y19_4_2.Printer;

public class ColorPrinter extends Printer{

    public ColorPrinter(String message){
        super(message);
    }

    public void print(){
        System.out.println(getMessage()+" [ColorPrint]");
    }
}
