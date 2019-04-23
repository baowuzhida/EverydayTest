package _HaiTong.CinemaManager_Y19_4_18.Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    public static int getInputByInt(Scanner input) {
        while (true) {
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                return i;
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
                input.nextLine();
            }
        }
    }

    public static String getInputByString(Scanner input) {
        while (true) {
            try {
                String i = input.next();//捕获输入其他不同的类型值
                return i;
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
                input.nextLine();
            }
        }
    }

    public static int getMovieDuration(Scanner input) {
        while (true) {
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i < 0 && i != -1) {
                    throw new Exception();
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数类型！请重新输入：");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("不能为负值！请重新输入：");
                input.nextLine();
            }
        }
    }

    public static int getMovieType(Scanner input) {
        while (true) {
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i < 0 || i > 3) {
                    throw new Exception();
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数类型！请重新输入：");
                input.nextLine();
            } catch (Exception e) {
                System.out.println("范围为1-3！请重新输入：");
                input.nextLine();
            }
        }
    }
}
