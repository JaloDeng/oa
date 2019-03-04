/*
MARIADB Backup
Source Server Version: 5.5.60
Source Database: test
Date: 2019/2/26 11:37:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int(10) unsigned DEFAULT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `user` VALUES ('1','Jalo','20','2'), ('2','dwj','18','2'), ('3','J','20','1'), ('4','user','25','user@qq.com'), ('5','hello','10','hello@qq.com'), ('7','hi2','17',NULL);
