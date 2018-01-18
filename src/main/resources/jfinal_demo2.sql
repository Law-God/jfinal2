/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : jfinal_demo2

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2018-01-18 16:17:45
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
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(100) DEFAULT NULL,
  `descript` varchar(1000) DEFAULT NULL,
  `content` longtext,
  `auth` varchar(100) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=819172 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('98298', 'Python 爬虫开发与项目实战', null, '<p>第 4 章 HTML 解析大法&nbsp;</p><p>HTML 网页数据解析提取是 Python 爬虫开发中非常关键的一步。HTML 网页的解析</p><p>提取有很多种方式，本章主要从三个方面进行讲解，分别为 Firebug 工具的使用、正则</p><p>表达式和 Beautiful soup，基本上涵盖了 HTML 网页数据解析提取的方方面面。</p><p>4.1 初识 Firebug&nbsp;</p><p>Firebug 是一个用于 Web 前端开发的工具，它是 FireFox 浏览器的一个扩展插件。它</p><p>可以用于调试 JavaScript、查看 DOM、分析 CSS、监控网络流量以及进行 Ajax 交互等。</p><p>它提供了几乎前端开发需要的全部功能，因此在 Python 爬虫开发中非常有用，尤其是</p><p>在分析协议和分析动态网站的时候，之后我们所有的分析场景都是基于这个工具，基于</p><p>FireFox 浏览器。Firebug 面板如图 4.1 所示：</p><p>图 4.1 Firebug 面板&nbsp;</p><p>大家如果之前用过 Firebug 会发现在面板上，多了一个 FirePath 的选项。FirePath 是</p><p>是 Firebug 上的一个扩展插件，它的功能主要是帮助我们精确定位网页中的元素，生成</p><p>XPath 或者是 CSS 查找路径表达式，在 Python 爬虫开发中抽取网页元素非常便利，省去</p><p>了手写 XPath 和 CSS 路径表达式的麻烦。FirePath 选项面板内容如图 4.2 所示：</p><p>图 4.2 FirePath 面板</p><p>4.1.1 安装 Firebug&nbsp;</p><p>由于 Firebug 是 Firefox 浏览器的一个扩展插件，所以首先需要下载 Firefox 浏览器。</p><p>读者可以访问 www.mozilla.com 下载并安装 Firefox 浏览器。安装完成后用它访问</p><p>https://addons.mozilla.org/zh-CN/firefox/collections/mozilla/webdeveloper/进入如图 4.3 所</p><p>示页面。点击\"添加到 Firefox\"，然后点击\"立即安装\"，最后重新启动 Firefox 浏览器即可</p><p>完成安装。</p><p>图 4.3 Firebug 下载页面</p><p>Firebug 安装完成后，为了扩展 Firebug 在路径选择上的功能，还需要安装 Firebug 的</p><p>插件 FirePath。打开火狐浏览器-&gt;设置-&gt;附件组件-&gt;搜索-&gt;输入 firepath，如图 4.4 所示：</p>', 'qiye_python', '2018-01-12 14:48:55');
INSERT INTO `book` VALUES ('98299', 'HTTP权威指南', null, '<p>前言</p><p>HTTP（Hypertext Transfer Protocol，超文本传输协议1）是在万维网上进行通信时所使用的协议方</p><p>案。HTTP 有很多应用，但最著名的是用于 Web 浏览器和 Web 服务器之间的双工通信。</p><p>HTTP 起初是一个简单的协议，因此你可能会认为关于这个协议没有太多好说的。但现在，你手上</p><p>拿着的却是一本将近两斤重的书。如果你想知道我们怎么会写出一本 700 多页的关于 HTTP 的</p><p>书，就去看看目录吧。本书不仅仅是一本 HTTP 首部参考手册，它还是一本名副其实的 Web 架</p><p>构“圣经”。</p><p>本书中，我们会将 HTTP 中一些互相关联且常被误解的规则梳理清楚，并编写了一系列基于各种主</p><p>题的章节介绍 HTTP 各方面的特性。纵观全书，我们对 HTTP“为什么”这样做进行了详细的解释，</p><p>而不仅仅停留在它是“怎么做”的。而且，为了节省大家寻找参考文献的时间，我们还介绍了很多</p><p>HTTP 应用程序正常工作所必需且重要的非 HTTP 技术。在条理清晰的附录中，可以找到按照字母</p><p>排序的首部参考（这些首部构成了最常见的 HTTP 文本的基础）。我们希望这种概念性的设计有助</p><p>于读者更好地使用 HTTP。</p><p>本书是为所有希望理解 HTTP 和 Web 底层结构的人编写的。软硬件工程师也可以将本书作为</p><p>HTTP 及相关 Web 技术参考书使用。系统架构师和网络管理员可以通过本书更好地了解如何设</p><p>计、实现并管理复杂的网络架构。性能工程师和分析人员可以从缓存和性能优化的相关章节中获</p><p>益。市场营销和咨询专家还可以通过概念介绍更好地理解 Web 技术的前景。</p><p>1 HTTP 译为“超文本传输协议”，其中“transfer”使用了“传输”的含义，但依据 HTTP 制定者之一 Roy Fielding 博士的论</p><p>文，“transfer”表示的是“（状态的）转移”，而不是“传输”。怎样翻译才更符合 HTTP 的原意，其讨论可参见图灵社区的文章，地址是</p><p>ituring.com.cn/article/details/1817。</p><p>本书澄清了一些常见的误解，推荐了“各种业内诀窍”，提供了便捷的参考资料，并且用通俗易懂的</p><p>语言阐述了枯燥且令人费解的标准规范，还详细探讨了 Web 正常工作所必需且互相关联的技术。</p><p>本书创作历时良久，是由很多热衷于因特网技术的人共同完成的，希望它能对你有所帮助。</p><p>运行实例：Joe的五金商店</p><p>本书的很多章节都涉及了一个假想的在线五金与家装商店示例，通过这个“Joe 的五金商店”来说</p><p>明一些技术概念。我们为这个商店构建了一个真实的 Web 站点（http://www.joes-hardware.com），以</p><p>便大家能够测试书中的部分实例。只要本书仍在销售，我们就会一直维护好这个 Web 站点。</p>', '陈涓， 赵振平', '2018-01-12 14:49:21');

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', '图片1', '45');
INSERT INTO `picture` VALUES ('2', '图片2', '46');
INSERT INTO `picture` VALUES ('3', '图片3', '47');
INSERT INTO `picture` VALUES ('4', '图片4', '48');
INSERT INTO `picture` VALUES ('5', 'aaa', '64');

-- ----------------------------
-- Table structure for `test`
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `testId` bigint(20) NOT NULL AUTO_INCREMENT,
  `picture` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `file` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `username` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`testId`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('29', '1', '2', '2018-01-10 12:39:32', '张三3');
INSERT INTO `test` VALUES ('30', '827ccb0eea8a706c4c34a16891f84e7b', '62', '2018-01-10 12:39:38', '张三4');

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

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
INSERT INTO `upload` VALUES ('49', 'test', '5.png', '57.png', 'image/png', 'password');
INSERT INTO `upload` VALUES ('50', 'test', '5.png', '58.png', 'image/png', 'password');
INSERT INTO `upload` VALUES ('51', '', null, null, null, null);
INSERT INTO `upload` VALUES ('52', '', null, null, null, null);
INSERT INTO `upload` VALUES ('53', '', null, null, null, null);
INSERT INTO `upload` VALUES ('54', 'test', '5.png', '510.png', 'image/png', 'password');
INSERT INTO `upload` VALUES ('55', 'test', '5.png', '511.png', 'image/png', 'password');
INSERT INTO `upload` VALUES ('56', 'test', '5.png', '512.png', 'image/png', 'picture');
INSERT INTO `upload` VALUES ('57', 'test', '新建文本文档 (2).txt', '新建文本文档 (2)2.txt', 'text/plain', 'file');
INSERT INTO `upload` VALUES ('58', 'test', '5.png', '513.png', 'image/png', 'picture');
INSERT INTO `upload` VALUES ('59', 'test', '新建文本文档 (2).txt', '新建文本文档 (2)3.txt', 'text/plain', 'file');
INSERT INTO `upload` VALUES ('60', 'test', '5.png', '514.png', 'image/png', 'picture');
INSERT INTO `upload` VALUES ('61', 'test', '5.png', '515.png', 'image/png', 'file');
INSERT INTO `upload` VALUES ('62', 'test', '5 - 副本.jpg', '5 - 副本9.jpg', 'image/jpeg', 'file');
INSERT INTO `upload` VALUES ('63', 'picture', '20160330033309925.jpg', '2016033003330992519.jpg', 'image/jpeg', 'picture');
INSERT INTO `upload` VALUES ('64', 'picture', '20160330033309925.jpg', '2016033003330992520.jpg', 'image/jpeg', 'pictureId');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `summary` longtext,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `idcard` varchar(18) DEFAULT NULL,
  `picture` varchar(200) DEFAULT NULL,
  `file` varchar(200) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=263 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '中国共wanyin和国', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('2', '中国', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('3', '中', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('4', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('5', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('6', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('7', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('8', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('12', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('13', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('14', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('15', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('16', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('17', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('18', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('19', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('27', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('28', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('29', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('30', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('32', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('33', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('34', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('35', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('36', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('37', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('38', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('39', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('40', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('41', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('42', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('58', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('59', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('60', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('61', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('62', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('65', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('66', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('67', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('68', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('69', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('70', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('71', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('72', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('73', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('74', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('75', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('76', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('77', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('78', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('79', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('80', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('81', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('82', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('83', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('84', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('85', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('86', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('87', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('88', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('89', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('121', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('122', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('123', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('124', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('125', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('126', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('127', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('128', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('129', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('130', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('132', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('133', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('134', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('135', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('137', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('138', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('139', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('140', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('141', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('142', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('143', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('144', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('145', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('146', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('147', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('148', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('149', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('150', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('151', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('152', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('153', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('154', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('155', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('156', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('158', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('159', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('160', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('161', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('162', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('163', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('164', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('165', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('166', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('167', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('168', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('170', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('171', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('172', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('173', '张三2', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('174', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('175', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('176', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('178', '123', '12', 'sdf', '2017-12-29', 'sdfsf', '13000000000', '11@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('180', '123', '1', 'sdf', '2017-12-29', 'sd', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('181', '233', '123', 'sdfsd', '2017-12-29', '1231', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('248', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('249', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('250', '123', '1', 'sfa', '2017-12-30', 'sdfs', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('251', '234', '12', 'sdf', '2017-12-30', '123', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('252', '345', '12', 'dfsa', '2017-12-30', 'sdf', '13100000000', '123@qq.com', 'http://123.com', '352227198807270511', null, null, null, null);
INSERT INTO `user` VALUES ('254', '312', '12', '123', '2017-12-30', '123', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', '5', null, null, null);
INSERT INTO `user` VALUES ('255', '567', '12', '1231', '2017-12-30', '12312', '13100000000', '123@qq.com', 'http://www.baiud.com', '352227198807270511', '11', null, null, null);
INSERT INTO `user` VALUES ('256', '123', '12', '123', '2017-12-30', '12312', '13100000000', '123@qq.com', 'http://www.baiud.com', '352227198707210511', '12', null, null, null);
INSERT INTO `user` VALUES ('257', '234', '22', '123', '2017-12-30', '123', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', '24', null, null, null);
INSERT INTO `user` VALUES ('258', '123', '12', '123', '2017-12-30', '123123', '13100000000', '12@qq.com', 'http://www.baidu.com', '352227198807270511', '25', null, null, null);
INSERT INTO `user` VALUES ('259', '555', '12', '123', '2017-12-30', '1231', '13100000000', '123@qq.com', 'http:///www.baidu.com', '352227198807270511', '26', null, null, null);
INSERT INTO `user` VALUES ('260', '777', '12', '123', '2017-12-31', '1231', '13100000000', 'qw@qq.com', 'http://www.baidu.com', '352227198807270511', 'picture', 'file', '0', null);
INSERT INTO `user` VALUES ('261', '888', '12', '123', '2017-12-31', '<img src=\"http://localhost:8080/js/layui/images/face/53.gif\" alt=\"[耶]\"><img src=\"http://localhost:8080/js/layui/images/face/30.gif\" alt=\"[思考]\">', '13100000000', '123@qq.com', 'http://www.baidu.com', '352227198807270511', '42', '43', '1', null);
INSERT INTO `user` VALUES ('262', 'zhangsan', null, null, null, null, null, null, null, null, null, null, null, 'e10adc3949ba59abbe56e057f20f883e');

-- ----------------------------
-- Table structure for `user_tokens`
-- ----------------------------
DROP TABLE IF EXISTS `user_tokens`;
CREATE TABLE `user_tokens` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL,
  `userAgent` varchar(40) DEFAULT '' COMMENT 'MD5值',
  `token` varchar(40) DEFAULT NULL COMMENT 'md5(username+md5(user_agent))',
  `type` varchar(100) DEFAULT NULL,
  `created` int(10) DEFAULT NULL,
  `expires` int(10) DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_token` (`token`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_tokens
-- ----------------------------
INSERT INTO `user_tokens` VALUES ('1', null, 'ab61034f6d30eea81e4d4f03995f2094', 'ecbef098320fc79cb5deca6c98410579', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('2', null, '19a69954dea70cf22871e377a1b45dfb', 'aa272d98ea7adc45f386d6c5f08dfda0', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('3', null, 'ee43b75b049234f9598ef610d374d5f6', 'bb28a6dfa17c675a9d58e1287440692c', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('4', null, '1cbcfb58d0e2bda187298815cb6e99df', '5af239b0a2e888d4f5e5cd9fd07521d8', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('5', null, '9b221dbf1b9f4dcbdaf0581608e63c1f', '717a4315129ef18aeb380c9de78c4466', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('6', null, '4477d6866612399bab0fca02b0ff8550', 'ad362f6fbcd522d702104362f51d7e75', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('7', null, 'fba122c9c9101615916dcb813953966a', '1f2b1cbea2644aae2846adbfec1d8917', null, null, '2592000');
INSERT INTO `user_tokens` VALUES ('8', '262', 'da8cecf1203b3e80938855ebae7a893d', '12cdf95b7b93a10df253f3763c148db1', null, null, '2592000');
