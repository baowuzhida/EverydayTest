package _HaiTong.CinemaManager_Y19_4_18.Entity;

import java.sql.Time;
import java.util.Date;

public class Session {
    private int s_id;
    private int s_cinema;
    private int s_hall;
    private int s_movie;
    private Date s_startTime;
    private Date s_endTime;
    private int s_m_duration;
    private double s_price;
    private int s_h_capacity;//剩余票数量

    public Session() {
    }

    public Session(int s_cinema, int s_hall, int s_movie, Date s_startTime, Date s_endTime, int s_m_duration, double s_price, int s_h_capacity) {
        this.s_cinema = s_cinema;
        this.s_hall = s_hall;
        this.s_movie = s_movie;
        this.s_startTime = s_startTime;
        this.s_endTime = s_endTime;
        this.s_m_duration = s_m_duration;
        this.s_price = s_price;
        this.s_h_capacity = s_h_capacity;
    }

    public Session(int s_id, int s_cinema, int s_hall, int s_movie, Date s_startTime, Date s_endTime, int s_m_duration, double s_price, int s_h_capacity) {
        this.s_id = s_id;
        this.s_cinema = s_cinema;
        this.s_hall = s_hall;
        this.s_movie = s_movie;
        this.s_startTime = s_startTime;
        this.s_endTime = s_endTime;
        this.s_m_duration = s_m_duration;
        this.s_price = s_price;
        this.s_h_capacity = s_h_capacity;
    }

    public Date getS_endTime() {
        return s_endTime;
    }

    public void setS_endTime(Date s_endTime) {
        this.s_endTime = s_endTime;
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

    public Date getS_startTime() {
        return s_startTime;
    }

    public void setS_startTime(Date s_startTime) {
        this.s_startTime = s_startTime;
    }

    public int getS_m_duration() {
        return s_m_duration;
    }

    public void setS_m_duration(int s_m_duration) {
        this.s_m_duration = s_m_duration;
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
                "场次编号=" + s_id +
                ", 所属影院=" + s_cinema +
                ", 所属厂厅=" + s_hall +
                ", 所属电影=" + s_movie +
                ", 开始时间=" + s_startTime +
                ", 结束时间=" + s_endTime +
                ", 持续时间=" + s_m_duration +
                ", 影票价格=" + s_price +
                ", 剩余票数=" + s_h_capacity +
                '}';
    }
}
