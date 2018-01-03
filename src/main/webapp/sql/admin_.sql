prompt PL/SQL Developer import file
prompt Created on 2018Äê1ÔÂ3ÈÕ by Administrator
set feedback off
set define off
prompt Creating SALARY_MANAGE.ADMIN_...
create table SALARY_MANAGE.ADMIN_
(
  ID        NUMBER not null,
  ADM_COUNT VARCHAR2(11),
  ADM_PASS  VARCHAR2(20)
)
;
alter table SALARY_MANAGE.ADMIN_
  add constraint PK_T1 primary key (ID);

prompt Loading SALARY_MANAGE.ADMIN_...
insert into SALARY_MANAGE.ADMIN_ (ID, ADM_COUNT, ADM_PASS)
values (1, 'admin', 'abc@1234');
commit;
prompt 1 records loaded
set feedback on
set define on
prompt Done.
