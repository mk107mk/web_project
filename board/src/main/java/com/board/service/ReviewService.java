package com.board.service;

import java.util.List;

import com.board.domain.ReviewDTO;

public interface ReviewService {

	public boolean insertReview(ReviewDTO params);

	public List<ReviewDTO> getReviewList();
	
	public ReviewDTO getReviewDetail(int ridx);
	
	public List<ReviewDTO> getReviewStudentNum(int rSnum);
	
	public List<ReviewDTO> orderbyReviewScore(int score);
	
	public List<ReviewDTO> getReviewSubjectCode(int rScode);
	
	public boolean updateReview(ReviewDTO params);
	
	public boolean deleteReview(ReviewDTO params);
	
	/*제목으로 검색*/
	public List<ReviewDTO> findReviewTitleName(String rTitle);

}