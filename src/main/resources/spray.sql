/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost
 Source Database       : spray

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : utf-8

 Date: 09/12/2016 11:02:17 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `beautiful`
-- ----------------------------
DROP TABLE IF EXISTS `beautiful`;
CREATE TABLE `beautiful` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL COMMENT '类型id',
  `title` varchar(255) DEFAULT NULL COMMENT '名称',
  `link` varchar(1000) DEFAULT NULL COMMENT '链接',
  `sources_id` int(11) DEFAULT NULL COMMENT '来源id',
  `author` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `placed_top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
  `recommend` tinyint(1) DEFAULT '0' COMMENT '是否推荐',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `albumid` int(11) DEFAULT NULL COMMENT '专辑id(暂未使用)',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=626 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='美图表';

-- ----------------------------
--  Table structure for `config`
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `code` varchar(200) DEFAULT NULL COMMENT '代码',
  `info` varchar(1000) DEFAULT NULL COMMENT '描述',
  `content` varchar(2000) DEFAULT NULL COMMENT '内容',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='配置参数表';

-- ----------------------------
--  Table structure for `funny`
-- ----------------------------
DROP TABLE IF EXISTS `funny`;
CREATE TABLE `funny` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT '1' COMMENT '所属类别',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `sources_id` int(11) DEFAULT NULL COMMENT '来源id',
  `label` varchar(200) DEFAULT NULL COMMENT '标签',
  `thumb_up` int(11) DEFAULT '0' COMMENT '点赞',
  `placed_top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
  `recommend` tinyint(1) DEFAULT '0' COMMENT '是否推荐',
  `status` int(11) DEFAULT '1' COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhuj` (`id`) COMMENT '(null)'
) ENGINE=InnoDB AUTO_INCREMENT=2466 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='搞笑段子表';

-- ----------------------------
--  Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT '1' COMMENT '所属类别',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `info` varchar(200) DEFAULT NULL COMMENT '描述',
  `content` text COMMENT '内容',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `explicit_link` tinyint(4) DEFAULT '0' COMMENT '是否是链接',
  `link` varchar(2000) DEFAULT NULL COMMENT '链接地址',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `sources_id` int(11) DEFAULT NULL COMMENT '来源id',
  `label` varchar(200) DEFAULT NULL COMMENT '标签',
  `thumb_up` int(11) DEFAULT '0' COMMENT '点赞',
  `placed_top` tinyint(1) DEFAULT '0' COMMENT '是否置顶',
  `recommend` tinyint(1) DEFAULT '0' COMMENT '是否推荐',
  `status` int(11) DEFAULT '1' COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '添加时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zhuj` (`id`) COMMENT '(null)'
) ENGINE=InnoDB AUTO_INCREMENT=458 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='新闻表';

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(20) NOT NULL COMMENT '主键',
  `pid` int(20) DEFAULT '0' COMMENT '上级ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '标题',
  `status` int(6) DEFAULT '0' COMMENT '状态 ',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '地址',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '图标',
  `create_date` datetime DEFAULT NULL COMMENT '描述',
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='权限表';

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '中文名',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色表';

-- ----------------------------
--  Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `permission_id` int(11) DEFAULT NULL COMMENT '权限id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色权限表';

-- ----------------------------
--  Table structure for `sources`
-- ----------------------------
DROP TABLE IF EXISTS `sources`;
CREATE TABLE `sources` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  `source` varchar(200) DEFAULT NULL COMMENT '来源',
  `source_image` varchar(2000) DEFAULT NULL COMMENT '来源图片',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='来源';

-- ----------------------------
--  Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `info` varchar(500) DEFAULT NULL COMMENT '描述',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `tid` int(11) DEFAULT '0' COMMENT '上级类别',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='类别表';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `salt` varchar(32) DEFAULT NULL COMMENT '密码盐',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `status` int(4) DEFAULT NULL COMMENT '账号状态（正常，锁定，删除）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_date` datetime DEFAULT NULL COMMENT '修改时间',
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户基本表';

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(20) DEFAULT NULL COMMENT '用户id',
  `role_id` int(20) DEFAULT NULL COMMENT '角色id',
  `create_date` datetime DEFAULT NULL,
  `modify_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关联表';

SET FOREIGN_KEY_CHECKS = 1;
