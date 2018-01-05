/*
Navicat MySQL Data Transfer

Source Server         : 测试
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-01-05 16:24:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `age` int(11) default NULL,
  `address` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小张', '26', '北京朝阳');
INSERT INTO `user` VALUES ('2', '小飞', '24', '北京顺义');
INSERT INTO `user` VALUES ('3', '小王', '25', '北京海淀');
INSERT INTO `user` VALUES ('4', '1234567', '28', '美国');
INSERT INTO `user` VALUES ('5', '黄晓明', '25', '北京三里屯');
INSERT INTO `user` VALUES ('6', '小胖', '28', '北京海淀');
INSERT INTO `user` VALUES ('7', '小胖', '24', '北京海淀');
INSERT INTO `user` VALUES ('8', '小胖', '25', '北京海淀');
INSERT INTO `user` VALUES ('12', '聂风', '25', '天下会');
INSERT INTO `user` VALUES ('13', '小胖', '25', '北京顺义');
