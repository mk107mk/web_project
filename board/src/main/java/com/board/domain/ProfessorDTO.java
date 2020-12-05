package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {

	private String pName;
	
	private int pNum;
	
	private String pPnum;
	
	private String pPwd;

	private int pLogcheck;

	@Override
	public String toString() {
		return "ProfessorDTO [pName=" + pName + ", pNum=" + pNum + ", pPnum=" + pPnum + ", pPwd=" + pPwd
				+ ", pLogcheck=" + pLogcheck + "]";
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpPnum() {
		return pPnum;
	}

	public void setpPnum(String pPnum) {
		this.pPnum = pPnum;
	}

	public String getpPwd() {
		return pPwd;
	}

	public void setpPwd(String pPwd) {
		this.pPwd = pPwd;
	}

	public int getpLogcheck() {
		return pLogcheck;
	}

	public void setpLogcheck(int pLogcheck) {
		this.pLogcheck = pLogcheck;
	}
	
	
}