package _HaiTong.CinemaManager_Y19_4_18.biz.bizImpl;

import _HaiTong.CinemaManager_Y19_4_18.biz.MovieCommentBiz;
import _HaiTong.CinemaManager_Y19_4_18.dao.MovieCommentDao;
import _HaiTong.CinemaManager_Y19_4_18.dao.daoImpl.MovieCommentDaoImpl;
import _HaiTong.CinemaManager_Y19_4_18.entity.MovieComment;

import java.util.List;

public class MovieCommentBizImpl implements MovieCommentBiz {

    private MovieCommentDao movieCommentDao = new MovieCommentDaoImpl();

    @Override
    public List<MovieComment> selectMovieCommentByMID(int m_c_mid) throws Exception {
        return movieCommentDao.selectMovieCommentByMID(m_c_mid);
    }

    @Override
    public boolean addMovieComment(MovieComment movieComment) throws Exception {
        return movieCommentDao.addMovieComment(movieComment);
    }

    @Override
    public boolean delMovieComment(int m_c_id) throws Exception {
        return movieCommentDao.delMovieComment(m_c_id);
    }
}
