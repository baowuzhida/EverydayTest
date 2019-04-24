package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.CinemaDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.executeQuery;

public class CinemaDaoImpl implements CinemaDao {
    @Override
    public List<Cinema> selectCinema() throws Exception {
        String sql = "select * from dvd_cinema";
        List<Object> list = new ArrayList<>();
        Class<Cinema> cls = Cinema.class;
        List<Cinema> cinemas = executeQuery(sql, list, cls);
        if (cinemas.size() == 0) {
            return null;
        }
        return cinemas;
    }

    @Override
    public boolean addCinema(List<Cinema> cinemas) throws Exception {
        for (Cinema c : cinemas) {
            String sql = "insert into dvd_cinema (c_name,c_address,c_info) values (?,?,?)";
            List<Object> list = new ArrayList<>();
            list.add(c.getC_name());
            list.add(c.getC_address());
            list.add(c.getC_info());
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean delCinema(int c_id) throws Exception {
        String sql = "delete from dvd_cinema where c_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(c_id);
        if (!excuteUpdate(sql, list))
            return false;
        return true;
    }

    @Override
    public boolean clearCinema() throws Exception {
        String sql = "truncate table dvd_cinema";//重置表
        List<Object> list = new ArrayList<>();
        excuteUpdate(sql, list);
        return true;
    }

    @Override
    public boolean updateCinema(List<Cinema> cinemas) throws Exception {
        for (Cinema c : cinemas) {
            List<Object> list = new ArrayList<>();
            StringBuilder sqlbuilder = new StringBuilder();
            sqlbuilder.append("update dvd_cinema set ");
            if (!c.getC_name().equals("-1")) {
                sqlbuilder.append(" c_name = ? ");
                list.add(c.getC_name());
            } else {
                sqlbuilder.append(" c_name = c_name ");
            }
            if (!c.getC_address().equals("-1")) {
                sqlbuilder.append(" ,c_address = ? ");
                list.add(c.getC_address());
            }
            if (!c.getC_info().equals("-1")) {
                sqlbuilder.append(" ,c_info = ? ");
                list.add(c.getC_info());
            }
            sqlbuilder.append(" where c_id = ? ");
            list.add(c.getC_id());
            String sql = sqlbuilder.toString();
            if (!excuteUpdate(sql, list))
                return false;
        }
        return true;
    }

    @Override
    public boolean findCinemabyId(int c_id) throws Exception {
        String sql = "select * from dvd_cinema where c_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(c_id);
        Class<Cinema> cls = Cinema.class;
        List<Cinema> cinemas = executeQuery(sql, list, cls);
        if (cinemas.size() == 0) {
            return false;
        }
        return true;
    }
}
