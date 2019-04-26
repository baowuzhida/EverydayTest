package _HaiTong.CinemaManager_Y19_4_18.biz;

import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;

import java.util.List;

public interface AdminBiz {

    boolean adminLogin(Integer number,String password) throws Exception;

    Integer adminChangePassword(String old ,String new1,String new2) throws Exception;

    List<BoxOffice> selectBoxOffice() throws  Exception;



}
