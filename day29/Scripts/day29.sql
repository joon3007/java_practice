--DML(DELETE, UPDATE)실습

--PLAYER 테이블에서 TEAM_ID가 'K01'인 선수 이름을 내이름으로 바꾸기
--ROLLBACK
UPDATE PLAYER 
SET PLAYER_NAME = '김휘준'
WHERE TEAM_ID = 'K01'

SELECT * FROM PLAYER WHERE TEAM_ID ='K01';

--PALYER 테이블에서 POSITION이 'MF'인 선수 삭제하기
--ROLLBACK
DELETE FROM PLAYER
WHERE "POSITION" = 'MF'

SELECT * FROM PLAYER WHERE "POSITION" = 'MF';

--PLAYER 테이블에서 HEIGHT가 180이상인 선수 삭제하기
--ROLLBACK
DELETE FROM PLAYER WHERE HEIGHT >= 180;
SELECT * FROM PLAYER WHERE HEIGHT >= 180;

--AS(Alias) : 별칭
-- SELECT 절 : AS뒤에 별칭을 쓰거나, 공백문자 뒤에 쓴다.
-- FROM 절 : 공백문자 뒤에쓴다.

SELECT PLAYER_ID AS "선수 번호", PLAYER_NAME AS "이름" FROM PLAYER;

--PLAYER테이블에서 선수이름을, TEAM테이블에서 주소를 검색
SELECT PLAYER_NAME, ADDRESS, p.TEAM_ID FROM PLAYER p, TEAM t;

--STADIUM테이블에서 ADDRESS를, TEAM테이블에서 TEL 검색
SELECT S.ADDRESS AS 주소, T.TEL AS 전화번호 FROM STADIUM s , TEAM t;

--NULL
--정의되지 않은 값
--빈 값 대신 미정값을 부여할 때 사용(PK는 불가능, FK는 가능)
-- NVL : NULL값 대신다른 값으로 변경 후 검색
-- NVL2 : NULL일 때의값, NULL이 아닐 떄의 값 2가지를 설정

SELECT NVL(NICKNAME, '별명 없음') FROM PLAYER;

--PLAYER테이블에서 NATION이 NULL이면 미등록, NULL이 아니면 등록으로 변경 후 선수이름 국가 검색
SELECT NVL2(NICKNAME,'등록','미등록') AS 별명 FROM PLAYER;

--USER테이블이 있다면 DROP하기
--USER_SEQ 만들기
--1부터 시작, 1씩 증가, 1000까지

--USER테이블 만들기
--USER_NUMBER NUMBER NOT NULL
--ID VC2(20)
--PW VC2(20)
--NAME VC2(20)
--AGE NUMBER
--PHONE NUMBER
--PK는 ID컬럼에 부여
DROP TABLE "USER";
DROP SEQUENCE USER_SEQ;

CREATE SEQUENCE USER_SEQ
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 1000;

CREATE TABLE "USER"(
	USER_NUMBER NUMBER NOT NULL,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	AGE NUMBER,
	PHONE_NUMBER VARCHAR2(11),
	CONSTRAINT USER_PK PRIMARY KEY(ID)
);

INSERT INTO HR."USER"
(USER_NUMBER, ID, PW, NAME, AGE, PHONE_NUMBER)
VALUES(USER_SEQ.NEXTVAL, 'JOON', '1234', '김휘준', 29, '01041418105');

SELECT * FROM "USER";

