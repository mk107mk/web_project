package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {

	private String stuName;
	
	private int stuNum;
	
	private String stuPnum;
	
	private String stuPwd;
	
	private int stuLogcheck;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuPnum() {
		return stuPnum;
	}

	public void setStuPnum(String stuPnum) {
		this.stuPnum = stuPnum;
	}

	public String getStuPwd() {
		return stuPwd;
	}

	public void setStuPwd(String stuPwd) {
		this.stuPwd = stuPwd;
	}

	public int getStuLogcheck() {
		return stuLogcheck;
	}

	public void setStuLogcheck(int stuLogcheck) {
		this.stuLogcheck = stuLogcheck;
	}
	@Override
	public String toString() {
		return "StudentDTO [stuName=" + stuName + ", stuNum=" + stuNum + ", stuPnum=" + stuPnum + ", stuPwd=" + stuPwd
				+ ", stuLogcheck=" + stuLogcheck + "]";
	}

	
}