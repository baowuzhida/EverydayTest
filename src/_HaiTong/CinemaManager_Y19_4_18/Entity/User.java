package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class User {
    private int u_id;
    private String u_name;
    private String u_password;
    private int u_type;// 0->primary  1->vip
    private double u_account;//  vip>=500

    public User() {
    }

    public User(String u_name, String u_password, int u_type, double u_account) {
        this.u_name = u_name;
        this.u_password = u_password;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }

    public double getU_account() {
        return u_account;
    }

    public void setU_account(double u_account) {
        this.u_account = u_account;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_password='" + u_password + '\'' +
                ", u_type=" + u_type +
                ", u_account=" + u_account +
                '}';
    }
}
