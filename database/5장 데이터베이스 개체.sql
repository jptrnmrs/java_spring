# 날짜 : 2024/07/05
# 이름 : 김주경
# 내용 : 5장 데이터베이스 개체

#실습 5-1. 인덱스 조회
show index from `user1`;
show index from `user2`;
show index from `user3`;

#실습 5-2. 인덱스 생성 및 적용
CREATE INDEX `idx_user1_uid` ON `user1`(`uid`);
analyze TABLE `User1`;

select * from `user5`;
insert into `user5` (`name`,`gender`,`age`,`addr`) select `name`,`gender`,`age`,`addr` from `user5`;

update `user5` set `name` = '홍길동' where `seq` = 3;
update `user5` set `name` = '정약용' where `seq` = 4148570;
select count(*) from `user5`;
select * from `user5` where `name` = '홍길동';
select * from `user5` where `name` = '정약용';
select * from `user5` where `seq` = 4148570; #pk엔 기본적으로 인덱스가 있기 때문에 검색 속도가 상당히 빠름

create index `idx_user5_name` on `user5` (`name`); #인덱스 생성 이후 검색 속도 향상
analyze table `user5`;

drop table `user5`;
delete from `user5` where `seq`>5;

#실습 5-3. 인덱스 삭제
DROP INDEX idx_user1_uid ON `user1`;

#실습 5-4. 뷰 생성
create view `vw_user1` AS (select `name`, `hp`, `age` from `user1`);
create view `vw_user4_age_under30` AS (select * from `user4` where `age` <30);
create view `vw_member_with_sales` AS(
	select
		a.uid 	AS `직원아이디`,
        b.name 	AS `직원이름`,
        b.pos 	AS `직급`,
        c.name 	AS `부서명`,
        a.year 	AS `매출년도`,
        a.month AS `월`,
        a.sale	AS `매출액`
	FROM `sales`	  AS a
    JOIN `member` 	  AS b using(uid)
    JOIN `department` AS c ON b.dep = c.depNo);
    
    
    
#실습 5-5. 뷰 조회
select * from `vw_user1`;
select * from `vw_user4_age_under30`;
select * from `vw_member_with_sales`;

#실습 5-6. 뷰 삭제
drop view `vw_user1`;
drop view `vw_user4_age_under30`;
drop view `vw_member_with_sales`;

#실습 5-7. 프로시저 생성 및 실행 기본
DELIMITER $$
	CREATE PROCEDURE proc_test1()
    BEGIN
		SELECT * FROM `Member`;
        SELECT * FROM `Department`;
	END $$
    DELIMITER ;

CALL proc_test1();

#실습 5-8. 매개변수를 갖는 프로시저 생성 및 실행
DELIMITER $$
	CREATE PROCEDURE proc_test2(IN _userName VARCHAR(10))
    BEGIN
		SELECT * FROM `Member` WHERE `name` = _userName;
	END $$
    DELIMITER ;

CALL proc_test2('김유신');

DELIMITER $$
	CREATE PROCEDURE proc_test3(IN _pos VARCHAR(10), IN _dep TINYINT)
    BEGIN
		SELECT * FROM `Member` WHERE `pos` = _pos AND `dep`= _dep;
	END $$
    DELIMITER ;

CALL proc_test3('차장',101);


DELIMITER $$
	CREATE PROCEDURE proc_test4(IN _pos VARCHAR(10), OUT _count INT)
    BEGIN
		SELECT COUNT(*) FROM `Member` WHERE `pos` = _pos;
	END $$
    DELIMITER ;

CALL proc_test4('대리',@_count);
select concat('_count : ', @count)

#실습 5-9.  프로시저 프로그래밍


DELIMITER $$
	CREATE PROCEDURE proc_test5(IN _name VARCHAR(10))
    BEGIN
		DECLARE userId VARCHAR(10);
        SELECT `uid` INTO userId FROM `Member` WHERE `name` = _name;
		SELECT * FROM `Sales` WHERE `uid` = userId;
	END $$
    DELIMITER ;

CALL proc_test5('김유신');


DELIMITER $$
	CREATE PROCEDURE proc_test6()
    BEGIN
		DECLARE num1 INT;
        DECLARE num2 INT;
        
        SET num1 = 1;
        SET num2 = 2;
        
        IF(Num1 > num2) THEN
			SELECT 'NUM1이 NUM2보다 크다.' AS '결과2';
		ELSE
			SELECT 'NUM1이 NUM2보다 작다.' AS '결과2';
		END IF;
	END $$
    DELIMITER ;

CALL proc_test6();


DELIMITER $$
	CREATE PROCEDURE proc_test7()
    BEGIN
		DECLARE sum INT;
        DECLARE num INT;
        
        SET sum = 0;
        SET num = 1;
        
        WHILE (num<=10) DO
			SET sum = sum + num;
            SET num = num + 1;
		END WHILE;
        
        SELECT sum AS '1부터 10까지 합계';
	END $$
    DELIMITER ;

CALL proc_test7();

#실습 5-10. 커서를 활용하는 프로시저

DELIMITER $$
	CREATE PROCEDURE proc_test8()
    BEGIN
		# 변수 선언
		DECLARE total INT default 0;
        DECLARE price INT;
        declare endOfRow boolean default false;
        
        # 커서 선언
		declare salesCursor CURSOR FOR
			SELECT `sale` FROM `sales`;
		# 반복 조건
		DECLARE CONTINUE HANDLER
            FOR NOT FOUND SET endOfRow = TRUE;
		# 커서 열기
		OPEN salesCursor;
        
        cursor_loop : LOOP
			FETCH salesCursor INTO Price;
            
            IF endOfRow THEN
				LEAVE cursor_loop;
			END IF;
            
            SET total = total + price;
		END LOOP;
        
        select total as `전체 합계`;
        CLOSE salesCursor;
	END $$
    DELIMITER ;

CALL proc_test8();

#실습 5-11. 저장 함수 생성 및 호출


DELIMITER $$
	CREATE FUNCTION func_test1(_userid VARCHAR(10)) RETURNS INT
    BEGIN
		DECLARE total INT;
        
		SELECT SUM(`sale`) INTO total FROM `sales` WHERE `uid`=_userid;
        
		RETURN total;
	END $$
    DELIMITER ;

select func_test1('a101');


DELIMITER $$
	CREATE FUNCTION func_test2(_sale INT) RETURNS DOUBLE
    BEGIN
		DECLARE bonus DOUBLE;
        
        IF (_sale >= 100000) THEN
			SET bonus = _sale * 0.1;
		ELSE
			SET bonus = _sale * 0.05;
		END IF;
		
	RETURN bonus;
	END $$
    DELIMITER ;
    
select
	`uid`,
    `year`,
    `month`,
    `sale`,
    func_test2(`sale`) as `bonus`
FROM `sales`;