package _HaiTong.CinemaManager_Y19_4_18.util;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class InputUtil {
    public static int getInputByInt(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                return i;
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            }
        }
    }

    public static double getInputByDouble(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {
                double i = input.nextDouble();//捕获输入其他不同的类型值
                return i;
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            }
        }
    }

    public static String getInputByString(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {
                String i = input.next();//捕获输入其他不同的类型值
                return i;
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            }
        }
    }

    public static int getMovieDuration(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i < 0 && i != -1) {
                    throw new Exception();
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数类型！请重新输入：");
            } catch (Exception e) {
                System.out.println("不能为负值！请重新输入：");
            }
        }
    }

    public static int getMovieType(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i < 0 || i > 3) {
                    throw new Exception();
                }
                return i;
            } catch (InputMismatchException e) {
                System.out.println("请输入整数类型！请重新输入：");
            } catch (Exception e) {
                System.out.println("范围为1-3！请重新输入：");
            }
        }
    }

    public static String getInputByTime(Scanner input) {

        while (true) {
            input = new Scanner(System.in);
            try {
                String i = input.nextLine();//捕获输入其他不同的类型值
                if (new TimeUtil().isValidDate(i))
                    return i;
                else
                    throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Integer getInputByTicket(Scanner input, int capacity, Map map) {

        while (true) {
            input = new Scanner(System.in);
            try {
                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i > 0 && i <= capacity && !map.get(i).equals("*"))
                    return i;
                else
                    throw new Exception();
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            } catch (Exception e) {
                System.out.println("请输入在范围内或未售出的座位号！请重新输入：");
            }
        }
    }

    public static int getInputByReCharge(Scanner input) {
        while (true) {
            input = new Scanner(System.in);
            try {

                int i = input.nextInt();//捕获输入其他不同的类型值
                if (i >1000 || i == -1)
                    return i;
                else
                    throw  new Exception();
            } catch (InputMismatchException e) {
                System.out.println("输入类型错误！请重新输入：");
            } catch (Exception e) {
                System.out.println("请输入1000以上的数值，或输入-1取消");
            }
        }
    }


}
