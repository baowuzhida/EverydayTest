package _HaiTong.CinemaManager_Y19_4_18.view;


import _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl.HallBizImpl;
import _HaiTong.CinemaManager_Y19_4_18.biz.HallBiz;
import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;
import _HaiTong.CinemaManager_Y19_4_18.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HallControl {
    private Scanner scanner;
    private HallBiz hallBiz;
    private int c_id ;

    public void hallControl(int c_id) throws Exception{
        this.c_id = c_id;
        hallBiz = new HallBizImpl();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n\n\n  请选择操作：");
            System.out.println("1.添加厂厅 2.厂厅查询 3.修改厂厅 4.删除厂厅 0.返回");
            int choose = InputUtil.getInputByInt(scanner);
            switch (choose) {
                case 1:
                    addHall();
                    break;
                case 2:
                    selectHall();
                    break;
                case 3:
                    updateHall();
                    break;
                case 4:
                    deleteHall();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误请重新输入");
            }
        }
    }

    private void addHall() throws Exception {
        scanner = new Scanner(System.in);
        List<Hall> halls = new ArrayList<>();
        while (true) {
            System.out.println("请输入厂厅名称:");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("厂厅所属影院编号:");
            System.out.println(c_id);
            System.out.println("请输入厂厅容量：");
            int capacity = InputUtil.getInputByInt(scanner);
            Hall hall = new Hall(name, c_id, capacity);
            halls.add(hall);
            System.out.println("是否继续添加：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1) {
                break;
            }
        }
        if (hallBiz.addHall(halls)) {
            System.out.println("插入成功！");
        } else {
            System.out.println("插入失败！");
        }

    }

    private int selectHall() throws Exception {
        List<Hall> halls = new ArrayList<>();
        halls = hallBiz.selectHall();
        if (halls != null) {
            halls.forEach(System.out::println);
            return 1;
        }
        else {
            System.out.println("暂无厂厅信息!");
            return 2;
        }
    }

    private void updateHall() throws Exception {
        scanner = new Scanner(System.in);
        List<Hall> halls = new ArrayList<>();
        while (true) {
            System.out.println("\n\n\n\n 当前列表有如下厂厅：");
            if(selectHall()==2)
                return;
            System.out.println("请输入需要更新的厂厅编号：");
            int id = InputUtil.getInputByInt(scanner);
            if (!hallBiz.findHallbyId(id)) {
                System.out.println("厂厅编号不存在！返回上一级！");
                return;
            }
            System.out.println("请输入厂厅名称：(不更改输入-1）");
            String name = InputUtil.getInputByString(scanner);
            System.out.println("厂厅所属影院：(不更改输入-1）");
            System.out.println(-1);
            System.out.println("请输入厂厅容量：(不更改输入-1）");
            int capacity = InputUtil.getInputByInt(scanner);
            Hall cinema = new Hall(id, name, -1, capacity);
            halls.add(cinema);
            System.out.println("是否继续更新：");
            System.out.println("1.继续  Other.结束");
            int ifadd = InputUtil.getInputByInt(scanner);
            if (ifadd != 1)
                break;
        }
        if (hallBiz.updateHall(halls)) {
            System.out.println("更新成功！");
        } else {
            System.out.println("更新失败！");
        }
    }

    private void deleteHall() throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("当前有如下厂厅：");
        if(selectHall()==2)
            return;
        System.out.println("请输入需要删除的厂厅编号(输入-1清空）：");
        int id = InputUtil.getInputByInt(scanner);
        if (!hallBiz.findHallbyId(id) && id != -1) {
            System.out.println("厂厅编号不存在！返回上一级！");
            return;
        }
        if (id == -1) {
            System.out.println("您确定要清空吗？！！！ 1.确定  Other.取消");
            int choose = InputUtil.getInputByInt(scanner);
            if (choose == 1) {
                if (hallBiz.delHall(id)) {
                    System.out.println("清空成功！");
                } else {
                    System.out.println("清空失败！");
                }
            }
        } else {
            if (hallBiz.delHall(id)) {
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
        }
    }
}
