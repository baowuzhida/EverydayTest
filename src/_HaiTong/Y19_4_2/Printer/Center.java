package _HaiTong.Y19_4_2.Printer;

public class Center  {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Old King");

        Printer printer = new ColorPrinter(student.toString());
        printer.print();
    }
}
