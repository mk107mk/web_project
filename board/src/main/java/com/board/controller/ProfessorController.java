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
import com.board.domain.NoticeDTO;
import com.board.domain.ProfessorDTO;
import com.board.domain.StudentDTO;
import com.board.domain.StudentInfoDTO;
import com.board.domain.SubjectInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.service.NoticeService;
import com.board.service.ProfessorService;
import com.board.service.SubjectInfoService;
import com.board.service.SubtableService;

@Controller
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	@Autowired
	private SubjectInfoService subject;
	@Autowired
	private NoticeService notice;
	@Autowired
	private SubtableService subtable;
	
	HttpSession session;

	@GetMapping(value = "/professor/write.do")
	public String openProfessortWrite() {
		return "professor/write";
	}
	   
	@PostMapping(value = "/professor/write.do")
	public String openProfessorWrites(@RequestParam(value = "pNum", required = false) String pNum,@RequestParam(value = "pass", required = false) String pPwd ,
			Model model, RedirectAttributes ra,HttpServletRequest request) {
	      
		if (pNum == null||pPwd==null) {
	         model.addAttribute("professor", new ProfessorDTO());
	         ra.addFlashAttribute("msg", "false");
	         return "redirect:/professor/write.do";
	    } 
	    else 
	    {
	    	ProfessorDTO tmp = new ProfessorDTO();
	    	tmp.setpNum(Integer.parseInt(pNum));
	    	tmp.setpPwd(pPwd);
	    	ProfessorDTO professor = professorService.getProfessorDetail(tmp);
	    	if (professor == null) 
	    	{
	    		ra.addFlashAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
	    		return "redirect:/professor/write.do";
	    	}
	    		session = request.getSession();
	    		 session.setAttribute("pro", professor.getpNum());
	    		 List<SubjectInfoDTO> sub =  subject.findSubByProName(professor.getpName());
	    			List<DayTimeDTO> list = new ArrayList<DayTimeDTO>();
	    			for(SubjectInfoDTO i : sub)
	    			{
	    				DayTimeDTO l = new DayTimeDTO();
	    				l.setDay(subject.days(i.getFinishTime()));
	    				l.setFinishTime(subject.times(i.getFinishTime()));
	    				l.setStartTime(subject.times(i.getStartTime()));
	    				l.setSubCode(i.getSubCode());
	    				l.setSubGrade(i.getSubGrade());
	    				l.setSubName(i.getSubName());
	    				l.setSubPnum(i.getSubPnum());
	    				l.setMajorCheck(i.getMajorCheck());
	    				l.setSem(i.getSem());
	    				list.add(l);
	    			}
	    			model.addAttribute("subject",list);
	    			return "home/prohome";
	    }


	}
	  @GetMapping(value = "/professor/findpwd.do")
      public String findpwd() {
         return "professor/findpwd";
      }
      
      @PostMapping(value = "/professor/findpwd.do")
      @ResponseBody
      public String findpwdp(ProfessorDTO result) {
    	 System.out.println(result);
    	 ProfessorDTO s= professorService.getProfessorPassword(result);
    			
    	  System.out.println(s);
    	  return s.getpPwd();
      }
      
  	@GetMapping(value = "/professor/prohome.do")
  	public String openProfessorhome(Model model, HttpServletRequest request) {
  		session = request.getSession();
  		int ses = (int)session.getAttribute("pro");
  		
  		
  		List<SubjectInfoDTO> sub =  subject.findSubByProName(professorService.findProfessorInfo(ses).getpName());
		List<DayTimeDTO> list = new ArrayList<DayTimeDTO>();
		for(SubjectInfoDTO i : sub)
		{
			DayTimeDTO l = new DayTimeDTO();
			l.setDay(subject.days(i.getFinishTime()));
			l.setFinishTime(subject.times(i.getFinishTime()));
			l.setStartTime(subject.times(i.getStartTime()));
			l.setSubCode(i.getSubCode());
			l.setSubGrade(i.getSubGrade());
			l.setSubName(i.getSubName());
			l.setSubPnum(i.getSubPnum());
			l.setMajorCheck(i.getMajorCheck());
			l.setSem(i.getSem());
			list.add(l);
		}
		model.addAttribute("subject",list);
  		return "home/prohome";
  	}
     
  	
  	@GetMapping(value = "/professor/list.do")
  	public String openProfessornotice(Model model, @RequestParam(value = "subCode", required = false) int subCode) {
  		model.addAttribute("noticeList", notice.getNoticeSubject(subCode));
  		model.addAttribute("sub",subCode);
  		return "professor/list";
  	}
  	@GetMapping(value = "/professor/insertn.do")
  	public String insertnotice(@RequestParam(value = "subCode", required = false) int subCode, Model model) {
  		
  		model.addAttribute("nScode",subCode);
  		return "professor/insertn";
  	}
  	@PostMapping(value = "/professor/insertn.do")
  	public String insertnoticep(NoticeDTO notice1, HttpServletRequest request) {
  		session = request.getSession();
		int id = (int)session.getAttribute("pro");
  		notice1.setnPnum(id);
  		System.out.println(notice.insertNotice(notice1));
  		return "redirect:/professor/list.do?subCode="+Integer.toString(notice1.getnScode());
  	}
  	
  	
  	@GetMapping(value = "/professor/detail.do")
	public String openNoticeDetail(@RequestParam(value = "idx", required = false)int idx, Model model) {
		
		NoticeDTO notice1 = notice.getNoticeDetail(idx);
		
		System.out.println(notice1);
		model.addAttribute("notice", notice1);
		
		return "professor/detail";
}
  	
  	@GetMapping(value = "/professor/update.do")
	public String openNoticeupdate(@RequestParam(value = "idx", required = false)int idx, Model model) {
		
		NoticeDTO notice1 = notice.getNoticeDetail(idx);
		
		model.addAttribute("notice", notice1);
		
		return "professor/update";
}
  	
  	@PostMapping(value = "/professor/update.do")
	public String openNoticeupdate2(NoticeDTO no,HttpServletRequest request) {
		session = request.getSession();
		int id = (int)session.getAttribute("pro");
		no.setnPnum(id);
		notice.updateNotice(no);
		System.out.println(no);
		
		return "redirect:/professor/list.do?subCode="+Integer.toString(no.getnScode());
}
      
  	@GetMapping(value = "/professor/score.do")
	public String insertscore(Model model,@RequestParam(value = "subCode", required = false) int subCode) 
  	{
		List<StudentInfoDTO> student = subtable.findStudentInfo(subCode);
		model.addAttribute("score",student);
		model.addAttribute("code", subCode);
		return "professor/score";
	}
  	
  	@PostMapping(value = "/professor/score.do")
	public String insertscore2(Model model, HttpServletRequest request) 
  	{
	String[] idx = request.getParameterValues("idx");
	String[] score= request.getParameterValues("score");
	String code = request.getParameter("code");
	for(int i=0;i<idx.length;i++)
	{
		SubtableDTO tmp= new SubtableDTO();
		tmp.setId(Integer.parseInt(idx[i]));
		tmp.setStGrade(Float.parseFloat(score[i]));
		subtable.updateSubtable(tmp);
	}
		return "redirect:/professor/score.do?subCode="+code;
	}
  	
  	
  	
}
