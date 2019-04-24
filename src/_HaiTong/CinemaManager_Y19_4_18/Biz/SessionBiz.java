package _HaiTong.CinemaManager_Y19_4_18.Biz;

import _HaiTong.CinemaManager_Y19_4_18.Entity.Session;

import java.util.List;

public interface SessionBiz {

    List<Session> selectSession() throws  Exception;

    boolean addSession(List<Session> sessions) throws Exception;

    boolean delSession(int s_id) throws  Exception;

    boolean updateSession(List<Session> sessions) throws  Exception;

    boolean findSessionbyId(int s_id) throws Exception;
}
