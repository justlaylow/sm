prompt PL/SQL Developer import file
prompt Created on 2018��1��3�� by Administrator
set feedback off
set define off
prompt Creating SALARY_MANAGE.EMPLOYEE_...
create table SALARY_MANAGE.EMPLOYEE_
(
  ID               NUMBER,
  BANK_ACCOUNT     VARCHAR2(19),
  SAL_NAME         VARCHAR2(10),
  POST_CATEGORY    VARCHAR2(30),
  SAL_ID           VARCHAR2(11) not null,
  SAL_DEP          VARCHAR2(40),
  SAL_POST         VARCHAR2(30),
  SAL_DATE         DATE,
  SAL_OA           VARCHAR2(22),
  STA_CATEGORY     VARCHAR2(30),
  SAL_REMARK       VARCHAR2(50),
  SAL_SKILLLEVEL   VARCHAR2(10),
  SAL_SKILL_SALARY NUMBER(12,2)
)
;
alter table SALARY_MANAGE.EMPLOYEE_
  add constraint PK_EMPLOYEE primary key (SAL_ID);

prompt Loading SALARY_MANAGE.EMPLOYEE_...
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (129, '1111111111111111111', '����', '����', '092451', '�ۺϰ칫��-������', '������Ա', to_date('10-10-2017', 'dd-mm-yyyy'), '12121212', '����-һ�����', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (130, '2222222222222222222', '����', null, '092452', '�ۺϰ칫��-������', '������Ա', to_date('10-10-2017', 'dd-mm-yyyy'), '00111111', '����-һ�����', null, null, null);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (131, '3333333333333333333', '����', null, '092453', '�ۺϰ칫��-������', '������Ա', to_date('10-10-2017', 'dd-mm-yyyy'), '87766776', '����-һ�����', null, null, null);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (197, '1', '1', null, '092346', '�豸�������Ĳ�-������', null, null, '735782', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (198, '2', '2', null, '092376', '�豸�������Ĳ�-������', null, null, '738209', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (199, '3', '3', null, '092463', '�豸�������Ĳ�-������', null, null, '00739854', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (200, '4', '4', null, '092114', '�豸�������Ĳ�-������', null, null, '718423.00', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (201, '5', '5', null, '090571', '�豸�������Ĳ�-������', null, null, '90571', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (202, '6', '6', null, '090079', '�豸�������Ĳ�-������', null, null, '90079.00', '����-��������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (203, '7', '7', null, '090518', '�豸�������Ĳ�-������', null, null, '90518.00', '����-��������', null, '8', 300);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (204, '8', '8', null, '091217', '������-��Ϣ����', null, null, '91217.00', '����-IT����', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (205, '9', '9', null, '091766', '������-��Ϣ����', null, null, '705360.00', '����-IT����', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (206, '10', '10', null, '092460', '������-��Ϣ����', null, null, '00739804', '����-IT����', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (207, '11', '11', null, '091106', '������-����������', null, null, '91106.00', '����-��������������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (208, '12', '12', null, '091337', '������-����������', null, null, '91337.00', '����-��������������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (209, '13', '13', null, '090233', '������-����������', null, null, '90233.00', '����-��������������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (210, '14', '14', null, '090124', '������-����������', null, null, '90124.00', '����-��������������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (211, '15', '15', null, '090111', '������-����������', null, null, '90111.00', '����-��������������', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (212, '16', '16', null, '090182', '�г��׳���-��ƹ���', null, null, '90182.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (213, '17', '17', null, '090126', '�г��׳���-��ƹ���', null, null, '90126.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (214, '18', '18', null, '090272', '�г��׳���-��ƹ���', null, null, '90272.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (215, '19', '19', null, '092282', '�г��׳���-��ƹ���', null, null, '723854.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (216, '20', '20', null, '090508', '�г��׳���-��ƹ���', null, null, '90508.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (217, '21', '21', null, '092488', '�г��׳���-��ƹ���', null, null, null, '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (218, '22', '22', null, '092087', '�г��׳���-��ƹ���', null, null, '717395.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (219, '23', '23', null, '090339', '�г��׳���-��ƹ���', null, null, '90339.00', '������Ա-��ʱ', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (220, '24', '24', null, '091319', '������Ӫ��-Ӫ����', null, null, '91319.00', 'Ӫ����Ա-�ۺ�', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (221, '25', '25', null, '090018', '������Ӫ��-Ӫ����', null, null, '90018', 'Ӫ����Ա-�ۺ�', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (222, '26', '26', null, '091243', '������Ӫ��-Ӫ����', null, null, '91243', 'Ӫ����Ա-�ۺ�', null, null, 0);
insert into SALARY_MANAGE.EMPLOYEE_ (ID, BANK_ACCOUNT, SAL_NAME, POST_CATEGORY, SAL_ID, SAL_DEP, SAL_POST, SAL_DATE, SAL_OA, STA_CATEGORY, SAL_REMARK, SAL_SKILLLEVEL, SAL_SKILL_SALARY)
values (223, '27', '27', null, '090203', '������Ӫ��-Ӫ����', null, null, '90203.00', 'Ӫ����Ա-�ۺ�', null, null, 0);
commit;
prompt 30 records loaded
set feedback on
set define on
prompt Done.
