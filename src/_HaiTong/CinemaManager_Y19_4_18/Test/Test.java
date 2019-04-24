package _HaiTong.CinemaManager_Y19_4_18.Test;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;
import _HaiTong.CinemaManager_Y19_4_18.Util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.BaseDao.executeQueryNocls;

public class Test {
    public static void main(String[] args) throws Exception {
//        new MainMenu().mainMenu();

//        String sql = "SELECT s_id,c_name,h_name,m_name,s_startTime,s_m_duration,s_price,s_h_capacity FROM dvd_session,dvd_cinema,dvd_movie,dvd_hall " +
//                "where s_id = ? AND s_cinema = c_id AND s_hall = h_id AND s_movie = m_id";
//        List<Object> list = new ArrayList<>();
//        list.add(2);
//        Class<User> cls = User.class;
////        List<Object> objects = executeQuery(sql, list, cls);
//        List<LinkedHashMap<Object, Object>> lists = executeQueryNocls(sql, list);
//        System.out.println("| 场次编号 | 电影院名称 | 场厅名称 | 电影名称 | 放映时间 | 持续时间 | 票价 | 剩余票数 |\n");
//        for(LinkedHashMap<Object,Object> map:lists) {
//            for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
//                String value = map.get(key).toString();//
//                System.out.print(" | "+value+" | ");
//            }
//        }
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, String.valueOf(1));
        map.put(2, String.valueOf(2));
        map.put(3, String.valueOf(3));
        map.put(4, String.valueOf(4));
        map.put(5, String.valueOf(5));
        if (map.containsKey(3)) {
            map.put(3, "*");
        }
        int index = 0;
        for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
            if(index % 3 ==0 && index!=0){
                System.out.println("");
            }
            String value = map.get(key).toString();//
            System.out.print(" [" + value + "] ");
            index++;
        }

//        Date ss = new Date();
//        System.out.println("一般日期输出：" + ss);
//        System.out.println("时间戳：" + ss.getTime());
//        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
//        System.out.println("格式化结果0：" + time);
//        SimpleDateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//        time = format1.format(ss.getTime());
//        System.out.println("格式化结果1：" + time);


//        Scanner scan = new Scanner(System.in); // 从键盘接收数据
//        String str = scan.nextLine();
////        Date date = null;
////        date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(str);
////        System.out.print("输入日期（yyyy-MM-dd HH:mm）：" + date);
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar nowTime1 = Calendar.getInstance();
//        Date date1 = sdf.parse(str);//把字符串转换成时间类型
//
//        nowTime1.setTime(date1);
//        nowTime1.add(Calendar.MINUTE, 30);//要增加什么，在这里写
//        System.out.println("自己定义的某个时间增加30分钟之后的时间：" + sdf.format(nowTime1.getTime()));


        /*
         *
         * INSERT INTO dvd_session ( s_cinema, s_hall, s_movie, s_startTime, s_endTime, s_m_duration, s_price, s_h_capacity )
         * VALUES(1,1,1,NOW( ),NOW( ),( SELECT m_duration FROM dvd_movie WHERE m_id = 1 ),40,( SELECT h_capacity FROM dvd_hall WHERE h_id = 1 ))
         *
         *
         * */

    }


}
