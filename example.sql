/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : example

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 15/12/2021 14:39:33
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
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ex_role
-- ----------------------------

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

-- ----------------------------
-- Table structure for ex_user
-- ----------------------------
DROP TABLE IF EXISTS `ex_user`;
CREATE TABLE `ex_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户姓名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `identity` smallint(6) NOT NULL DEFAULT 0 COMMENT '用户身份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ex_user
-- ----------------------------
INSERT INTO `ex_user` VALUES (1, '张三', '123', 0);
INSERT INTO `ex_user` VALUES (2, '李四', '123', 0);
INSERT INTO `ex_user` VALUES (3, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (4, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (5, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (6, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (7, 'admin', 'admin', 0);
INSERT INTO `ex_user` VALUES (8, 'admin', 'admin', 0);
INSERT INTO `ex_user` VALUES (9, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (10, '王二麻', '123', 0);
INSERT INTO `ex_user` VALUES (11, '王二麻', '123', 0);

SET FOREIGN_KEY_CHECKS = 1;
