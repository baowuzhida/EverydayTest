package _HaiTong.CinemaManager_Y19_4_18.Entity;

import java.sql.Time;
import java.util.Date;

public class Session {
    private int s_id;
    private int s_cinema;
    private int s_hall;
    private int s_movie;
    private Time s_startTime;
    private Time s_overTime;
    private double s_price;
    private int s_h_capacity;

    public Session() {
    }

    public Session(int s_cinema, int s_hall, int s_movie, Time s_startTime, Time s_overTime, double s_price, int s_h_capacity) {
        this.s_cinema = s_cinema;
        this.s_hall = s_hall;
        this.s_movie = s_movie;
        this.s_startTime = s_startTime;
        this.s_overTime = s_overTime;
        this.s_price = s_price;
        this.s_h_capacity = s_h_capacity;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_cinema() {
        return s_cinema;
    }

    public void setS_cinema(int s_cinema) {
        this.s_cinema = s_cinema;
    }

    public int getS_hall() {
        return s_hall;
    }

    public void setS_hall(int s_hall) {
        this.s_hall = s_hall;
    }

    public int getS_movie() {
        return s_movie;
    }

    public void setS_movie(int s_movie) {
        this.s_movie = s_movie;
    }

    public Time getS_startTime() {
        return s_startTime;
    }

    public void setS_startTime(Time s_startTime) {
        this.s_startTime = s_startTime;
    }

    public Time getS_overTime() {
        return s_overTime;
    }

    public void setS_overTime(Time s_overTime) {
        this.s_overTime = s_overTime;
    }

    public double getS_price() {
        return s_price;
    }

    public void setS_price(double s_price) {
        this.s_price = s_price;
    }

    public int getS_h_capacity() {
        return s_h_capacity;
    }

    public void setS_h_capacity(int s_h_capacity) {
        this.s_h_capacity = s_h_capacity;
    }

    @Override
    public String toString() {
        return "Session{" +
                "s_id=" + s_id +
                ", s_cinema=" + s_cinema +
                ", s_hall=" + s_hall +
                ", s_movie=" + s_movie +
                ", s_startTime=" + s_startTime +
                ", s_overTime=" + s_overTime +
                ", s_price=" + s_price +
                ", s_h_capacity=" + s_h_capacity +
                '}';
    }
}
