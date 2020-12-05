package com.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeDTO {
	
	private int idx;
	
	private String title;
	
	private String content;
	
	private int nScode;
	
	private int nPnum;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getnScode() {
		return nScode;
	}

	public void setnScode(int nScode) {
		this.nScode = nScode;
	}

	public int getnPnum() {
		return nPnum;
	}

	public void setnPnum(int nPnum) {
		this.nPnum = nPnum;
	}

	@Override
	public String toString() {
		return "NoticeDTO [idx=" + idx + ", title=" + title + ", content=" + content + ", nScode=" + nScode + ", nPnum="
				+ nPnum + "]";
	}

	
}