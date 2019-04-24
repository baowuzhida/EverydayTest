package _HaiTong.CinemaManager_Y19_4_18.Biz.BizImpl;

import _HaiTong.CinemaManager_Y19_4_18.Biz.SessionBiz;
import _HaiTong.CinemaManager_Y19_4_18.Dao.DaoImpl.SessionDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.Dao.SessionDao;
import _HaiTong.CinemaManager_Y19_4_18.Entity.Session;

import java.util.List;

public class SessionBizImpl implements SessionBiz {

    SessionDao sessionDao = new SessionDaoImpl();

    @Override
    public List<Session> selectSession() throws Exception {
        return sessionDao.selectSession();
    }

    @Override
    public boolean addSession(List<Session> sessions) throws Exception {
        return sessionDao.addSession(sessions);
    }

    @Override
    public boolean delSession(int s_id) throws Exception {
        if (s_id == -1)
            return sessionDao.clearSession();
        else
            return sessionDao.delSession(s_id);
    }

    @Override
    public boolean updateSession(List<Session> sessions) throws Exception {
        return sessionDao.updateSession(sessions);

    }

    @Override
    public boolean findSessionbyId(int s_id) throws Exception {
        return sessionDao.findSessionbyId(s_id);
    }
}
