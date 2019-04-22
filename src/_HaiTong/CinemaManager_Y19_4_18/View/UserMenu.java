package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Entity.User;
import _HaiTong.CinemaManager_Y19_4_18.Util.GlobalUtil;

import java.util.Scanner;

public class UserMenu {

    private GlobalUtil globalUtil = new GlobalUtil();
    private User userinfo;
    private Scanner scanner;

    public void userMenu(){
        scanner = new Scanner(System.in);
        userinfo = globalUtil.getUserInfo();
        System.out.println("欢迎您"+userinfo.getU_name()+"使用本系统");
    }
}
