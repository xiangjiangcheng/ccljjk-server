/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : logistics

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 29/07/2020 18:13:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `deleted` int(2) NULL DEFAULT 0 COMMENT '删除标志 1：删除 0：未删除',
  `roles` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', 18, 'test1@baomidou.com', 0, 'ROLE_LEVEL1,ROLE_LEVEL2,,ROLE_LEVEL3');
INSERT INTO `user` VALUES (2, 'Jack', 20, 'test2@baomidou.com', 0, 'ROLE_LEVEL1,ROLE_LEVEL2');
INSERT INTO `user` VALUES (3, 'Tom', 28, 'test3@baomidou.com', 0, 'ROLE_LEVEL1,ROLE_LEVEL2');
INSERT INTO `user` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', 0, 'ROLE_LEVEL1,ROLE_LEVEL2');
INSERT INTO `user` VALUES (5, 'Billie', 24, 'test5@baomidou.com', 0, 'ROLE_LEVEL1,ROLE_LEVEL2');

SET FOREIGN_KEY_CHECKS = 1;
