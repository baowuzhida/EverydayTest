package _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl;

import _HaiTong.CinemaManager_Y19_4_18.Biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.Dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.AdminDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;

import java.util.List;

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

    @Override
    public List<Movie> selectMovie() throws Exception {
        return adminDao.selectMovie();
    }

    @Override
    public boolean addMovie(List<Movie> movies) throws Exception {
        return adminDao.addMovie(movies);
    }
}
