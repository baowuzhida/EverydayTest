package _HaiTong.Y19_4_2.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {;
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Train());

        for (Vehicle vehicle : vehicles) vehicle.drive();
    }
}
