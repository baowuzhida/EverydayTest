package _HaiTong.CinemaManager_Y19_4_18.Biz;

import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;

import java.util.List;

public interface MovieBiz {

    List<Movie> selectMovie() throws  Exception;

    boolean addMovie(List<Movie> movies) throws Exception;

    boolean delMovie(int m_id) throws  Exception;

    boolean updateMovie(List<Movie> movies) throws  Exception;

    Movie findMoviebyId(int m_id) throws Exception;
}
