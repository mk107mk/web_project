package com.board.service;

import java.util.List;

import com.board.domain.ProfessorDTO;

public interface ProfessorService {

	public boolean insertProfessor(ProfessorDTO params);

	public List<ProfessorDTO> getProfessorList();
	
	public ProfessorDTO getProfessorPassword(ProfessorDTO params);
	
	public ProfessorDTO getProfessorDetail(ProfessorDTO params);

	public boolean deleteProfessor(int pNum);
	
	public ProfessorDTO findProfessorInfo(int subPnum);


}