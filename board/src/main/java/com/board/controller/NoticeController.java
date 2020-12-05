package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.NoticeDTO;
import com.board.service.NoticeService;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	



	@GetMapping(value = "/notice/list.do")
	public String getNoticeStudent(@RequestParam(value = "toCode", required = false) String nSnum, Model model) {
		List<NoticeDTO> noticeList = noticeService.getNoticeSubject(Integer.parseInt(nSnum));
		model.addAttribute("noticeList", noticeList);
		return "notice/list";
	}
	

	
	@GetMapping(value = "notice/detailnotice.do")
		public String openNoticeDetail(@RequestParam(value = "idx", required = false) String idx, Model model) {
			if(idx==null) {
				return "redirect:/notice/list.do";
			}
			
			NoticeDTO notice = noticeService.getNoticeDetail(Integer.parseInt(idx));
			if(notice == null) {
				return "redirect:/subtable/mysub.do";
			}
			
			model.addAttribute("notice", notice);
			
			return "notice/detailnotice";
	}
	
	
	
	
}
