package com.matjip.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.matjip.bean.QnaBean;
import com.matjip.bean.ReplyBean;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;	
	
//	public void addContentInfo(NoticeBean writeNoticeBean){
//		
//		sqlSessionTemplate.insert("notice.addNotiInfo", writeNoticeBean);
//	}
	
	// 댓글 리스트 가져오기
	public List<ReplyBean> getReplyList(RowBounds rowBounds){
		
		// System.out.println(sqlSessionTemplate.selectList("notice.getNotiList"));
		return sqlSessionTemplate.selectList("reply.getReplyList", rowBounds );
	}
	
	public List<ReplyBean> getReplyDetail(RowBounds rowBounds) {
		
		return sqlSessionTemplate.selectList("reply.getReplyDetail", rowBounds);
	}
	
	public ReplyBean getReplyWrite(int qna_idx) {
		return sqlSessionTemplate.selectOne("reply.getReplyWrite", qna_idx);
	}
	
//	
//	// 수정페이지에서 게시글 수정하기
//	public void modifyContentInfo(ContentBean modifyContentBean) {
//		
//		sqlSessionTemplate.update("board.modifyContentInfo", modifyContentBean);
//	}
//	
//	// 게시글 삭제하기
//	public void deleteContentInfo(int content_idx) {
//		
//		sqlSessionTemplate.delete("board.deleteContentInfo",content_idx);
//	}
//	
	// 게시글 전체 개수 가져오기
	public int getReplyCnt() {
		
		return sqlSessionTemplate.selectOne("reply.getReplyCnt");
	}

	
	
}