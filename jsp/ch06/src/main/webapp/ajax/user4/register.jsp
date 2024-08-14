<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ajax::user4</title>
	<script>
		window.onload = function(){
			const btnSubmit = document.getElementsByName('submit')[0];
			const formUser = document.getElementsByTagName('form')[0];
			
			btnSubmit.onclick = (e) => {
				
				e.preventDefault();
				
				const uid = formUser.uid.value;
				const name = formUser.name.value;
				const gender = formUser.gender.value;
				const age = formUser.age.value;
				const hp = formUser.hp.value;
				const addr = formUser.addr.value;
				
				// json 생성
				const jsonData = {
						"uid" : uid,
						"name" : name,
						"gender" : gender,
						"age" : age,
						"hp" : hp,
						"addr" : addr
				};
				
				console.log(jsonData);
				
				fetch('./registerProc.jsp',{
						method: 'POST',
						header: {'Content-Type':'application/json'},
						body: JSON.stringify(jsonData)
					})
					.then(response => response.json())
					.then(data => {
						console.log(data)
						//서버에서 결과 데이터 수신
						if(data.result>0){
							alert('등록 성공');
							location.href = './list.jsp';
						}else{
							alert('등록 실패');
						}
					})
					.catch(err=>{
						console.log(err)
					});
					
			}
		}
	
	</script>
</head>
<body>
	<h3>user4등록</h3>
	<a href="./list.jsp">목록으로</a>
	<form action="#" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<label><input type="radio" name="gender" value="F"> 여자 </label>
					<label><input type="radio" name="gender" value="M"> 남자 </label>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" name="age"/></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="hp"/></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr"/></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" name="submit" value="등록하기"/>
				</td>
			</tr>		
		</table>
	
	</form>
</body>
</html>