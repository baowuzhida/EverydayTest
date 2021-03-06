package _HaiTong.CinemaManager_Y19_4_18.biz;

import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;

import java.util.List;

public interface HallBiz {


    List<Hall> selectHall() throws Exception;

    List<Hall> findHallbyCid(int c_id) throws  Exception;

    boolean addHall(List<Hall> halls) throws Exception;

    boolean delHall(int h_id) throws Exception;

    boolean updateHall(List<Hall> halls) throws Exception;

    boolean findHallbyId(int h_id) throws Exception;

    boolean findHallbyIdCid(int h_id,int c_id) throws Exception;
}
