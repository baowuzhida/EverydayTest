package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.CinemaBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.HallBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.MovieBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.SessionBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.CinemaBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.HallBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.SessionBiz;
import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;
import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;
import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.entity.Session;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;
import _HaiTong.CinemaManager_Y19_4_18.util.TimeUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SessionControl {

    private Scanner scanner;
    private SessionBiz sessionBiz;
    private CinemaBiz cinemaBiz;
    private HallBiz hallBiz;
    private MovieBiz movieBiz;

    public void sessionControl() throws Exception {
        hallBiz = new HallBizImpl();
        movieBiz = new MovieBizImpl();
        cinemaBiz = new CinemaBizImpl();
        sessionBiz = new SessionBizImpl();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n\n  请选择操作：");
            System.out.println("1.添加场次 2.场次查询 3.修改场次 4.删除场次 5.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    addSession();
                    break;
                case 2:
                    selectSession();
                    break;
                case 3:
                    updateSession();
                    break;
                case 4:
                    deleteSession();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }

    }

    private void addSession() throws Exception {
        scanner = new Scanner(System.in);
        List<Session> sessions = new ArrayList<>();
        while (true) {
            if (selectCinema() == 2)
                return;
            System.out.println("请输入影院编号：");
            int s_c_id = InputUtil.getInputByInt(scanner);
            if (!cinemaBiz.findCinemabyId(s_c_id)) {
                System.out.println("影院编号不存在！返回上一级！");
                return;
            }
            if (selectHallByCid(s_c_id) == null)
                return;
            System.out.println("请输入影厅编号：");
            int s_h_id = InputUtil.getInputByInt(scanner);
            if (!hallBiz.findHallbyIdCid(s_h_id, s_c_id)) {
                System.out.println("影厅编号不存在！返回上一级！");
                return;
            }
            if (selectMovie() == 2)
                return;
            System.out.println("请输入电影编号：");
            int s_m_id = InputUtil.getInputByInt(scanner);
            Movie movie = movieBiz.findMoviebyId(s_m_id);
            if (movie == null) {
                System.out.println("电影编号不存在！返回上一级！");
                return;
            }

            Date s_startTime = TimeUtil.compareSystemTime();//输入开始时间
            Date s_endTime = TimeUtil.getEndTime(s_startTime, movie.getM_duration());//提取结束时间
            if(sessionBiz.selectIfConflict(s_c_id,s_h_id,s_m_id,s_startTime,s_endTime)) {
                System.out.println("该时间已存在档期！返回上一级！");
                return;
            }

            System.out.println("请输入价格：");
            double s_price = InputUtil.getInputByDouble(scanner);

            Session session = new Session(s_c_id, s_h_id, s_m_id, s_startTime, s_endTime, movie.getM_duration(), s_price, s_h_id);//最后capacity传入shid通过数据库直接查找
            sessions.add(session);
            System.out.println("是否继续添加：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1) {
                break;
            }
        }
        if (sessionBiz.addSession(sessions)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }

    }

    private int selectSession() throws Exception {

        List<Session> sessions = new ArrayList<>();
        sessions = sessionBiz.selectSession();
        if (sessions != null) {
            sessions.forEach(System.out::println);
            return 1;
        } else {
            System.out.println("暂无场次信息!");
            return 2;
        }
    }

    private void updateSession() throws Exception {

        scanner = new Scanner(System.in);
        List<Session> sessions = new ArrayList<>();
        while (true) {
            System.out.println("\n当前列表有如下场次：");
            if (selectSession() == 2)
                return;
            System.out.println("请输入需要更新的场次编号：（返回请输入任意不存在编号 推荐-1）");
            int id = InputUtil.getInputByInt(scanner);
            if (!sessionBiz.findSessionbyId(id)) {
                System.out.println("场次编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入更新后的的影院编号：（返回请输入任意不存在编号 推荐-1）");
            int s_c_id = InputUtil.getInputByInt(scanner);
            if (!cinemaBiz.findCinemabyId(s_c_id)) {
                System.out.println("影院编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入更新后的影厅编号：（返回请输入任意不存在编号 推荐-1）");
            int s_h_id = InputUtil.getInputByInt(scanner);
            if (!hallBiz.findHallbyId(s_h_id)) {
                System.out.println("影厅编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入更新后的电影编号：（返回请输入任意不存在编号 推荐-1）");
            int s_m_id = InputUtil.getInputByInt(scanner);
            Movie movie = movieBiz.findMoviebyId(s_m_id);
            if (movie == null) {
                System.out.println("电影编号不存在！返回上一级！");
                return;
            }
            System.out.println("是否修改时间：1 是 Other 否");
            int ifchangeTime = InputUtil.getInputByInt(scanner);
            Date s_startTime = null, s_endTime = null;
            if (ifchangeTime == 1) {
                s_startTime = TimeUtil.compareSystemTime();//输入开始时间
                s_endTime = TimeUtil.getEndTime(s_startTime, movie.getM_duration());//提取结束时间
                if(sessionBiz.selectIfConflict(s_c_id,s_h_id,s_m_id,s_startTime,s_endTime)) {
                    System.out.println("该时间已存在档期！返回上一级！");
                    return;
                }
            }

            System.out.println("请输入价格：（不修改输入-1）");
            double s_price = InputUtil.getInputByDouble(scanner);

            Session session = new Session(id, s_c_id, s_h_id, s_m_id, s_startTime, s_endTime, movie.getM_duration(), s_price, -1);
            sessions.add(session);
            System.out.println("是否继续更新：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1)
                break;
        }
        if (sessionBiz.updateSession(sessions)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }


    }

    private void deleteSession() throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("当前有如下场次：");
        if (selectSession() == 2)
            return;
        System.out.println("请输入需要删除的场次编号(输入-1清空）：");
        int id = InputUtil.getInputByInt(scanner);
        if (!sessionBiz.findSessionbyId(id) && id != -1) {
            System.out.println("场次编号不存在！返回上一级！");
            return;
        }
        if (id == -1) {
            System.out.println("您确定要清空吗？！！！ 1.确定  Other.取消");
            int choose = InputUtil.getInputByInt(scanner);
            if (choose == 1) {
                if (sessionBiz.delSession(id)) {
                    System.out.println("清空成功！");
                } else {
                    System.out.println("清空失败！");
                }
            }
        } else {
            if (sessionBiz.delSession(id)) {
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
        } else {
            System.out.println("暂无电影信息!");
            return 2;
        }

    }

    private int selectCinema() throws Exception {
        List<Cinema> cinemas = new ArrayList<>();
        cinemas = cinemaBiz.selectCinema();
        if (cinemas != null) {
            cinemas.forEach(System.out::println);
            return 1;
        } else {
            System.out.println("暂无影院信息!");
            return 2;
        }
    }

    private List<Hall> selectHallByCid(int c_id) throws Exception {
        List<Hall> halls = new ArrayList<>();
        halls = hallBiz.findHallbyCid(c_id);
        if (halls != null) {
            halls.forEach(System.out::println);
            return halls;
        } else {
            System.out.println("暂无厂厅信息!");
            return null;
        }
    }

}
