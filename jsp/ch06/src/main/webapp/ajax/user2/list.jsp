<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax :: user2</title>
	<script>
	
		window.onload = function(){
			
			const table = document.getElementsByTagName('table')[0];
			
			// 사용자 데이터 요청
			fetch('./proc/getUsers.jsp')
				.then(response=>response.json())
				.then(data => {
					console.log(data);
					
					for(const user of data){
						
						console.log(user.uid);
						
						const row = `<tr>
										<td>\${user.uid}</td>
										<td>\${user.name}</td>
										<td>\${user.birth}</td>
										<td>\${user.addr}</td>
										<td>
										<a href='#' class='modify'>수정</a>
										<a href='#' class='delete'>삭제</a>
										</td>
									</tr>`;							
					
				table.insertAdjacentHTML('beforeend', row);
				}
			})
			.catch(err=>{
				console.log(err)
			});
			
			document.body.addEventListener('click', function(e){
				
				// 삭제 클릭 이벤트 (동적 이벤트 연결)
				if(e.target.classList.contains('delete')){
					e.preventDefault();
					const tr = e.target.closest('tr');
					const uid = tr.children[0].innerText;
					
					// 삭제 요청
					fetch('./proc/deleteProc.jsp?uid='+uid)
						.then(response => response.json())
						.then(data => {
							console.log(data);

							if(data.result>0){
								alert('삭제 성공');
								tr.remove();
							}else{
								alert('삭제 실패');
							}
						})
						.catch(err => {
							console.log(err);
						});
				}// 삭제 이벤트 끝
				
				// 수정 이벤트
				if(e.target.classList.contains('modify')){

					e.preventDefault();
					const tr = e.target.closest('tr');
					const uid = tr.children[0].innerText;
					location.href='./modify.jsp?uid='+uid;
				}
				
			}); // 클릭 이벤트 끝
			
			
		}// onload 끝
	</script>
</head>
<body>
	<h3> user2</h3>
	<a href="./register.jsp">등록하기</a>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>주소</th>
			<th>관리</th>
		</tr>
	</table>
</body>
</html>