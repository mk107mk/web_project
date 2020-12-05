package com.board.service;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.StudentInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.domain.TotalSubDTO;
import com.board.mapper.SubtableMapper;

@Service
public class SubtableServiceImpl implements SubtableService {

	@Autowired
	private SubtableMapper subtableMapper;

	@Override
	public boolean insertSubtable(SubtableDTO params) {
		// INSERT 및 UPDATE 기능. 우선적으로 INSERT 기능만 구현 예정.
		int queryResult = 0;

		// 쿼리 실행 후 성공여부를 queryResult 에 저장.
		queryResult = subtableMapper.insertSubtable(params);

		// queryResult 값이 1이면 수행성공. 아니면 수행실패.
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<TotalSubDTO> showSubtable(int stSnum) {
		List<TotalSubDTO> totalList = Collections.emptyList();

		totalList = subtableMapper.selectSubtable(stSnum);

		return totalList;
	}

	@Override
	public boolean deleteSubtable(SubtableDTO params) {
		// INSERT 및 UPDATE 기능. 우선적으로 INSERT 기능만 구현 예정.
		int queryResult = 0;

		// 쿼리 실행 후 성공여부를 queryResult 에 저장.
		queryResult = subtableMapper.deleteSubtable(params);

		// queryResult 값이 1이면 수행성공. 아니면 수행실패.
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public boolean updateSubtable(SubtableDTO params) {
		// INSERT 및 UPDATE 기능. 우선적으로 INSERT 기능만 구현 예정.
		int queryResult = 0;

		// 쿼리 실행 후 성공여부를 queryResult 에 저장.
		queryResult = subtableMapper.updateSubtable(params);

		// queryResult 값이 1이면 수행성공. 아니면 수행실패.
		return (queryResult == 1) ? true : false;
	}
	
	/*총학점 조회*/
	@Override
	public int sumTotalGrade(int stNum) {
		return subtableMapper.computeTotalGrade(stNum);
	}
	
	/*총학점 조회 전공만*/
	@Override
	public int sumTotalMajorGrade(int stNum) {
		return subtableMapper.computeTotalMajorGrade(stNum);
	}

	/*총학점 조회 평균 */
	@Override
	public float averageTotalGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem) {
		return subtableMapper.computeAverageTotalGrade(stSnum, startSem, lastSem);
	}
	
	/*총학점 조회 평균 전공만*/
	@Override
	public float averageTotalMajorGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem) {
		return subtableMapper.computeAverageTotalMajorGrade(stSnum, startSem, lastSem);
	}
	
	
	/*학기 고정*/
	@Override
	public List<TotalSubDTO> showSubtableBySem(int stSnum) {
		List<TotalSubDTO> totalList = Collections.emptyList();

		totalList = subtableMapper.selectSubtableBySem(stSnum);

		return totalList;
	}
	
	
	@Override
	public List<StudentInfoDTO> findStudentInfo (int stCode) {
		List<StudentInfoDTO> subList = Collections.emptyList();

		subList = subtableMapper.searchStudentInfo(stCode);

		return subList;
	}
}