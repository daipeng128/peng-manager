/*
 Navicat MySQL Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : peng

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 19/07/2019 19:58:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role` varchar(50) DEFAULT NULL COMMENT '角色',
  `description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `yn` int(11) DEFAULT NULL COMMENT '0 启用 1 禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, '老师', '老师', 0);
INSERT INTO `t_role` VALUES (2, '校长', '校长', 0);
INSERT INTO `t_role` VALUES (3, '董事长', 'sss', 0);
INSERT INTO `t_role` VALUES (4, '董事长秘书', '秘书', 0);
INSERT INTO `t_role` VALUES (5, '家长', '家长', 0);
INSERT INTO `t_role` VALUES (6, '学生', '学生', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(60) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL,
  `phone` varchar(60) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `portrait_url` varchar(60) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `yn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'peng', 'e836fd910f8131b760e86c6573723852', '17600299987', NULL, NULL, NULL, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户表主键',
  `role_id` int(11) NOT NULL COMMENT '角色表主键',
  `yn` int(11) DEFAULT NULL COMMENT '0 启用 1 禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1, 1, 1);
INSERT INTO `t_user_role` VALUES (6, 1, 4, 1);
INSERT INTO `t_user_role` VALUES (7, 1, 4, 1);
INSERT INTO `t_user_role` VALUES (8, 1, 4, 1);
INSERT INTO `t_user_role` VALUES (9, 1, 2, 1);
INSERT INTO `t_user_role` VALUES (10, 1, 3, 1);
INSERT INTO `t_user_role` VALUES (11, 1, 4, 1);
INSERT INTO `t_user_role` VALUES (12, 1, 2, 1);
INSERT INTO `t_user_role` VALUES (13, 1, 3, 1);
INSERT INTO `t_user_role` VALUES (14, 1, 4, 1);
INSERT INTO `t_user_role` VALUES (15, 1, 5, 1);
INSERT INTO `t_user_role` VALUES (16, 1, 1, 0);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
