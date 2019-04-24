package _HaiTong.CinemaManager_Y19_4_18.entity;

public class Ticket {
    private int t_id;
    private int t_user;
    private int t_session;
    private int t_seat;
    private int t_cinema;
    private int t_hall;
    private int t_movie;
    private double t_price;

    public Ticket() {
    }

    public Ticket(int t_user, int t_session, int t_seat, int t_cinema, int t_hall, int t_movie, double t_price) {
        this.t_user = t_user;
        this.t_session = t_session;
        this.t_seat = t_seat;
        this.t_cinema = t_cinema;
        this.t_hall = t_hall;
        this.t_movie = t_movie;
        this.t_price = t_price;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getT_user() {
        return t_user;
    }

    public void setT_user(int t_user) {
        this.t_user = t_user;
    }

    public int getT_session() {
        return t_session;
    }

    public void setT_session(int t_session) {
        this.t_session = t_session;
    }

    public int getT_seat() {
        return t_seat;
    }

    public void setT_seat(int t_seat) {
        this.t_seat = t_seat;
    }

    public int getT_cinema() {
        return t_cinema;
    }

    public void setT_cinema(int t_cinema) {
        this.t_cinema = t_cinema;
    }

    public int getT_hall() {
        return t_hall;
    }

    public void setT_hall(int t_hall) {
        this.t_hall = t_hall;
    }

    public int getT_movie() {
        return t_movie;
    }

    public void setT_movie(int t_movie) {
        this.t_movie = t_movie;
    }

    public double getT_price() {
        return t_price;
    }

    public void setT_price(double t_price) {
        this.t_price = t_price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "影票编号=" + t_id +
                ", 用户编号=" + t_user +
                ", 场次编号=" + t_session +
                ", 座位编号=" + t_seat +
                ", 影院编号=" + t_cinema +
                ", 场厅编号=" + t_hall +
                ", 电影编号=" + t_movie +
                ", 电影价格=" + t_price +
                '}';
    }
}
