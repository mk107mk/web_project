package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.ProfessorDTO;

@Mapper
public interface ProfessorMapper {

	public int insertProfessor(ProfessorDTO params);
	
	public List<ProfessorDTO> selectProfessor();
	
	public ProfessorDTO findProfessorPassword(ProfessorDTO params);
	
	public ProfessorDTO selectProfessorDetail(ProfessorDTO params);
	
	public ProfessorDTO checkProfessorLogin(ProfessorDTO params);
	
	public int updateProfessor(ProfessorDTO params);
	
	public int deleteProfessor(int pNum);
	
	public ProfessorDTO searchProfessorInfo(int subPnum);
	
}