package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.ReviewDTO;
import com.board.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public boolean insertReview(ReviewDTO params) {
		int queryResult = 0;
			
		queryResult = reviewMapper.insertReview(params);

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<ReviewDTO> getReviewList() {
		List<ReviewDTO> reviewList = Collections.emptyList();
		
		reviewList = reviewMapper.selectReviewList();
		
		return reviewList;
	}
	
	@Override
	public ReviewDTO getReviewDetail(int ridx) {
		return reviewMapper.selectReviewDetail(ridx);
	}
	
	@Override
	public List<ReviewDTO> getReviewStudentNum(int rSnum) {
		
		List<ReviewDTO> reviewList = Collections.emptyList();
		
		reviewList = reviewMapper.selectReviewStudentNum(rSnum);
		
		return reviewList;
	}
	
	@Override
	public List<ReviewDTO> orderbyReviewScore(int rScore) {
		
		List<ReviewDTO> reviewList = Collections.emptyList();
		
		reviewList = reviewMapper.selectReviewStudentNum(rScore);
		
		return reviewList;
	}
	
	@Override
	public List<ReviewDTO> getReviewSubjectCode(int rScode) {
		
		List<ReviewDTO> reviewList = Collections.emptyList();
		
		reviewList = reviewMapper.selectReviewStudentNum(rScode);
		
		return reviewList;
	}

	@Override
	public boolean updateReview(ReviewDTO params) {
		int queryResult = 0;
			
		queryResult = reviewMapper.updateReview(params);

		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public boolean deleteReview(ReviewDTO params) {
		int queryResult = 0;

		queryResult = reviewMapper.deleteReview(params);

		return (queryResult == 1) ? true : false;
	}
	
	/*제목으로 검색*/
	@Override
	public List<ReviewDTO> findReviewTitleName(String rTitle) {
		
		List<ReviewDTO> reviewList = Collections.emptyList();
		
		reviewList = reviewMapper.searchReviewTitleName(rTitle);
		
		return reviewList;
	}

}