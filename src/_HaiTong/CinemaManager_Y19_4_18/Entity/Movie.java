package _HaiTong.CinemaManager_Y19_4_18.Entity;

public class Movie {
    private int m_id;
    private String m_name;
    private int m_duration;//minute
    private int m_type;
    private String m_info;

    public Movie() {
    }

    public Movie(String m_name, int m_duration, int m_type, String m_info) {
        this.m_name = m_name;
        this.m_duration = m_duration;
        this.m_type = m_type;
        this.m_info = m_info;
    }

    public Movie(int m_id, String m_name, int m_duration, int m_type, String m_info) {
        this.m_id = m_id;
        this.m_name = m_name;
        this.m_duration = m_duration;
        this.m_type = m_type;
        this.m_info = m_info;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getM_duration() {
        return m_duration;
    }

    public void setM_duration(int m_duration) {
        this.m_duration = m_duration;
    }

    public int getM_type() {
        return m_type;
    }

    public void setM_type(int m_type) {
        this.m_type = m_type;
    }

    public String getM_info() {
        return m_info;
    }

    public void setM_info(String m_info) {
        this.m_info = m_info;
    }

    @Override
    public String toString() {
        return "Movie{" +
                " 电影编号='" + m_id + '\'' +
                " 电影名称='" + m_name + '\'' +
                ", 电影时长=" + m_duration +
                ", 电影类型=" + m_type +
                ", 电影详情='" + m_info + '\'' +
                '}';
    }
}
