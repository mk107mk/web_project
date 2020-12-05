package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
	
	private int ridx;
	
	private String rTitle;

	private String rContent;
	
	private int rScode;
	
	private int rSnum;
	
	private String rPwd;
	
	private int score;

	public int getRidx() {
		return ridx;
	}

	public void setRidx(int ridx) {
		this.ridx = ridx;
	}

	public String getrTitle() {
		return rTitle;
	}

	public void setrTitle(String rTitle) {
		this.rTitle = rTitle;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public int getrScode() {
		return rScode;
	}

	public void setrScode(int rScode) {
		this.rScode = rScode;
	}

	public int getrSnum() {
		return rSnum;
	}

	public void setrSnum(int rSnum) {
		this.rSnum = rSnum;
	}

	public String getrPwd() {
		return rPwd;
	}

	public void setrPwd(String rPwd) {
		this.rPwd = rPwd;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ReviewDTO [ridx=" + ridx + ", rTitle=" + rTitle + ", rContent=" + rContent + ", rScode=" + rScode
				+ ", rSnum=" + rSnum + ", rPwd=" + rPwd + ", score=" + score + "]";
	}
	
	

}