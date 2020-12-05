package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.StudentDTO;
import com.board.mapper.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public boolean insertStudent(StudentDTO params) {
		int queryResult = 0;
		
		queryResult = studentMapper.insertStudent(params);

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<StudentDTO> getStudentList() {
		List<StudentDTO> studentList = Collections.emptyList();

		studentList = studentMapper.selectStudent();

		return studentList;
	}
	
	@Override
	public StudentDTO findStudentPassword(StudentDTO params) {
		return studentMapper.findStudentPassword(params);
	}
	
	@Override
	public StudentDTO getStudentDetail(StudentDTO params) {
		return studentMapper.selectStudentDetail(params);
	}

	@Override
	public boolean deleteStudent(int stuNum) {

		int queryResult = 0;

		queryResult = studentMapper.deleteStudent(stuNum);

		return (queryResult == 1) ? true : false;
	}

}