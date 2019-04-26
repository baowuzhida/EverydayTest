package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.AdminDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.entity.Admin;
import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;

import java.util.List;

public class AdminBizImpl implements AdminBiz {

    private AdminDao adminDao = new AdminDaoImpl();

    private GlobalUtil globalUtil = new GlobalUtil();

    private Admin adminInfo;

    @Override
    public boolean adminLogin(Integer number, String password) throws Exception {
        if (number == null || password.equals(""))
            return false;
        else {
            return adminDao.loginAdmin(number, password);
        }
    }

    @Override
    public Integer adminChangePassword(String old, String new1, String new2) throws Exception {
        adminInfo = globalUtil.getAdminInfo();
        if (old.equals(adminInfo.getA_password())) {
            if (new1.equals(new2))
                if (adminDao.adminChangePassword(new1))
                    return 1;
                else
                    return 4;//修改失败
            else
                return 3;//两次密码不一致
        } else
            return 2;//原密码错误
    }

    @Override
    public List<BoxOffice> selectBoxOffice() throws Exception {
        return adminDao.selectBoxOffice();
    }


}
