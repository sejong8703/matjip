<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath }" />  
<script>
	alert("QnA게시판 글쓰기에 성공했습니다.");
	location.href = "${root}/qna/detail?qna_idx=${writeQnaBean.qna_idx}&page=${page}";
</script>