package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.board.domain.NoticeDTO;
import com.board.domain.StudentInfoDTO;
import com.board.domain.SubtableDTO;
import com.board.domain.TotalSubDTO;

@Mapper
public interface SubtableMapper {

	/*수강 신청*/
	public int insertSubtable(SubtableDTO params);
	
	/*수강 삭제*/
	public int deleteSubtable(SubtableDTO params);
	
	/*수강 목록 조회*/
	public List<TotalSubDTO> selectSubtable(int stSnum);
	
	/*학점 업데이트*/
	public int updateSubtable(SubtableDTO params);

	/*총 학점 조회*/
	public int computeTotalGrade(int stSNum);
	
	/*총 학점 조회 전공만 */
	public int computeTotalMajorGrade(int stSNum);
	
	/*총 학점 평균 조회*/
	public float computeAverageTotalGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem);
	
	/*총 학점 평균 조회 전공만*/
	public float computeAverageTotalMajorGrade(@Param("stSnum") int stSnum, 
			@Param("startSem") int startSem, @Param("lastSem") int lastSem);
	
	public List<TotalSubDTO> selectSubtableBySem(int stSnum);
	
	public List<StudentInfoDTO> searchStudentInfo(int stCode);
	
}