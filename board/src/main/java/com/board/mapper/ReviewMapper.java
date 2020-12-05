package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.ReviewDTO;

@Mapper
public interface ReviewMapper {

	public int insertReview(ReviewDTO params);
	
	public List<ReviewDTO> selectReviewList();
	
	public ReviewDTO selectReviewDetail(int ridx);
	
	public List<ReviewDTO> selectReviewStudentNum(int rSnum);
	
	public List<ReviewDTO> orderReviewScore();
	
	public List<ReviewDTO> selectReviewSubjectCode(String subName);
	
	public int updateReview(ReviewDTO params);
	
	public int deleteReview(ReviewDTO params);
	
	/*제목으로 검색*/
	public List<ReviewDTO> searchReviewTitleName(String rTitle);

}
