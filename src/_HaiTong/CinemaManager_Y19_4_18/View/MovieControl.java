package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Biz.AdminBiz;
import _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl.AdminBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.Util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieControl {

    private Scanner scanner;

    public void movieControl() throws Exception {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1.添加电影 2.电影查询 3.修改电影 4.删除电影 5.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    selectMovie();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    private void selectMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies = new AdminBizImpl().selectMovie();
        movies.forEach(System.out::println);
    }

    private void addMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        while (true) {
            System.out.println("请输入电影名称：");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入电影时长（分钟）：");
            int duration = InputUtil.getInputByInt(scanner);
            System.out.println("请输入电影类型（1-9）：");
            int type = InputUtil.getInputByInt(scanner);
            System.out.println("请输入电影信息：");
            String info = InputUtil.getInputByString(scanner);
            Movie movie = new Movie(name, duration, type, info);
            movies.add(movie);
            System.out.println("是否继续添加：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1) {
                break;
            }
        }
        if (new AdminBizImpl().addMovie(movies)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }
}
