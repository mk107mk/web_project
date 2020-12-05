package com.board.service;

import java.util.List;

import com.board.domain.SubjectInfoDTO;

public interface SubjectInfoService {

	public List<SubjectInfoDTO> getSubjectList();
	
	public List<SubjectInfoDTO> findSubjectName(String subName);

	public List<SubjectInfoDTO> judgeMajorSubject(int majorCheck);
	
	public List<SubjectInfoDTO> findSubByProName(String pName);
	
	public List<SubjectInfoDTO> searchStuSubject(int stNum);
	//시간 찾기
	public String times(int time1);
	//요일찾기
	public String days(int days);
	
	public SubjectInfoDTO findSubjectCode(int subCode);
	
	public List<SubjectInfoDTO> getSubjectBySemList();
	
	public List<SubjectInfoDTO> getStuSubInfo(int stSnum);

	
}