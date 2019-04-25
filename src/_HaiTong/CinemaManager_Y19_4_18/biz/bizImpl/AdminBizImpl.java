package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public boolean adminLogin(String number, String password) throws Exception {
        if (number.equals("") || password.equals(""))
            return false;
        else {
            return adminDao.loginAdmin(number, password);
        }
    }


}
