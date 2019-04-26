package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.AdminBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.UserBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.UserBiz;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.Scanner;

public class MainMenu {

    private Scanner scanner;
    private UserBiz userBiz;
    private AdminBiz adminBiz;

    public void mainMenu() throws Exception {
        userBiz = new UserBizImpl();
        adminBiz = new AdminBizImpl();
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("欢迎来到电影院管理系统");
            System.out.println("1.登录 2.注册 3.退出 ");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    loginMenu();
                    break;
                case 2:
                    registerMenu();
                    break;
                case 3:
                    System.exit(0);
                case -1:
                    backMenu();
                    break;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }

    }

    private void registerMenu() throws Exception {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入密码：");
            String password = InputUtil.getInputByString(scanner);
            String captcha = new GlobalUtil().getRandomString(4);
            System.out.println("请输入验证码：" + captcha);
            String str = InputUtil.getInputByString(scanner);
            if (str.equals(captcha)) {
                boolean bol = userBiz.userRegister(name, password);
                if (bol) {
                    System.out.println("注册成功");
                    System.out.println("\n\n\n\n\n\n\n");
                    return;
                } else {//注册失败
                    System.out.println("你输入的用户名已存在，请重新输入");
                }
            } else {
                System.out.println("验证码错误，是否重试？");
                System.out.println("1.是  Other。否");
                if (InputUtil.getInputByInt(scanner) != 1)
                    return;
            }
        }

    }

    private void loginMenu() throws Exception {
        while ((true)) {
            scanner = new Scanner(System.in);
            System.out.println("请输入用户名：");
            String name = scanner.nextLine();
            System.out.println("请输入密码：");
            String password = scanner.nextLine();

            boolean bol = userBiz.userLogin(name, password);
            if (bol) {
                System.out.println("登录成功");
                System.out.println("\n\n\n\n\n\n\n");
                new UserMenu().userMenu();
                return;
            } else {//登录失败
                System.out.println("账号或密码错误");
                System.out.println("是否重试？：1.是 2.否");
                int iftry = InputUtil.getInputByInt(scanner);
                switch (iftry) {
                    case 2:
                        return;
                    case 1:
                        continue;
                    default:
                        System.out.println("输入错误，返回！");
                        System.out.println("\n\n\n\n\n\n\n");
                        return;

                }
            }
        }
    }

    private void backMenu() throws Exception {
        while (true) {
            scanner = new Scanner(System.in);
            System.out.println("厉害！被您发现了后台！");
            System.out.println("请输入管理员账户：");
            Integer number = InputUtil.getInputByInt(scanner);
            System.out.println("请输入管理员密码：");
            String password = InputUtil.getInputByString(scanner);
            boolean bol = adminBiz.adminLogin(number, password);
            if (bol) {
                System.out.println("登录成功");
                System.out.println("\n\n\n\n\n\n\n");
                new AdminMenu().adminMenu();
                return;
            } else {//登录失败
                System.out.println("账号或密码错误");
                System.out.println("是否重试？：1.是 2.否");
                int iftry = 0;
                try {
                    iftry = InputUtil.getInputByInt(scanner);
                    switch (iftry) {
                        case 2:
                            return;
                        case 1:
                            continue;
                        default:
                            System.out.println("输入错误，返回！");
                            return;
                    }
                } catch (Exception e) {
                    System.out.println("请正常输入！！！");
                    System.out.println("\n\n\n\n\n\n\n");
                }
            }
        }
    }
}
