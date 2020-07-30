/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : 127.0.0.1:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/07/2020 11:00:06
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
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号，用户登录时输入的用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `gender` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 F: 女 M:男 ',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色（目前只有超级管理员和普通用户两种角色）',
  `created_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modified_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  `deleted` int(2) NULL DEFAULT 0 COMMENT '删除标志： 1：删除 0：未删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Jone', '17783715544', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 'F', 18, 'test1@baomidou.com', 'ADMIN', '2020-07-30 10:21:35', '2020-07-30 10:21:54', 0);
INSERT INTO `user` VALUES (2, 'Jack', '17783715545', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 'F', 20, 'test2@baomidou.com', 'USER', '2020-07-30 10:21:38', '2020-07-30 10:21:58', 0);
INSERT INTO `user` VALUES (3, 'Tom', '17783715546', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 'F', 28, 'test3@baomidou.com', 'USER', '2020-07-30 10:21:41', '2020-07-30 10:21:58', 0);
INSERT INTO `user` VALUES (4, 'Sandy', '17783715547', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 'F', 21, 'test4@baomidou.com', 'USER', '2020-07-30 10:21:46', '2020-07-30 10:21:58', 0);
INSERT INTO `user` VALUES (5, 'Billie', '17783715548', '$2a$10$WD3M6xRnSiBoTwMdVURpFe.zdJzGhwtZmQerYSiWc5X/p7ABEjXUq', 'M', 24, 'test5@baomidou.com', 'USER', '2020-07-30 10:21:48', '2020-07-30 10:21:58', 0);

SET FOREIGN_KEY_CHECKS = 1;
