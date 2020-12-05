package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.domain.NoticeDTO;

@Mapper
public interface NoticeMapper {

	public int insertNotice(NoticeDTO params);
	
	public List<NoticeDTO> selectNoticeStudent(int stSnum);
	
	public NoticeDTO selectNoticeDetail(int idx);
	
	public int updateNotice(NoticeDTO params);
	
	public List<NoticeDTO> selectNoticeSubject(int subCode);
	
}
