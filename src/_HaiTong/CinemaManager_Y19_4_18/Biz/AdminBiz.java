package _HaiTong.CinemaManager_Y19_4_18.Biz;

import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;

import java.util.List;

public interface AdminBiz {

    boolean adminLogin(String name,String password) throws Exception;

    List<Movie> selectMovie() throws  Exception;

    boolean addMovie(List<Movie> movies) throws Exception;
}
