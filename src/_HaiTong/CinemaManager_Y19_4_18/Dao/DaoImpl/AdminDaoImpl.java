package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import _HaiTong.CinemaManager_Y19_4_18.Dao.AdminDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Admin;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.excuteUpdate;
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

    @Override
    public List<Movie> selectMovie() throws Exception {
        String sql = "select * from dvd_movie";
        List<Object> list = new ArrayList<>();
        Class<Movie> cls = Movie.class;
        List<Movie> movies = executeQuery(sql, list, cls);
        if (movies.size() == 0) {
            return null;
        }
        return movies;
    }

    @Override
    public boolean addMovie(List<Movie> movies) throws Exception {
        for (Movie m : movies) {
            String sql = "insert into dvd_movie (m_name,m_duration,m_type,m_info) values (?,?,?,?)";
            List<Object> list = new ArrayList<>();
            list.add(m.getM_name());
            list.add(m.getM_duration());
            list.add(m.getM_type());
            list.add(m.getM_info());
            if(!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }
}
