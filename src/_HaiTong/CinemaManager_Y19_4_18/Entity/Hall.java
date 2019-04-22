package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class Hall {
    private int h_id;
    private String h_name;
    private int h_cinema;//cinema->c_id
    private int h_capacity;// 1-n

    public Hall() {
    }

    public Hall(String h_name, int h_cinema, int h_capacity) {
        this.h_name = h_name;
        this.h_cinema = h_cinema;
        this.h_capacity = h_capacity;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public int getH_cinema() {
        return h_cinema;
    }

    public void setH_cinema(int h_cinema) {
        this.h_cinema = h_cinema;
    }

    public int getH_capacity() {
        return h_capacity;
    }

    public void setH_capacity(int h_capacity) {
        this.h_capacity = h_capacity;
    }
}
