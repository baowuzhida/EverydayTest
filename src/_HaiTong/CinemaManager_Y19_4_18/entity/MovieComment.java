package _HaiTong.CinemaManager_Y19_4_18.entity;

public class MovieComment {
    private int m_c_id;
    private int m_c_mid;
    private int m_c_uid;
    private String m_comment;
    private int m_point;

    public MovieComment() {
    }

    public MovieComment(int m_c_mid, int m_c_uid, String m_comment, int m_point) {
        this.m_c_mid = m_c_mid;
        this.m_c_uid = m_c_uid;
        this.m_comment = m_comment;
        this.m_point = m_point;
    }

    public MovieComment(int m_c_id, int m_c_mid, int m_c_uid, String m_comment, int m_point) {
        this.m_c_id = m_c_id;
        this.m_c_mid = m_c_mid;
        this.m_c_uid = m_c_uid;
        this.m_comment = m_comment;
        this.m_point = m_point;
    }

    public int getM_c_mid() {
        return m_c_mid;
    }

    public void setM_c_mid(int m_c_mid) {
        this.m_c_mid = m_c_mid;
    }

    public int getM_c_id() {
        return m_c_id;
    }

    public void setM_c_id(int m_c_id) {
        this.m_c_id = m_c_id;
    }

    public int getM_c_uid() {
        return m_c_uid;
    }

    public void setM_c_uid(int m_c_uid) {
        this.m_c_uid = m_c_uid;
    }

    public String getM_comment() {
        return m_comment;
    }

    public void setM_comment(String m_comment) {
        this.m_comment = m_comment;
    }

    public int getM_point() {
        return m_point;
    }

    public void setM_point(int m_point) {
        this.m_point = m_point;
    }

    @Override
    public String toString() {
        return "MovieComment{" +
                "评论编号 = " + m_c_id +
                ", 电影编号 = " + m_c_mid +
                ", 用户编号 = " + m_c_uid +
                ", 用户评论 = '" + m_comment + '\'' +
                ", 用户评分（1-5） = " + m_point +
                '}';
    }
}
