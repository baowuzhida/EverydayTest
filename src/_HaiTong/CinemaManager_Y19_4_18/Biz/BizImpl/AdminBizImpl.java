package _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl;

import _HaiTong.CinemaManager_Y19_4_18.Biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.Dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean adminLogin(String number, String password) throws Exception {
        if (number.equals("") || password.equals(""))
            return false;
        else {
            return adminDao.loginAdmin(number, password);
        }
    }
}
