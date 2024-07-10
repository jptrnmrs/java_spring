# 날짜 : 2024/07/03
# 이름 : 김주경
# 내용 : 4장 SQL 고급

#실습 4-1. 아래 표를 참고하여 테이블을 생성하시오
CREATE TABLE `Member` (
	`uid`	VARCHAR(10) PRIMARY KEY,
	`name`	VARCHAR(10) NOT NULL,
	`hp`	CHAR(13) UNIQUE NOT NULL,
	`pos`	VARCHAR(10) default '사원',
	`dep`	TINYINT,
	`rdate`	DATETIME  NOT NULL
);

CREATE TABLE `Department` (
	`depNo`	TINYINT PRIMARY KEY,
	`name`	VARCHAR(10) NOT NULL,
	`tel`	CHAR(12) NOT NULL
);

CREATE TABLE `Sales` (
	`no`	INT AUTO_INCREMENT PRIMARY KEY,
	`uid`	VARCHAR(10) NOT NULL,
	`year`	YEAR NOT NULL,
	`month`	TINYINT NOT NULL,
	`sale`	INT
);

#실습 4-2. 테이블에 아래 그림과 같이 데이터를 입력하시오.

INSERT INTO `Member` VALUES ('a101', '박혁거세', '010-1234-1001', '부장', 101, '2024-07-03 14:33:21');
INSERT INTO `Member` VALUES ('a102', '김유신',   '010-1234-1002', '차장', 101, NOW());
INSERT INTO `Member` VALUES ('a103', '김춘추',   '010-1234-1003', '사원', 101, NOW());
INSERT INTO `Member` VALUES ('a104', '장보고',   '010-1234-1004', '대리', 102, NOW());
INSERT INTO `Member` VALUES ('a105', '강감찬',   '010-1234-1005', '과장', 102, NOW());
INSERT INTO `Member` VALUES ('a106', '이성계',   '010-1234-1006', '차장', 103, NOW());
INSERT INTO `Member` VALUES ('a107', '정철',     '010-1234-1007', '차장', 103, NOW());
INSERT INTO `Member` VALUES ('a108', '이순신',   '010-1234-1008', '부장', 104, NOW());
INSERT INTO `Member` VALUES ('a109', '허균',     '010-1234-1009', '부장', 104, NOW());
INSERT INTO `Member` VALUES ('a110', '정약용',   '010-1234-1010', '사원', 105, NOW());
INSERT INTO `Member` VALUES ('a111', '박지원',   '010-1234-1011', '사원', 105, NOW());

INSERT INTO `Department` VALUES (101, '영업1부', '051-512-1001');
INSERT INTO `Department` VALUES (102, '영업2부', '051-512-1002');
INSERT INTO `Department` VALUES (103, '영업3부', '051-512-1003');
INSERT INTO `Department` VALUES (104, '영업4부', '051-512-1004');
INSERT INTO `Department` VALUES (105, '영업5부', '051-512-1005');
INSERT INTO `Department` VALUES (106, '영업지원부', '051-512-1006');
INSERT INTO `Department` VALUES (107, '인사부', '051-512-1007');

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a101', 2018, 1,  98100);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2018, 1, 136000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a103', 2018, 1,  80100);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a104', 2018, 1,  78000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a105', 2018, 1,  93000);

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a101', 2018, 2,  23500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2018, 2, 126000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a103', 2018, 2,  18500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a105', 2018, 2,  19000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a106', 2018, 2,  53000);

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a101', 2019, 1,  24000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2019, 1, 109000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a103', 2019, 1, 101000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a104', 2019, 1,  53500);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a107', 2019, 1,  24000);

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2019, 2, 160000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a103', 2019, 2, 101000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a104', 2019, 2,  43000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a105', 2019, 2,  24000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a106', 2019, 2, 109000);

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2020, 1, 201000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a104', 2020, 1,  63000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a105', 2020, 1,  74000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a106', 2020, 1, 122000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a107', 2020, 1, 111000);

INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a102', 2020, 2, 120000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a103', 2020, 2,  93000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a104', 2020, 2,  84000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a105', 2020, 2, 180000);
INSERT INTO `Sales` (`uid`, `year`, `month`, `sale`) VALUES ('a108', 2020, 2,  76000);



#실습 4-3. 조건에 일치하는 투플 조회
#	SELECT 칼럼명1, 칼럼명2 ... FROM 테이블명 WHERE 조건식;

SELECT * FROM `member`WHERE `name` = '김유신';
SELECT * FROM `member`WHERE `pos`  = '차장' AND dep=101;
SELECT * FROM `member`WHERE `pos`  = '차장' OR dep=101;
SELECT * FROM `member`WHERE `name` != '김춘추';
SELECT * FROM `member`WHERE `name` <> '김춘추';
SELECT * FROM `member`WHERE `pos`  = '사원'OR `pos`='대리';
SELECT * FROM `member`WHERE `pos`  IN ('사원','대리');
SELECT * FROM `member`WHERE `dep`  IN (101,102,103);
SELECT * FROM `member`WHERE `name` LIKE '%신';
SELECT * FROM `member`WHERE `name` LIKE '김%';
SELECT * FROM `member`WHERE `name` LIKE '김__';
SELECT * FROM `member`WHERE `name` LIKE '_성_';
SELECT * FROM `member`WHERE `name` LIKE '정_';
SELECT * FROM `Sales` WHERE `sale` > 50000;
SELECT * FROM `Sales` WHERE `sale` >= 50000 AND `sale` < 100000 AND `month`=1;
SELECT * FROM `Sales` WHERE `sale` BETWEEN 50000 AND 100000;
SELECT * FROM `Sales` WHERE `sale` NOT BETWEEN 50000 AND 100000;
SELECT * FROM `Sales` WHERE `year` IN(2020);
SELECT * FROM `Sales` WHERE `month`IN(1, 2);

#실습 4-4. 오름/내림차순으로 정렬
#	SELECT 칼럼명1, 칼럼명2 ... FROM 테이블명 ORDER BY 기준_칼럼명 (ASC/DESC)오름/내림차순

SELECT * FROM `Sales` ORDER BY `sale`;
SELECT * FROM `Sales` ORDER BY `sale`  ASC;
SELECT * FROM `Sales` ORDER BY `sale` DESC;
SELECT * FROM `Member`ORDER BY `name`;
SELECT * FROM `Member`ORDER BY `name` DESC;
SELECT * FROM `Member`ORDER BY `rdate` ASC;
SELECT * FROM `Sales` WHERE `sale`>50000 ORDER BY `sale` DESC;
SELECT * FROM `Sales` WHERE `sale`>50000 ORDER BY `year`,`month`,`sale` DESC;

#실습 4-5 투플 개수를 제한
#	SELECT 칼럼명1, 칼럼명2 ... FROM 테이블명 LIMIT 제한할_투플;

SELECT * FROM Sales LIMIT 3;
SELECT * FROM Sales LIMIT 0,3;
SELECT * FROM Sales LIMIT 1,2;
SELECT * FROM Sales LIMIT 5,3;
SELECT * FROM Sales ORDER BY `sale` DESC LIMIT 3,5;
SELECT * FROM Sales WHERE `sale` < 50000 ORDER BY `sale` DESC LIMIT 3;
SELECT * FROM Sales WHERE `sale` > 50000 ORDER BY `year` DESC, `month`,`sale` DESC LIMIT 5;

#실습 4-6. 칼럼명을 별칭으로 사용하기
#	SELECT 칼럼명 AS 별칭 FROM 테이블명;

SELECT SUM(sale) AS `합계`  FROM `Sales`;
SELECT AVG(sale) AS `평균`  FROM `Sales`;
SELECT MAX(sale) AS `최대값` FROM `Sales`;
SELECT MIN(sale) AS `최소값` FROM `Sales`;
SELECT CEILING(1.2);
SELECT CEILING(1.8);
SELECT FLOOR(1.2);
SELECT FLOOR(1.8);
SELECT ROUND(1.2);
SELECT ROUND(1.8);
SELECT RAND();
SELECT CEILING(RAND()*10);
SELECT COUNT(sale) AS `갯수` FROM `Sales`;
SELECT COUNT(*) AS `갯수` FROM `Sales`;

SELECT LEFT('HelloWorld',5);
SELECT RIGHT('HelloWorld',5);
SELECT SUBSTRING('HelloWorld',6,5);
SELECT CONCAT('Hello','World');
SELECT CONCAT(`uid`,`name`,`hp`) FROM `member` WHERE `uid`='a108';

SELECT CURDATE();
SELECT CURTIME();
SELECT NOW();
INSERT INTO `Member` VALUES('a112','유관순','010-1234-1012','대리',107,NOW());

#실습 4-7. 2018년 1월 매출의 총합을 구하시오.

SELECT SUM(`sale`) FROM `Sales` WHERE `year`=2018 AND `month`=1;

#실습 4-8. 2019년 2월에 5만원 이상 매출에 대한 총합과 평균을 구하시오.
SELECT SUM(`sale`) FROM `Sales` WHERE `year`=2019 AND `month`=2 AND `sale`>=50000;
SELECT AVG(`sale`) FROM `Sales` WHERE `year`=2019 AND `month`=2 AND `sale`>=50000;

#실습 4-9. 2020년 전체 매출 가운데 최저, 최고 매출을 구하시오.

SELECT MAX(`sale`), MIN(`sale`) FROM `Sales` WHERE `year`=2020;



				# 날짜 : 2024/07/04

SET SESSION sql_mode = 'STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

#실습 4-10. 그룹별로 조회
#	SELECT 칼럼명1, 칼럼명2 ... FROM 테이블명 GROUP BY 그룹화_칼럼명;

SELECT * FROM `Sales` GROUP BY `uid`;
SELECT * FROM `Sales` GROUP BY `year`;
SELECT * FROM `Sales` GROUP BY `uid`,`year`;
SELECT `uid`, COUNT(*)  AS `건수` FROM `Sales` GROUP BY `uid`;
SELECT `uid`, SUM(sale) AS `합계` FROM `Sales` GROUP BY `uid`;
SELECT `uid`, AVG(sale) AS `평균` FROM `Sales` GROUP BY `uid`;

SELECT	 `uid`, `year`, SUM(sale) AS `합계`
FROM	 `Sales`
GROUP BY `uid`, `year`;

SELECT	 `uid`, `year`, SUM(sale) AS `합계`
FROM	 `Sales`
GROUP BY `uid`, `year`
ORDER BY `year` ASC, `합계` DESC;

SELECT	 `uid`, `year`, SUM(sale) AS `합계`
FROM	 `Sales`
GROUP BY `uid`, `year`
ORDER BY `합계` DESC;

#실습 4-11. 그룹화에 검색조건 설정
#	SELECT 칼럼명1, 칼럼명2 ... FROM 테이블명 GROUP BY 그룹화_칼럼명 HAVING 조건;

SELECT	 `uid`, `year`, SUM(sale) AS `합계`
FROM	 `Sales`
GROUP BY `uid`
HAVING	 `합계` 	>= 200000;

SELECT	 `uid`, `year`, SUM(sale) AS `합계`
FROM	 `Sales`
WHERE	 `sale` >= 100000
GROUP BY `uid`, `year`
HAVING	 `합계` 	>= 200000
ORDER BY `합계` DESC;

#실습 4-12. 테이블 합치기
#	SELECT 칼럼명 FROM 테이블명1 UNION SELECT 칼럼명 FROM 테이블명2;
CREATE TABLE `Sales2` LIKE `Sales`;
INSERT INTO  `Sales2` SELECT * FROM `Sales`;
UPDATE `Sales2` SET `year` = `year` + 3;

SELECT * FROM `Sales`  UNION SELECT * FROM `Sales2`;
SELECT * FROM `Sales`  WHERE `sale` >= 100000
UNION
SELECT * FROM `Sales2` WHERE `sale` >= 100000;

SELECT `uid`, `year`, `sale` FROM Sales
UNION
SELECT `uid`, `year`, `sale` FROM Sales2;

SELECT `uid`, `year`, SUM(sale) AS `합계`
FROM `Sales`
GROUP BY `uid`, `year`
UNION
SELECT `uid`, `year`, sum(sale) AS `합계`
FROM `Sales2`
GROUP BY `uid`, `year`
ORDER BY `year` ASC, `합계` DESC;


#실습 4-13. 테이블 결합 (내부 조인)
#	SELECT 칼럼 FROM 테이블1 INNER JOIN 테이블2 ON 테이블1.칼럼=테이블2.칼럼;
SELECT * FROM `Sales` INNER JOIN `Member` ON `Sales`.uid = `Member`.uid;
SELECT * FROM `Member` INNER JOIN `department` ON `member`.dep = `department`.depNo;

SELECT * FROM `sales` AS a JOIN `member` AS d ON a.uid = b.uid;
select * from `member` AS a JOIN `department` AS b ON a.dep = b.depNo;

select * from `sales` as a, `member` as b where a.uid = b.uid;
select * from `member` AS a, `department` AS b where a.dep = b.depNo;

select a.`no`, a.`uid`, `sale`, `name`, `pos` from `sales` AS a
JOIN `member` AS b ON a.`uid` = b.`uid`;

select a.`no`, a.`uid`, `sale`, `name`, `pos` from `sales` AS a
JOIN `member` AS b USING(uid);

select a.`no`, a.`uid`, `sale`, `name`, `pos` from `sales` AS a
JOIN `member` AS b ON a.`uid` = b.`uid`
WHERE `sale` >= 100000;

select a.`no`, a.`uid`, `sale`, `name`, `pos`,SUM(`sale`) AS `합계` from `sales` AS a
JOIN `member` AS b ON a.`uid` = b.`uid`
group by a.`uid`, a.`year` having `합계` >= 100000
order by a.`year` ASC, `합계` DESC;

select * from `sales` AS a
Join `member` as b on a.`uid` = b.`uid`
join `department` as c on b.`dep` = c.`depNo`;

select a.`no`, a.`uid`, a.`sale`, b.`name`, b.`pos`, c.`name` from `sales` AS a
Join `member` as b on a.`uid` = b.`uid`
join `department` as c on b.`dep` = c.`depNo`;

select a.`no`, a.`uid`, a.`sale`, b.`name`, b.`pos`, c.`name` from `sales` AS a
Join `member` as b on a.`uid` = b.`uid`
join `department` as c on b.`dep` = c.`depNo`
WHere `sale` > 100000
order by `sale` DESC;


#실습 4-14. 테이블 결합 (외부 조인)
#	SELECT 칼럼 FROM 테이블1 (LEFT/RIGHT) JOIN 테이블2 ON 테이블1.칼럼=테이블2.칼럼;
SELECT * FROM `Sales` AS a
LEFT JOIN `Member`	  AS b
ON a.`uid` = b.`uid`;

SELECT * FROM `Sales` AS a
RIGHT JOIN `Member`	  AS b
ON a.`uid` = b.`uid`;

SELECT a.`no`, a.`uid`, `sale`, `name`, `pos`
FROM `Sales` 		  AS a
LEFT JOIN `Member`    AS b
USING(uid);


#실습 4-15. 모든 직원의 아이디, 이름, 직급, 부서명을 조회하시오.

SELECT
	m.`uid`  AS `아이디`,
    m.`name` AS `이름`,
    m.`pos`  AS `직급`,
    d.`name` AS `부서명`
FROM `Member`     AS m
JOIN `department` AS d
ON m.`dep` = d.`depNo`;

#실습 4-16. '김유신' 직원의 2019년 매출의 합을 조회하시오.

SELECT
	m.`name`  AS `이름`,
    s.`year`  AS `년도`,
    SUM(sale) AS `매출 합`
FROM `Member` AS m
JOIN `Sales`  AS s USING(uid)
WHERE m.`name` = '김유신' AND s.`year` = 2019;

#실습 4-17. 2019년 50,000이상 매출에 대해 직원별 매출의 합이 100,000원 이상인
#		   직원 이름, 부서명, 직급, 년도, 매출 합을 조회하시오. 단, 매출 합이 큰 순서부터 정렬

SELECT 
	m.`name`	AS `이름`,
	d.`name`	AS `부서명`,
	`pos`		AS `직급`,
	`year`		AS `년도`,
	SUM(`sale`) AS `매출 합` 
FROM `Sales`		AS s
JOIN `Member` 		AS m USING(`uid`)
JOIN `department` 	AS d ON d.`depNo` = m.`dep`
WHERE `year` = 2019 AND `sale` >= 50000
GROUP BY s.`uid`
HAVING `매출 합` >= 100000
ORDER BY `매출 합` DESC
LIMIT 2;