package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectInfoDTO {
	
	private String subName;
	
	private int majorCheck;
	
	private int subGrade;
	
	private int subCode;
	
	private int subPnum;
	
	private int startTime;
	
	private int finishTime;
	
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

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	@Override
	public String toString() {
		return "SubjectInfoDTO [subName=" + subName + ", majorCheck=" + majorCheck + ", subGrade=" + subGrade
				+ ", subCode=" + subCode + ", subPnum=" + subPnum + ", startTime=" + startTime + ", finishTime="
				+ finishTime + ", sem=" + sem + "]";
	}

	
}
