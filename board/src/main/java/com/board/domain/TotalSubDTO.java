package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalSubDTO {
	private int toId;
	
	private int toSnum;
	
	private int toCode;
	
	private float toGrade;

	private String toSubName;
	
	private String toPname;
	
	private int toSem;

	

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public int getToSnum() {
		return toSnum;
	}

	public void setToSnum(int toSnum) {
		this.toSnum = toSnum;
	}

	public int getToCode() {
		return toCode;
	}

	public void setToCode(int toCode) {
		this.toCode = toCode;
	}

	public float getToGrade() {
		return toGrade;
	}

	public void setToGrade(float toGrade) {
		this.toGrade = toGrade;
	}

	public String getToSubName() {
		return toSubName;
	}

	public void setToSubName(String toSubName) {
		this.toSubName = toSubName;
	}

	public String getToPname() {
		return toPname;
	}

	public void setToPname(String toPname) {
		this.toPname = toPname;
	}

	
	public int getToSem() {
		return toSem;
	}

	public void setToSem(int toSem) {
		this.toSem = toSem;
	}

	@Override
	public String toString() {
		return "TotalSubDTO [toId=" + toId + ", toSnum=" + toSnum + ", toCode=" + toCode + ", toGrade=" + toGrade
				+ ", toSubName=" + toSubName + ", toPname=" + toPname + "]";
	}
	
}
