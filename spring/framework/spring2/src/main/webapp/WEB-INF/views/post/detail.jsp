<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
 <html>
 <head>
 	 <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
 </head>
 <body id="body">
 	<c:choose>
 		<c:when test="${post ne null}">
 			<h1>게시글 상세</h1>
 			<div>
 				<div class="form-group mt-3">
 					<label class="form-label">게시판</label>
 					<input type="text" class="form-control" value="${post.po_bo_name }" readonly>
 				</div>
 				<div class="form-group mt-3">
 					<label class="form-label">제목</label>
 					<input type="text" class="form-control" value="${post.po_title}" readonly>
 				</div>
 				<div class="form-group mt-3">
 					<label class="form-label">작성자</label>
 					<input type="text" class="form-control"value="${post.po_me_id}" readonly>
 				</div>
 				<div class="form-group mt-3">
 					<label for="title" class="form-label">작성일</label>
 					<input type="text" class="form-control" value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly>
 				</div>
 				
 				<div class="form-group mt-3">
 					<label for="title" class="form-label">조회수</label>
 					<input type="text" class="form-control" value="${post.po_view}" readonly>
 				</div>
 				<div class="form-group mt-3 d-flex justify-content-center" id="btns">
 					<button class="btn btn<c:if test="${like.li_state ne 1 }">-outline</c:if>-success btn-up" data-state="1">추천(<span>${post.po_up }</span>)</button>
 					<button class="btn btn<c:if test="${like.li_state ne -1 }">-outline</c:if>-danger ml-3 btn-down" data-state="-1">비추천(<span>${post.po_down }</span>)</button>
 				</div>
 				
				<div class="mb-3">
 	              	<c:forEach items="${list}" var="file">
 						<img alt="첨부파일" width="auto" height="300" src="<c:url value="/download${file.fi_name }"/>">
 					</c:forEach>
 				</div>
 			</div>
 		</c:when>
 		<c:otherwise>
 			<h3>등록되지 않거나 삭제된 게시글입니다.</h3>		
 		</c:otherwise>
 	</c:choose>
 	<div class="d-flex justify-content-between">
 		<a href="<c:url value="/post/list"/>" class="btn btn-outline-success">목록</a>
 		<c:if test="${user.me_id eq post.po_me_id }">
 			<div class="btns">
 				<a href="<c:url value="/post/update/${post.po_num}"/>" class="btn btn-outline-info">수정</a>
 				<a href="<c:url value="/post/delete/${post.po_num}"/>" class="btn btn-outline-danger">삭제</a>
 			</div>
 		</c:if>
 	</div>
 </body>
 </html>