# 날짜 : 2024/07/01
# 이름 : 김주경
# 내용 : 1장 데이터베이스 개요와 MySQL 설치

#실습 1-1. MySQL 접속, 데이터베이스 생성 및 삭제
create database `StudyDB`;
show databases;

drop database `StudyDB`;

#실습 1-2. 일반 관리자 생성 및 권한 부여
CREATE USER 'under'@'%' identified by '1234';
GRANT ALL privileges on studydb.* TO 'under'@'%';
flush privileges;

#실습 1-3. 사용자 비밀번호 수정 및 삭제

alter user 'under'@'%' identified by 'abc1234';
drop user 'under'@'%';
flush privileges;