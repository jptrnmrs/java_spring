<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fn" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글보기</title>
<link rel="stylesheet" href="/jboard/css/style.css">
<script>
		window.onload = function() {
			const commentForm = document.commentForm;
			const commentList = document.getElementsByClassName('commentList')[0];
			const empty = document.getElementsByClassName('empty')[0];
			
			let originalText = '';
			
			document.addEventListener('click', function(e){

				
					const article = e.target.closest('article');
				    const textarea = article.querySelector('textarea');
					const commentRemove = document.getElementsByClassName('commentRemove');
					const commentCancel = article.querySelector('.commentCancel');
					const commentModify = article.querySelector('.commentModify');
					// 취소
	    			if(e.target.classList == 'commentCancel'){
	    				e.preventDefault();
	    				textarea.value = originalText;
	    				textareaEditMode(false);
	    			}
					
					// 수정
				if(e.target.classList == 'commentModify'){
					e.preventDefault();
				    const mode = e.target.innerText;
				    
				    if(mode ==='수정'){
				    	originalText = textarea.value;
    					textareaEditMode(true);
				    }else{
				    	// 수정완료
	    				const cno = commentModify.dataset.cno;
	    				const comment = textarea.value;
	    				
	    				const formData = new FormData();
	    				formData.append("cno", cno);
	    				formData.append("comment", comment);
	    				
	    				fetch('/jboard/comment/modify.do', {
	    						method: 'POST',
	    						body: formData
	    					})
	    					.then(resp => resp.json())
	    					.then(data => {
	    						console.log(data);
	    						
	    						if(data.result > 0){
	    							alert('댓글이 수정되었습니다.');
	    							textareaEditMode(false);
	    						}
	    					})
	    					.catch(err => {
	    						console.log(err);
	    					});
    				}
    			}
    			
    			// 댓글 Textarea 수정모드/일반모드 전환 함수
    			function textareaEditMode(edit) {
        			if(edit){
        				// 수정모드
        				textarea.readOnly = false;
        				textarea.style.background = 'white';
        				textarea.style.border = '1px solid #555';
        				textarea.focus();
        				commentModify.innerText = '수정완료';
        				commentCancel.style.display = 'inline';
	    				commentRemove.style.display = 'none';
        			}else{
        				// 일반모드
        				textarea.readOnly = true;
	    				textarea.style.background = 'transparent';
	    				textarea.style.border = 'none';
	    				commentModify.innerText = '수정';
	    				commentCancel.style.display = 'none';
        				commentRemove.style.display = 'inline';
        			}
        		}
				
				//삭제
				if(e.target.classList == 'commentRemove'){
					
					e.preventDefault();
					
					
						if(!confirm('정말 삭제하시겠습니까?')){
							return;
						}
						const info = document.getElementById('articleInfo');
						const article = e.target.closest('article');
						const cno = e.target.dataset.cno;
						const ano = e.target.dataset.ano;
						
						fetch('/jboard/comment/delete.do?cno='+cno+'&ano='+ano)
							.then(resp=>resp.json)
							.then(data=>{
								console.log(data);
								if(data.result != 0){
									alert('댓글이 삭제되었습니다.');
									
									//동적 삭제 처리
									article.remove();
									info.innerHTML =`\${article.writerNick}　  　\${article.rdate}
										<span>조회수 \${article.hit} 　 댓글 \${data.count}</span>`;
								}else{

									alert('오류가 발생했습니다. 관리자에게 문의하세요.');
								}
							})
							.catch(err=>{
								console.log(err)
							});
						
					
					
				}// 삭제 끝
				
			});
			
			// 댓글 등록
			commentForm.onsubmit = function(e){
				e.preventDefault();
				
				const ano = commentForm.ano.value;
				const writer = commentForm.writer.value;
				const content = commentForm.comment.value;
				
				if(content==""){
					alert('내용을 입력하세요');
					return;
				}
				
				// 폼 데이터 생성
				
				const formData = new FormData();
				formData.append("parent", parent);
				formData.append("writer", writer);
				formData.append("content", content);
				
				/* const jsonData = {
						"parent":parent,
						"writer":writer,
						"content":content
				} */
				
				fetch('/jboard/comment/write.do',{
						method: 'POST',
						body : formData
						/* body: JSON.stringify(jsonData) */
					})
					.then(resp=>resp.json())
					.then(data => {
						console.log(data);
						if(data != null){
							alert('등록되었습니다.');
							
							//등록한 댓글 동적 태그 생성
							
							const commentArticle = `<article class = 'comment'>
														<span>
															<span style='font-weight: bolder'>\${data.nick}</span>
															<span> | \${data.rdate}</span>
														</span>
														<textarea name='comment' readonly>\${data.content}</textarea>
														<div>
								                            <a href="#" class="commentCancel" data-cno="${comment.cno}" data-ano="${article.ano}">취소</a>
								                            <a href="#" class="commentModify" data-cno="${comment.cno}" data-ano="${article.ano}">수정</a>
															<a href="#" class="commentRemove" data-cno="${comment.cno}" data-ano="${article.ano}">삭제</a>
														</div>
													</article>`;
												
							commentList.insertAdjacentHTML('beforeend',commentArticle);
							commentForm.comment.value="";
							commentForm.comment.focus();
						}else{
							alert('등록에 실패했습니다. 관리자에게 문의하세요.')
						}
					})
					.catch(err=>{
						console.log(err);
					});
				
				
			}// 댓글 등록 끝
			
			
		}// onload end
	</script>
</head>
<body>
	<div id="container">
		<%@ include file="./_header.jsp"%>
		<main>
			<section class="view">
				<h3>글보기</h3>
				<table>
					<tr>
						<td colspan="3"><input type="text" name="title" value="${article.title}"
							readonly /></td>
					</tr>
					<tr>
						<td colspan="3" id="articleInfo">${article.writerNick}　  　${article.rdate}
						<span>조회수 ${article.hit} 　 댓글 ${article.comment}</span></td>
					</tr>
					<c:if test="${article.file>0}">
						<tr>
							<td style="width:50px" rowspan="${article.file+1}">첨부파일</td>
							<c:forEach var="file" items="${article.files}">
									<tr>
										<td style="border-bottom:none"><a href="/jboard/article/fileDownload.do?fno=${file.fno}">${file.oName}</a></td>
										<td style="border-bottom:none"><span style="color: grey;">${file.download}회 다운로드</span></td>
									</tr>
								</c:forEach>
					</c:if>
					</tr>
					<tr>
						<td colspan="3" class="content"><textarea name="content" readonly>${article.content}</textarea>
						</td>
					</tr>
				</table>
				<div>
					<c:if test="${sessUser.uid==article.writer}">
						<a href="/jboard/article/list.do" class="btnDelete">삭제</a>
						<a href="/jboard/article/list.do" class="btnModify">수정</a>
					</c:if>
					<a href="/jboard/article/list.do?pg=${currentPage}" class="btnList">목록</a>
				</div>

				<!-- 댓글리스트 -->
				<section class="commentList">
					<h3>댓글목록</h3>
					<c:forEach var="comment" items="${comments}">
						<article class="comment">
							<span> <span style="font-weight: bolder">${comment.nick}</span>
								<span> | ${comment.rdate}</span>
							</span>
							<textarea name="comment" readonly>${comment.content}</textarea>

							<c:if test="${sessUser.uid eq comment.writer}">
								<div>
									<a href="#" class="commentCancel" data-cno="${comment.cno}" data-ano="${article.ano}">취소</a>
									<a href="#" class="commentModify" data-cno="${comment.cno}" data-ano="${article.ano}">수정</a>
									<a href="#" class="commentRemove" data-cno="${comment.cno}" data-ano="${article.ano}">삭제</a>
								</div>
							</c:if>
						</article>
					</c:forEach>
					<c:if test="${empty comments}">
						<p class="empty">등록된 댓글이 없습니다.</p>
					</c:if>
				</section>

				<!-- 댓글입력폼 -->
				<section class="commentForm">
					<h3>댓글쓰기</h3>
					<form name="commentForm">
						<input type="hidden" name="ano" value="${article.ano}" />
						<input type="hidden" name="writer" value="${sessUser.uid}" />
						<textarea name="comment"></textarea>
						<div>
							<a href="#" class="btnCancel">취소</a>
							<input type="submit" class="btnWrite" value="작성완료" />
						</div>
					</form>
				</section>

			</section>
		</main>
		<%@ include file="./_footer.jsp"%>
	</div>
</body>
</html>