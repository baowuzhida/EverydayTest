package _HaiTong.CinemaManager_Y19_4_18.Test;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;

import java.text.SimpleDateFormat;
import java.util.*;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.executeQueryNocls;

public class Test {
    public static void main(String[] args) throws Exception {
//        new MainMenu().mainMenu();

//        String sql = "SELECT * FROM dvd_user";
//        List<Object> list = new ArrayList<>();
//        Class<User> cls = User.class;
////        List<Object> objects = executeQuery(sql, list, cls);
//        List<Map<Object, Object>> lists = executeQueryNocls(sql, list);
//        for(Map<Object,Object> map:lists){
//            for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
//                String value = map.get(key).toString();//
//                System.out.println("key:" + key + " vlaue:" + value);
//
//            }
//            System.out.println(map.get("u_name").toString());
//        Date ss = new Date();
//        System.out.println("一般日期输出：" + ss);
//        System.out.println("时间戳：" + ss.getTime());
//        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
//        System.out.println("格式化结果0：" + time);
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        time = format1.format(ss.getTime());
//        System.out.println("格式化结果1：" + time);


        Scanner scan = new Scanner(System.in); // 从键盘接收数据
        String str = scan.nextLine();
        Date date = null;
        date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
        System.out.print("输入日期（yyyy-MM-dd HH:mm）："+date);



    }
}
