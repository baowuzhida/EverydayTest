package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.Cinema;
import _HaiTong.CinemaManager_Y19_4_18.entity.Session;
import _HaiTong.CinemaManager_Y19_4_18.entity.Ticket;
import _HaiTong.CinemaManager_Y19_4_18.entity.User;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserDao {

    User resarchByName(String name) throws Exception;

    Integer getCapacityByShid(int s_hall) throws Exception;

    Boolean userChangePassword(String new_password) throws Exception;

    Boolean userRecharge(int account,int ifvip) throws Exception;

    Boolean registUser(String name,String password) throws Exception;

    Boolean loginUser(String name,String password) throws  Exception;

    Boolean userBuyTicket(int u_id,Session session,double after_account,int seat) throws Exception;

    Session selectSessionForUser(int m_id, int c_id, int s_id) throws Exception;

    List<LinkedHashMap<Object, Object>> selectSessionListForUser(int m_id,int c_id) throws Exception;

    List<Cinema> selectCinemaFromMid(int m_id) throws Exception;

    List<Ticket> selectTicketFromSid(int s_id) throws  Exception;

    List<LinkedHashMap<Object, Object>> selectTicketFromUid(int u_id) throws Exception;

}
