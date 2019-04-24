package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> selectMovie() throws Exception;

    Movie findMoviebyId(int m_id) throws Exception;

    boolean addMovie(List<Movie> movies) throws Exception;

    boolean delMovie(int m_id) throws  Exception;

    boolean updateMovie(List<Movie> movies) throws  Exception;

    boolean clearMovie() throws Exception;
}
