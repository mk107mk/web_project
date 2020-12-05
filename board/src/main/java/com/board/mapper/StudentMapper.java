package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.StudentDTO;

@Mapper
public interface StudentMapper {

	public int insertStudent(StudentDTO params);
	
	public List<StudentDTO> selectStudent();
	
	public StudentDTO findStudentPassword(StudentDTO params);
	
	public StudentDTO selectStudentDetail(StudentDTO params);
	
	public StudentDTO checkStudentLogin(StudentDTO params);
	
	public int updateStudent(StudentDTO params);
	
	public int deleteStudent(int stuNum);
	
}