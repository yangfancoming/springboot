--权限表（资源和权限合并）
CREATE TABLE sys_permission (
                              id number(20) PRIMARY KEY NOT NULL,-- COMMENT '主键',
                              name varchar2(128) NOT NULL ,     --COMMENT '资源名称',
                              type varchar2(32) NOT NULL,      -- COMMENT '资源类型：menu,button,',
                              url varchar2(128) DEFAULT NULL ,  --COMMENT '访问url地址',
                              percode varchar2(128) DEFAULT NULL, -- COMMENT '权限代码字符串',
                              parentid number(20) DEFAULT NULL , --COMMENT '父结点id',
                              parentids varchar2(128) DEFAULT NULL, -- COMMENT '父结点id列表串',
                              sortstring varchar2(128) DEFAULT NULL, -- COMMENT '排序号',
                              available  varchar2(1) DEFAULT NULL -- COMMENT '是否可用,1：可用，0不可用',
)


  COMMENT ON table sys_permission IS '权限表（资源和权限合并）';
comment on column sys_permission.id is '主键';
comment on column sys_permission.name is '资源名称';
comment on column sys_permission.type is '资源类型：menu,button,';
comment on column sys_permission.url is '访问url地址';
comment on column sys_permission.percode is '权限代码字符串';
comment on column sys_permission.parentid is '父结点id';
comment on column sys_permission.parentids is '父结点id列表串';
comment on column sys_permission.sortstring is '排序号';
comment on column sys_permission.available is '是否可用,1：可用，0不可用';




--角色表
CREATE TABLE sys_role (
                        id varchar2(36) primary key NOT NULL,
                        name varchar2(128) NOT NULL,
                        available varchar2(1) DEFAULT NULL
)
  COMMENT ON table sys_role IS '角色表';
comment on column sys_role.id is 'id';
comment on column sys_role.name is '角色名称';
comment on column sys_role.available is '是否可用,1：可用，0不可用';


--角色权限表 (对角色和权限表的一个包装)
CREATE TABLE sys_role_permission (
                                   id varchar2(36) primary  key NOT NULL,
                                   sys_role_id varchar2(32) NOT NULL,
                                   sys_permission_id varchar2(32) NOT NULL
)
  COMMENT ON table sys_role_permission IS '角色权限表(对角色和权限表的一个包装)';
comment on column sys_role_permission.id is 'id';
comment on column sys_role_permission.sys_role_id is '角色id';
comment on column sys_role_permission.sys_permission_id is '权限id';



CREATE TABLE sys_user (
                        id varchar2(36) primary key NOT NULL , --COMMENT '主键',
                        usercode varchar2(32) NOT NULL,--COMMENT '账号',
                        username varchar2(64) NOT NULL,-- COMMENT '姓名',
                        password varchar2(32) NOT NULL,-- COMMENT '密码',
                        salt varchar2(64) DEFAULT NULL ,--COMMENT '盐',
                        locked varchar2(1) DEFAULT NULL --COMMENT '账号是否锁定，1：锁定，0未锁定',

)
  COMMENT ON table sys_user IS '用户表（主体）';
comment on column sys_user.id is '主键';
comment on column sys_user.usercode is '账号';
comment on column sys_user.username is '姓名';
comment on column sys_user.password is '密码';
comment on column sys_user.salt is '盐';
comment on column sys_user.locked is '账号是否锁定，1：锁定，0未锁定';


/*Table structure for table `sys_user_role` */

CREATE TABLE sys_user_srole (
                              id varchar(36) primary key NOT NULL,
                              sys_user_id varchar(32) NOT NULL,
                              sys_role_id varchar(32) NOT NULL
)

  COMMENT ON table sys_user_role IS '用户角色表';
comment on column sys_user_role.id is '主键';
comment on column sys_user_role.sys_user_id is '用户id';
comment on column sys_user_role.sys_role_id is '角色id';



insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(1,'权限','','','',0,'0/','0','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(11,'商品管理','menu','/item/queryItem.action',NULL,1,'0/1/','1.','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(12,'商品新增','permission','/item/add.action','item:create',11,'0/1/11/','','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(13,'商品修改','permission','/item/editItem.action','item:update',11,'0/1/11/','','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(14,'商品删除','permission','','item:delete',11,'0/1/11/','','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(15,'商品查询','permission','/item/queryItem.action','item:query',11,'0/1/15/',NULL,'1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(21,'用户管理','menu','/user/query.action','user:query',1,'0/1/','2.','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(22,'用户新增','permission','','user:create',21,'0/1/21/','','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(23,'用户修改','permission','','user:update',21,'0/1/21/','','1');
insert  into sys_permission(id,name,type,url,percode,parentid,parentids,sortstring,available)
values
(24,'用户删除','permission','','user:delete',21,'0/1/21/','','1');

/*Data for the table `sys_role` */

insert  into sys_role(id,name,available) values
('1','商品管理员','1');
insert  into sys_role(id,name,available) values
('2','用户管理员','1');
delete from sys_role
/*Data for the table `sys_role_permission` */

insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('1','1','12');
insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('2','1','11');
insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('3','1','21');
insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('4','2','15');
insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('5','2','22');
insert  into sys_role_permission(id,sys_role_id,sys_permission_id)
values
('6','2','13');

/*Data for the table `sys_user` */
delete from sys_user
insert  into sys_user(id,usercode,username,password,salt,locked)
values
('lisi','lisi','李四','123456','uiwueylm','0');
insert  into sys_user(id,usercode,username,password,salt,locked)
values
('zhangsan','zhangsan','张三','1234567','eteokues','0');
/*Data for the table `sys_user_role` */
delete from sys_user_role
insert  into sys_user_role(id,sys_user_id,sys_role_id) values
('1','zhangsan','1');
insert  into sys_user_role(id,sys_user_id,sys_role_id) values
('2','lisi','2');
