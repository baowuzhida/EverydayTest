package _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl;

import _HaiTong.CinemaManager_Y19_4_18.Biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.MovieDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.Dao.MovieDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;

import java.util.List;

public class MovieBizImpl implements MovieBiz {

    MovieDao movieDao = new MovieDaoImpl();

    @Override
    public List<Movie> selectMovie() throws Exception {
        return movieDao.selectMovie();
    }

    @Override
    public boolean addMovie(List<Movie> movies) throws Exception {
        return movieDao.addMovie(movies);
    }

    @Override
    public boolean delMovie(int m_id) throws Exception {
        if (m_id == -1)
            return movieDao.clearMovie();
        else
            return movieDao.delMovie(m_id);
    }

    @Override
    public boolean updateMovie(List<Movie> movies) throws Exception {
        return movieDao.updateMovie(movies);

    }

    @Override
    public boolean findMoviebyId(int m_id) throws Exception {
        return movieDao.findMoviebyId(m_id);
    }
}
