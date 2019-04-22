package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class Ticket {
    private int t_id;
    private int t_user;
    private int t_session;
    private int t_seat;

    public Ticket() {
    }

    public Ticket(int t_user, int t_session, int t_seat) {
        this.t_user = t_user;
        this.t_session = t_session;
        this.t_seat = t_seat;
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
}
