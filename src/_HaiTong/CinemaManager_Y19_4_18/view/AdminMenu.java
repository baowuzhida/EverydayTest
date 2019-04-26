package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.AdminBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {

    private Scanner scanner;

    private AdminBiz adminBiz;

    public void adminMenu() throws Exception {
        scanner = new Scanner(System.in);
        adminBiz = new AdminBizImpl();
        while (true) {
            System.out.println("欢迎您，管理员！");
            System.out.println("请选择操作：");
            System.out.println("1.电影院管理 2.电影管理 3.场次管理 4.票房查询 5.修改密码 6.退出");
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
                    selectBoxOffice();
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

    private void selectBoxOffice() throws Exception {
        List<BoxOffice> boxOffices = new ArrayList<>();
        boxOffices = adminBiz.selectBoxOffice();
        if (boxOffices != null) {
            System.out.println("当前票房信息如下：");
            boxOffices.forEach(System.out::println);
        } else {
            System.out.println("暂无票房信息!");
        }
    }

    private void changePassword() throws Exception {
        System.out.println("请先输入原密码：");
        String oldPassword = InputUtil.getInputByString(scanner);
        System.out.println("请先输入新密码：");
        String newPassword = InputUtil.getInputByString(scanner);
        System.out.println("请再次输入新密码：");
        String reNewPassword = InputUtil.getInputByString(scanner);
        int i = adminBiz.adminChangePassword(oldPassword, newPassword, reNewPassword);
        switch (i) {
            case 1:
                System.out.println("修改成功！");
                break;
            case 2:
                System.out.println("原密码输入错误！");
                break;
            case 3:
                System.out.println("两次新密码不一致！");
                break;
            case 4:
                System.out.println("修改失败！");
                break;
            default:
                System.out.println("未知错误！");
        }
    }
}
