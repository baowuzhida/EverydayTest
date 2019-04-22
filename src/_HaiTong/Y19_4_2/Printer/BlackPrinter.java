package _HaiTong.Y19_4_2.Printer;

public class BlackPrinter extends  Printer{

    public BlackPrinter(String message){
        super(message);
    }

    public void print(){
        System.out.println(getMessage()+" [ColorPrint]");
    }
}
