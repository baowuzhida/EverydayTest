package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import _HaiTong.CinemaManager_Y19_4_18.Dao.UserDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.User;
import _HaiTong.CinemaManager_Y19_4_18.Util.GlobalUtil;

import java.util.ArrayList;
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
}
