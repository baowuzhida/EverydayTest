package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class Cinema {
    private int c_id;
    private String c_name;
    private String c_address;
    private String c_info;

    public Cinema() {
    }

    public Cinema(String c_name, String c_address, String c_info) {
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_info = c_info;
    }

    public Cinema(int c_id, String c_name, String c_address, String c_info) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.c_address = c_address;
        this.c_info = c_info;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_info() {
        return c_info;
    }

    public void setC_info(String c_info) {
        this.c_info = c_info;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "电影院编号=" + c_id +
                ", 电影院名称='" + c_name + '\'' +
                ", 电影院地址='" + c_address + '\'' +
                ", 电影院信息='" + c_info + '\'' +
                '}';
    }
}

