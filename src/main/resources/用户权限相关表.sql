prompt PL/SQL Developer import file
prompt Created on 2019��5��17��, ������ by Administrator
set feedback off
set define off
prompt Dropping RESOURCE_URL...
drop table RESOURCE_URL cascade constraints;
prompt Dropping USERSROLES...
drop table USERSROLES cascade constraints;
prompt Creating RESOURCE_URL...
create table RESOURCE_URL
(
  id        NUMBER not null,
  name      VARCHAR2(100) not null,
  url       VARCHAR2(100) not null,
  memo      VARCHAR2(100),
  levelname VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index PRIMARY_KEY on RESOURCE_URL (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table RESOURCE_URL
  add constraint RESOURCE_ID primary key (ID);

prompt Creating USERSROLES...
create table USERSROLES
(
  id       NUMBER not null,
  name     VARCHAR2(20),
  relresid NUMBER,
  memo     VARCHAR2(100)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index USERID on USERSROLES (ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERSROLES
  add constraint ROLEID primary key (ID);

prompt Disabling triggers for RESOURCE_URL...
alter table RESOURCE_URL disable all triggers;
prompt Disabling triggers for USERSROLES...
alter table USERSROLES disable all triggers;
prompt Loading RESOURCE_URL...
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (30, 'ָ������', 'quota-manager.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (31, '�Թ�ʵ������', 'zigoushiwuyouliao.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (15, '��Ȧ��', 'card_operation_quota.htm', 'fa-credit-card', '���Ϳ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (17, '������', 'card_operation_provide.htm', 'fa-credit-card', '���Ϳ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (16, '����Ϣ�޸�', 'card_operation_modify.htm', 'fa-credit-card', '���Ϳ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (25, '������Ϣ����', 'depart-manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (26, '������Ϣ����', 'car-manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (27, '�������Ͷ���', 'car-type-manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (28, '����վ����', 'gas-station-manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (29, '��Ʒ����', 'oil-type-manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (1, 'ָ�����', 'quota_assign_managment.htm' || chr(9) || '', 'fa-pie-chart', 'ָ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (2, '��������', 'quota_fixed_managment.htm', 'fa-pie-chart', 'ָ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (3, '���ս�ת', 'nianzongjiezhuan.htm', 'fa-pie-chart', 'ָ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (4, '��ž�����', 'youliao_huandan.htm', 'fa-retweet', '���Ϲ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (5, '��ž��Ϳ�', 'youliao_diaobo.htm', 'fa-download', '�����շ�');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (6, '�侯�Ϳ�', 'wjyouliao_diaobo.htm', 'fa-download', '�����շ�');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (7, 'ת����ָ�����', 'zdgyouliao_diaobo.htm', 'fa-download', '�����շ�');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (8, '�Ϳ����', 'youku_sunhao.htm', 'fa-download', '�����շ�');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (9, '�Թ�ʵ������', 'youliao_zigou.htm', 'fa-download', '�����շ�');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (10, '����ָ�귢��', 'card_quota_provide.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (11, '�̶�ָ�귢��', 'fixed_quota_provide.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (12, '��IC�����Ĺ���', 'card-trade-nonIC-manager.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (13, '����վ���¼��', 'gasstation-loss-manager.htm', ' fa-exchange', '���͹���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (14, '������', 'card_operation_init.htm', 'fa-credit-card', '���Ϳ�����');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (20, '���Ͽ����', 'null', ' fa-database', '���Ͽ��');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (21, '�ʹ������ѯ', 'null', ' fa-database', '���Ͽ��');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (22, '��Ӧ��λ����', 'supply_department_manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (23, '�ܹ���λ����', 'supply_department_manager.htm', ' fa-gear', '���ݹ���');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (24, '��Ʒ����', 'youku_youliao_manager.htm', ' fa-gear', '���ݹ���');
commit;
prompt 29 records loaded
prompt Loading USERSROLES...
insert into USERSROLES (id, name, relresid, memo)
values (106, '֧������', 31, null);
insert into USERSROLES (id, name, relresid, memo)
values (108, '֧������', 26, null);
insert into USERSROLES (id, name, relresid, memo)
values (109, '֧������', 27, null);
insert into USERSROLES (id, name, relresid, memo)
values (110, '֧������', 28, null);
insert into USERSROLES (id, name, relresid, memo)
values (111, '֧������', 29, null);
insert into USERSROLES (id, name, relresid, memo)
values (105, '֧������', 30, null);
insert into USERSROLES (id, name, relresid, memo)
values (107, '֧������', 25, null);
insert into USERSROLES (id, name, relresid, memo)
values (99, '�ܶ�����', 24, null);
insert into USERSROLES (id, name, relresid, memo)
values (98, '�ܶ�����', 22, null);
insert into USERSROLES (id, name, relresid, memo)
values (97, '�ܶ�����', 21, null);
insert into USERSROLES (id, name, relresid, memo)
values (96, '�ܶ�����', 20, null);
insert into USERSROLES (id, name, relresid, memo)
values (48, '֧������', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (49, '֧������', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (50, '֧������', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (51, '֧������', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (52, '֧������', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (53, '֧������', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (54, '֧������', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (55, '֧������', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (56, '֧������', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (57, '֧������', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (1, 'ϵͳ����Ա', 1, null);
insert into USERSROLES (id, name, relresid, memo)
values (2, 'ϵͳ����Ա', 2, null);
insert into USERSROLES (id, name, relresid, memo)
values (3, 'ϵͳ����Ա', 3, null);
insert into USERSROLES (id, name, relresid, memo)
values (4, 'ϵͳ����Ա', 4, null);
insert into USERSROLES (id, name, relresid, memo)
values (5, 'ϵͳ����Ա', 5, null);
insert into USERSROLES (id, name, relresid, memo)
values (6, 'ϵͳ����Ա', 6, null);
insert into USERSROLES (id, name, relresid, memo)
values (7, 'ϵͳ����Ա', 7, null);
insert into USERSROLES (id, name, relresid, memo)
values (8, 'ϵͳ����Ա', 8, null);
insert into USERSROLES (id, name, relresid, memo)
values (9, 'ϵͳ����Ա', 9, null);
insert into USERSROLES (id, name, relresid, memo)
values (10, 'ϵͳ����Ա', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (11, 'ϵͳ����Ա', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (12, 'ϵͳ����Ա', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (13, 'ϵͳ����Ա', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (14, 'ϵͳ����Ա', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (15, 'ϵͳ����Ա', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (16, 'ϵͳ����Ա', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (17, 'ϵͳ����Ա', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (18, 'ϵͳ����Ա', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (19, 'ϵͳ����Ա', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (20, '�ܶ�����', 1, null);
insert into USERSROLES (id, name, relresid, memo)
values (21, '�ܶ�����', 2, null);
insert into USERSROLES (id, name, relresid, memo)
values (22, '�ܶ�����', 3, null);
insert into USERSROLES (id, name, relresid, memo)
values (23, '�ܶ�����', 4, null);
insert into USERSROLES (id, name, relresid, memo)
values (24, '�ܶ�����', 5, null);
insert into USERSROLES (id, name, relresid, memo)
values (25, '�ܶ�����', 6, null);
insert into USERSROLES (id, name, relresid, memo)
values (26, '�ܶ�����', 7, null);
insert into USERSROLES (id, name, relresid, memo)
values (27, '�ܶ�����', 8, null);
insert into USERSROLES (id, name, relresid, memo)
values (28, '�ܶ�����', 9, null);
insert into USERSROLES (id, name, relresid, memo)
values (67, '����Ա', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (68, '����Ա', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (69, '����Ա', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (70, '����Ա', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (71, '����Ա', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (72, '����Ա', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (73, '����Ա', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (74, '����Ա', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (75, '����Ա', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (76, '����Ա', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (86, '����Ա', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (87, '����Ա', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (88, '����Ա', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (89, '����Ա', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (90, '����Ա', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (91, '����Ա', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (92, '����Ա', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (93, '����Ա', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (94, '����Ա', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (95, '����Ա', 19, null);
commit;
prompt 69 records loaded
prompt Enabling triggers for RESOURCE_URL...
alter table RESOURCE_URL enable all triggers;
prompt Enabling triggers for USERSROLES...
alter table USERSROLES enable all triggers;
set feedback on
set define on
prompt Done.
