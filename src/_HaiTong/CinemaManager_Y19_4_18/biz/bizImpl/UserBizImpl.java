package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.UserBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.UserDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.dao.UserDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.*;

import java.util.LinkedHashMap;
import java.util.List;

public class UserBizImpl implements UserBiz {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean userRegister(String name, String password) throws Exception {
        if (name.equals("") || password.equals(""))
            return false;
        else {
            User user = userDao.resarchByName(name);
            if (user != null)
                return false;
            else {
                if (userDao.registUser(name, password))
                    return true;
                else
                    return false;
            }
        }
    }

    @Override
    public boolean userLogin(String name, String password) throws Exception {
        if (name.equals("") || password.equals(""))
            return false;
        else {
            return userDao.loginUser(name, password);
        }
    }

    @Override
    public Integer userBuyTicket(int u_id, double u_account, Session session, int u_type, int seat) throws Exception {

        double after_account;
        if (u_type == 1)
            after_account = u_account - session.getS_price()*0.8;
        else
            after_account = u_account - session.getS_price();
        if (after_account < 0) {
            return 2;
        } else {
            if (userDao.userBuyTicket(u_id, session, after_account, seat)) {
                return 1;
            } else
                return 3;
        }
    }

    @Override
    public Integer getCapacityByShid(int s_hall) throws Exception {
        return userDao.getCapacityByShid(s_hall);
    }

    @Override
    public Session selectSessionForUser(int m_id, int c_id, int s_id) throws Exception {
        Session session = userDao.selectSessionForUser(m_id, c_id, s_id);
        if(session!=null) {
            if (session.getS_h_capacity() > 0)
                return session;
            else
                return null;
        }
        return null;
    }

    @Override
    public List<LinkedHashMap<Object, Object>> selectSessionListForUser(int m_id, int c_id) throws Exception {
        return userDao.selectSessionListForUser(m_id, c_id);
    }

    @Override
    public List<Cinema> selectCinemaFromMid(int m_id) throws Exception {
        return userDao.selectCinemaFromMid(m_id);
    }

    @Override
    public List<Ticket> selectTicketFromSid(int s_id) throws Exception {
        return userDao.selectTicketFromSid(s_id);
    }

    @Override
    public  List<LinkedHashMap<Object, Object>> selectTicketFromUid(int u_id) throws Exception {
        return userDao.selectTicketFromUid(u_id);
    }
}
