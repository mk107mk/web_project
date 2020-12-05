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
import com.board.domain.ProfessorDTO;
import com.board.domain.SubjectInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.service.ProfessorService;
import com.board.service.SubjectInfoService;

@Controller
public class SubjectInfoController {

	@Autowired
	private SubjectInfoService subjectService;
	@Autowired
	private ProfessorService professorService;
	
	
	 @GetMapping(value = "/subjectinfo/subinfo.do")
	   public String subinfo(Model model) {
		 List<SubjectInfoDTO> st = subjectService.getSubjectList();
		 model.addAttribute("subject",st);
	      return "subjectinfo/subinfo";
	   }
	 

	 
	 @GetMapping(value = "/subjectinfo/detail.do")
	   public String details(Model model,@RequestParam int subCode) {
		SubjectInfoDTO sub = subjectService.findSubjectCode(subCode);
		
		String startt= subjectService.times(sub.getStartTime());
		String finisht=subjectService.times(sub.getFinishTime());
		String days= subjectService.days(sub.getFinishTime());
		System.out.println("----------------------------------------");
		System.out.println(professorService.findProfessorInfo(sub.getSubPnum()));
		System.out.println("----------------------------------------");
		ProfessorDTO pname=professorService.findProfessorInfo(sub.getSubPnum());
		String pro=pname.getpName();
		model.addAttribute("startt", startt);
		model.addAttribute("fint", finisht);
		model.addAttribute("days", days);
		model.addAttribute("pname", pro);
		model.addAttribute("subject", sub);
		/*  HttpSession session = request.getSession();
		   
		model.addAttribute("sess", name);*/
		 return "subjectinfo/detail";
	 }
	
	 
		@PostMapping(value = "/subjectinfo/insert.do")
		public String search(Model model,SubjectInfoDTO sub) {
			System.out.println("-----------------------------------------------");
		System.out.println(sub);
		 model.addAttribute("subject",subjectService.findSubjectName(sub.getSubName()));
			
			  return "subjectinfo/subinfo::#list";

		}
	 

}
