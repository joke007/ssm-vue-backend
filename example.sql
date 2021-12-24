/*
 Navicat Premium Data Transfer

 Source Server         : 远程
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.35.44.70:3306
 Source Schema         : example

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 23/12/2021 13:50:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ex_role
-- ----------------------------
DROP TABLE IF EXISTS `ex_role`;
CREATE TABLE `ex_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ex_role
-- ----------------------------
INSERT INTO `ex_role` VALUES (1, '普通用户');
INSERT INTO `ex_role` VALUES (2, '管理员');
INSERT INTO `ex_role` VALUES (3, '超级管理员');

-- ----------------------------
-- Table structure for ex_role_user
-- ----------------------------
DROP TABLE IF EXISTS `ex_role_user`;
CREATE TABLE `ex_role_user`  (
  `userId` int(11) NOT NULL COMMENT '用户id',
  `roleId` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`userId`, `roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ex_role_user
-- ----------------------------
INSERT INTO `ex_role_user` VALUES (40, 1);
INSERT INTO `ex_role_user` VALUES (41, 2);

-- ----------------------------
-- Table structure for ex_user
-- ----------------------------
DROP TABLE IF EXISTS `ex_user`;
CREATE TABLE `ex_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ex_user
-- ----------------------------
INSERT INTO `ex_user` VALUES (40, 'user', '25f9e794323b453885f5181f1b624d0b');
INSERT INTO `ex_user` VALUES (41, 'admin', '5d4565b02217e1761d3b981c1f1c6878');

SET FOREIGN_KEY_CHECKS = 1;
