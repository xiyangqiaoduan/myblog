/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-05-12 16:04:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` varchar(64) DEFAULT NULL,
  `article_title` varchar(200) DEFAULT NULL,
  `article_abstract` tinytext,
  `article_content` text,
  `article_create_date` datetime DEFAULT NULL,
  `article_update_date` datetime DEFAULT NULL,
  `article_tags` tinytext,
  `article_comment_count` int(11) DEFAULT NULL,
  `article_view_count` int(11) DEFAULT NULL,
  `article_sign_id` varchar(200) DEFAULT NULL,
  `article_perma_link` varchar(200) DEFAULT NULL,
  `article_puttop` tinyint(1) DEFAULT NULL,
  `article_is_published` tinyint(1) DEFAULT NULL,
  `article_had_been_published` tinyint(1) DEFAULT NULL,
  `article_random_double` double DEFAULT NULL,
  `article_commentable` tinyint(1) DEFAULT NULL,
  `article_view_pwd` varchar(64) DEFAULT NULL,
  `article_editor_type` varchar(200) DEFAULT NULL,
  `article_author_rmail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------

-- ----------------------------
-- Table structure for blog_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `id` varchar(64) NOT NULL,
  `article_id` varchar(64) NOT NULL,
  `tag_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article_tag
-- ----------------------------

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` varchar(64) NOT NULL,
  `comment_content` tinytext,
  `comment_name` varchar(200) DEFAULT NULL,
  `comment_email` varchar(100) DEFAULT NULL,
  `comment_sharp_url` varchar(200) DEFAULT NULL,
  `comment_url` varchar(200) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_ip` varchar(200) DEFAULT NULL,
  `comment_thumbnail_url` varchar(200) DEFAULT NULL,
  `comment_on_id` varchar(64) DEFAULT NULL,
  `comment_on_type` varchar(200) DEFAULT NULL,
  `comment_original_comment_id` varchar(64) DEFAULT NULL,
  `comment_original_comment_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_option
-- ----------------------------
DROP TABLE IF EXISTS `blog_option`;
CREATE TABLE `blog_option` (
  `key` varchar(200) DEFAULT NULL,
  `option_value` tinytext,
  `option_category` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_option
-- ----------------------------

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` varchar(64) NOT NULL,
  `tag_title` varchar(200) DEFAULT NULL,
  `tag_reference_count` int(11) DEFAULT NULL,
  `tag_published_refCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` varchar(64) NOT NULL,
  `user_email` varchar(200) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `user_url` varchar(200) DEFAULT NULL,
  `user_password` varchar(64) DEFAULT NULL,
  `user_role` varchar(100) DEFAULT NULL,
  `user_article_count` int(11) DEFAULT NULL,
  `user_published_article_count` int(11) DEFAULT NULL,
  `user_vatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1', '1@123.com', '1', '1', '1', '1', '1', '1', '1');
