package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Util.GlobalUtil;

import java.util.Scanner;

public class UserMenu {

    private GlobalUtil globalUtil = new GlobalUtil();
    private Scanner scanner;

    public void userMenu(){
        scanner = new Scanner(System.in);
        System.out.println(globalUtil.getUserInfo().toString());
    }
}
