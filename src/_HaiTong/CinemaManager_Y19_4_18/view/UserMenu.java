package _HaiTong.CinemaManager_Y19_4_18.view;

import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.CinemaBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.MovieBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.UserBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.CinemaBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.MovieBiz;
import _HaiTong.CinemaManager_Y19_4_18.biz.UserBiz;
import _HaiTong.CinemaManager_Y19_4_18.entity.*;
import _HaiTong.CinemaManager_Y19_4_18.util.GlobalUtil;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class UserMenu {

    private GlobalUtil globalUtil = new GlobalUtil();
    private MovieBiz movieBiz;
    private CinemaBiz cinemaBiz;
    private UserBiz userBiz;
    private User userinfo;
    private Scanner scanner;

    public void userMenu() throws Exception {
        movieBiz = new MovieBizImpl();
        cinemaBiz = new CinemaBizImpl();
        userBiz = new UserBizImpl();
        while (true) {
            scanner = new Scanner(System.in);
            userinfo = globalUtil.getUserInfo();
            System.out.println("\n\n\n\n\n 欢迎您" + userinfo.getU_name() + "使用本系统");
            System.out.println("请选择操作：");
            System.out.println("1.购买电影票 2.查询已购买影票 3.充值 4.猜你喜欢 5.修改密码 6.查看个人信息 7.退出");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    buyMovieTicket();
                    break;
                case 2:
                    selectMovieTicket();
                    break;
                case 3:
                    reCharge();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    globalUtil.clearUserInfo();
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    /*
     * 充值
     * */
    private void reCharge() throws Exception {
        while (true) {
            System.out.println("当前余额为：" + userinfo.getU_account());
            System.out.println("请选择充值数额：");
            System.out.println("1.【50】  2.【100】 3.【200】 4.【500】 5.【1000】 6.自定义（大于1000）Other.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    return;
            }

        }
    }

    /*
     *购买电影票主程序
     * */
    private void buyMovieTicket() throws Exception {
        selectMovie();
        System.out.println("请选择想看的电影编号：");
        int m_id = InputUtil.getInputByInt(scanner);
        if (movieBiz.findMoviebyId(m_id) == null) {
            System.out.println("电影id不存在 返回首页！");
            return;
        }
        List<Cinema> cinemas = selectCinemaForUser(m_id);
        if (cinemas == null) {
            System.out.println("当前无影院放映此电影 返回首页！");
            return;
        }
        System.out.println("请选择想去的影院编号：");
        int c_id = InputUtil.getInputByInt(scanner);
        if (!cinemaBiz.findCinemabyId(c_id)) {
            System.out.println("影院id不存在 返回首页！");
            return;
        }
        List<LinkedHashMap<Object, Object>> sessionList = userBiz.selectSessionListForUser(m_id, c_id);
        if (sessionList != null) {
            System.out.println("有如下场次供您选择：");
            System.out.println("\n\n\n | 场次编号 | 电影院名称 |  场厅名称  |  电影名称  |  放映时间  |  持续时间  |    票价    |  剩余票数  | ");
            for (LinkedHashMap<Object, Object> map : sessionList) {
                for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
                    String value = map.get(key).toString();//
                    System.out.print(" [" + value + "] ");
                }
                System.out.println("");
            }
            System.out.println("请选择场次编号：");
            int s_id = InputUtil.getInputByInt(scanner);
            Session session = userBiz.selectSessionForUser(m_id, c_id, s_id);
            if (session == null) {
                System.out.println("不包括在列表内，或已售空 返回首页！");
                return;
            }
            int capacity = userBiz.getCapacityByShid(session.getS_hall());

            int seat = chooseSeat(session, capacity);
            if (createTicket(session, seat)) {
                System.out.println("购票成功！");
            } else
                System.out.println("购票失败！返回主页！");
        } else
            System.out.println("暂无此电影上映~");
    }

    /*
     * 查询电影信息
     * */
    private void selectMovie() throws Exception {
        List<Movie> movies = new ArrayList<>();
        movies = movieBiz.selectMovie();
        if (movies != null) {
            System.out.println("当前热映电影信息如下：");
            movies.forEach(System.out::println);
        } else
            System.out.println("暂无电影信息!");
    }

    /*
     * 通过电影id查找上映影院
     * */
    private List<Cinema> selectCinemaForUser(int m_id) throws Exception {
        List<Cinema> cinemas = userBiz.selectCinemaFromMid(m_id);
        if (cinemas != null) {
            System.out.println("当前放映此电影影厅如下：");
            cinemas.forEach(System.out::println);
            return cinemas;
        } else
            return null;
    }

    /*
     * 选择座位
     * */
    private int chooseSeat(Session session, int capacity) throws Exception {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        for (int i = 1; i <= capacity; i++) {
            map.put(i, String.valueOf(i));
        }

        List<Ticket> tickets = userBiz.selectTicketFromSid(session.getS_id());
        if (tickets != null) {
            for (int i = 0; i < tickets.size(); i++) {
                if (map.containsKey(tickets.get(i).getT_seat())) {
                    map.put(tickets.get(i).getT_seat(), "*");
                }
            }
        }
        int index = 0;
        for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
            if (index % 10 == 0 && index != 0) {
                System.out.println("");
            }
            String value = map.get(key).toString();//
            System.out.print(" [ " + value + " ] ");
            index++;
        }
        System.out.println("\n请选择座位：(带有*标记的为已售出的座位）");
        int seat = InputUtil.getInputByTicket(scanner, capacity, map);
        return seat;
    }

    /*
     * 生成影票
     * */
    private boolean createTicket(Session session, int seat) throws Exception {
        int u_type = userinfo.getU_type();
        double u_account = userinfo.getU_account();
        if (u_type == 1) {
            System.out.println("您是尊贵的VIP，电影票八折！");
            int ifbuy = userBiz.userBuyTicket(userinfo.getU_id(), u_account, session, 1, seat);
            if (ifbuy == 1)
                return true;
            else if (ifbuy == 2) {
                System.out.println("余额不足，请先充值！");
                return false;
            } else {
                return false;
            }
        } else {
            System.out.println("您还不是VIP，一次性充值500送VIP打八折哦！");
            int ifbuy = userBiz.userBuyTicket(userinfo.getU_id(), u_account, session, 0, seat);
            if (ifbuy == 1)
                return true;
            else if (ifbuy == 2) {
                System.out.println("余额不足，请先充值！");
                return false;
            } else {
                return false;
            }
        }
    }

    /*
     * 查看已购影票
     * */
    private void selectMovieTicket() throws Exception {

        List<LinkedHashMap<Object, Object>> ticketsList = userBiz.selectTicketFromUid(userinfo.getU_id());
        if (ticketsList != null) {
            System.out.println("当前已购买影票信息如下");
            System.out.println("\n\n\n | 影票编号 | 用户编号 | 场次编号 | 座位编号 | 影院名称 | 场厅名称 | 电影名称 | 电影价格 | ");
            for (LinkedHashMap<Object, Object> map : ticketsList) {
                for (Object key : map.keySet()) {//keySet获取map集合key的集合  然后在遍历key即可
                    String value = map.get(key).toString();//
                    System.out.print(" [ " + value + " ] ");
                }
                System.out.println("");
            }
        } else
            System.out.println("暂无电影信息!");
    }
}
