package _HaiTong.CinemaManager_Y19_4_18.dao;

import _HaiTong.CinemaManager_Y19_4_18.entity.MovieComment;

import java.util.List;

public interface MovieCommentDao {

    List<MovieComment> selectMovieCommentByMID(int m_c_mid) throws  Exception;

    boolean addMovieComment(MovieComment movieComment) throws Exception;

    boolean delMovieComment(int m_c_id) throws  Exception;
}
