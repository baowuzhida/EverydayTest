package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl.MovieBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl.SessionBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl.UserBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.Biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.Biz.SessionBiz;
import _HaiTong.CinemaManager_Y19_4_18.Biz.UserBiz;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Session;
import _HaiTong.CinemaManager_Y19_4_18.Entity.User;
import _HaiTong.CinemaManager_Y19_4_18.Util.GlobalUtil;
import _HaiTong.CinemaManager_Y19_4_18.Util.InputUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private GlobalUtil globalUtil = new GlobalUtil();
    private MovieBiz movieBiz;
    private UserBiz userBiz;
    private User userinfo;
    private Scanner scanner;

    public void userMenu() throws Exception {
        movieBiz = new MovieBizImpl();
        userBiz = new UserBizImpl();
        while (true) {
            scanner = new Scanner(System.in);
            userinfo = globalUtil.getUserInfo();
            System.out.println("\n\n\n\n\n 欢迎您" + userinfo.getU_name() + "使用本系统");
            System.out.println("请选择操作：");
            System.out.println("1.购买电影票 2.查询已购买影票 3.充值 4.猜你喜欢 5.修改密码 6.退出");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    buyMovieTicket();
                    break;
                case 2:
                    selectMovieTicket();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    private void buyMovieTicket() throws Exception {
        selectMovie();
        System.out.println("请选择想看的电影编号：");
        int id = InputUtil.getInputByInt(scanner);
        if (movieBiz.findMoviebyId(id) == null) {
            System.out.println("电影id不存在 返回首页！");
            return;
        }
        List<LinkedHashMap<Object, Object>> sessionList = userBiz.selectSessionForUser(id);
        if (sessionList != null) {
            System.out.println("\n\n\n |  场次编号  | 电影院名称 |  场厅名称  |  电影名称  |  放映时间  |  持续时间  |    票价    |  剩余票数  | ");
            for (LinkedHashMap<Object, Object> map : sessionList) {
                for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
                    String value = map.get(key).toString();//
                    System.out.print(" | " + value + " | ");
                }
            }
            System.out.println();
        } else
            System.out.println();
    }

    private void selectMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies = movieBiz.selectMovie();
        if (movies != null) {
            System.out.println("当前热映电影信息如下：");
            movies.forEach(System.out::println);
        } else
            System.out.println("暂无电影信息!");
    }

    private void selectMovieTicket() {

    }
}
