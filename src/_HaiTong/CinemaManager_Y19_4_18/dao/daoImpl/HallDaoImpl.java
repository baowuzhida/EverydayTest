package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.HallDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.executeQuery;

public class HallDaoImpl implements HallDao {
    @Override
    public List<Hall> selectHall() throws Exception {
        String sql = "select * from dvd_hall";
        List<Object> list = new ArrayList<>();
        Class<Hall> cls = Hall.class;
        List<Hall> halls = executeQuery(sql, list, cls);
        if (halls.size() == 0) {
            return null;
        }
        return halls;
    }

    @Override
    public boolean addHall(List<Hall> halls) throws Exception {
        for (Hall h : halls) {
            String sql = "insert into dvd_hall (h_name,h_cinema,h_capacity) values (?,?,?)";
            List<Object> list = new ArrayList<>();
            list.add(h.getH_name());
            list.add(h.getH_cinema());
            list.add(h.getH_capacity());
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean delHall(int h_id) throws Exception {
        String sql = "delete from dvd_hall where h_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(h_id);
        if (!excuteUpdate(sql, list))
            return false;
        return true;
    }

    @Override
    public boolean clearHall() throws Exception {
        String sql = "truncate table dvd_hall";//重置表
        List<Object> list = new ArrayList<>();
        excuteUpdate(sql, list);
        return true;
    }

    @Override
    public boolean updateHall(List<Hall> halls) throws Exception {
        for (Hall h : halls) {
            List<Object> list = new ArrayList<>();
            StringBuilder sqlbuilder = new StringBuilder();
            sqlbuilder.append("update dvd_hall set ");
            if (!h.getH_name().equals("-1")) {
                sqlbuilder.append(" h_name = ? ");
                list.add(h.getH_name());
            } else {
                sqlbuilder.append(" h_name = h_name ");
            }
            if (h.getH_cinema() != -1) {
                sqlbuilder.append(" ,h_cinema = ? ");
                list.add(h.getH_cinema());
            }
            if (h.getH_capacity() != -1) {
                sqlbuilder.append(" ,h_capacity = ? ");
                list.add(h.getH_capacity());
            }
            sqlbuilder.append(" where h_id = ? ");
            list.add(h.getH_id());
            String sql = sqlbuilder.toString();
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean findHallbyId(int h_id) throws Exception {
        String sql = "select * from dvd_hall where h_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(h_id);
        Class<Hall> cls = Hall.class;
        List<Hall> halls = executeQuery(sql, list, cls);
        if (halls.size() == 0) {
            return false;
        }
        return true;
    }
}
