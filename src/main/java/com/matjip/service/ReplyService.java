package com.matjip.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.matjip.bean.PageBean;
import com.matjip.bean.QnaBean;
import com.matjip.bean.ReplyBean;
import com.matjip.bean.UserBean;
import com.matjip.dao.ReplyDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;
	
	// Session Scope 에 있는 UserBean 객체 주입받아야함
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	
	// 페이징 관련 변수 : 페이지당 게시글의 개수
	@Value("${page.listcnt}")
	private int pageListcnt;
	
	// 페이징 관련 변수 : 페이지 버튼 개수
	@Value("${page.paginationcnt}")
	private int pagePaginationcnt;
	
		
	// 게시글 리스트 가져오기
	public List<ReplyBean> getReplyList(int page){

		int start = (page - 1) * pageListcnt;
		//
		RowBounds rowBounds = new RowBounds(start, pageListcnt);
	
		return replyDAO.getReplyList(rowBounds);
	}
	
	public List<ReplyBean> getReplyDetail(RowBounds rowBounds) {
		return replyDAO.getReplyDetail(rowBounds);
	}
	
	//게시글 쓰기
	public ReplyBean getReplyWrite (int qna_idx) {
		ReplyBean replyWriteBean = replyDAO.getReplyWrite(qna_idx);	
		return replyDAO.getReplyWrite(qna_idx);
	}
	

	
//	// 수정페이지에서 게시글 수정하기
//	public void modifyContentInfo(NoticeBean modifyNoticeBean) {
//				
//		MultipartFile upload_file = modifyNoticeBean.getUpload_file();
//		
//		if(upload_file.getSize() > 0) {
//			
//			// 파일이름
//			String file_name = saveUploadFile(upload_file);
//			System.out.println("fileName : " + file_name);
//			modifyNoticeBean.setNoti_file(file_name);
//		}
//		
//		noticeDAO.modifyNoticeInfo(modifyNoticeBean);
//	}
//	
//	// 게시글 삭제하기
//	public void deleteNoticeInfo(int content_idx) {
//		
//		noticeDAO.deleteNoticeInfo(content_idx);
//	}
//	
	// 게시글 전체 개수 가져오기
	// Controller 로부터 int content_board_idx, int currentP 값을 받아옴
	// pageListcnt : 페이지당 게시글의 개수
	// pagePaginationcnt : 페이지 버튼 개수	
	public PageBean getReplyCnt(int currentP) {
		
		int qnaCnt = replyDAO.getReplyCnt();
		
		PageBean pageBean = new PageBean(qnaCnt, currentP, pageListcnt, pagePaginationcnt);
		
		return pageBean;
	}

}
