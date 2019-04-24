package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;

import java.util.List;

public interface CinemaDao {


    List<Cinema> selectCinema() throws  Exception;

    boolean addCinema(List<Cinema> cinemas) throws Exception;

    boolean delCinema(int c_id) throws  Exception;

    boolean clearCinema() throws Exception;

    boolean updateCinema(List<Cinema> cinemas) throws  Exception;

    boolean findCinemabyId(int c_id) throws Exception;
}
