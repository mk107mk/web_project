package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubtableDTO {
	
	private int id;
	
	private int stSnum;
	
	private int stCode;
	
	private float stGrade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStSnum() {
		return stSnum;
	}

	public void setStSnum(int stSnum) {
		this.stSnum = stSnum;
	}

	public int getStCode() {
		return stCode;
	}

	public void setStCode(int stCode) {
		this.stCode = stCode;
	}

	public float getStGrade() {
		return stGrade;
	}

	public void setStGrade(float stGrade) {
		this.stGrade = stGrade;
	}

	@Override
	public String toString() {
		return "SubtableDTO [id=" + id + ", stSnum=" + stSnum + ", stCode=" + stCode + ", stGrade=" + stGrade + "]";
	}

	
	
}