package _HaiTong.CinemaManager_Y19_4_18.util;

import _HaiTong.CinemaManager_Y19_4_18.entity.Admin;
import _HaiTong.CinemaManager_Y19_4_18.entity.User;

import java.util.HashMap;
import java.util.Map;

public class GlobalUtil {

    private static Map<String,Object> userinfo = new HashMap<>();

    private static Map<String,Object> admininfo = new HashMap<>();

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

    public Admin getAdminInfo(){
        Admin admin = new Admin();
        admin.setA_id((Integer)admininfo.get("a_id"));
        admin.setA_number((Integer) admininfo.get("a_number"));
        admin.setA_password((String) admininfo.get("a_password"));
        return admin;
    }

    public boolean setAdminInfo(Admin admin){
        if (admin == null)
            return false;
        else {
            admininfo.put("a_id", admin.getA_id());
            admininfo.put("a_number", admin.getA_number());
            admininfo.put("a_password", admin.getA_password());
            return true;
        }
    }

    public boolean setUserAccount(double account){
        if (account < 0)
            return false;
        else {
            userinfo.put("u_account", account);
            return true;
        }
    }

    public boolean clearUserInfo(){
        userinfo.clear();
        return true;
    }

    public  String getRandomString(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }
}
