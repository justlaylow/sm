--����ID������һ������
--CREATE SEQUENCE id_sequence  
--INCREMENT BY 1 -- ÿ�μӼ���  
--START WITH 1 -- ��1��ʼ����  
--NOMAXVALUE -- ���������ֵ  
--NOCYCLE -- һֱ�ۼӣ���ѭ��  
--NOCACHE -- ���������� 

--����һ��������
--CREATE TRIGGER insurance_trigger  
--   BEFORE INSERT ON SALARY_MANAGE.INSURANCE_  
--   FOR EACH ROW  
--   WHEN (new.id is null) --ֻ����idΪ��ʱ�������ô���������id��  
--begin  
--   select id_sequence.nextval into :new.id from sys.dual;  
--end;


