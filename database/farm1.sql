-- 테이블 순서는 관계를 고려하여 한 번에 실행해도 에러가 발생하지 않게 정렬되었습니다.
-- Article Table Create SQL
-- 테이블 생성 SQL - Article


CREATE TABLE Article
(
    `no`       INT             NOT NULL    AUTO_INCREMENT,
    `group`    VARCHAR(50)     NOT NULL,
    `cate`   VARCHAR(50)     NOT NULL,
    `title`    VARCHAR(255)    NOT NULL,
    `content`  TEXT            NOT NULL,
    `file`     TINYINT         NOT NULL,
    `hit`      INT             NOT NULL    DEFAULT 0,
    `comment`      INT             NOT NULL,
    `writer`   VARCHAR(50)     NOT NULL,
    `regip`    VARCHAR(50)     NULL,
    `redate`   DATETIME        NULL,
     PRIMARY KEY (no)
);
-- 테이블 commentment 설정 SQL - Article
ALTER TABLE Article commentMENT '게시판';
-- Users Table Create SQL
-- 테이블 생성 SQL - Users
CREATE TABLE Users
(
    `uid`       VARCHAR(50)     NOT NULL,
    `password`  VARCHAR(255)    NOT NULL,
    `name`      VARCHAR(10)     NOT NULL,
    `nick`      VARCHAR(50)     NULL,
    `email`     VARCHAR(100)    NOT NULL,
    `hp`        CHAR(13)        NOT NULL,
    `zip`       VARCHAR(10)     NOT NULL,
    `addr1`     VARCHAR(250)    NOT NULL,
    `addr2`     VARCHAR(250)    NOT NULL,
    `regdate`   DATETIME        NULL,
    `grade`     VARCHAR(45)     NOT NULL,
    `point`     INT             NOT NULL    DEFAULT 0,
     PRIMARY KEY (uid)
);
-- 테이블 commentment 설정 SQL - Users
ALTER TABLE Users commentMENT '사용자';
-- Unique Index 설정 SQL - Users(hp, nick, email)
CREATE UNIQUE INDEX UQ_Users_1
    ON Users(hp, nick, email);
-- Products Table Create SQL
-- 테이블 생성 SQL - Products
CREATE TABLE Products
(
    `p_no`        INT             NOT NULL    AUTO_INCREMENT commentMENT '상품번호',
    `p_name`      VARCHAR(45)     NOT NULL    commentMENT '상품명',
    `p_cateType`  INT             NOT NULL    commentMENT '종류',
    `p_price`     INT             NOT NULL    commentMENT '가격',
    `p_point`     INT             NOT NULL    commentMENT '포인트',
    `p_sale`      INT             NOT NULL    DEFAULT 0 commentMENT '할인',
    `p_delivery`  INT             NOT NULL    DEFAULT 0 commentMENT '배송비',
    `p_stock`     INT             NOT NULL    commentMENT '재고',
    `p_img1`      VARCHAR(255)    NOT NULL    DEFAULT '0' commentMENT '상품목록이미지',
    `p_img2`      VARCHAR(255)    NOT NULL    DEFAULT '0' commentMENT '기본정보이미지',
    `p_img3`      VARCHAR(255)    NOT NULL    DEFAULT '0' commentMENT '상품설명이미지',
    `p_etc`       VARCHAR(255)    NULL        commentMENT '기타',
    `p_redate`    DATETIME        NOT NULL    commentMENT '둥록일',
     PRIMARY KEY (p_no)
);
-- 테이블 commentment 설정 SQL - Products
ALTER TABLE Products commentMENT '상품';
-- Cart Table Create SQL
-- 테이블 생성 SQL - Cart
CREATE TABLE Cart
(
    `cart_no`    INT            NOT NULL    AUTO_INCREMENT,
    `cart_uid`   VARCHAR(50)    NOT NULL,
    `cart_pNo`   INT            NOT NULL,
    `cart_qty`   INT            NOT NULL,
    `cart_date`  DATETIME       NULL,
     PRIMARY KEY (cart_no)
);
-- 테이블 commentment 설정 SQL - Cart
ALTER TABLE Cart commentMENT '장바구니';
-- Foreign Key 설정 SQL - Cart(cart_uid) -> Users(uid)
ALTER TABLE Cart
    ADD CONSTRAINT FK_Cart_cart_uid_Users_uid FOREIGN KEY (cart_uid)
        REFERENCES Users (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - Cart(cart_uid)
-- ALTER TABLE Cart
-- DROP FOREIGN KEY FK_Cart_cart_uid_Users_uid;
-- Foreign Key 설정 SQL - Cart(cart_pNo) -> Products(p_no)
ALTER TABLE Cart
    ADD CONSTRAINT FK_Cart_cart_pNo_Products_p_no FOREIGN KEY (cart_pNo)
        REFERENCES Products (p_no) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - Cart(cart_pNo)
-- ALTER TABLE Cart
-- DROP FOREIGN KEY FK_Cart_cart_pNo_Products_p_no;
-- Orders Table Create SQL
-- 테이블 생성 SQL - Orders
CREATE TABLE Orders
(
    `o_no`          INT             NOT NULL    AUTO_INCREMENT commentMENT 'pk',
    `o_pNo`         INT             NOT NULL    commentMENT 'propk',
    `o_uid`         VARCHAR(50)     NOT NULL    commentMENT 'userpk',
    `o_rdate`       DATETIME        NOT NULL    commentMENT '주문일',
    `o_recName`     VARCHAR(45)     NOT NULL    commentMENT '받는분',
    `o_recHp`       CHAR(13)        NOT NULL    commentMENT '연락처',
    `o_recZip`      VARCHAR(20)     NOT NULL    commentMENT '우편번호',
    `o_recAddr1`    VARCHAR(255)    NOT NULL    commentMENT '기본주소',
    `o_recAddr2`    VARCHAR(255)    NULL        commentMENT '상세주소',
    `o_payments`    INT             NOT NULL    commentMENT '결제방법',
    `o_etc`         VARCHAR(255)    NULL        commentMENT '기타',
    `o_qty`         INT             NOT NULL    commentMENT '수량',
    `o_delivery`    INT             NOT NULL    DEFAULT 0 commentMENT '배송비',
    `o_totalPrice`  INT             NOT NULL    commentMENT '합계',
     PRIMARY KEY (o_no)
);
-- 테이블 commentment 설정 SQL - Orders
ALTER TABLE Orders commentMENT '주문';
-- Foreign Key 설정 SQL - Orders(o_pNo) -> Products(p_no)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_o_pNo_Products_p_no FOREIGN KEY (o_pNo)
        REFERENCES Products (p_no) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - Orders(o_pNo)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_o_pNo_Products_p_no;
-- Foreign Key 설정 SQL - Orders(o_uid) -> Users(uid)
ALTER TABLE Orders
    ADD CONSTRAINT FK_Orders_o_uid_Users_uid FOREIGN KEY (o_uid)
        REFERENCES Users (uid) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - Orders(o_uid)
-- ALTER TABLE Orders
-- DROP FOREIGN KEY FK_Orders_o_uid_Users_uid;
-- commentment Table Create SQL
-- 테이블 생성 SQL - commentment
CREATE TABLE commentment
(
    `c_no`       INT             NOT NULL    AUTO_INCREMENT,
    `c_parent`   INT             NOT NULL,
    `c_content`  TEXT            NOT NULL,
    `c_writer`   VARCHAR(20)     NOT NULL,
    `c_regip`    VARCHAR(100)    NULL,
    `c_rdate`    DATETIME        NULL,
     PRIMARY KEY (c_no)
);
-- 테이블 commentment 설정 SQL - commentment
ALTER TABLE commentment commentMENT '댓글';
-- Foreign Key 설정 SQL - commentment(c_parent) -> Article(no)
ALTER TABLE commentment
    ADD CONSTRAINT FK_commentment_c_parent_Article_no FOREIGN KEY (c_parent)
        REFERENCES Article (no) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - commentment(c_parent)
-- ALTER TABLE commentment
-- DROP FOREIGN KEY FK_commentment_c_parent_Article_no;
-- Terms Table Create SQL
-- 테이블 생성 SQL - Terms
CREATE TABLE Terms
(
    `term_id`        INT     NOT NULL    AUTO_INCREMENT,
    `term_content1`  TEXT    NOT NULL    commentMENT 'term_',
    `term_content2`  TEXT    NOT NULL    commentMENT 'term_',
     PRIMARY KEY (term_id)
);
-- 테이블 commentment 설정 SQL - Terms
ALTER TABLE Terms commentMENT '약관';
-- File Table Create SQL
-- 테이블 생성 SQL - File
CREATE TABLE File
(
    `f_no`        INT             NOT NULL    AUTO_INCREMENT,
    `no`        INT             NOT NULL,
    `f_oName`     VARCHAR(255)    NOT NULL,
    `f_sName`     VARCHAR(255)    NOT NULL,
    `f_download`  INT             NOT NULL    DEFAULT 0,
    `f_rdate`     DATETIME        NULL,
     PRIMARY KEY (f_no)
);
-- 테이블 commentment 설정 SQL - File
ALTER TABLE File commentMENT '파일';
-- Foreign Key 설정 SQL - File(no) -> Article(no)
ALTER TABLE File
    ADD CONSTRAINT FK_File_no_Article_no FOREIGN KEY (no)
        REFERENCES Article (no) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- Foreign Key 삭제 SQL - File(no)
-- ALTER TABLE File
-- DROP FOREIGN KEY FK_File_no_Article_no;


