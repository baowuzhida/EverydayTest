package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Util.InputUtil;

import java.util.Scanner;

public class AdminMenu {

    private Scanner scanner;

    public void adminMenu() throws Exception {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("欢迎您，管理员！");
            System.out.println("请选择操作：");
            System.out.println("1.电影院管理 2.电影管理 3.场次管理 4.购票信息查询 5.修改密码 6.退出");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    new CinemaControl().cinemaControl();
                    break;
                case 2:
                    new MovieControl().movieControl();
                    break;
                case 3:
                    new SessionControl().sessionControl();
                    break;
                case 4:
                    new TicketInfoControl().ticketInfoControl();
                    break;
                case 5:
                    changePassword();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    private void changePassword(){

    }
}
