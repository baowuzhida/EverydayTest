package _HaiTong.CinemaManager_Y19_4_18.Util;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class GlobalUtil {

    private static Map<String,Object> userinfo = new HashMap<>();

    public User getUserInfo(){
        User user = new User();
        user.setU_id((Integer)userinfo.get("u_id"));
        user.setU_name((String) userinfo.get("u_name"));
        user.setU_password((String) userinfo.get("u_password"));
        user.setU_type((Integer) userinfo.get("u_type"));
        user.setU_account((Double) userinfo.get("u_account"));
        return user;
    }

    public boolean setUserInfo(User user){
        if (user == null)
            return false;
        else {
            userinfo.put("u_id", user.getU_id());
            userinfo.put("u_name", user.getU_name());
            userinfo.put("u_password", user.getU_password());
            userinfo.put("u_type", user.getU_type());
            userinfo.put("u_account", user.getU_account());
            return true;
        }
    }

    public boolean clearUserInfo(){
        userinfo.clear();
        return true;
    }
}
