prompt PL/SQL Developer import file
prompt Created on 2018��1��3�� by Administrator
set feedback off
set define off
prompt Creating SALARY_MANAGE.DEPARTMENT_...
create table SALARY_MANAGE.DEPARTMENT_
(
  ID                NUMBER not null,
  DEP_ID            VARCHAR2(20),
  DEP_NAME          VARCHAR2(50),
  DEP_COST_CATEGORY VARCHAR2(30),
  DEP_REMARK        VARCHAR2(30)
)
;
alter table SALARY_MANAGE.DEPARTMENT_
  add constraint PK_DEPARTMENT primary key (ID);

prompt Loading SALARY_MANAGE.DEPARTMENT_...
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (70, '003', '�豸�������Ĳ�-������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (71, '004', '�豸�������Ĳ�-�豸��', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (72, '005', '�ۺϰ칫��-������Դ��', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (73, '006', '�ۺϰ칫��-������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (74, '007', '���׳���-��������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (75, '008', '���׳���-�ۺϹ���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (76, '009', '����-���������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (77, '010', '������Ӫ��-�ƻ��ɹ���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (78, '011', '������Ӫ��-Ӫ����', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (79, '012', '������-����������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (80, '013', '������-����������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (81, '024', '������-����������', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (82, '014', '�г��׳���-����', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (83, '015', '�г��׳���-�г��ۺϹ���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (84, '016', '���׳���-���׹���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (85, '017', '���׳���-����', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (86, '018', '���׳���-���Ṥ��', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (87, '019', '�г��׳���-��ƹ���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (88, '020', '���׳���-���׹���', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (89, '021', '�ۺϰ칫��', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (90, '022', '�ۺϰ칫��-�����', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (91, '023', '���׳���-����', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (3, '001', '������-����ʵ����', null, '����');
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (4, '002', '������-��Ϣ����', null, '����');
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (252, '028', '�ۺϰ칫��-������', null, null);
commit;
prompt 25 records loaded
set feedback on
set define on
prompt Done.
