package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.SessionBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.SessionDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.dao.SessionDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Session;

import java.util.Date;
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

    @Override
    public boolean selectIfConflict(int c_id, int h_id, int m_id, Date start, Date end) throws Exception {
        return sessionDao.selectIfConflict(c_id,h_id,m_id,start,end);
    }
}
