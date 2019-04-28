package _HaiTong.CinemaManager_Y19_4_18.entity;

public class BoxOffice {

    private int b_id;
    private int b_movie;
    private String b_m_name;
    private long b_ticketsum;
    private double b_sumearning;

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getB_movie() {
        return b_movie;
    }

    public void setB_movie(int b_movie) {
        this.b_movie = b_movie;
    }

    public long getB_ticketsum() {
        return b_ticketsum;
    }

    public void setB_ticketsum(long b_ticketsum) {
        this.b_ticketsum = b_ticketsum;
    }

    public double getB_sumearning() {
        return b_sumearning;
    }

    public void setB_sumearning(double b_sumearning) {
        this.b_sumearning = b_sumearning;
    }

    public String getB_m_name() {
        return b_m_name;
    }

    public void setB_m_name(String b_m_name) {
        this.b_m_name = b_m_name;
    }

    @Override
    public String toString() {
        return "BoxOffice{" +
                "电影编号 = " + b_movie +
                ", 电影名称 = " + b_m_name +
                ", 售出票总数 = " + b_ticketsum +
                ", 总共收入 = " + b_sumearning +
                '}';
    }
}
