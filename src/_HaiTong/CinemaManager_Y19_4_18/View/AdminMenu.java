package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Util.InputUtil;

import java.util.Scanner;

public class AdminMenu {

    private Scanner scanner;

    public void adminMenu() {
        scanner = new Scanner(System.in);
        System.out.println("欢迎您，管理员！");
        System.out.println("请选择操作：");
        System.out.println("1.电影院管理 2.电影管理 3.修改密码 4.退出");
        int choose = InputUtil.getInputByInt(scanner);
        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                return;
            default:
                System.out.println("输入错误请重新输入");
        }
    }
}
