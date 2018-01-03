prompt PL/SQL Developer import file
prompt Created on 2018年1月3日 by Administrator
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
values (70, '003', '设备动力技改部-技改组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (71, '004', '设备动力技改部-设备组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (72, '005', '综合办公室-人力资源组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (73, '006', '综合办公室-行政组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (74, '007', '配套车间-配送中心', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (75, '008', '配套车间-综合工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (76, '009', '财务部-财务管理组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (77, '010', '生产经营部-计划采购组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (78, '011', '生产经营部-营销组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (79, '012', '质量部-质量管理组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (80, '013', '质量部-安环管理组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (81, '024', '质量部-服务中心组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (82, '014', '中长缸车间-管理', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (83, '015', '中长缸车间-中长综合工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (84, '016', '配套车间-阀套工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (85, '017', '长缸车间-管理', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (86, '018', '长缸车间-油漆工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (87, '019', '中长缸车间-电镀工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (88, '020', '长缸车间-长缸工段', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (89, '021', '综合办公室', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (90, '022', '综合办公室-审计组', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (91, '023', '配套车间-管理', null, null);
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (3, '001', '技术部-技术实验组', null, '在用');
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (4, '002', '技术部-信息化组', null, '在用');
insert into SALARY_MANAGE.DEPARTMENT_ (ID, DEP_ID, DEP_NAME, DEP_COST_CATEGORY, DEP_REMARK)
values (252, '028', '综合办公室-安环组', null, null);
commit;
prompt 25 records loaded
set feedback on
set define on
prompt Done.
