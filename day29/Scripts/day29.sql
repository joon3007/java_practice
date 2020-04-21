--DML(DELETE, UPDATE)�ǽ�

--PLAYER ���̺��� TEAM_ID�� 'K01'�� ���� �̸��� ���̸����� �ٲٱ�
--ROLLBACK
UPDATE PLAYER 
SET PLAYER_NAME = '������'
WHERE TEAM_ID = 'K01'

SELECT * FROM PLAYER WHERE TEAM_ID ='K01';

--PALYER ���̺��� POSITION�� 'MF'�� ���� �����ϱ�
--ROLLBACK
DELETE FROM PLAYER
WHERE "POSITION" = 'MF'

SELECT * FROM PLAYER WHERE "POSITION" = 'MF';

--PLAYER ���̺��� HEIGHT�� 180�̻��� ���� �����ϱ�
--ROLLBACK
DELETE FROM PLAYER WHERE HEIGHT >= 180;
SELECT * FROM PLAYER WHERE HEIGHT >= 180;

--AS(Alias) : ��Ī
-- SELECT �� : AS�ڿ� ��Ī�� ���ų�, ���鹮�� �ڿ� ����.
-- FROM �� : ���鹮�� �ڿ�����.

SELECT PLAYER_ID AS "���� ��ȣ", PLAYER_NAME AS "�̸�" FROM PLAYER;

--PLAYER���̺��� �����̸���, TEAM���̺��� �ּҸ� �˻�
SELECT PLAYER_NAME, ADDRESS, p.TEAM_ID FROM PLAYER p, TEAM t;

--STADIUM���̺��� ADDRESS��, TEAM���̺��� TEL �˻�
SELECT S.ADDRESS AS �ּ�, T.TEL AS ��ȭ��ȣ FROM STADIUM s , TEAM t;

--NULL
--���ǵ��� ���� ��
--�� �� ��� �������� �ο��� �� ���(PK�� �Ұ���, FK�� ����)
-- NVL : NULL�� ��Ŵٸ� ������ ���� �� �˻�
-- NVL2 : NULL�� ���ǰ�, NULL�� �ƴ� ���� �� 2������ ����

SELECT NVL(NICKNAME, '���� ����') FROM PLAYER;

--PLAYER���̺��� NATION�� NULL�̸� �̵��, NULL�� �ƴϸ� ������� ���� �� �����̸� ���� �˻�
SELECT NVL2(NICKNAME,'���','�̵��') AS ���� FROM PLAYER;

--USER���̺��� �ִٸ� DROP�ϱ�
--USER_SEQ �����
--1���� ����, 1�� ����, 1000����

--USER���̺� �����
--USER_NUMBER NUMBER NOT NULL
--ID VC2(20)
--PW VC2(20)
--NAME VC2(20)
--AGE NUMBER
--PHONE NUMBER
--PK�� ID�÷��� �ο�
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
VALUES(USER_SEQ.NEXTVAL, 'JOON', '1234', '������', 29, '01041418105');

SELECT * FROM "USER";

