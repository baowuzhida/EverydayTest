package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.CinemaBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.CinemaDao;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.CinemaDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;

import java.util.List;

public class CinemaBizImpl implements CinemaBiz {

    private CinemaDao cinemaDao = new CinemaDaoImpl();
    @Override
    public List<Cinema> selectCinema() throws Exception {
        return cinemaDao.selectCinema();
    }

    @Override
    public boolean addCinema(List<Cinema> cinemas) throws Exception {
        return cinemaDao.addCinema(cinemas);
    }

    @Override
    public boolean delCinema(int c_id) throws Exception {
        if (c_id == -1)
            return cinemaDao.clearCinema();
        else
            return cinemaDao.delCinema(c_id);
    }

    @Override
    public boolean updateCinema(List<Cinema> cinemas) throws Exception {
        return cinemaDao.updateCinema(cinemas);
    }

    @Override
    public boolean findCinemabyId(int c_id) throws Exception {

        return cinemaDao.findCinemabyId(c_id);
    }
}
