/*
 Navicat Premium Data Transfer

 Source Server         : blogs1
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39-0ubuntu0.22.04.1)
 Source Host           : 123.57.23.218:3306
 Source Schema         : blogs

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39-0ubuntu0.22.04.1)
 File Encoding         : 65001

 Date: 18/08/2024 17:31:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章表id',
  `main` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章表正文',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, '2222');
INSERT INTO `article` VALUES (3, '\r\n<h1>This is a Heading</h1>\r\n<p>This is a paragraph.</p>\r\n<img src=\"avatar.png\" alt=\"Avatar\" style=\"width:200px\">');
INSERT INTO `article` VALUES (4, '111');
INSERT INTO `article` VALUES (5, '肉丁数联文章介绍');
INSERT INTO `article` VALUES (6, '个人博客文章介绍');

-- ----------------------------
-- Table structure for article_category
-- ----------------------------
DROP TABLE IF EXISTS `article_category`;
CREATE TABLE `article_category`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章类别表主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文章类别名称',
  `navitem_id` int NULL DEFAULT NULL COMMENT '导航项id',
  `pid` int NULL DEFAULT NULL COMMENT '父级类别id',
  `category_id` int NULL DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文章类别表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article_category
-- ----------------------------
INSERT INTO `article_category` VALUES (1, '企业项目', 2, NULL, NULL);
INSERT INTO `article_category` VALUES (2, 'SpringBoot', 5, NULL, NULL);
INSERT INTO `article_category` VALUES (3, 'spingboot文章1', 5, 2, 1);
INSERT INTO `article_category` VALUES (4, 'springboot2', NULL, 2, 2);
INSERT INTO `article_category` VALUES (5, '肉丁数联Saas平台', 3, NULL, 5);
INSERT INTO `article_category` VALUES (6, 'Java', 5, NULL, NULL);
INSERT INTO `article_category` VALUES (7, 'Mysql', 5, NULL, NULL);
INSERT INTO `article_category` VALUES (8, '个人博客', 4, NULL, 6);
INSERT INTO `article_category` VALUES (9, 'java1', 5, 6, 3);
INSERT INTO `article_category` VALUES (10, '前端被淘汰了吗？', 6, NULL, 3);
INSERT INTO `article_category` VALUES (11, 'Springboot3新特性', 6, NULL, 1);
INSERT INTO `article_category` VALUES (12, 'md文档和html转换', 7, NULL, 3);

-- ----------------------------
-- Table structure for blogs_home
-- ----------------------------
DROP TABLE IF EXISTS `blogs_home`;
CREATE TABLE `blogs_home`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '首页id',
  `github` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'github',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `wechat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系方式图片',
  `main_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '主页介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '博客主页表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of blogs_home
-- ----------------------------
INSERT INTO `blogs_home` VALUES (1, 'https://github.com/dengqizhang', '2435563017@qq.com', 'https://th.bing.com/th/id/R.6b5df1bfe0e4778a44dba0753cd169c8?rik=QRQIMqvjWRCO5Q&riu=http%3a%2f%2fpic39.nipic.com%2f20140321%2f8857347_232251363165_2.jpg&ehk=7oAaMo6LCHJc%2bqpQ0IPvcH7v69jGRQhb2vDz%2fOd5720%3d&risl=&pid=ImgRaw&r=0', '内容包含SpringBoot，Java，JVM，SpringCloud，Docker等。我的项目经历以及网络杂谈，工具收集等。');

-- ----------------------------
-- Table structure for navitem
-- ----------------------------
DROP TABLE IF EXISTS `navitem`;
CREATE TABLE `navitem`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '导航项主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导航项名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '导航项路径',
  `pid` int NULL DEFAULT NULL COMMENT '父级导航项id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '导航项表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of navitem
-- ----------------------------
INSERT INTO `navitem` VALUES (1, '首页', '/', NULL);
INSERT INTO `navitem` VALUES (2, '项目经历', '/projectExperience', NULL);
INSERT INTO `navitem` VALUES (3, '肉丁数联Saas平台', '/roudingSaas', 2);
INSERT INTO `navitem` VALUES (4, '个人博客', '/caryBiogs', 2);
INSERT INTO `navitem` VALUES (5, '技术积累', '/technology', NULL);
INSERT INTO `navitem` VALUES (6, '网络杂谈', '/tittleTattle', NULL);
INSERT INTO `navitem` VALUES (7, '工具收集', '/tool', NULL);

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '项目表',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目标题',
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目介绍',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '项目地址',
  `project_type` int NULL DEFAULT NULL COMMENT '1:(更新计划)，2：(必看专栏)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '项目表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, 'parameter-log-tool', 'SpringBoot日志参数记录工具插件,用于记录方法的入参出参值，并将日志打印到文档中。', 'https://github.com/dengqizhang/parameter-log-tool', 1);
INSERT INTO `project` VALUES (2, 'cary-biogs', '个人博客的前端地址，预计打造成一个动态前端，可配置化渲染页面。', NULL, 1);
INSERT INTO `project` VALUES (3, 'KAP', '面试题及知识点整理仓库。', NULL, 1);
INSERT INTO `project` VALUES (4, 'parameter-log-tool', 'SpringBoot日志参数记录工具插件,用于记录方法的入参出参值，并将日志打印到文档中。', NULL, 2);

SET FOREIGN_KEY_CHECKS = 1;
