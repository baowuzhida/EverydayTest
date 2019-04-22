package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl.UserBizImpl;

import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);

    public void mainMenu() throws Exception {
        System.out.println("欢迎来到电影院管理系统");
        while (true) {
            System.out.println("1.登录 2.注册 3.退出 ");
            int choose = scanner.nextInt();
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
                default:
                    System.out.println("输入错误请重新输入");
            }
        }

    }

    private void registerMenu() throws Exception {
        while (true) {
            System.out.println("请输入用户名：");
            String name = scanner.next();
            System.out.println("请输入密码：");
            String password = scanner.next();
            boolean bol = new UserBizImpl().userRegister(name, password);
            if (bol) {
                System.out.println("注册成功");
                return;
            } else {//注册失败
                System.out.println("你输入的用户名已存在，请重新输入");
            }
        }

    }

    private void loginMenu() throws Exception {
        while ((true)) {
            System.out.println("请输入用户名：");
            String name = scanner.next();
            System.out.println("请输入密码：");
            String password = scanner.next();
            boolean bol = new UserBizImpl().userLogin(name, password);
            if (bol) {
                System.out.println("登录成功");
                return;
            } else {//登录失败
                System.out.println("账号或密码错误");
                System.out.println("是否重试？：1.是 2.否");
                int iftry = scanner.nextInt();
                switch (iftry) {
                    case 2:
                        return;
                    case 1:
                        continue;
                    default:
                        System.out.println("输入错误，返回！");
                        return;

                }
            }
        }
    }

    private void backMenu() throws Exception {
        System.out.println("厉害！被您发现了后台！");
        System.out.println("请输入管理员账户：");
        String number = scanner.next();
        System.out.println("请输入管理员密码：");
        String password = scanner.next();

    }
}
