package com.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.AverageDTO;
import com.board.domain.StudentDTO;
import com.board.domain.SubjectInfoDTO;
import com.board.service.StudentService;
import com.board.service.SubjectInfoService;
import com.board.service.SubtableService;
import com.mysql.cj.conf.ConnectionUrlParser.Pair;

@Controller
public class StudentController {

   @Autowired
   private StudentService studentService;
   
   @Autowired
   private SubtableService sub;
   
   @Autowired
   private SubjectInfoService subinfo;
   HttpSession session;

   @GetMapping(value = "/student/write.do")
   public String openStudentWrite() {
      return "student/write";
   }
      
   @PostMapping(value = "/student/write.do")
   public String openStudentWrites(@RequestParam(value = "stu_num", required = false) String stu_num,@RequestParam(value = "pass", required = false) String stu_pwd ,Model model,
		   RedirectAttributes ra, HttpServletRequest request ) {
         
      if (stu_num == null||stu_pwd==null) {
            model.addAttribute("student", new StudentDTO());
          
            ra.addFlashAttribute("msg", "false");
            return "redirect:/student/write.do";
       } 
       else 
       { 
    	  StudentDTO temp = new StudentDTO();
    	  temp.setStuNum(Integer.parseInt(stu_num));
    	  temp.setStuPwd(stu_pwd);
          StudentDTO student = studentService.getStudentDetail(temp);
          if (student == null) 
          {
             ra.addFlashAttribute("msg", "아이디 또는 비밀번호가 잘못되었습니다.");
             return "redirect:/student/write.do";
          }
          
          AverageDTO avg = new AverageDTO();

      	  avg.setAvgG(sub.averageTotalGrade(temp.getStuNum(), 11, 21));
      	  avg.setAvgMG(sub.averageTotalGrade(temp.getStuNum(), 11, 21));
      	  avg.setAvgG11(sub.averageTotalGrade(temp.getStuNum(), 11, 11));
      	  avg.setAvgG12(sub.averageTotalGrade(temp.getStuNum(), 12, 12));
      	  avg.setAvgG21(sub.averageTotalGrade(temp.getStuNum(), 21, 21));
      	  avg.setAvgMG11(sub.averageTotalMajorGrade(temp.getStuNum(), 11, 11));
      	  avg.setAvgMG12(sub.averageTotalMajorGrade(temp.getStuNum(), 12, 12));
      	  avg.setAvgMG21(sub.averageTotalMajorGrade(temp.getStuNum(), 21, 21));
      	  avg.setTotalG(sub.sumTotalGrade(temp.getStuNum()));
      	  avg.setTotalMG(sub.sumTotalMajorGrade(temp.getStuNum()));
      	  model.addAttribute("avg", avg);
             model.addAttribute("student", student);
             session= request.getSession();
             session.setAttribute("stu", student.getStuNum());
             session.setAttribute("pwd",student.getStuPwd() );
             return "home/write";
       }

        
   }

   @GetMapping(value = "/student/register.do")
      public String streg() {
         return "student/register";
      }
      
      @PostMapping(value = "/student/register.do")
      public String insertStudent(final StudentDTO params,  RedirectAttributes ra) {
         try {
            boolean isRegistered = studentService.insertStudent(params);
            if (isRegistered == false) {
               ra.addFlashAttribute("msg","이미 존재하거나 잘못된 입력입니다.");
               return "redirect:/student/register.do";
            }
         } catch (DataAccessException e) {
            

         } catch (Exception e) {
            
         }

         return "redirect:/student/write.do";
      }
      
      @GetMapping(value = "/student/findpwd.do")
      public String findpwd() {
         return "student/findpwd";
      }
      
      @PostMapping(value = "/student/findpwd.do")
      @ResponseBody
      public String findpwdp(StudentDTO result) {
    	 System.out.println(result);
    	  StudentDTO s= new StudentDTO();
    			  s= studentService.findStudentPassword(result);
    	  System.out.println(s);
    	  return s.getStuPwd();
      }
      
      @GetMapping(value = "/home/write.do")
      public String home(HttpServletResponse response, HttpServletRequest re, Model model) throws IOException {
    	  session=re.getSession(false);
    	int ses = (int)session.getAttribute("stu");
    	
    	System.out.println(ses);
          	  AverageDTO avg = new AverageDTO();

          	  avg.setAvgG(sub.averageTotalGrade(ses, 11, 21));
          	  avg.setAvgMG(sub.averageTotalGrade(ses, 11, 21));
          	  avg.setAvgG11(sub.averageTotalGrade(ses, 11, 11));
          	  avg.setAvgG12(sub.averageTotalGrade(ses, 12, 12));
          	  avg.setAvgG21(sub.averageTotalGrade(ses, 21, 21));
          	  avg.setAvgMG11(sub.averageTotalMajorGrade(ses, 11, 11));
          	  avg.setAvgMG12(sub.averageTotalMajorGrade(ses, 12, 12));
          	  avg.setAvgMG21(sub.averageTotalMajorGrade(ses, 21, 21));
          	  avg.setTotalG(sub.sumTotalGrade(ses));
          	  avg.setTotalMG(sub.sumTotalMajorGrade(ses));
    	  model.addAttribute("avg", avg);
    	  
    	  if(session!=null)
         return "home/write";
    	  else
    		  response.setContentType("text/html; charset=UTF-8");
    	  PrintWriter out = response.getWriter();
    	  out.println("<script>alert('잘못된 접근입니다.'); </script>");
    	  out.flush();
    		  return null;
      }
      
      @GetMapping(value = "/student/logout.do")
      public String logout(HttpServletRequest re) {
    	  session=re.getSession();
    	  session.invalidate();
         return "redirect:/student/write.do";
      }
      
      
      @GetMapping(value = "/student/info.do")
      public String info(HttpServletRequest re, Model model) 
      {
    	  session=re.getSession();
    	  int ses = (int)session.getAttribute("stu");
    	  String pwd = (String)session.getAttribute("pwd");
    	  StudentDTO student = new StudentDTO();
    	  student.setStuNum(ses);
    	  student.setStuPwd(pwd);
    	  StudentDTO st = studentService.getStudentDetail(student);
    	  
    	  model.addAttribute("info", st);
         return "/home/studentinfo";
      }
      
      @GetMapping(value = "/student/mine.do")
      public String mine(HttpServletRequest re, Model model) {
    	  session=re.getSession();
    	  
    	  int ses = (int)session.getAttribute("stu");
    	  List<SubjectInfoDTO>li = subinfo.getStuSubInfo(ses);
    	  String[] one =  {"b","a","a","a","a","a"};
    	  String[] two =  {"b","a","a","a","a","a"};
    	  String[] three =  {"b","a","a","a","a","a"};
    	  String[] four =  {"b","a","a","a","a","a"};
    	  String[] five =  {"b","a","a","a","a","a"};
    	
    	  for(SubjectInfoDTO l : li)
    	  {
    		  System.out.println(l);
    		  
    		  if(l.getStartTime()>50) {
    			  int start = l.getStartTime() - 50;
    			  int finish= l.getFinishTime() -50;
    			 
    			  
    			  for(int i =start; i<finish+1;i++) {
    				  if(i==1) one[5]=l.getSubName();
    				  if(i==2) two[5]=l.getSubName();
    				  if(i==3) three[5]=l.getSubName();
    				  if(i==4) four[5]=l.getSubName();
    				  if(i==5) five[5]=l.getSubName();
    			  }
    			  
    		  }else if(l.getStartTime()>40) {
    			  int start = l.getStartTime() - 40;
    			  int finish= l.getFinishTime() -40;
    			  
    			  for(int i =start; i<finish+1;i++) {
    				  if(i==1) one[4]=l.getSubName();
    				  if(i==2) two[4]=l.getSubName();
    				  if(i==3) three[4]=l.getSubName();
    				  if(i==4) four[4]=l.getSubName();
    				  if(i==5) five[4]=l.getSubName();
    			  }
    			  
    		  }else if(l.getStartTime()>30) {
    			  int start = l.getStartTime() - 30;
    			  int finish= l.getFinishTime() -30;
    			  
    			  for(int i =start; i<finish+1;i++) {
    				  if(i==1) one[3]=l.getSubName();
    				  if(i==2) two[3]=l.getSubName();
    				  if(i==3) three[3]=l.getSubName();
    				  if(i==4) four[3]=l.getSubName();
    				  if(i==5) five[3]=l.getSubName();
    			  }
    			  
    		  }else if(l.getStartTime()>20) {
    			  int start = l.getStartTime() - 20;
    			  int finish= l.getFinishTime() -20;
    			  
    			  for(int i =start; i<finish+1;i++) {
    				  if(i==1) one[2]=l.getSubName();
    				  if(i==2) two[2]=l.getSubName();
    				  if(i==3) three[2]=l.getSubName();
    				  if(i==4) four[2]=l.getSubName();
    				  if(i==5) five[2]=l.getSubName();
    			  }
    			  
    		  }else if(l.getStartTime()>10) {
    			  int start = l.getStartTime() - 10;
    			  int finish= l.getFinishTime() -10;
    			 
    			  for(int i =start; i<finish+1;i++) {
    				  if(i==1) one[1]=l.getSubName();
    				  if(i==2) two[1]=l.getSubName();
    				  if(i==3) three[1]=l.getSubName();
    				  if(i==4) four[1]=l.getSubName();
    				  if(i==5) five[1]=l.getSubName();
    			  }
    		  }
    		  
    	  }

    	  model.addAttribute("one", one); model.addAttribute("two", two);
    	  model.addAttribute("three", three); model.addAttribute("four", four);
    	  model.addAttribute("five", five);
         return "/student/mine";
      }
      
}