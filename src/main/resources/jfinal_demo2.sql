/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : jfinal_demo2

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-12-29 18:49:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog`
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'JFinal Demo Title here', 'JFinal Demo Content here');
INSERT INTO `blog` VALUES ('2', 'test 1', 'test 1');
INSERT INTO `blog` VALUES ('3', 'test 2', 'test 2');
INSERT INTO `blog` VALUES ('4', 'test 3', 'test 3');
INSERT INTO `blog` VALUES ('5', 'test 4', 'test 4');
INSERT INTO `blog` VALUES ('6', null, '2');

-- ----------------------------
-- Table structure for `upload`
-- ----------------------------
DROP TABLE IF EXISTS `upload`;
CREATE TABLE `upload` (
  `uploadid` bigint(20) NOT NULL AUTO_INCREMENT,
  `businessType` varchar(50) NOT NULL DEFAULT '',
  `originalFileName` varchar(100) DEFAULT NULL,
  `fileName` varchar(100) DEFAULT NULL,
  `contentType` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uploadid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES ('1', '', null, null, null);
INSERT INTO `upload` VALUES ('2', '', null, null, null);
INSERT INTO `upload` VALUES ('3', '', null, null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `age` int(3) NOT NULL,
  `address` varchar(255) NOT NULL,
  `birthday` date NOT NULL,
  `summary` longtext NOT NULL,
  `phone` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `url` varchar(200) NOT NULL,
  `idcard` varchar(18) NOT NULL,
  `picture` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=248 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('2', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('3', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('4', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('5', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('6', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('7', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('8', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('12', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('13', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('14', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('15', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('16', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('17', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('18', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('19', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('27', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('28', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('29', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('30', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('32', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('33', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('34', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('35', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('36', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('37', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('38', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('39', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('40', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('41', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('42', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('58', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('59', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('60', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('61', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('62', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('63', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('64', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('65', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('66', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('67', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('68', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('69', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('70', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('71', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('72', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('73', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('74', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('75', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('76', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('77', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('78', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('79', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('80', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('81', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('82', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('83', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('84', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('85', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('86', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('87', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('88', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('89', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('121', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('122', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('123', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('124', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('125', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('126', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('127', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('128', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('129', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('130', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('132', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('133', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('134', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('135', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('137', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('138', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('139', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('140', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('141', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('142', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('143', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('144', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('145', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('146', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('147', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('148', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('149', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('150', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('151', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('152', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('153', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('154', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('155', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('156', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('158', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('159', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('160', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('161', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('162', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('163', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('164', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('165', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('166', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('167', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('168', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('170', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('171', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('172', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('173', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('174', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('175', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('176', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('178', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('180', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
INSERT INTO `user` VALUES ('181', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null);
