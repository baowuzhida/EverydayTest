package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;

import java.util.List;

public interface AdminDao {

    boolean loginAdmin(Integer number,String password) throws  Exception;

    boolean adminChangePassword(String new_password) throws Exception;

    List<BoxOffice> selectBoxOffice() throws  Exception;


}
