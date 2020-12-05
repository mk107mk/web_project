package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.ProfessorDTO;
import com.board.mapper.ProfessorMapper;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorMapper professorMapper;

	@Override
	public boolean insertProfessor(ProfessorDTO params) {
		// INSERT 및 UPDATE 기능. 우선적으로 INSERT 기능만 구현 예정.
		int queryResult = 0;

		// 쿼리 실행 후 성공여부를 queryResult 에 저장.
		queryResult = professorMapper.insertProfessor(params);

		// queryResult 값이 1이면 수행성공. 아니면 수행실패.
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<ProfessorDTO> getProfessorList() {
		List<ProfessorDTO> professorList = Collections.emptyList();

		professorList = professorMapper.selectProfessor();

		return professorList;
	}
	
	@Override
	public ProfessorDTO getProfessorPassword(ProfessorDTO params) {
		return professorMapper.findProfessorPassword(params);
	}
	
	@Override
	public ProfessorDTO getProfessorDetail(ProfessorDTO params) {
		return professorMapper.selectProfessorDetail(params);
	}

	@Override
	public boolean deleteProfessor(int pNum) {

		int queryResult = 0;

		// 쿼리 실행 후 성공여부를 queryResult 에 저장.
		queryResult = professorMapper.deleteProfessor(pNum);

		// queryResult 값이 1이면 수행성공. 아니면 수행실패.
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public ProfessorDTO findProfessorInfo(int subPnum) {
		return professorMapper.searchProfessorInfo(subPnum);
	}

}