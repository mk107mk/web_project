package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DayTimeDTO {

	//시작과 끝교시를 알려준다.
	
	private String subName;
	
	private int majorCheck;
	
	private int subGrade;
	
	private int subCode;
	
	private int subPnum;
	
	private String startTime;
	
	private String finishTime;
	
	private String day;

	private int sem;
	
	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int getMajorCheck() {
		return majorCheck;
	}

	public void setMajorCheck(int majorCheck) {
		this.majorCheck = majorCheck;
	}

	public int getSubGrade() {
		return subGrade;
	}

	public void setSubGrade(int subGrade) {
		this.subGrade = subGrade;
	}

	public int getSubCode() {
		return subCode;
	}

	public void setSubCode(int subCode) {
		this.subCode = subCode;
	}

	public int getSubPnum() {
		return subPnum;
	}

	public void setSubPnum(int subPnum) {
		this.subPnum = subPnum;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}



	@Override
	public String toString() {
		return "DayTimeDTO [subName=" + subName + ", majorCheck=" + majorCheck + ", subGrade=" + subGrade + ", subCode="
				+ subCode + ", subPnum=" + subPnum + ", startTime=" + startTime + ", finishTime=" + finishTime
				+ ", day=" + day + "]";
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}
	

	
}
