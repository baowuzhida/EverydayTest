package _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl;

import _HaiTong.CinemaManager_Y19_4_18.dao.MovieCommentDao;
import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.entity.MovieComment;

import java.util.ArrayList;
import java.util.List;

import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.excuteUpdate;
import static _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.BaseDao.executeQuery;

public class MovieCommentDaoImpl implements MovieCommentDao {
    @Override
    public List<MovieComment> selectMovieCommentByMID(int m_c_mid) throws Exception {
        String sql = "SELECT * FROM dvd_moviecomment WHERE m_c_mid = ? ";
        List<Object> list = new ArrayList<>();
        list.add(m_c_mid);
        Class<MovieComment> cls = MovieComment.class;
        List<MovieComment> movieComments = executeQuery(sql, list, cls);
        if (movieComments.size() == 0) {
            return null;
        }
        return movieComments;
    }

    @Override
    public boolean addMovieComment(MovieComment movieComment) throws Exception {
        String sql = "INSERT INTO dvd_moviecomment (m_c_mid,m_c_uid,m_comment,m_point) VALUES (?,?,?,?)";
        List<Object> list = new ArrayList<>();
        list.add(movieComment.getM_c_mid());
        list.add(movieComment.getM_c_uid());
        list.add(movieComment.getM_comment());
        list.add(movieComment.getM_point());
        if (!excuteUpdate(sql, list)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delMovieComment(int m_c_id) throws Exception {
        String sql = "delete from dvd_movie where m_c_id = ?";
        List<Object> list = new ArrayList<>();
        list.add(m_c_id);
        if (!excuteUpdate(sql, list))
            return false;
        return true;
    }

}
