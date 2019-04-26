package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.SessionDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.executeQuery;

public class SessionDaoImpl implements SessionDao {
    @Override
    public List<Session> selectSession() throws Exception {
        String sql = "select * from dvd_session";
        List<Object> list = new ArrayList<>();
        Class<Session> cls = Session.class;
        List<Session> sessions = executeQuery(sql, list, cls);
        if (sessions.size() == 0) {
            return null;
        }
        return sessions;
    }

    @Override
    public boolean findSessionbyId(int s_id) throws Exception {
        String sql = "select * from dvd_session where s_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(s_id);
        Class<Session> cls = Session.class;
        List<Session> sessions = executeQuery(sql, list, cls);
        if (sessions.size() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addSession(List<Session> sessions) throws Exception {
        for (Session s : sessions) {
            String sql = "insert into dvd_session (s_cinema,s_hall,s_movie,s_startTime,s_endTime,s_m_duration,s_price,s_h_capacity) " +
                    "values (?,?,?,?,?,?,?,( SELECT h_capacity FROM dvd_hall WHERE h_id = ? ))";
            List<Object> list = new ArrayList<>();
            list.add(s.getS_cinema());
            list.add(s.getS_hall());
            list.add(s.getS_movie());
            list.add(s.getS_startTime());
            list.add(s.getS_endTime());
            list.add(s.getS_m_duration());
            list.add(s.getS_price());
            list.add(s.getS_hall());
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean delSession(int s_id) throws Exception {
        String sql = "delete from dvd_session where s_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(s_id);
        if (!excuteUpdate(sql, list))
            return false;
        return true;
    }

    @Override
    public boolean updateSession(List<Session> sessions) throws Exception {
        for (Session s : sessions) {
            List<Object> list = new ArrayList<>();
            StringBuilder sqlbuilder = new StringBuilder();
            sqlbuilder.append("update dvd_session set ");
            sqlbuilder.append(" s_id = s_id ");
            if (s.getS_cinema() != -1) {
                sqlbuilder.append(" ,s_cinema = ? ");
                list.add(s.getS_cinema());
            }
            if (s.getS_hall() != -1) {
                sqlbuilder.append(" ,s_hall = ? ");
                list.add(s.getS_hall());
            }
            if (s.getS_movie() != -1) {
                sqlbuilder.append(" ,s_movie = ? ");
                list.add(s.getS_movie());
            }
            if (s.getS_startTime() != null) {
                sqlbuilder.append(" ,s_startTime = ? ");
                list.add(s.getS_startTime());
            }
            if (s.getS_endTime() != null) {
                sqlbuilder.append(" ,s_endTime = ? ");
                list.add(s.getS_endTime());
            }
            if (s.getS_m_duration() != -1) {
                sqlbuilder.append(" ,s_m_duration = ? ");
                list.add(s.getS_m_duration());
            }
            if (s.getS_price() != -1) {
                sqlbuilder.append(" ,s_price = ? ");
                list.add(s.getS_price());
            }
            if (s.getS_h_capacity() != -1) {
                sqlbuilder.append(" ,s_h_capacity = ? ");
                list.add(s.getS_h_capacity());
            }
            sqlbuilder.append(" where s_id = ? ");
            list.add(s.getS_id());
            String sql = sqlbuilder.toString();
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean clearSession() throws Exception {
        String sql = "truncate table dvd_session";//重置表
        List<Object> list = new ArrayList<>();
        excuteUpdate(sql, list);
        return true;
    }

    @Override
    public boolean selectIfConflict(int c_id, int h_id, int m_id, Date start, Date end) throws Exception {
        String sql = "SELECT * FROM dvd_session  WHERE s_cinema = ? AND s_hall = ? AND s_movie = ? " +
                "AND NOT ((s_startTime > ? OR s_endTime < ? ))";
        List<Object> list = new ArrayList<>();
        list.add(c_id);
        list.add(h_id);
        list.add(m_id);
        list.add(end);
        list.add(start);
        Class<Session> cls = Session.class;
        List<Session> sessions = executeQuery(sql, list, cls);
        if (sessions.size() == 0) {
            return false;
        }
        return true;
    }
}
