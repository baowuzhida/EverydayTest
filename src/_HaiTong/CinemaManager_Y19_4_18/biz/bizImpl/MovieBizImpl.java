package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.MovieDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.dao.MovieDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;

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
    public Movie findMoviebyId(int m_id) throws Exception {
        return movieDao.findMoviebyId(m_id);
    }
}
