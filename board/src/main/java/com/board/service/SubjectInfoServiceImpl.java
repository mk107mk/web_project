package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.SubjectInfoDTO;
import com.board.mapper.SubjectInfoMapper;

@Service
public class SubjectInfoServiceImpl implements SubjectInfoService {

	@Autowired
	private SubjectInfoMapper subjectInfoMapper;

	@Override
	public List<SubjectInfoDTO> getSubjectList() {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.selectSubject();

		return subjectInfoList;
	}
	
	@Override
	public List<SubjectInfoDTO> findSubjectName(String subName) {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();
		
		subjectInfoList = subjectInfoMapper.searchSubjectName(subName);
		return subjectInfoList;
	}

	@Override
	public List<SubjectInfoDTO> judgeMajorSubject(int majorCheck) {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.checkMajorSubject(majorCheck);

		return subjectInfoList;
	}
	
	@Override
	public List<SubjectInfoDTO> findSubByProName(String pName) {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.searchSubByProName(pName);

		return subjectInfoList;
	}

	@Override
	public List<SubjectInfoDTO> searchStuSubject(int stNum) {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.selectStuSubject(stNum);

		return subjectInfoList;
	}
	
	@Override
	public String days(int days) {
		if(days>=50)
			return "금요일";
		else if(days>=40)
			return "목요일";
		else if(days>=30)
			return "수요일";
		else if(days>=20)
			return "화요일";
		else if(days>=10)
			return "월요일";
		else 
		return null;
	}
	
	@Override
	public String times(int time1) {
		int tmp=0;
		if(time1>=50){
			tmp = time1 - 50;
		}else if(time1>=40) {
			tmp=time1 -40;
		}else if(time1>=30) {
			tmp=time1-30;
		}else if(time1>=20) {
			tmp=time1-20;
		}else if(time1>=10) {
			tmp=time1-10;
		}
		
		if(tmp==1)
			return "1교시";
		if(tmp==2)
			return "2교시";
		if(tmp==3)
			return "3교시";
		if(tmp==4)
			return "4교시";
		if(tmp==5)
			return "5교시";

	return null;
	}
	
	@Override
	public SubjectInfoDTO findSubjectCode(int subCode) {
		return subjectInfoMapper.searchSubjectCode(subCode);
	}
	
	/*고정학기 전체과목 리스트*/
	@Override
	public List<SubjectInfoDTO> getSubjectBySemList() {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.selectSubjectBySem();

		return subjectInfoList;
	}
	
	@Override
	public List<SubjectInfoDTO> getStuSubInfo(int stSnum) {
		List<SubjectInfoDTO> subjectInfoList = Collections.emptyList();

		subjectInfoList = subjectInfoMapper.selectStuSubInfo(stSnum);

		return subjectInfoList;
	}
	
}