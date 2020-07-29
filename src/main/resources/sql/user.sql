/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50637
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50637
 File Encoding         : 65001

 Date: 30/07/2020 00:52:58
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
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色（目前只有超级管理员和普通用户两种角色）',
  `deleted` int(2) NULL DEFAULT 0 COMMENT '删除标志 1：删除 0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 18, 'test1@baomidou.com', 'ADMIN', 0);
INSERT INTO `user` VALUES (2, 'Jack', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 20, 'test2@baomidou.com', 'USER', 0);
INSERT INTO `user` VALUES (3, 'Tom', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 28, 'test3@baomidou.com', 'USER', 0);
INSERT INTO `user` VALUES (4, 'Sandy', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 21, 'test4@baomidou.com', 'USER', 0);
INSERT INTO `user` VALUES (5, 'Billie', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 24, 'test5@baomidou.com', 'USER', 0);

SET FOREIGN_KEY_CHECKS = 1;
