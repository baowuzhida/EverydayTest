package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class Admin {
    private int a_id;
    private int a_number;
    private String a_password;

    public Admin() {
    }

    public Admin(int a_id, int a_number, String a_password) {
        this.a_number = a_number;
        this.a_password = a_password;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getA_number() {
        return a_number;
    }

    public void setA_number(int a_number) {
        this.a_number = a_number;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_id=" + a_id +
                ", a_number=" + a_number +
                ", a_password='" + a_password + '\'' +
                '}';
    }
}
