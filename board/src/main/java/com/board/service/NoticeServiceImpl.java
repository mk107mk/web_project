package com.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.domain.NoticeDTO;
import com.board.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public boolean insertNotice(NoticeDTO params) {
		int queryResult = 0;
			
		queryResult = noticeMapper.insertNotice(params);

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<NoticeDTO> getNoticeStudent(int nSnum) {
		List<NoticeDTO> noticeList = Collections.emptyList();
		
		noticeList = noticeMapper.selectNoticeStudent(nSnum);
		
		return noticeList;
	}
	
	@Override
	public boolean updateNotice(NoticeDTO params) {
		int queryResult = 0;
			
		queryResult = noticeMapper.updateNotice(params);

		return (queryResult == 1) ? true : false;
	}

	@Override
	public NoticeDTO getNoticeDetail(int idx) {
		
		return noticeMapper.selectNoticeDetail(idx);
	}
	

	@Override
	public List<NoticeDTO> getNoticeSubject(int nScode) {
		List<NoticeDTO> noticeList = Collections.emptyList();
		
		noticeList = noticeMapper.selectNoticeSubject(nScode);
		
		return noticeList;
	}
}