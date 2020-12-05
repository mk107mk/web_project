package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.SubjectInfoDTO;

@Mapper
public interface SubjectInfoMapper {

	/*전체 과목 리스트*/
	public List<SubjectInfoDTO> selectSubject();
	
	/*과목 이름으로 조회*/
	public List<SubjectInfoDTO> searchSubjectName(String subName);
	
	/*교수 이름으로 조회*/
	public List<SubjectInfoDTO> searchSubByProName(String pName);
	
	/*전공 여부 관련 조회*/
	public List<SubjectInfoDTO> checkMajorSubject(int majorCheck);
	
	/*수강 과목 조회*/
	public List<SubjectInfoDTO> selectStuSubject(int stNum);
	
	/*요일별로 과목 조회*/
	/*public List<SubjectInfoDTO> checkDaySubject(int startTime);*/
	
	/*특정과목 총 수강 인원 조회*/
	/*public List<SubjectTotalDTO> countSubjectTotal(int subCode);*/
	
	public SubjectInfoDTO searchSubjectCode(int subCode);
	
	public List<SubjectInfoDTO> selectSubjectBySem();
	
	public List<SubjectInfoDTO> selectStuSubInfo(int stSnum);

	
}