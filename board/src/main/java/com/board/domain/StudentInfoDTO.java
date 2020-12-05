package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInfoDTO {
	
	private int siIdx;
	
	private String siSname;
	
	private float siGrade;
	
	private int siSnum;

	public int getSiIdx() {
		return siIdx;
	}

	public void setSiIdx(int siIdx) {
		this.siIdx = siIdx;
	}

	public String getSiSname() {
		return siSname;
	}

	public void setSiSname(String siSname) {
		this.siSname = siSname;
	}

	public float getSiGrade() {
		return siGrade;
	}

	public void setSiGrade(float siGrade) {
		this.siGrade = siGrade;
	}

	public int getSiSnum() {
		return siSnum;
	}

	public void setSiSnum(int siSnum) {
		this.siSnum = siSnum;
	}

	@Override
	public String toString() {
		return "StudentInfoDTO [siIdx=" + siIdx + ", siSname=" + siSname + ", siGrade=" + siGrade + ", siSnum=" + siSnum
				+ "]";
	}
	
}