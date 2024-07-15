# 날짜 : 2024/07/15
# 이름 : 김주경
# 내용 : 데이터 모델링 실습

#실습 6-2. 아래와 같이 데이터를 입력하시오

insert into `customer` values ('C101','김유신','010-1234-1001','경남 김해시','2023-01-01');
insert into `customer` values ('C102','김춘추','010-1234-1002','경남 경주시','2023-01-02');
insert into `customer` values ('C103','장보고','010-1234-1003','전남 완도군','2023-01-03');
insert into `customer` values ('C104','강감찬','010-1234-1004','서울시 관악구','2023-01-04');
insert into `customer` values ('C105','이순신','010-1234-1005','부산시 금정구','2023-01-05');

insert into `product` values(1,'새우깡',5000,1500,'농심');
insert into `product` values(2,'초코파이',2500,2500,'오리온');
insert into `product` values(3,'포카칩',3600,1700,'오리온');
insert into `product` values(4,'양파링',1250,1800,'농심');
insert into `product` (`prodNo`,`prodName`,`stock`,`company`)values(5,'죠리퐁',2200,'크라운');

insert into `Order` (`orderId`,`orderProduct`,`orderCount`,`orderDate`) values ('C102',3,2,'2023-01-01 13:15:10');
insert into `Order` (`orderId`,`orderProduct`,`orderCount`,`orderDate`) values ('C101',4,1,'2023-01-01 13:15:12');
insert into `Order` (`orderId`,`orderProduct`,`orderCount`,`orderDate`) values ('C102',1,1,'2023-01-01 13:15:14');
insert into `Order` (`orderId`,`orderProduct`,`orderCount`,`orderDate`) values ('C103',6,5,'2023-01-01 13:15:16');
insert into `Order` (`orderId`,`orderProduct`,`orderCount`,`orderDate`) values ('C105',2,1,'2023-01-01 13:15:18');

# 실습 6-3. 다음 데이터를 조회하시오.
# > 모든 주문의 주문번호, 주문한 고객명, 주문한 상품명, 주문수량, 주문일을 조회하시오.
select
	`orderNo`,
    `name`,
    `prodName`,
    `orderCount`,
    `orderDate`
from `Order` a 
join `customer` b on a.orderId=b.custId
join `product` c on a.orderproduct=c.prodNo;

# > 김유신이 주문한 상품의 주문번호, 상품번호, 강품명, 가격, 주문수량, 주문일을 조회하시오.
select
	`orderNo`,
    `prodNo`,
    `prodName`,
    `price`,
    `orderCount`,
    `orderDate`
from `Order` a 
join `customer` b on a.orderId=b.custId
join `product` c on a.orderproduct=c.prodNo
where `name` = '김유신';

# > 주문한 상품의 총 주문 금액을 조회하시오.
select
	sum(orderCount*price)
from `Order` a 
join `product` b on a.orderproduct=b.prodNo;

# 실습 6-5. 아래와 같이 데이터를 입력하시오.
insert into `bank_customer` values ('730423-1000001','김유신',1,'010-1234-1001','경남 김해시');
insert into `bank_customer` values ('730423-1000002','김춘추',1,'010-1234-1002','경남 경주시');
insert into `bank_customer` values ('750423-1000003','장보고',1,'010-1234-1003','전남 완도군');
insert into `bank_customer` values ('102-12-51094','(주)정보산업',2,'051-500-1004','부산시 부산진구');
insert into `bank_customer` values ('930423-1000005','이순신',1,'010-1234-1005','서울 종로구');

insert into `bank_account` values ('101-11-1001','S1','자유저축예금','730423-1000001',1550000,'2011-04-11');
insert into `bank_account` values ('101-11-1002','S1','자유저축예금','930423-1000005', 260000,'2011-05-12');
insert into `bank_account` values ('101-11-1003','S1','자유저축예금','750423-1000003',   75000,'2011-06-13');
insert into `bank_account` values ('101-12-1001','S2','기업전용예금','102-12-51094',15000000,'2011-07-14');
insert into `bank_account` values ('101-13-1001','S3','정기저축예금','730423-1000002', 120000,'2011-08-15');

insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-11-1001',1,   50000,'2023-01-01 13:15:10');
insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-12-1001',2,1000000,'2023-01-01 13:15:12');
insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-11-1002',3, 260000,'2023-01-01 13:15:14');
insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-11-1002',2, 100000,'2023-01-01 13:15:16');
insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-11-1003',3,  75000,'2023-01-01 13:15:18');
insert into `bank_transaction` (`t_a_no`,`t_dist`,`t_amount`,`t_datetime`) values ('101-11-1001',1, 150000,'2023-01-01 13:15:20');

# 실습 6-6. 다음 데이터를 조회하시오.
# >  모든 고객의 고객번호, 이름, 연락처, 계좌번호, 계좌상품명, 현재잔액을 조회하시오.
select `c_no`, `c_name`,`c_phone`,`a_no`,`a_item_name`,`a_balance`
from `bank_customer` a
join `bank_account` b on a.c_no=b.a_c_no;
# > 이순신 고객명으로 모든 거래내역 중 거래구분, 거래금액, 거래날짜를 조회하시오.
select `t_dist`,`t_amount`,`t_datetime` from `bank_transaction`
where `t_a_no` in (
	select
		`a_no`
	from `bank_customer` a
	join `bank_account` b
	on a.c_no=b.a_c_no
    where `c_name` = '이순신');
# > 개인고객 중 현재 잔액이 가장 큰 고객의 주민번호, 고객명, 계좌번호, 현재잔액, 계좌개설일을 조회하시오.
select `c_no`,`c_name`,`a_no`,`a_balance`,`a_open_date`
from`bank_customer` a
join `bank_account` b
on a.c_no=b.a_c_no
where `c_dist` = 1
order by `a_balance` desc limit 1;

# 실습 6-8. 아래와 같이 데이터를 입력하시오.
insert into `student` values ('20201011','김유신','010-1234-1001',3,'경남 김해시');
insert into `student` values ('20201122','김춘추','010-1234-1002',3,'경남 경주시');
insert into `student` values ('20210213','장보고','010-1234-1003',2,'전남 완도군');
insert into `student` values ('20210324','강감찬','010-1234-1004',2,'서울 관악구');
insert into `student` values ('20220415','이순신','010-1234-1005',1,'서울 종로구');

insert into `lecture` values(101,'컴퓨터과학 개론',2,40,'본301');
insert into `lecture` values(102,'프로그래밍 언어',3,52,'본302');
insert into `lecture` values(103,'데이터베이스',3,56,'본303');
insert into `lecture` values(104,'자료구조',3,60,'본304');
insert into `lecture` values(105,'운영체제',3,52,'본305');

insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20220415',101,60,30);
insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20210324',103,54,36);
insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20201011',105,52,28);
insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20220415',102,38,40);
insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20210324',104,56,32);
insert into `register` (`regStdNo`,`regLecNo`,`regMidScore`,`regFinalScore`) values('20210213',103,48,40);

# 실습 6-9. 다음 데이터를 조회하시오.
# > 이번 학기에 수강신청 하지 않은 학생의 학번, 이름, 연락처, 학년을 조회하시오.
select `stdNo`,`stdName`,`stdHp`,`stdYear`
from `student` a left join `register` b
on a.stdNo = b.regStdNo
where `regStdNo` is null; 
# > 중간고사 점수와 기말고사 점수의 총합을 구하고 등급을 구하시오
select 
	`regStdNo`, 
    `regLecNo`, 
    `regMidScore`,
    `regFinalScore`,
    `regMidScore` + `regFinalScore` as `합`,
    case
		when (`regMidScore` + `regFinalScore` >= 90) then 'A'
		when (`regMidScore` + `regFinalScore` >= 80) then 'B'
		when (`regMidScore` + `regFinalScore` >= 70) then 'C'
		when (`regMidScore` + `regFinalScore` >= 60) then 'D'
	else 'F'
    end as `등급`
from `Register`;
# > 2학년 학생의 학번, 이름, 학년, 수강강좌명, 중간점수, 기말점수, 총합, 등급을 조회하시오
select `stdNo`,`stdName`,`stdYear`,`lecName`,`regMidScore`,`regFinalScore`,
    `regMidScore` + `regFinalScore` as `합`,
    case
		when (`regMidScore` + `regFinalScore` >= 90) then 'A'
		when (`regMidScore` + `regFinalScore` >= 80) then 'B'
		when (`regMidScore` + `regFinalScore` >= 70) then 'C'
		when (`regMidScore` + `regFinalScore` >= 60) then 'D'
	else 'F'
    end as `등급`
from `student` a
left join `register` b on a.stdNo = b.regStdNo
join `lecture` c on b.regLecNo = c.lecNo
where `stdYear` = 2;