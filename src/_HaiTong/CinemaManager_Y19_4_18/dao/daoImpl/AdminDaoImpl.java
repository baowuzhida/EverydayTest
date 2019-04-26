package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Admin;
import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.executeQuery;

public class AdminDaoImpl implements AdminDao {

    GlobalUtil globalUtil = new GlobalUtil();

    private Admin adminInfo;

    @Override
    public boolean loginAdmin(Integer number, String password) throws Exception {
        String sql = "select * from dvd_admin where a_number = ? and a_password = ?";
        List<Object> list = new ArrayList<>();
        list.add(number);
        list.add(password);
        Class<Admin> cls = Admin.class;
        List<Admin> admins = executeQuery(sql, list, cls);
        if (admins.size() == 0) {
            return false;
        }
        globalUtil.setAdminInfo(admins.get(0));
        return true;
    }

    @Override
    public boolean adminChangePassword(String new_password) throws Exception {
        adminInfo = globalUtil.getAdminInfo();
        String sql = "UPDATE dvd_admin SET a_password = ? WHERE a_id = ? ";
        List<Object> list = new ArrayList<>();
        list.add(new_password);
        list.add(adminInfo.getA_id());

        if (excuteUpdate(sql, list)) {
            loginAdmin(adminInfo.getA_number(), adminInfo.getA_password());
            return true;
        } else
            return false;
    }

    @Override
    public List<BoxOffice> selectBoxOffice() throws Exception {
        String sql = "select * from dvd_boxoffice";
        List<Object> list = new ArrayList<>();
        Class<BoxOffice> cls = BoxOffice.class;
        List<BoxOffice> boxOffices = executeQuery(sql, list, cls);
        if (boxOffices.size() == 0) {
            return null;
        }
        return boxOffices;
    }

}
