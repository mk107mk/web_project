package com.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.DayTimeDTO;
import com.board.domain.SubjectInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.domain.TotalSubDTO;
import com.board.service.SubjectInfoService;
import com.board.service.SubtableService;

@Controller
public class SubtableController {

   @Autowired
   private SubtableService subtableService;
   @Autowired
   private SubjectInfoService subjectinfoservice;

   @GetMapping(value="/subtable/mysub.do")
   public String stlist(Model model, HttpServletRequest request) {
	   HttpSession session = request.getSession();
	   int ses = (int)session.getAttribute("stu");
	   List<TotalSubDTO>sub = subtableService.showSubtable(ses);
	   model.addAttribute("subject",sub);
	   return "notice/mysub";
   }
   
   
   @GetMapping(value = "/subtable/update.do")
	public String stupdate() {
		return "subtable/update";
   }
     
	@PostMapping(value = "/subtable/update.do")
		public String updateSubtable(final SubtableDTO params,  RedirectAttributes ra) {
			try {
				boolean isRegistered = subtableService.updateSubtable(params);
			if (isRegistered == false) {
              ra.addFlashAttribute("msg","이미 존재하거나 잘못된 입력입니다.");
              return "redirect:/subtable/update.do";
           }
			} catch (DataAccessException e) {
           

			} catch (Exception e) {
           
			}

			return "redirect:/subtable/list.do";
		}
	
	@PostMapping(value = "/subtable/delete.do")
		public String deleteSubtable(final SubtableDTO params, RedirectAttributes ra) {
			try {
				boolean isRegistered = subtableService.deleteSubtable(params);
			if(isRegistered == false) {
				ra.addFlashAttribute("msg","게시글 삭제에 실패하였습니다.");
				return "redirect:/subtable/list.do";
				}
			} catch(DataAccessException e) {
				
			} catch(Exception e) {
				
			}
			
			return "redirect:/subtable/list.do";
	}
	
	@GetMapping(value = "/insertsub/insert.do")
	public String insertsub(Model model,HttpServletRequest request) {
		
		//list 출력
		List<SubjectInfoDTO> sub =  subjectinfoservice.getSubjectBySemList();
		List<DayTimeDTO> list = new ArrayList<DayTimeDTO>();
		for(SubjectInfoDTO i : sub)
		{
			DayTimeDTO l = new DayTimeDTO();
			l.setDay(subjectinfoservice.days(i.getFinishTime()));
			l.setFinishTime(subjectinfoservice.times(i.getFinishTime()));
			l.setStartTime(subjectinfoservice.times(i.getStartTime()));
			l.setSubCode(i.getSubCode());
			l.setSubGrade(i.getSubGrade());
			l.setSubName(i.getSubName());
			l.setSubPnum(i.getSubPnum());
			l.setMajorCheck(i.getMajorCheck());
			list.add(l);
		}
		
		model.addAttribute("subject",list);
		
		//수강리스트 출력
		HttpSession session = request.getSession();
		   int ses = (int)session.getAttribute("stu");
		List<TotalSubDTO> to = subtableService.showSubtableBySem(ses);
		model.addAttribute("addl", to);
		
		return "/insertsub/insert";
	}
	
	@PostMapping(value = "/insertsub/insert.do")
	public String inserttosub(Model model,HttpServletRequest request,DayTimeDTO total) {
		SubtableDTO sub = new SubtableDTO();
		sub.setStCode(total.getSubCode());
		System.out.println(total);
		HttpSession session = request.getSession();
		   int ses = (int)session.getAttribute("stu");
		   sub.setStSnum(ses);
		   System.out.println(sub +":" + ses);
		//삽입
		System.out.println(subtableService.insertSubtable(sub));
		
		model.addAttribute("addl", subtableService.showSubtableBySem(ses));
		
		  return "insertsub/insert :: #list";

	}
	@PostMapping(value = "/insertsub/insert2.do")
	public String deltosub(Model model,HttpServletRequest request,DayTimeDTO total) {
		SubtableDTO sub = new SubtableDTO();
		sub.setStCode(total.getSubCode());
		System.out.println(total);
		HttpSession session = request.getSession();
		   int ses = (int)session.getAttribute("stu");
		   sub.setStSnum(ses);
		   System.out.println(sub +":" + ses);
		//삽입
		   System.out.println(subtableService.deleteSubtable(sub));
		
		model.addAttribute("addl", subtableService.showSubtableBySem(ses));
		
		  return "insertsub/insert::#list";

	}
	


	
}