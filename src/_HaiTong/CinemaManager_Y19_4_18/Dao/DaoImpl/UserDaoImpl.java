package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import _HaiTong.CinemaManager_Y19_4_18.Dao.UserDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.User;
import _HaiTong.CinemaManager_Y19_4_18.Util.GlobalUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {


    private GlobalUtil globalUtil = new GlobalUtil();

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
    public List<LinkedHashMap<Object, Object>> selectSessionForUser(int m_id) throws Exception {
        String sql = "SELECT s_id,c_name,h_name,m_name,s_startTime,s_m_duration,s_price,s_h_capacity FROM dvd_session,dvd_cinema,dvd_movie,dvd_hall " +
                "where s_movie = ? AND s_cinema = c_id AND s_hall = h_id AND s_movie = m_id";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        Class<User> cls = User.class;
        List<LinkedHashMap<Object, Object>> lists = executeQueryNocls(sql, list);
        if(lists !=null)
            return lists;
        else
            return null;
    }
}
