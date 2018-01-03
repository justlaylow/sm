--自增ID，创建一个序列
--CREATE SEQUENCE id_sequence  
--INCREMENT BY 1 -- 每次加几个  
--START WITH 1 -- 从1开始计数  
--NOMAXVALUE -- 不设置最大值  
--NOCYCLE -- 一直累加，不循环  
--NOCACHE -- 不建缓冲区 

--创建一个触发器
--CREATE TRIGGER insurance_trigger  
--   BEFORE INSERT ON SALARY_MANAGE.INSURANCE_  
--   FOR EACH ROW  
--   WHEN (new.id is null) --只有在id为空时，启动该触发器生成id号  
--begin  
--   select id_sequence.nextval into :new.id from sys.dual;  
--end;


