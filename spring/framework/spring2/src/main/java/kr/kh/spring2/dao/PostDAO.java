package kr.kh.spring2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.FileVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.Criteria;
import kr.kh.spring2.pagination.PostCriteria;

public interface PostDAO {

	List<BoardVO> selectBoardList();

	List<PostVO> selectPostList(@Param("cri")Criteria cri);

	int selectCountPostList(@Param("cri")PostCriteria cri);

	PostVO selectPost(@Param("po_num")int po_num);

	List<FileVO> selectFileList(@Param("po_num")int po_num);

	boolean insertPost(PostVO post);

}
