package _HaiTong.CinemaManager_Y19_4_18.Biz;

public interface UserBiz {

    boolean userRegister(String name,String password) throws Exception;

    boolean userLogin(String name,String password) throws Exception;
}
