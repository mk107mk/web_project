package com.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.board.domain.StudentInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.domain.TotalSubDTO;

public interface SubtableService {

	public boolean insertSubtable(SubtableDTO params);
	
	public boolean deleteSubtable(SubtableDTO params);
	
	public List<TotalSubDTO> showSubtable(int stSnum);
	
	public boolean updateSubtable(SubtableDTO params);
	
	/*총학점 조회*/
	public int sumTotalGrade(int stSnum);
	
	/*총학점 조회 전공만*/
	public int sumTotalMajorGrade(int stSnum);
	
	/*총학점 조회 평균*/
	public float averageTotalGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem);
	
	/*총학점 조회 평균 전공만*/
	public float averageTotalMajorGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem);
	
	
	public List<TotalSubDTO> showSubtableBySem(int stSnum);
	
	public List<StudentInfoDTO> findStudentInfo(int stCode);
}