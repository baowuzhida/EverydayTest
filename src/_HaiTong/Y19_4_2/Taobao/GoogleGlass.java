package _HaiTong.Y19_4_2.Taobao;

public class GoogleGlass extends Elec implements IChargeable,IWearable {

    @Override
    public void charge() {
        System.out.println("Charge glass");
    }

    @Override
    public void wear() {
        System.out.println("Wear glass");
    }
}
