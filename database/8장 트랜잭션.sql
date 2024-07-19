# 날짜 : 2024/07/19
# 이름 : 김주경
# 내용 : 8장 트랜잭션

#실습 8-1
-- set

update `bank_account` set `a_balance`=100000 where `a_no`='101-11-1001';

start transaction;	-- 트랜잭션 시작

select * from `bank_account`;
update `bank_account` set `bank_account` = `a_balance` - 10000
									where `a_no` = '101-11-1001';

update `bank_account` set `a_balance` = `bank_account` + 10000
									where `a_no` = '101-11-1212';
commit; 	-- 작업 확정 (트랜잭션 종료)

select * from `bank_account`;


#실습 8-2

update `bank_account` set `a_balance`=100000 where `a_no`='101-11-1001';

start transaction;	-- 트랜잭션 시작

select * from `bank_account`;
update `bank_account` set `bank_account` = `a_balance` - 10000
									where `a_no` = '101-11-1001';

update `bank_account` set `a_balance` = `bank_account` + 10000
									where `a_no` = '101-11-1212';
rollback; 	-- 작업 확정 (트랜잭션 종료)

select * from `bank_account`;