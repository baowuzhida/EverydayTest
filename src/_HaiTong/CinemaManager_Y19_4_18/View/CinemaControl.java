package _HaiTong.CinemaManager_Y19_4_18.View;

import _HaiTong.CinemaManager_Y19_4_18.Biz.CinemaBiz;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Cinema;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.Util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaControl {

    private Scanner scanner;
    private CinemaBiz cinemaBiz;

    public void cinemaControl() throws Exception {
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择操作：");
            System.out.println("1.添加影院 2.影院查询 3.修改影院 4.删除影院 5.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    addCinema();
                    break;
                case 2:
                    selectCinema();
                    break;
                case 3:
                    updateCinema();
                    break;
                case 4:
                    deleteCinema();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }

    }

    private void addCinema()throws Exception {
        scanner = new Scanner(System.in);
        List<Cinema> cinemas = new ArrayList<>();
        while (true) {
            System.out.println("请输入电影名称:");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入影院地址:");
            String address = InputUtil.getInputByString(scanner);
            System.out.println("请输入影院信息：");
            String info = InputUtil.getInputByString(scanner);
            Cinema cinema = new Cinema(name, address, info);
            cinemas.add(cinema);
            System.out.println("是否继续添加：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1) {
                break;
            }
        }
        if (cinemaBiz.addCinema(cinemas)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }

    }

    private void selectCinema()throws Exception {
        List<Cinema> cinemas = new ArrayList<>();
        cinemas = cinemaBiz.selectCinema();
        if (cinemas != null)
            cinemas.forEach(System.out::println);
        else
            System.out.println("暂无影院信息!");
    }

    private void updateCinema() throws Exception {

        scanner = new Scanner(System.in);
        List<Cinema> cinemas = new ArrayList<>();
        while (true) {
            System.out.println("\n\n\n\n 当前列表有如下影院：");
            selectCinema();
            System.out.println("请输入需要更新的影院编号：");
            int id = InputUtil.getInputByInt(scanner);
            if (!cinemaBiz.findCinemabyId(id)) {
                System.out.println("电影编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入电影名称：(不更改输入-1）");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("请输入影院地址：(不更改输入-1）");
            String address = InputUtil.getInputByString(scanner);
            System.out.println("请输入影院信息：(不更改输入-1）");
            String info = InputUtil.getInputByString(scanner);
            Cinema cinema = new Cinema(id, name, address, info);
            cinemas.add(cinema);
            System.out.println("是否继续更新：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1)
                break;
        }
        if (cinemaBiz.updateCinema(cinemas)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }


    }

    private void deleteCinema()throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("当前有如下影院：");
        selectCinema();
        System.out.println("请输入需要删除的影院编号(输入-1清空）：");
        int id = InputUtil.getInputByInt(scanner);
        if (!cinemaBiz.findCinemabyId(id) && id != -1) {
            System.out.println("影院编号不存在！返回上一级！");
            return;
        }
        if (id == -1) {
            System.out.println("您确定要清空吗？！！！ 1.确定  Other.取消");
            int choose = InputUtil.getInputByInt(scanner);
            if (choose == 1) {
                if (cinemaBiz.delCinema(id)) {
                    System.out.println("清空成功！");
                } else {
                    System.out.println("清空失败！");
                }
            }
        } else {
            if (cinemaBiz.delCinema(id)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }
    }
}
