package _HaiTong.CinemaManager_Y19_4_18.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TimeUtil {

    public static Date compareSystemTime() {//与系统时间进行比较
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                System.out.println("请输入开始时间：(yyyy-MM-dd HH:mm:ss格式进行输入)");
                Date datebegin = null;
                input = new Scanner(System.in);
                String begintime = InputUtil.getInputByTime(input);
                datebegin = df.parse(begintime);
                String systemTime = df.format(new Date());// new Date()为获取当前系统时间
                String nowTime = df.format(datebegin);//输入时间
                if (systemTime.compareTo(nowTime) < 0) {
                    return datebegin;
                } else {
                    System.out.println("不能在系统时间前！请重新输入！");
                }
            } catch (ParseException e) {
                System.out.println("时间输入格式有误，请重新输入！");
            }
        }
    }

    public static Date getEndTime(Date beginTime,int time) {//获得结束时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Calendar nowTime = Calendar.getInstance();
        nowTime.setTime(beginTime);
        nowTime.add(Calendar.MINUTE, time);//要增加什么，在这里写
        System.out.println("结束时间为：\n" + df.format(nowTime.getTime()));
        return nowTime.getTime();
    }

//    public static boolean compareTime(Date Time1, Date Time2) {//比较开始和结束时间是否在这个影厅所在时间内
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String begin = df.format(Time1);//输入时间
//        String end = df.format(Time2);//输入时间
//        if (begin.compareTo(end)<=0) {
//            return true;//存在
//        } else {
//            return false;//不存在
//        }
//    }

    public boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
