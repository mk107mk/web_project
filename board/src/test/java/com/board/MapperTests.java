package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.domain.StudentDTO;
import com.board.mapper.StudentMapper;

@SpringBootTest
public class MapperTests {

	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void testofInsert() {
		StudentDTO params = new StudentDTO();
		params.setStuName("홍길동");
		params.setStuNum(123456);
		params.setStuPnum("01012351234");
		params.setStuPwd("g1512");
		
		int result = studentMapper.insertStudent(params);
		System.out.println("결과는" + result + "입니다");
	}
	
}
