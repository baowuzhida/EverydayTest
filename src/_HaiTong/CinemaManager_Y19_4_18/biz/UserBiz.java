package _HaiTong.CinemaManager_Y19_4_18.biz;

import _HaiTong.CinemaManager_Y19_4_18.entity.BoxOffice;
import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;
import _HaiTong.CinemaManager_Y19_4_18.entity.Session;
import _HaiTong.CinemaManager_Y19_4_18.entity.Ticket;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserBiz {

    boolean userRegister(String name, String password) throws Exception;

    boolean userLogin(String name, String password) throws Exception;

    boolean userRecharge(int i) throws Exception;

    Integer userChangePassword(String old ,String new1,String new2) throws Exception;

    Integer userBuyTicket(int u_id, double u_account, Session session, int u_type, int seat) throws Exception;

    Integer getCapacityByShid(int s_hall) throws Exception;

    Session selectSessionForUser(int m_id, int c_id, int s_id) throws Exception;

    List<LinkedHashMap<Object, Object>> selectSessionListForUser(int m_id, int c_id) throws Exception;

    List<BoxOffice> selectHotMovie() throws Exception;

    List<Cinema> selectCinemaFromMid(int m_id) throws Exception;

    List<Ticket> selectTicketFromSid(int s_id) throws Exception;

    List<LinkedHashMap<Object, Object>> selectTicketFromUid(int u_id) throws Exception;
}
