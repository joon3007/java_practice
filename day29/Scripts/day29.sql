--DML(DELETE, UPDATE)�ǽ�

--PLAYER ���̺����� TEAM_ID�� 'K01'�� ���� �̸��� ���̸����� �ٲٱ�
--ROLLBACK
UPDATE PLAYER 
SET PLAYER_NAME = '������'
WHERE TEAM_ID = 'K01'

SELECT * FROM PLAYER WHERE TEAM_ID ='K01';

--PALYER ���̺����� POSITION�� 'MF'�� ���� �����ϱ�
--ROLLBACK
DELETE FROM PLAYER
WHERE "POSITION" = 'MF'

SELECT * FROM PLAYER WHERE "POSITION" = 'MF';

--PLAYER ���̺����� HEIGHT�� 180�̻��� ���� �����ϱ�
--ROLLBACK
DELETE FROM PLAYER WHERE HEIGHT >= 180;
SELECT * FROM PLAYER WHERE HEIGHT >= 180;