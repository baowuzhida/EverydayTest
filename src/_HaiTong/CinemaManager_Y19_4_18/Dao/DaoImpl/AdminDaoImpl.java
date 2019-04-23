package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import _HaiTong.CinemaManager_Y19_4_18.Dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Admin;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.executeQuery;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean loginAdmin(String number, String password) throws Exception {
        String sql = "select * from dvd_admin where a_number = ? and a_password = ?";
        List<Object> list = new ArrayList<>();
        list.add(number);
        list.add(password);
        Class<Admin> cls = Admin.class;
        List<Admin> admins = executeQuery(sql, list, cls);
        if (admins.size() == 0) {
            return false;
        }
        return true;
    }

}
