package _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl;

import _HaiTong.CinemaManager_Y19_4_18.Biz.UserBiz;
import _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.UserDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.Dao.UserDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

import java.util.LinkedHashMap;
import java.util.List;

public class UserBizImpl implements UserBiz {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean userRegister(String name, String password) throws Exception {
        if (name.equals("") || password.equals(""))
            return false;
        else {
            User user = userDao.resarchByName(name);
            if (user != null)
                return false;
            else {
                if (userDao.registUser(name, password))
                    return true;
                else
                    return false;
            }
        }
    }

    @Override
    public boolean userLogin(String name, String password) throws Exception {
        if (name.equals("") || password.equals(""))
            return false;
        else {
            return userDao.loginUser(name, password);
        }
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectSessionForUser(int m_id) throws Exception {
        return userDao.selectSessionForUser(m_id);
    }
}
