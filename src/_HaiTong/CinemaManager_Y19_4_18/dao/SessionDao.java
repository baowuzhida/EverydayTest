package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.Session;

import java.util.List;

public interface SessionDao {

    List<Session> selectSession() throws Exception;

    boolean findSessionbyId(int s_id) throws Exception;

    boolean addSession(List<Session> sessions) throws Exception;

    boolean delSession(int s_id) throws  Exception;

    boolean updateSession(List<Session> sessions) throws  Exception;

    boolean clearSession() throws Exception;
}
