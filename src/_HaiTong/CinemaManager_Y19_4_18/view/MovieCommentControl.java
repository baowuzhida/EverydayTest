package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.MovieCommentBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.MovieBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.MovieCommentBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.entity.Admin;
import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.entity.MovieComment;
import _HaiTong.CinemaManager_Y19_4_18.entity.User;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieCommentControl {

    private Scanner scanner;
    private MovieBiz movieBiz;
    private MovieCommentBiz movieCommentBiz;
    private User userInfo;
    private GlobalUtil globalUtil = new GlobalUtil();

    public void userMovieControl() throws Exception {
        userInfo = globalUtil.getUserInfo();
        movieBiz = new MovieBizImpl();
        movieCommentBiz = new MovieCommentBizImpl();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n 请选择操作：");
            System.out.println("1.查看影评 2.填写影评 0.退出");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    selectMovieComment();
                    break;
                case 2:
                    addMovieComment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    public void adminMovieControl() throws Exception {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n请选择操作：");
            System.out.println("1.查看影评 2.删除影评 0.退出");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    selectMovieComment();
                    break;
                case 2:
                    deleteMovieComment();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    /*
     * 搜索影评
     * */
    private void selectMovieComment() throws Exception {
        if (selectMovie() == 2) {
            return;
        }
        System.out.println("\n请选择需要查看影评的电影编号：");
        int id = InputUtil.getInputByInt(scanner);
        if (movieBiz.findMoviebyId(id) == null) {
            System.out.println("电影编号不存在！返回上一级！");
            return;
        }
        List<MovieComment> movieComments = new ArrayList<>();
        movieComments = movieCommentBiz.selectMovieCommentByMID(id);
        if (movieComments != null) {
            movieComments.forEach(System.out::println);
        } else {
            System.out.println("暂无影评信息!");
        }

    }

    /*
     * 添加影评
     * */
    private void addMovieComment() throws Exception {
        scanner = new Scanner(System.in);
        if (selectMovie() == 2) {
            return;
        }
        System.out.println("\n请选择需要添加影评的电影编号：");
        int m_id = InputUtil.getInputByInt(scanner);
        if (movieBiz.findMoviebyId(m_id) == null) {
            System.out.println("电影编号不存在！返回上一级！");
            return;
        }
        System.out.println("请输入影评内容：");
        String comment = InputUtil.getInputByString(scanner);
        System.out.println("请输入电影评分：");
        int point = InputUtil.getInputByMoviePoint(scanner);

        MovieComment movieComment = new MovieComment(m_id, userInfo.getU_id(), comment, point);
        if (movieCommentBiz.addMovieComment(movieComment)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }
    }

    /*
     * 删除影评
     * */
    private void deleteMovieComment() throws Exception {
        System.out.println("你还敢随便删影评？？");
        System.out.println("滚犊子！");
    }

    /*
     * 查找电影列表
     * */
    private int selectMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies = movieBiz.selectMovie();
        if (movies != null) {
            movies.forEach(System.out::println);
            return 1;
        } else {
            System.out.println("暂无电影信息!");
            return 2;
        }

    }

}
