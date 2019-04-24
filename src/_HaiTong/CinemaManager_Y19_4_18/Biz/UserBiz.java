package _HaiTong.CinemaManager_Y19_4_18.Biz;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserBiz {

    boolean userRegister(String name,String password) throws Exception;

    boolean userLogin(String name,String password) throws Exception;

    List<LinkedHashMap<Object, Object>> selectSessionForUser(int m_id) throws Exception;
}
