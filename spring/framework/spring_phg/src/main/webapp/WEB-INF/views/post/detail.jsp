<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
 <html>
 <head>
 	<link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.css" rel="stylesheet">
     <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-bs4.min.js"></script>
 </head>
 <body>
 
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
 				<div class="form-group mt-3">
 					<label for="content" class="form-label">내용</label>
 					<div class="form-control" id="content" style="min-height: 400px;">${post.po_content }</div>
 				</div>
 				<c:if test="${list.size() ne 0}">
 					<div class="form-group">
 						<label>첨부파일</label>
 						<c:forEach items="${list }" var="file">
 							<a class="form-control" href="<c:url value="/download${file.fi_name}"/>" download="${file.fi_ori_name}">${file.fi_ori_name }</a>
 						</c:forEach>							
 					</div>
 				</c:if>
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
 	<hr>
 	<h3>댓글</h3>
 	<div class="comment-container">
 		
 	</div>
 	
 	<!-- 댓글 목록 조회 -->
 	<script type="text/javascript">
 		var cri = {
			page : 1,
			search : ${post.po_num}
			}	
 		function getCommentList(cri){
 			//ajax로 댓글 리스트를 가져와서 화면에 출력
 			$.ajax({
 				async : true, //비동기 : true(비동기), false(동기)
 				url : '<c:url value="/comment/list"/>', 
 				type : 'post', 
 				data : JSON.stringify(cri), 
 				contentType : "application/json; charset=utf-8",
 				success : function (data){
 					$(".comment-container").html(data);
 				},
 				error : function(jqXHR, textStatus, errorThrown){
 
 				}
 			});
 		}
 		
 		getCommentList(cri);
 		function drawCommentList(list){
 			
 			if(list.length == 0){
 				$(".comment-list").html(`<div class="text-center mb-3">등록된 게시글이 없습니다.</div>`)
 				return;
 			}
 			
 			let str = '';
 			for(comment of list){
 				let btns = '';
 				let replyBtn = '';
 				let padding = '';
 				
 				//회원이 댓글/답글 작성자이면 수정/삭제버튼 추가
 				if(comment.co_me_id == '${user.me_id}'){
 					btns = `
 						<button class="btn btn-outline-warning">수정</button>
 						<button class="btn btn-outline-danger" >삭제</button>
 					`;
 				}
 				
 				//댓글이면 답글 버튼 추가
 				if(comment.co_num == comment.co_ori_num){
 					replyBtn = `<button class="btn btn-outline-success btn-reply" data-num="\${comment.co_num}">답글</button>`;	
 				}
 				//답글이면 왼쪽 패딩 추가
 				else{
 					padding = 'pl-5';
 				}
 				
 				str += `
 					<div class="\${padding}">
						<div class="comment-item form-control mb-3" style="min-height: auto; height: auto;">
							<div class="comment-wrap">
								<div class="comment-writer">\${comment.co_me_id}</div>
								<div class="comment-content">\${comment.co_content}</div>
							</div>
							<div class="comment-func mt-2">
								\${replyBtn}
								\${btns}
							</div>
 						</div>
 					</div>
 				`
 			}
 			$(".comment-list").html(str);
 		}
 		
 		getCommentList();
 	</script>
 	
 </body>