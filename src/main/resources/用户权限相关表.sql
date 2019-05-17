prompt PL/SQL Developer import file
prompt Created on 2019年5月17日, 星期五 by Administrator
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
values (30, '指标数据', 'quota-manager.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (31, '自购实物油料', 'zigoushiwuyouliao.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (15, '卡圈存', 'card_operation_quota.htm', 'fa-credit-card', '加油卡管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (17, '卡发行', 'card_operation_provide.htm', 'fa-credit-card', '加油卡管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (16, '卡信息修改', 'card_operation_modify.htm', 'fa-credit-card', '加油卡管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (25, '部门信息管理', 'depart-manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (26, '车辆信息管理', 'car-manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (27, '车辆类型定义', 'car-type-manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (28, '加油站定义', 'gas-station-manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (29, '油品定义', 'oil-type-manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (1, '指标分配', 'quota_assign_managment.htm' || chr(9) || '', 'fa-pie-chart', '指标管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (2, '本级调整', 'quota_fixed_managment.htm', 'fa-pie-chart', '指标管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (3, '年终结转', 'nianzongjiezhuan.htm', 'fa-pie-chart', '指标管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (4, '解放军换单', 'youliao_huandan.htm', 'fa-retweet', '油料管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (5, '解放军油库', 'youliao_diaobo.htm', 'fa-download', '油料收发');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (6, '武警油库', 'wjyouliao_diaobo.htm', 'fa-download', '油料收发');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (7, '转代供指标调拨', 'zdgyouliao_diaobo.htm', 'fa-download', '油料收发');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (8, '油库损耗', 'youku_sunhao.htm', 'fa-download', '油料收发');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (9, '自购实物油料', 'youliao_zigou.htm', 'fa-download', '油料收发');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (10, '单卡指标发放', 'card_quota_provide.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (11, '固定指标发放', 'fixed_quota_provide.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (12, '非IC卡消耗管理', 'card-trade-nonIC-manager.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (13, '加油站损耗录入', 'gasstation-loss-manager.htm', ' fa-exchange', '加油管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (14, '卡操作', 'card_operation_init.htm', 'fa-credit-card', '加油卡管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (20, '油料库存帐', 'null', ' fa-database', '油料库存');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (21, '油储情况查询', 'null', ' fa-database', '油料库存');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (22, '供应单位定义', 'supply_department_manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (23, '受供单位定义', 'supply_department_manager.htm', ' fa-gear', '数据管理');
insert into RESOURCE_URL (id, name, url, memo, levelname)
values (24, '油品定义', 'youku_youliao_manager.htm', ' fa-gear', '数据管理');
commit;
prompt 29 records loaded
prompt Loading USERSROLES...
insert into USERSROLES (id, name, relresid, memo)
values (106, '支队助理', 31, null);
insert into USERSROLES (id, name, relresid, memo)
values (108, '支队助理', 26, null);
insert into USERSROLES (id, name, relresid, memo)
values (109, '支队助理', 27, null);
insert into USERSROLES (id, name, relresid, memo)
values (110, '支队助理', 28, null);
insert into USERSROLES (id, name, relresid, memo)
values (111, '支队助理', 29, null);
insert into USERSROLES (id, name, relresid, memo)
values (105, '支队助理', 30, null);
insert into USERSROLES (id, name, relresid, memo)
values (107, '支队助理', 25, null);
insert into USERSROLES (id, name, relresid, memo)
values (99, '总队助理', 24, null);
insert into USERSROLES (id, name, relresid, memo)
values (98, '总队助理', 22, null);
insert into USERSROLES (id, name, relresid, memo)
values (97, '总队助理', 21, null);
insert into USERSROLES (id, name, relresid, memo)
values (96, '总队助理', 20, null);
insert into USERSROLES (id, name, relresid, memo)
values (48, '支队助理', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (49, '支队助理', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (50, '支队助理', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (51, '支队助理', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (52, '支队助理', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (53, '支队助理', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (54, '支队助理', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (55, '支队助理', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (56, '支队助理', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (57, '支队助理', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (1, '系统管理员', 1, null);
insert into USERSROLES (id, name, relresid, memo)
values (2, '系统管理员', 2, null);
insert into USERSROLES (id, name, relresid, memo)
values (3, '系统管理员', 3, null);
insert into USERSROLES (id, name, relresid, memo)
values (4, '系统管理员', 4, null);
insert into USERSROLES (id, name, relresid, memo)
values (5, '系统管理员', 5, null);
insert into USERSROLES (id, name, relresid, memo)
values (6, '系统管理员', 6, null);
insert into USERSROLES (id, name, relresid, memo)
values (7, '系统管理员', 7, null);
insert into USERSROLES (id, name, relresid, memo)
values (8, '系统管理员', 8, null);
insert into USERSROLES (id, name, relresid, memo)
values (9, '系统管理员', 9, null);
insert into USERSROLES (id, name, relresid, memo)
values (10, '系统管理员', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (11, '系统管理员', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (12, '系统管理员', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (13, '系统管理员', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (14, '系统管理员', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (15, '系统管理员', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (16, '系统管理员', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (17, '系统管理员', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (18, '系统管理员', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (19, '系统管理员', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (20, '总队助理', 1, null);
insert into USERSROLES (id, name, relresid, memo)
values (21, '总队助理', 2, null);
insert into USERSROLES (id, name, relresid, memo)
values (22, '总队助理', 3, null);
insert into USERSROLES (id, name, relresid, memo)
values (23, '总队助理', 4, null);
insert into USERSROLES (id, name, relresid, memo)
values (24, '总队助理', 5, null);
insert into USERSROLES (id, name, relresid, memo)
values (25, '总队助理', 6, null);
insert into USERSROLES (id, name, relresid, memo)
values (26, '总队助理', 7, null);
insert into USERSROLES (id, name, relresid, memo)
values (27, '总队助理', 8, null);
insert into USERSROLES (id, name, relresid, memo)
values (28, '总队助理', 9, null);
insert into USERSROLES (id, name, relresid, memo)
values (67, '油料员', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (68, '油料员', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (69, '油料员', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (70, '油料员', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (71, '油料员', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (72, '油料员', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (73, '油料员', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (74, '油料员', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (75, '油料员', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (76, '油料员', 19, null);
insert into USERSROLES (id, name, relresid, memo)
values (86, '加油员', 10, null);
insert into USERSROLES (id, name, relresid, memo)
values (87, '加油员', 11, null);
insert into USERSROLES (id, name, relresid, memo)
values (88, '加油员', 12, null);
insert into USERSROLES (id, name, relresid, memo)
values (89, '加油员', 13, null);
insert into USERSROLES (id, name, relresid, memo)
values (90, '加油员', 14, null);
insert into USERSROLES (id, name, relresid, memo)
values (91, '加油员', 15, null);
insert into USERSROLES (id, name, relresid, memo)
values (92, '加油员', 16, null);
insert into USERSROLES (id, name, relresid, memo)
values (93, '加油员', 17, null);
insert into USERSROLES (id, name, relresid, memo)
values (94, '加油员', 18, null);
insert into USERSROLES (id, name, relresid, memo)
values (95, '加油员', 19, null);
commit;
prompt 69 records loaded
prompt Enabling triggers for RESOURCE_URL...
alter table RESOURCE_URL enable all triggers;
prompt Enabling triggers for USERSROLES...
alter table USERSROLES enable all triggers;
set feedback on
set define on
prompt Done.
