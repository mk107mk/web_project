package com.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.domain.NoticeDTO;
import com.board.domain.ReviewDTO;
import com.board.service.ReviewService;
import com.mysql.cj.protocol.x.Notice;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewservice;
	
	@GetMapping("/review/review.do")
	String reviewmain(Model model)
	{
		List<ReviewDTO> re = reviewservice.getReviewList();
		model.addAttribute("review", re);
		return "review/review";
	}
	
	@PostMapping("/review/review.do")
	String reviesearch(Model model, ReviewDTO review)
	{
		List<ReviewDTO> re = reviewservice.findReviewTitleName(review.getrTitle());
		model.addAttribute("review", re);
		
		 return "review/review::#list";
	}
	@GetMapping("/review/detail.do")
	String reviewdetail(Model model,@RequestParam(value = "ridx", required = false) String idx, HttpServletRequest request)
	{
		ReviewDTO re = reviewservice.getReviewDetail(Integer.parseInt(idx));
		//System.out.println(re);
		model.addAttribute("review", re);
		 HttpSession session = request.getSession();
		 int ses = (int)session.getAttribute("stu");
		if(re.getrSnum()==ses)
			model.addAttribute("check", 1);
		else
			model.addAttribute("check", 0);
		
		return "review/detail";
	}
	
	@PostMapping("/review/alter.do")
	String reviewalter(Model model,@RequestParam(value = "idx", required = false) String idx)
	{
		model.addAttribute("idx",Integer.parseInt(idx));
		return "review/alter";
	}
	
	@PostMapping("/review/alter2.do")
	String reviewalter2(ReviewDTO re)
	{
		System.out.println(re);
	 reviewservice.updateReview(re);
			return "redirect:/review/review.do";
			
	}
	@GetMapping("/review/writeR.do")
	String writereview(Model model,HttpServletRequest request ,@RequestParam(value = "subCode", required = false) int subCode) {
		HttpSession session = request.getSession();
		   int ses = (int)session.getAttribute("stu");
		   model.addAttribute("rSnum", ses);
		   model.addAttribute("rScode",subCode);
		   System.out.println(subCode);
		   
		return "review/writeR";
	}
	@PostMapping("/review/writeR.do")
	String writereview2(ReviewDTO re) {
		System.out.println(re);
		   reviewservice.insertReview(re);
		   return "redirect:/review/review.do";
	}
	
}
