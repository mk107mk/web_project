package com.board.service;

import java.util.List;

import com.board.domain.StudentDTO;

public interface StudentService {

	public boolean insertStudent(StudentDTO params);

	public List<StudentDTO> getStudentList();
	
	public StudentDTO findStudentPassword(StudentDTO params);
	
	public StudentDTO getStudentDetail(StudentDTO params);
	
	public boolean deleteStudent(int stuNum);

}