package _HaiTong.CinemaManager_Y19_4_18.biz;

import _HaiTong.CinemaManager_Y19_4_18.entity.Movie;
import _HaiTong.CinemaManager_Y19_4_18.entity.MovieComment;

import java.util.List;

public interface MovieCommentBiz {

    List<MovieComment> selectMovieCommentByMID(int m_c_mid) throws  Exception;

    boolean addMovieComment(MovieComment movieComment) throws Exception;

    boolean delMovieComment(int m_c_id) throws  Exception;

}
