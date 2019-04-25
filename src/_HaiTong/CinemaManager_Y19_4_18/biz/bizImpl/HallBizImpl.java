package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.HallBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.HallDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.dao.HallDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Hall;

import java.util.List;

public class HallBizImpl implements HallBiz {

    HallDao hallDao = new HallDaoImpl();

    @Override
    public List<Hall> selectHall() throws Exception {
        return hallDao.selectHall();
    }

    @Override
    public List<Hall> findHallbyCid(int c_id) throws Exception {
        return hallDao.findHallbyCid(c_id);
    }

    @Override
    public boolean addHall(List<Hall> halls) throws Exception {
        return hallDao.addHall(halls);
    }

    @Override
    public boolean delHall(int h_id) throws Exception {
        if (h_id == -1)
            return hallDao.clearHall();
        else
            return hallDao.delHall(h_id);
    }

    @Override
    public boolean updateHall(List<Hall> halls) throws Exception {
        return hallDao.updateHall(halls);
    }

    @Override
    public boolean findHallbyId(int h_id) throws Exception {
        return hallDao.findHallbyId(h_id);
    }

    @Override
    public boolean findHallbyIdCid(int h_id, int c_id) throws Exception {
        return hallDao.findHallbyIdCid(h_id,c_id);
    }
}
