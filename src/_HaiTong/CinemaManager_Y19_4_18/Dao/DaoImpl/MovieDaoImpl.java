package _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl;

import _HaiTong.CinemaManager_Y19_4_18.Dao.MovieDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.executeQuery;

public class MovieDaoImpl implements MovieDao {


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
    public Movie findMoviebyId(int m_id) throws Exception {
        String sql = "select * from dvd_movie where m_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        Class<Movie> cls = Movie.class;
        List<Movie> movies = executeQuery(sql, list, cls);
        if (movies.size() == 0) {
            return null;
        }
        return movies.get(0);
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
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean delMovie(int m_id) throws Exception {
        String sql = "delete from dvd_movie where m_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(m_id);
        if (!excuteUpdate(sql, list))
            return false;
        return true;
    }

    @Override
    public boolean clearMovie() throws Exception {
        String sql = "truncate table dvd_movie";//重置表
        List<Object> list = new ArrayList<>();
        excuteUpdate(sql, list);
        return true;
    }

    @Override
    public boolean updateMovie(List<Movie> movies) throws Exception {
        for (Movie m : movies) {
            List<Object> list = new ArrayList<>();
            StringBuilder sqlbuilder = new StringBuilder();
            sqlbuilder.append("update dvd_movie set ");
            if (!m.getM_name().equals("-1")) {
                sqlbuilder.append(" m_name = ? ");
                list.add(m.getM_name());
            } else {
                sqlbuilder.append(" m_name = m_name ");
            }
            if (m.getM_duration() != -1) {
                sqlbuilder.append(" ,m_duration = ? ");
                list.add(m.getM_duration());
            }
            if (m.getM_type() != -1) {
                sqlbuilder.append(" ,m_type = ? ");
                list.add(m.getM_type());
            }
            if (!m.getM_info().equals("-1")) {
                sqlbuilder.append(" ,m_info = ? ");
                list.add(m.getM_info());
            }
            sqlbuilder.append(" where m_id = ? ");
            list.add(m.getM_id());
            String sql = sqlbuilder.toString();
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }


}
