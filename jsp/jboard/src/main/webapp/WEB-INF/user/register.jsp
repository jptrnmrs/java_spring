<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/jboard/js/validation.js"></script>
<script>
	
	function postcode() {
		new daum.Postcode({
			oncomplete: function(data) {
				// 팝업을 통한 검색 결과 항목 클릭 시 실행
				var addr = ''; // 주소_결과값이 없을 경우 공백 
				var extraAddr = ''; // 참고항목
	
				//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				if (data.userSelectedType === 'R') { // 도로명 주소를 선택
					addr = data.roadAddress;
				} else { // 지번 주소를 선택
					addr = data.jibunAddress;
				}
	
				if (data.userSelectedType === 'R') {
					if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
						extraAddr += data.bname;
					}
					if (data.buildingName !== '' && data.apartment === 'Y') {
						extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
					}
					if (extraAddr !== '') {
						extraAddr = '(' + extraAddr + ')';
					}
				} else {
					registerForm.addr1.value = '';
				}
	
				// 선택된 우편번호와 주소 정보를 input 박스에 넣는다.
				document.getElementById('zip').value = data.zonecode;
				document.getElementById('addr1').value = addr;
				document.getElementById('addr2').value += extraAddr;
				document.getElementById('addr2').focus(); // 우편번호 + 주소 입력이 완료되었음으로 상세주소로 포커스 이동
			}
		}).open();
	}
</script>
<main>
	<section class="register">
		<form action="/jboard/user/register.do" method="post">
			<table border="1">
				<caption>사이트 이용정보 입력</caption>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" placeholder="아이디 입력" required/>
						<button type="button" id="btnCheckUid">
							<img src="../images/chk_id.gif" alt="">
						</button> <span class="resultId"></span></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pass1" placeholder="비밀번호 입력" required/>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pass2" placeholder="비밀번호 확인 입력" required/>
					<span class="resultPass"></span></td>
				</tr>
			</table>
			<table border="1">
				<caption>개인정보 입력</caption>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" placeholder="이름 입력" required/> <span
						class="resultName"></span></td>
				</tr>
				<tr>
					<td>별명</td>
					<td>
						<p>공백없이 한글, 영문, 숫자만 입력가능</p> <input type="text" name="nick"
						placeholder="별명 입력" required/> <span class="resultNick"></span>
					</td>
				</tr>
				<tr>
					<td>E-Mail</td>
					<td>
						<input type="email" name="email" placeholder="이메일 입력"/>
						<button type="button" id="btnSendEmail">
							<img src="../images/chk_auth.gif" alt="인증번호 받기" />
						</button>
						<span class="resultEmail"></span>
						<div class="auth">
							<input type="text" name="auth" placeholder="인증번호 입력"/>
							<button type="button" id="btnAuthEmail">
								<img src="../images/chk_confirm.gif" alt="확인" />
							</button>
						</div></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" placeholder="- 포함 13자리 입력"
						minlength="13" maxlength="13" required/> <span class="resultHp"></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<div>
							<input type="text" name="zip" id="zip" placeholder="우편번호" readonly/>
							<button type="button" class="btnZip" onclick="postcode()">
								<img src="/jboard/images/chk_post.gif" alt="">
							</button>
						</div>
						<div>
							<input type="text" name="addr1" id="addr1" placeholder="주소를 검색하세요." readonly />
						</div>
						<div>
							<input type="text" name="addr2" id="addr2" placeholder="상세주소를 입력하세요." />
						</div>
					</td>
				</tr>
			</table>

			<div>
				<a href="/jboard/user/login.do" class="btnCancel">취소</a> <input
					type="submit" class="btnSubmit" value="회원가입" />
			</div>
		</form>
	</section>
</main>
<%@ include file="./_footer.jsp"%>