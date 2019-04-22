package _HaiTong.CinemaManager_Y19_4_18.Test;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.executeQueryNocls;

public class Test {
    public static void main(String[] args) throws Exception {
//        new MainMenu().mainMenu();

        String sql = "SELECT * FROM dvd_user";
        List<Object> list = new ArrayList<>();
        Class<User> cls = User.class;
//        List<Object> objects = executeQuery(sql, list, cls);
        List<Map<Object, Object>> lists = executeQueryNocls(sql, list);
        for(Map<Object,Object> map:lists){
            for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
                String value = map.get(key).toString();//
                System.out.println("key:" + key + " vlaue:" + value);

            }
//            System.out.println(map.get("u_name").toString());
        }
    }
}
