package _HaiTong.CinemaManager_Y19_4_18.Dao;

import _HaiTong.CinemaManager_Y19_4_18.Entity.Cinema;

import java.util.List;

public interface CinemaDao {


    List<Cinema> selectCinema() throws  Exception;

    boolean addCinema(List<Cinema> cinemas) throws Exception;

    boolean delCinema(int c_id) throws  Exception;

    boolean clearCinema() throws Exception;

    boolean updateCinema(List<Cinema> cinemas) throws  Exception;

    boolean findCinemabyId(int c_id) throws Exception;
}
