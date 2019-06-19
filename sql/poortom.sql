/*
Navicat MySQL Data Transfer

Source Server         : wang
Source Server Version : 50522
Source Host           : localhost:3306
Source Database       : poortom

Target Server Type    : MYSQL
Target Server Version : 50522
File Encoding         : 65001

Date: 2019-06-14 22:44:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for participant
-- ----------------------------
DROP TABLE IF EXISTS `participant`;
CREATE TABLE `participant` (
  `parrtid` int(8) DEFAULT NULL COMMENT '活动id',
  `userid` int(8) DEFAULT NULL COMMENT '人员id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动参与人员表';

-- ----------------------------
-- Records of participant
-- ----------------------------

-- ----------------------------
-- Table structure for parttimejob
-- ----------------------------
DROP TABLE IF EXISTS `parttimejob`;
CREATE TABLE `parttimejob` (
  `ptjobid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `issueid` int(4) DEFAULT NULL COMMENT '发布者id',
  `ptname` varchar(32) DEFAULT NULL COMMENT '兼职任务名字',
  `starttime` varchar(32) DEFAULT NULL COMMENT '开始时间',
  `overtime` varchar(32) DEFAULT NULL COMMENT '结束时间',
  `money_day` varchar(32) DEFAULT NULL COMMENT '每天的报酬',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `activetext` varchar(99) DEFAULT NULL COMMENT '活动内容描述',
  PRIMARY KEY (`ptjobid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='兼职任务表';

-- ----------------------------
-- Records of parttimejob
-- ----------------------------

-- ----------------------------
-- Table structure for t_jurisdiction
-- ----------------------------
DROP TABLE IF EXISTS `t_jurisdiction`;
CREATE TABLE `t_jurisdiction` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `limits` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `hierarchy` varchar(32) DEFAULT NULL COMMENT '等级制度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_jurisdiction
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `iphone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `usernumber` varchar(32) DEFAULT NULL COMMENT '身份证号',
  `weixin` varchar(32) DEFAULT NULL COMMENT '微信号',
  `hierarchy` varchar(32) DEFAULT NULL COMMENT '等级制度',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
