package com.board.service;

import java.util.List;

import com.board.domain.NoticeDTO;

public interface NoticeService {

	public boolean insertNotice(NoticeDTO params);

	public List<NoticeDTO> getNoticeStudent(int nSnum);
	
	public NoticeDTO getNoticeDetail(int idx);
	
	public boolean updateNotice(NoticeDTO params);
	
	public List<NoticeDTO> getNoticeSubject(int nScode);


}