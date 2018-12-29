DROP DATABASE IF EXISTS authority;
CREATE DATABASE IF NOT EXISTS authority DEFAULT CHARSET utf8 COLLATE utf8_general_ci;

USE authority;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                          `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
                          `account` varchar(45) DEFAULT NULL COMMENT '账号',
                          `password` varchar(45) DEFAULT NULL COMMENT '密码',
                          `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
                          `name` varchar(45) DEFAULT NULL COMMENT '名字',
                          `birthday` datetime DEFAULT NULL COMMENT '生日',
                          `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
                          `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
                          `phone` varchar(45) DEFAULT NULL COMMENT '电话',
                          `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
                          `deptid` int(11) DEFAULT NULL COMMENT '部门id',
                          `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
                          `createtime` datetime DEFAULT NULL COMMENT '创建时间',
                          `version` int(11) DEFAULT NULL COMMENT '保留字段',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'girl.gif', 'admin', 'ecfadcde9305f8891bcfe5a1e28c253e', '8pgby', '张三', '2017-05-05 00:00:00', '2', 'sn93@qq.com', '18200000000', '1', '27', '1', '2016-01-29 08:49:53', '25');
INSERT INTO `sys_user` VALUES ('44', null, 'test', '45abb7879f6a8268f1ef600e6038ac73', 'ssts3', 'test', '2017-05-01 00:00:00', '1', 'abc@123.com', '', '5', '26', '3', '2017-05-16 20:33:37', null);
INSERT INTO `sys_user` VALUES ('45', null, 'boss', '71887a5ad666a18f709e1d4e693d5a35', '1f7bf', '老板', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:02', null);
INSERT INTO `sys_user` VALUES ('46', null, 'manager', 'b53cac62e7175637d4beb3b16b2f7915', 'j3cs9', '经理', '2017-12-04 00:00:00', '1', '', '', '1', '24', '1', '2017-12-04 22:24:24', null);


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
                          `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                          `num` int(11) DEFAULT NULL COMMENT '序号',
                          `pid` int(11) DEFAULT NULL COMMENT '父角色id',
                          `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
                          `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
                          `tips` varchar(255) DEFAULT NULL COMMENT '提示',
                          `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '超级管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('5', '2', '1', '临时', '26', 'temp', null);


-- ----------------------------
-- Table structure for sys_re_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_re_user_role`;
CREATE TABLE `sys_re_user_role` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                                  `userid` bigint(11) DEFAULT NULL COMMENT '用户id',
                                  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户和角色关联表';


-- ----------------------------
-- Table structure for sys_re_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_re_role_menu`;
CREATE TABLE `sys_re_role_menu` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
                              `roleid` int(11) DEFAULT NULL COMMENT '角色id',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3792 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_re_role_menu
-- ----------------------------
INSERT INTO `sys_re_role_menu` VALUES ('3377', '105', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3378', '106', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3379', '107', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3380', '108', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3381', '109', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3382', '110', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3383', '111', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3384', '112', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3385', '113', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3386', '114', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3387', '115', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3388', '116', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3389', '117', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3390', '118', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3391', '119', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3392', '120', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3393', '121', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3394', '122', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3395', '150', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3396', '151', '5');
INSERT INTO `sys_re_role_menu` VALUES ('3737', '105', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3738', '106', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3739', '107', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3740', '108', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3741', '109', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3742', '110', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3743', '111', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3744', '112', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3745', '113', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3746', '165', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3747', '166', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3748', '167', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3749', '114', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3750', '115', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3751', '116', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3752', '117', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3753', '118', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3754', '162', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3755', '163', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3756', '164', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3757', '119', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3758', '120', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3759', '121', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3760', '122', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3761', '150', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3762', '151', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3763', '128', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3764', '134', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3765', '158', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3766', '159', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3767', '130', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3768', '131', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3769', '135', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3770', '136', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3771', '137', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3772', '152', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3773', '153', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3774', '154', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3775', '132', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3776', '138', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3777', '139', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3778', '140', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3779', '155', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3780', '156', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3781', '157', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3782', '133', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3783', '160', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3784', '161', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3785', '141', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3786', '142', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3787', '143', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3788', '144', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3789', '145', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3790', '148', '1');
INSERT INTO `sys_re_role_menu` VALUES ('3791', '149', '1');



-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
                          `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
                          `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
                          `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
                          `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
                          `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
                          `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
                          `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
                          `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
                          `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
                          `tips` varchar(255) DEFAULT NULL COMMENT '备注',
                          `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
                          `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=171 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '#', '4', '1', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', null, '/dept', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('145', 'hello', '0', '[0],', '通知', 'fa-rocket', '/notice/hello', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('148', 'code', '0', '[0],', '代码生成', 'fa-code', '/code', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('149', 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', '2', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);


