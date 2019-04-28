package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.MovieBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieControl {

    private Scanner scanner;
    private MovieBiz movieBiz;

    public void movieControl() throws Exception {
        movieBiz = new MovieBizImpl();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n\n  请选择操作：");
            System.out.println("1.添加电影 2.电影查询 3.修改电影 4.删除电影 0.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    addMovie();
                    break;
                case 2:
                    selectMovie();
                    break;
                case 3:
                    updateMovie();
                    break;
                case 4:
                    deleteMovie();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    private void updateMovie() throws Exception {
        scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();
        while (true) {
            System.out.println("\n\n\n\n 当前列表有如下电影：");
            if(selectMovie()==2){
                return;
            }
            System.out.println("请输入需要更新的电影编号：");
            int id = InputUtil.getInputByInt(scanner);
            if (movieBiz.findMoviebyId(id)==null) {
                System.out.println("电影编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入电影名称：(不更改输入-1）");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入电影时长（分钟）：(不更改输入-1）");
            int duration = InputUtil.getMovieDuration(scanner);
            System.out.println("请输入电影类型（1-3）：(不更改输入-1）\n\n  类型对照表  \n\n 1-好看  2-一般  3-难看");
            int type = InputUtil.getMovieType(scanner);
            System.out.println("请输入电影信息：(不更改输入-1）");
            String info = InputUtil.getInputByString(scanner);
            Movie movie = new Movie(id, name, duration, type, info);
            movies.add(movie);
            System.out.println("是否继续更新：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1)
                break;
        }
        if (movieBiz.updateMovie(movies)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }

    }

    private void deleteMovie() throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("当前有如下电影：");
        if(selectMovie()==2){
            return;
        }
        System.out.println("请输入需要删除的电影编号(输入-1清空）：");
        int id = InputUtil.getInputByInt(scanner);
        if (movieBiz.findMoviebyId(id)==null && id != -1) {
            System.out.println("电影编号不存在！返回上一级！");
            return;
        }
        if (id == -1) {
            System.out.println("您确定要清空吗？！！！ 1.确定  Other.取消");
            int choose = InputUtil.getInputByInt(scanner);
            if (choose == 1) {
                if (movieBiz.delMovie(id)) {
                    System.out.println("清空成功！");
                } else {
                    System.out.println("清空失败！");
                }
            }
        } else {
            if (movieBiz.delMovie(id)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }

    }

    private int selectMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies = movieBiz.selectMovie();
        if (movies != null) {
            movies.forEach(System.out::println);
            return 1;
        }
        else {
            System.out.println("暂无电影信息!");
            return 2;
        }

    }

    private void addMovie() throws Exception {
        scanner = new Scanner(System.in);
        List<Movie> movies = new ArrayList<>();
        while (true) {
            System.out.println("请输入电影名称：");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入电影时长（分钟）：");
            int duration = InputUtil.getMovieDuration(scanner);
            if (duration == -1 ){
                System.out.println("不能为负值，返回上一级！");
                return;
            }
            System.out.println("请输入电影类型（1-3）：");
            int type = InputUtil.getMovieType(scanner);
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
        if (movieBiz.addMovie(movies)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }
}
