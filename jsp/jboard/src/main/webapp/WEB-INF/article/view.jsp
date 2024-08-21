<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글보기</title>
    <link rel="stylesheet" href="/jboard/css/style.css">    
</head>
<body>
    <div id="container">
        <%@ include file="./_header.jsp" %>
        <main>
            <section class="view">
                <h3>글보기</h3>
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" name="title" value="${article.title}" readonly/></td>
                    </tr>
                    <tr>
                        <td>첨부파일</td>
                        <td>
                            <a href="#">${file1.oName}</a>
                            <span>${file1.download}회 다운로드</span>
                        </td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td>
                            <textarea name="content" readonly>${article.content}</textarea>
                        </td>
                    </tr>
                </table>
                <div>
                    <a href="/jboard/article/list.do" class="btnDelete">삭제</a>
                    <a href="/jboard/article/list.do" class="btnModify">수정</a>
                    <a href="/jboard/article/list.do" class="btnList">목록</a>
                </div>  
                
                <!-- 댓글리스트 -->
                <section class="commentList">
                    <h3>댓글목록</h3>
                    <c:forEach var="comment" items="${comments}">
	                    <article class="comment">
	                        <span>
	                            <span>${comment.writer}</span>
	                            <span>${fn:substring(comment.rdate,2,10)}</span>
	                        </span>
	                        <textarea name="comment" readonly>${comment.content}</textarea>
	                        <div>
	                            <a href="#">삭제</a>
	                            <a href="#">수정</a>
	                        </div>
	                    </article>
                    </c:forEach>
                    <p class="empty">
                        등록된 댓글이 없습니다.
                    </p>
                </section>
    
                <!-- 댓글입력폼 -->
                <section class="commentForm">
                    <h3>댓글쓰기</h3>
                    <form action="#">
                        <textarea name="comment"></textarea>
                        <div>
                            <a href="#" class="btnCancel">취소</a>
                            <input type="submit" class="btnWrite" value="작성완료"/>
                        </div>
                    </form>
                </section>
    
            </section>
        </main>
        <%@ include file="./_footer.jsp" %>
    </div>
</body>
</html>