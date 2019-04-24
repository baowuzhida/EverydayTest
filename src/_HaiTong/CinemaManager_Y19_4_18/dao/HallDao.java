package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;

import java.util.List;

public interface HallDao {
    List<Hall> selectHall() throws  Exception;

    boolean addHall(List<Hall> halls) throws Exception;

    boolean delHall(int h_id) throws  Exception;

    boolean clearHall() throws Exception;

    boolean updateHall(List<Hall> halls) throws  Exception;

    boolean findHallbyId(int h_id) throws Exception;
}
