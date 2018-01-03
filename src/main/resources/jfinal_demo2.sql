/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : jfinal_demo2

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2018-01-03 23:09:29
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
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `itemId` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemCode` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `itemSup` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `itemName` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `itemUrl` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  `enable` char(1) CHARACTER SET utf8 DEFAULT NULL,
  `itemSub` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`itemId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', 'item', '0', '菜单管理', '/item', '2018-01-01 00:00:00', '1', '0');
INSERT INTO `item` VALUES ('2', 'user', '0', '用户管理', '/user', '2018-01-01 00:00:00', '1', '0');
INSERT INTO `item` VALUES ('3', 'code', '0', '代码配置', '/code', '2018-01-01 00:00:00', '1', '0');
INSERT INTO `item` VALUES ('4', 'pic', '0', '首页图片', '/picture', '2018-01-01 00:00:00', '1', '0');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` bigint(20) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `createTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `errorStack` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1', '/', '2018-01-03 00:00:00', null);

-- ----------------------------
-- Table structure for `picture`
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `pictureId` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '图片1', '45');
INSERT INTO `picture` VALUES ('2', '图片2', '46');
INSERT INTO `picture` VALUES ('3', '图片3', '47');
INSERT INTO `picture` VALUES ('4', '图片4', '48');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `testId` bigint(20) NOT NULL AUTO_INCREMENT,
  `book` varchar(100) DEFAULT NULL,
  `password` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`testId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------

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
  `businessField` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uploadid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upload
-- ----------------------------
INSERT INTO `upload` VALUES ('6', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482592.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('7', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482592.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('8', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482592.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('9', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482592.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('10', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482592.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('11', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482593.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('12', 'user', 'mmexport1506515848259.jpeg', 'mmexport1506515848259.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('13', 'user', 'mmexport1506515848259.jpeg', 'mmexport15065158482599.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('14', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('15', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('16', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('17', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('18', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('19', 'user', 'wx_camera_1497853140729.jpg', 'wx_camera_1497853140729.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('20', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825910.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('24', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825914.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('25', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825915.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('26', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825916.jpeg', null, null);
INSERT INTO `upload` VALUES ('27', 'user', 'wx_camera_1497324148595.jpg', 'wx_camera_14973241485951.jpg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('28', '', null, null, null, null);
INSERT INTO `upload` VALUES ('29', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825932.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('30', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825933.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('31', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825935.jpeg', 'image/jpeg', null);
INSERT INTO `upload` VALUES ('32', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825936.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('33', 'user', 'wx_camera_1497678518033.jpg', 'wx_camera_14976785180337.jpg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('34', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825939.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('35', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825940.jpeg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('36', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825939.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('37', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825940.jpeg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('38', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825939.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('39', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825940.jpeg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('40', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825941.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('41', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825942.jpeg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('42', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825943.jpeg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('43', 'user', 'mmexport1506515848259.jpeg', 'mmexport150651584825944.jpeg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('44', 'picture', '桌布20171005-天虎令.jpg', '桌布20171005-天虎令.jpg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('45', 'picture', '桌布20171005-天虎令.jpg', '桌布20171005-天虎令.jpg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('46', 'picture', '桌布20170804-江山快手.jpg', '桌布20170804-江山快手.jpg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('47', 'picture', '桌布20170602-九千勝.jpg', '桌布20170602-九千勝.jpg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('48', 'picture', '桌布20171014-赤龍影.jpg', '桌布20171014-赤龍影.jpg', 'image/jpeg', 'picture');

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
  `file` varchar(200) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=262 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('2', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('3', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('4', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('5', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('6', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('7', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('8', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('12', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('13', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('14', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('15', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('16', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('17', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('18', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('19', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('27', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('28', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('29', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('30', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('32', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('33', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('34', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('35', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('36', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('37', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('38', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('39', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('40', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('41', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('42', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('58', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('59', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('60', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('61', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('62', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('65', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('66', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('67', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('68', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('69', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('70', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('71', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('72', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('73', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('74', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('75', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('76', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('77', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('78', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('79', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('80', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('81', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('82', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('83', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('84', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('85', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('86', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('87', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('88', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('89', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('121', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('122', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('123', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('124', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('125', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('126', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('127', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('128', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('129', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('130', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('132', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('133', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('134', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('135', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('137', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('138', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('139', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('140', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('141', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('142', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('143', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('144', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('145', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('146', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('147', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('148', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('149', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('150', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('151', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('152', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('153', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('154', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('155', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('156', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('158', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('159', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('160', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('161', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('162', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('163', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('164', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('165', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('166', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('167', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('168', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('170', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('171', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('172', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('173', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('174', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('175', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('176', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('178', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('180', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('181', '233', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('248', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('249', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('250', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('251', '234', '12', 'sdf', '2017-12-30', '123', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('252', '345', '12', 'dfsa', '2017-12-30', 'sdf', '13100000000', '123@qq.com', 'http://123.com', '352227198807270511', null, null, null);
INSERT INTO `user` VALUES ('254', '312', '12', '123', '2017-12-30', '123', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', '5', null, null);
INSERT INTO `user` VALUES ('255', '567', '12', '1231', '2017-12-30', '12312', '13100000000', '123@qq.com', 'http://www.baiud.com', '352227198807270511', '11', null, null);
INSERT INTO `user` VALUES ('256', '123', '12', '123', '2017-12-30', '12312', '13100000000', '123@qq.com', 'http://www.baiud.com', '352227198707210511', '12', null, null);
INSERT INTO `user` VALUES ('257', '234', '22', '123', '2017-12-30', '123', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', '24', null, null);
INSERT INTO `user` VALUES ('258', '123', '12', '123', '2017-12-30', '123123', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', '25', null, null);
INSERT INTO `user` VALUES ('259', '555', '12', '123', '2017-12-30', '1231', '13100000000', '123@qq.com', 'http:///www.baidu.com', '352227198807270511', '26', null, null);
INSERT INTO `user` VALUES ('260', '777', '12', '123', '2017-12-31', '1231', '13100000000', 'qw@qq.com', 'http://www.baidu.com', '352227198807270511', 'picture', 'file', '0');
INSERT INTO `user` VALUES ('261', '888', '12', '123', '2017-12-31', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', '42', '43', '1');
