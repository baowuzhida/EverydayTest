package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.UserDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.*;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    private GlobalUtil globalUtil = new GlobalUtil();
    private User userInfo;

    @Override
    public User resarchByName(String name) throws Exception {
        String sql = "select * from dvd_user where u_name = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        Class<User> cls = User.class;
        List<User> users = executeQuery(sql, list, cls);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    @Override
    public Integer getCapacityByShid(int s_hall) throws Exception {
        String sql = "select * from dvd_hall where h_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(s_hall);
        Class<Hall> cls = Hall.class;
        List<Hall> halls = executeQuery(sql, list, cls);
        if (halls.size() == 0) {
            return null;
        }
        return halls.get(0).getH_capacity();
    }

    @Override
    public Boolean userChangePassword(String new_password) throws Exception {
        userInfo = globalUtil.getUserInfo();
        String sql = "UPDATE dvd_user SET u_password = ? WHERE u_id = ? ";
        List<Object> list = new ArrayList<>();
        list.add(new_password);
        list.add(userInfo.getU_id());

        if (excuteUpdate(sql, list)) {
            loginUser(userInfo.getU_name(), userInfo.getU_password());
            return true;
        } else
            return false;
    }

    @Override
    public Boolean userRecharge(int account, int ifvip) throws Exception {
        userInfo = globalUtil.getUserInfo();
        List<Object> list = new ArrayList<>();
        StringBuilder sqlbuilder = new StringBuilder();
        sqlbuilder.append("UPDATE dvd_user SET u_account = u_account + ? , ");
        list.add(account);
        if (ifvip == 1) {
            sqlbuilder.append(" u_type = ? ");
            list.add(ifvip);
        } else
            sqlbuilder.append(" u_type = u_type ");
        sqlbuilder.append(" WHERE u_id = ? ");
        list.add(userInfo.getU_id());
        String sql = sqlbuilder.toString();
        if (excuteUpdate(sql, list)) {
            loginUser(userInfo.getU_name(), userInfo.getU_password());
            return true;
        } else
            return false;
    }

    @Override
    public Boolean registUser(String name, String password) throws Exception {
        String sql = "insert into dvd_user (u_name,u_password) values (?,?)";
        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(password);

        return excuteUpdate(sql, list);
    }

    @Override
    public Boolean loginUser(String name, String password) throws Exception {
        String sql = "select * from dvd_user where u_name = ? and u_password = ?";
        List<Object> list = new ArrayList<>();
        list.add(name);
        list.add(password);
        Class<User> cls = User.class;
        List<User> users = executeQuery(sql, list, cls);
        if (users.size() == 0) {
            return false;
        }
        globalUtil.setUserInfo(users.get(0));
        return true;
    }

    @Override
    public Boolean userBuyTicket(int u_id, Session session, double after_account, int seat) throws Exception {
        userInfo = globalUtil.getUserInfo();
        String sql1 = "INSERT into dvd_ticket (t_user,t_session,t_seat,t_cinema,t_hall,t_movie,t_price) values (?,?,?,?,?,?,?)";
        List<Object> list1 = new ArrayList<>();
        list1.add(u_id);
        list1.add(session.getS_id());
        list1.add(seat);
        list1.add(session.getS_cinema());
        list1.add(session.getS_hall());
        list1.add(session.getS_movie());
        list1.add(session.getS_price());
        if (excuteUpdate(sql1, list1)) {
            String sql2 = "UPDATE dvd_boxoffice, dvd_user,dvd_session SET u_account = ? , s_h_capacity = s_h_capacity - 1 ,b_ticketsum = b_ticketsum + 1 ,b_sumearning = b_sumearning + ?  " +
                    "WHERE u_id = ? AND s_id = ? AND b_movie = ?";
            List<Object> list2 = new ArrayList<>();
            list2.add(after_account);
            list2.add(session.getS_price());
            list2.add(u_id);
            list2.add(session.getS_id());
            list2.add(session.getS_movie());
            if (excuteUpdate(sql2, list2) && loginUser(userInfo.getU_name(), userInfo.getU_password())) {
                return true;
            } else
                return false;
        }
        return false;
    }

    @Override
    public Session selectSessionForUser(int m_id, int c_id, int s_id) throws Exception {
        String sql = "SELECT * FROM dvd_session WHERE s_movie = ? AND s_cinema = ? AND s_id = ? AND s_startTime > NOW()";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        list.add(c_id);
        list.add(s_id);
        Class<Session> cls = Session.class;
        List<Session> sessions = executeQuery(sql, list, cls);
        if (sessions.size() > 0)
            return sessions.get(0);
        else
            return null;
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectSessionListForUser(int m_id, int c_id) throws Exception {
        String sql = "SELECT s_id,c_name,h_name,m_name,s_startTime,s_m_duration,s_price,s_h_capacity,h_capacity  FROM dvd_session,dvd_cinema,dvd_movie,dvd_hall " +
                "WHERE s_movie = ? AND s_cinema = ? AND s_cinema = c_id AND s_hall = h_id AND s_movie = m_id AND s_startTime > NOW()";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        list.add(c_id);
        List<LinkedHashMap<Object, Object>> lists = executeQueryNocls(sql, list);
        if (lists.size() > 0)
            return lists;
        else
            return null;
    }

    @Override
    public List<BoxOffice> selectHotMovie() throws Exception {
        String sql = "SELECT * FROM dvd_boxoffice ORDER BY b_ticketsum DESC LIMIT 3";//找前三
        List<Object> list = new ArrayList<>();
        Class<BoxOffice> cls = BoxOffice.class;
        List<BoxOffice> boxOffices = executeQuery(sql, list, cls);
        if (boxOffices.size() > 0)
            return boxOffices;
        else
            return null;
    }

    @Override
    public List<Cinema> selectCinemaFromMid(int m_id) throws Exception {
        String sql = "SELECT DISTINCT c_id,c_name,c_address,c_info FROM dvd_session,dvd_cinema,dvd_movie WHERE s_movie = ? AND s_cinema = c_id";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        Class<Cinema> cls = Cinema.class;
        List<Cinema> cinemas = executeQuery(sql, list, cls);
        if (cinemas.size() > 0)
            return cinemas;
        else
            return null;
    }

    @Override
    public List<Ticket> selectTicketFromSid(int s_id) throws Exception {
        String sql = "SELECT * FROM dvd_ticket WHERE t_session = ?";
        List<Object> list = new ArrayList<>();
        list.add(s_id);
        Class<Ticket> cls = Ticket.class;
        List<Ticket> tickets = executeQuery(sql, list, cls);
        if (tickets.size() > 0)
            return tickets;
        else
            return null;
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectTicketFromUid(int u_id) throws Exception {
        String sql = "SELECT t_id,t_user,t_session,t_seat,c_name,h_name,m_name,t_price FROM dvd_ticket,dvd_cinema,dvd_movie,dvd_hall " +
                "WHERE t_user = ? AND t_cinema = c_id AND t_hall = h_id AND t_movie = m_id";
        List<Object> list = new ArrayList<>();
        list.add(u_id);
        List<LinkedHashMap<Object, Object>> ticketsList = executeQueryNocls(sql, list);
        if (ticketsList.size() > 0)
            return ticketsList;
        else
            return null;
    }
}
