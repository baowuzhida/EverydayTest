package _HaiTong.CinemaManager_Y19_4_18.Dao;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

public interface UserDao {
    User resarchByName(String name) throws Exception;

    Boolean registUser(String name,String password) throws Exception;

    Boolean loginUser(String name,String password) throws  Exception;

}
