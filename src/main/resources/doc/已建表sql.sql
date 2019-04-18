-- MySQL dump 10.13  Distrib 8.0.14, for Win64 (x86_64)
--
-- Host: localhost    Database: namecard_master
-- ------------------------------------------------------
-- Server version	8.0.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `core_attachment`
--

DROP TABLE IF EXISTS `core_attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `core_attachment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `uid` int(10) unsigned NOT NULL,
  `filename` varchar(255) NOT NULL,
  `path` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `createtime` int(10) unsigned NOT NULL,
  `module_upload_dir` varchar(100) NOT NULL,
  `group_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `core_attachment`
--

LOCK TABLES `core_attachment` WRITE;
/*!40000 ALTER TABLE `core_attachment` DISABLE KEYS */;
/*!40000 ALTER TABLE `core_attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_account_wxapp`
--

DROP TABLE IF EXISTS `ims_account_wxapp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_account_wxapp` (
  `acid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) NOT NULL,
  `token` varchar(32) NOT NULL,
  `encodingaeskey` varchar(43) NOT NULL,
  `level` tinyint(4) NOT NULL,
  `account` varchar(30) NOT NULL,
  `original` varchar(50) NOT NULL,
  `key` varchar(50) NOT NULL,
  `secret` varchar(50) NOT NULL,
  `name` varchar(30) NOT NULL,
  `appdomain` varchar(255) NOT NULL,
  PRIMARY KEY (`acid`),
  KEY `uniacid` (`uniacid`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_account_wxapp`
--

LOCK TABLES `ims_account_wxapp` WRITE;
/*!40000 ALTER TABLE `ims_account_wxapp` DISABLE KEYS */;
INSERT INTO `ims_account_wxapp` VALUES (6,6,'ZZo2i225T59oy925v9jK8g72TwdiWq4O','e5cp1828pc2812PAC32As3nbI2l5N10r3NPbOC6Is8L',1,'','gh_36d5fb6633ea','wx07062296ba4d72fa','794da5e73f633d3ec3eadbb9cd0b351c','同城智慧名片',''),(4,4,'NlM2t2Y5Nn41Mw7ql5knTMW2M3KtXXXx','cIu9vv7Qz65jvA5ioZTQ07g5uKE9EtKba09WQ9k5uU9',1,'','gh_5bb1f11b8c0a','wxa2874b7d7fbc68e7','849f7c0f41c50cf5d35e7da055c1b576','承德小程序制作',''),(5,5,'BMzLI1t31T4991133jL9yn91q15llbgL','R9mfIt868Ih55M58156oLI86rhi6i18TLTtktB55L15',1,'','gh_67bf1c69f980','wxd962cf7ddc966aaf','2432966e943c11afab156e05c367fb26','众维互赢',''),(7,7,'jQnv8W2npWfaqAJ8cpzWzcK8xnjvvceq','l2435MCQ2C5R2j7Aqsck3n3Z343Eq1n2522a5273EJ4',1,'','gh_374a71f29315','wx0110fc581063049d','e5e7a2c51095bb8584a834b504419b09','彩艺美发',''),(8,8,'d51p4W5n9JZ5ZoNeW9ejZ9i64Jn1jNn2','EObLihOrY98RyuqOW11llOh1iAIyoh98Uqt1R11Zh1a',1,'','gh_dbb3d035d355','wx3e92a65c76016eed','6555739b358a01e9e82211b016312737','新思路美发',''),(9,9,'Pg1qfDLIK9K1R6jIDNNC3GJlZijZliJl','M2mFLLG2cG9gFG1mpHP2hlCH99gRwgFfBM90FB1w1gm',1,'','gh_bc2cd703091e','wxd0ec9e050c3d6518','0a604cff3bcec0e08120384d319bdbd3','建材行业案例',''),(10,10,'wuUYFLU2dLE33ua3ZjU6bU2eSSJL3sjU','Vz8428e4Q77e8HlN4RRH8l4zKe8wufMnz44mfV48nE8',1,'','gh_e921dfda1522','wx375f7dbf4119b0ab','7c24516a60b00643fbdad38333ff6f5a','baby母婴馆',''),(11,11,'p288dO1eJO2sPoE8sOsPe2Yp28S3SdpO','u2B4KRBb7oBz2R2kAKr292CYy9vdaR42db28k4O6c24',1,'','gh_4b19d71e642c','wx95830afe06c6a0f5','b74020d90e812d3f343e189c2e232bac','承德通程泰合装饰工程有限公司',''),(12,12,'j17mZl5iN5WlBG7GwM75cQL715l2W755','blJ7c7gEmzWmjCLlGw1YMJicWbo12Z6L76W7g7CZLGo',1,'','gh_6f8b0fc3ad12','wx5a2326ab5d8e2187','4566d3c31ae8584fa0416467a15d8c34','鱼乐baby婴幼儿水育馆',''),(13,13,'WQ0WRIbOVR1nQQ10BNoIqWWnxoWXRVIz','yCzCWss5W2kZzD1Srj5d1SFLVJkWmwsVLsAsS4RIMKD',1,'','gh_b55dfc6acfb7','wx8f376eabd7f68746','25d3d363b819c6eb7e259a13c7967dde','终南独一方体验中心',''),(14,14,'Lu0pK8LWzg1L18kK0s2SwKu9B1n1USgl','TYjUfkPub79KFzM6QQ2I68yzMk7oYDO9kO5JK775JK9',1,'','gh_f1d11b045724','wx07d68667d87f4e8a','2f5520966526fb724794adb9aafcbf30','承德嘉丽网络科技有限公司',''),(15,15,'OyLyKLysVUCVZY4fU4MZiYmZy2Y83MGm','IlOBq1G1B70MqMgQoBmXq4gqQqx1GqoO1QQ0mx44MM7',1,'','gh_cd376b2a6cef','wx718cb4fe86248c65','caa4afb8cd35cc3eb42c96aa626d76a6','通程泰合商城',''),(16,16,'Ct2tStA2hEOUtsBa2To2zBuuUxh7TV7T','BfHPf816VK2Af25K1E81fe98P8o5kVPp85GkGKA5FTT',1,'','gh_dc3cf20f0cb8','wx6b53b6545d5c8f9d','c59f8a4b12c088ad8374b7d83eabd0c3','金色时光孕婴童连锁承德1店',''),(17,17,'d7v1elFUeR8M0KLvrvZLfUVdV1e70uDU','ixI1Q4IZX5CjJz5cA5xlyb1qZ4A491552rCA94J1J7x',1,'','gh_2b9d56210e0e','wxfd5a8b2195a716a0','df94fc0eb6178bc9ac6cfaa9fee22245','承德门萨全脑教育','');
/*!40000 ALTER TABLE `ims_account_wxapp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `identify` varchar(300) NOT NULL,
  `card_logo` varchar(300) NOT NULL,
  `detailed_address` varchar(300) NOT NULL,
  `card_name` varchar(300) NOT NULL,
  `errmsg` varchar(300) NOT NULL,
  `card_instr` text NOT NULL,
  `card_id` varchar(80) NOT NULL,
  `userid` varchar(80) NOT NULL,
  `weixinid` varchar(80) NOT NULL,
  `photo` text NOT NULL,
  `address` varchar(80) NOT NULL,
  `sex` tinyint(1) NOT NULL DEFAULT '0',
  `template_type` tinyint(1) NOT NULL DEFAULT '0',
  `card_forward_status` tinyint(1) NOT NULL DEFAULT '0',
  `see_num` int(11) NOT NULL DEFAULT '0',
  `browse_headimg_num` int(11) NOT NULL DEFAULT '0',
  `sort` int(11) NOT NULL DEFAULT '0',
  `signature_count` int(11) NOT NULL DEFAULT '0',
  `share_num` int(11) NOT NULL DEFAULT '0',
  `total_pic_num` int(11) NOT NULL DEFAULT '0',
  `ishide` tinyint(1) NOT NULL DEFAULT '0',
  `thumbs_num` int(11) NOT NULL DEFAULT '0',
  `mrtype` tinyint(1) NOT NULL DEFAULT '0',
  `card_level` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否标星',
  `last_update_star_time` varchar(15) NOT NULL,
  `card_tel` varchar(15) NOT NULL,
  `role_name` varchar(15) NOT NULL DEFAULT '职位',
  `phone` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL,
  `hide_property` tinyint(1) NOT NULL,
  `customer_disturb` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否隐藏',
  `open_boss` tinyint(3) DEFAULT '0',
  `zd_msg` varchar(350) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `template_img` varchar(300) NOT NULL,
  `share_img` varchar(350) NOT NULL,
  `share_title` varchar(350) NOT NULL,
  `is_sendcard_id` int(11) DEFAULT '0',
  `is_sendcard` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard`
--

LOCK TABLES `ims_dbs_masclwlcard` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard` VALUES (3,0,'','attachment/images/2019/3/26/20190326154724$1$MutYAYrt$P5sqpHFoInYqbtdGCN.7H0.png','高新区大学城','于宏涛','','测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试','','admin','yuhongtaoit','[attachment/images/2019/3/26/20190326154724$1$sEVt2dzC$wiupopLslkcaBog8opG5v1.png, attachment/images/2019/3/26/20190326154724$1$MUfJzvnW$IYLRklGoLmKEjqhNUT96N0.png, attachment/images/2019/3/26/20190326154724$1$fpmL0xPE$WzU75Z5vKlY92AouFhn.png, attachment/images/2019/3/26/20190326154724$1$MW.i0tlm$6DX2ftkTTTEQOowQDfjAn0.png]','',1,2,0,0,0,0,0,0,7,0,88,1,0,'','15690095525','教师','2025160','642047940@qq.com',0,0,0,'','承德石油高等专科学校','attachment/images/2019/3/26/20190326154724$1$R0C.VlU$6QFpCri.53ANuTW38tGAD0.png','attachment/images/2019/3/26/20190326154724$1$9LuNkmZW$vtx2xd4qojrVqPx4hzNYZ0.png','测试',0,0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_act_report`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_act_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_act_report` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `copytype` varchar(300) NOT NULL DEFAULT '0',
  `footertype` varchar(300) NOT NULL DEFAULT '0',
  `updatetime` varchar(30) NOT NULL,
  `card_id` int(11) NOT NULL DEFAULT '1',
  `num` int(11) NOT NULL DEFAULT '0',
  `act_id` int(11) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `p_id` int(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `act_content` varchar(300) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=811 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_act_report`
--

LOCK TABLES `ims_dbs_masclwlcard_act_report` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_act_report` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_act_report` VALUES (653,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691754','0','0','',8,1,656,0,1,1,'','难得糊涂第1次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(654,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691778','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(655,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691789','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(656,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691790','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(657,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691791','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(658,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691793','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(659,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691793','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(660,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691794','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(661,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691795','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(662,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(663,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(664,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(665,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691817','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(666,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691817','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(667,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691818','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(668,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691833','0','0','',8,2,656,0,1,1,'','难得糊涂第2次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(669,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691846','0','0','',8,0,103,0,1,1,'','难得糊涂分享了名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(670,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691859','0','0','',8,0,659,0,1,1,'','难得糊涂生成了您的海报','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(671,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691995','0','0','',8,3,656,0,1,1,'','难得糊涂第3次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(672,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692023','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(673,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692029','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(674,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692029','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(675,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692031','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(676,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692033','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(677,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692035','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(678,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692036','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(679,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692039','0','0','',8,4,656,0,1,1,'','难得糊涂第4次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(680,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692041','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(681,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692044','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(682,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692089','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(683,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692240','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(684,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692251','0','0','',8,5,656,0,1,1,'','难得糊涂第5次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(685,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692254','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(686,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692255','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(687,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692256','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(688,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692393','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(689,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692394','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(690,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692413','0','0','',8,6,656,0,1,1,'','难得糊涂第6次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(691,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692416','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(692,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692418','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(693,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692419','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(694,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692420','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(695,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692581','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(696,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692584','0','0','',8,7,656,0,1,1,'','难得糊涂第7次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(697,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692586','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(698,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692587','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(699,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692588','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(700,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692589','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(701,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692590','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(702,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692599','0','0','',8,8,656,0,1,1,'','难得糊涂第8次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(703,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692602','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(704,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692603','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(705,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692604','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(706,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692621','0','0','',8,9,656,0,1,1,'','难得糊涂第9次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(707,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692623','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(708,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692630','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(709,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692633','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(710,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692634','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(711,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692713','0','0','',8,10,656,0,1,1,'','难得糊涂第10次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(712,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692716','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(713,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692746','0','0','',8,11,656,0,1,1,'','难得糊涂第11次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(714,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692748','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(715,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692769','0','0','',8,12,656,0,1,1,'','难得糊涂第12次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(716,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692771','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(717,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692801','0','0','',8,13,656,0,1,1,'','难得糊涂第13次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(718,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692828','0','0','',8,14,656,0,1,1,'','难得糊涂第14次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(719,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692831','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(720,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692850','0','0','',8,15,656,0,1,1,'','难得糊涂第15次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(721,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692852','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(722,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692862','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(723,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692863','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(724,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692863','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(725,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692866','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(726,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692869','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(727,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692871','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(728,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692872','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(729,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692974','0','0','',8,16,656,0,1,1,'','难得糊涂第16次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(730,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692977','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(731,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692986','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(732,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692987','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(733,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692987','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(734,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693138','0','0','',8,17,656,0,1,1,'','难得糊涂第17次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(735,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693140','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(736,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693143','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(737,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693153','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(738,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693359','0','0','',8,18,656,0,1,1,'','难得糊涂第18次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(739,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693361','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(740,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693395','0','0','',8,19,656,0,1,1,'','难得糊涂第19次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(741,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693397','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(742,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693398','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(743,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693407','0','0','',8,20,656,0,1,1,'','难得糊涂第20次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(744,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693409','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(745,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693410','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(746,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693411','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(747,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693560','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(748,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693561','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(749,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693565','0','0','',8,21,656,0,1,1,'','难得糊涂第21次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(750,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693568','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(751,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693571','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(752,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693573','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(753,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693574','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(754,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693577','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(755,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693579','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(756,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693586','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(757,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693588','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(758,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693589','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(759,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693590','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(760,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693593','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(761,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693596','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(762,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693716','0','0','',8,22,656,0,1,1,'','难得糊涂第22次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(763,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693719','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(764,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693720','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(765,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693721','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(766,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693728','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(767,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693731','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(768,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693747','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(769,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693749','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(770,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693750','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(771,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693798','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(772,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693798','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(773,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693799','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(774,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693807','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(775,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693808','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(776,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693825','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(777,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693828','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(778,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693828','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(779,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693834','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(780,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693836','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(781,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693843','0','0','',8,23,656,0,1,1,'','难得糊涂第23次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(782,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693847','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(783,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693856','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(784,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693858','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(785,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693950','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(786,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693952','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(787,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693957','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(788,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693973','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(789,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693992','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(790,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693993','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(791,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693993','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(792,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693994','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(793,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693994','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(794,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693995','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(795,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693999','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(796,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694025','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(797,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694030','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(798,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694037','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(799,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694041','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(800,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694143','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(801,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694144','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(802,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694144','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(803,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694277','0','0','',8,24,656,0,1,1,'','难得糊涂第24次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(804,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694313','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(805,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694322','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(806,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694331','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(807,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694341','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(808,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694350','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(809,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694353','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(810,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694356','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_act_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_adv`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_adv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_adv` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `images` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_adv`
--

LOCK TABLES `ims_dbs_masclwlcard_adv` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_adv` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_adv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_auth_user`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_auth_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_auth_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `sessionId` varchar(300) NOT NULL,
  `uniacid` int(10) unsigned NOT NULL,
  `unionid` varchar(64) NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `country` varchar(100) NOT NULL,
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`sessionId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_auth_user`
--

LOCK TABLES `ims_dbs_masclwlcard_auth_user` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_auth_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_auth_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_card_member`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_card_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_card_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '1',
  `show_zan` tinyint(3) NOT NULL DEFAULT '0',
  `is_pop_card` tinyint(3) NOT NULL DEFAULT '0',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatar_url` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  `gailv` tinyint(3) DEFAULT '0',
  `hmd_status` tinyint(3) DEFAULT '0',
  `pb_status` tinyint(3) DEFAULT '0',
  `source_id` int(11) DEFAULT '0',
  `can_take` decimal(11,2) NOT NULL,
  `total_broker` decimal(11,2) NOT NULL,
  `has_taken` decimal(11,2) NOT NULL,
  `in_taking` decimal(11,2) NOT NULL,
  `not_in_account` decimal(11,2) NOT NULL,
  `send_cardid` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_card_member`
--

LOCK TABLES `ims_dbs_masclwlcard_card_member` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_card_member` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_card_member` VALUES (37,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691754','',8,0,0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','',0,0,0,0,0.00,0.00,0.00,0.00,0.00,0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_card_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_chat`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_chat` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `fid` int(11) NOT NULL DEFAULT '0',
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `card_id` int(11) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `is_send` tinyint(1) NOT NULL DEFAULT '0',
  `type` tinyint(1) NOT NULL DEFAULT '0',
  `stype` tinyint(1) NOT NULL DEFAULT '1',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `send_fromid` tinyint(11) NOT NULL DEFAULT '0',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `formId` varchar(350) NOT NULL,
  `msg` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_chat`
--

LOCK TABLES `ims_dbs_masclwlcard_chat` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_chat` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_chat` VALUES (34,2,0,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692053','',8,0,0,1,0,1,0,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','3725ed9a11daa3fc12821522654a1f2e','！','Bali',''),(35,2,0,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692150','',8,0,0,1,0,1,0,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','40a9a794c0822560f76e93092156cafb','这么着','Bali','');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_footer`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_footer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_footer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `card_img` varchar(380) NOT NULL,
  `card_img_no` varchar(380) NOT NULL,
  `card_name` varchar(30) NOT NULL,
  `shop_name` varchar(30) NOT NULL,
  `friend_name` varchar(30) NOT NULL,
  `web_name` varchar(30) NOT NULL,
  `shop_img` varchar(380) NOT NULL,
  `friend_img` varchar(380) NOT NULL,
  `web_img` varchar(380) NOT NULL,
  `shop_img_no` varchar(380) NOT NULL,
  `friend_img_no` varchar(380) NOT NULL,
  `web_img_no` varchar(380) NOT NULL,
  `shop_type` tinyint(1) NOT NULL,
  `friend_type` tinyint(1) NOT NULL,
  `web_type` tinyint(1) NOT NULL,
  `card_type` tinyint(1) NOT NULL,
  `shop_url` varchar(380) NOT NULL,
  `shop_path` varchar(380) NOT NULL,
  `card_path` varchar(380) NOT NULL,
  `web_path` varchar(380) NOT NULL,
  `web_appid` varchar(380) NOT NULL,
  `card_appid` varchar(380) NOT NULL,
  `friend_appid` varchar(380) NOT NULL,
  `friend_path` varchar(380) NOT NULL,
  `shop_appid` varchar(380) NOT NULL,
  `friend_url` varchar(380) NOT NULL,
  `web_url` varchar(380) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_footer`
--

LOCK TABLES `ims_dbs_masclwlcard_footer` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_footer` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_footer` VALUES (1,2,'','','名片','商城','动态','官网','','','','','','',0,0,0,0,'','','','','','','','','','','');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_footer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_formid`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_formid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_formid` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `formId` varchar(350) NOT NULL DEFAULT '',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=267 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_formid`
--

LOCK TABLES `ims_dbs_masclwlcard_formid` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_formid` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_formid` VALUES (127,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691753','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(128,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691789','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(129,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691790','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(130,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691791','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(131,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691792','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(132,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691793','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(133,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691794','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(134,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691795','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(135,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(136,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(137,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(138,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691817','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(139,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691817','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(140,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691818','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(141,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691821','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(142,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691833','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(143,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691882','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(144,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691995','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b133c61ddc6dc36c147c715ab03f7f1b','Bali',''),(145,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692023','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','d484f0b3b77b5fa2022cdf521fbb416a','Bali',''),(146,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692029','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','2e56a3dc8015a1c34345aa69e26ba0a6','Bali',''),(147,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692030','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','aa808e24a81b4314b684e0648ceb0bb6','Bali',''),(148,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692031','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','2de52ebc935949c717aec860e18c223b','Bali',''),(149,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692033','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','0d59caca3ed9e65d2af13fd3bb4c2664','Bali',''),(150,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692035','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','9d7875038221fe8115c9425604c39e5f','Bali',''),(151,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692041','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','61e0e2337d3b9d5af7a3d5e2be8132d5','Bali',''),(152,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692250','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(153,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692254','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(154,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692255','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(155,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692393','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','c502e1e278823087fb9ac8cba2df50e3','Bali',''),(156,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692394','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','1497428b17111997e05cc1fd6aac24fe','Bali',''),(157,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692410','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','48331f44125ea88848e2574d0db58a7e','Bali',''),(158,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692413','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','0a80df6bf035fae388bf2de1e1760e55','Bali',''),(159,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692416','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','62369e1f357f5ac60698ddf866935c3b','Bali',''),(160,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692418','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','364a619b9430516d6e140e1b4729e3b1','Bali',''),(161,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692419','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b813ffe6d5f35c22e20bdccf2374dcfb','Bali',''),(162,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692420','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','3f30f7c388521eee783de88c8a98fa5b','Bali',''),(163,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692586','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(164,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692587','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(165,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692588','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(166,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692589','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(167,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692602','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(168,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692603','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(169,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692623','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(170,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692630','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(171,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692633','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(172,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692634','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(173,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692712','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(174,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692716','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(175,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692745','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(176,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692748','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(177,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692768','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(178,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692771','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(179,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692800','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(180,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692827','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(181,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692831','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(182,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692849','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(183,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692852','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(184,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692862','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(185,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692863','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(186,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692863','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(187,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692866','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(188,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692869','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(189,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692871','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(190,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692872','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(191,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692973','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(192,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692977','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(193,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692986','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(194,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692986','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(195,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692987','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(196,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693137','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(197,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693140','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(198,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693358','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(199,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693361','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(200,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693394','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(201,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693397','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(202,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693398','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(203,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693409','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(204,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693410','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(205,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693560','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','28b420ac85ebf2dba211720db9f4dee3','Bali',''),(206,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693561','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b3a4efb07850f80536fbc1358f3e89ce','Bali',''),(207,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693563','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','ea08e72cfb3c72bae8ec43a482f5949f','Bali',''),(208,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693565','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','4db1b073a0bce9475df3f627653171b2','Bali',''),(209,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693571','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','76d03567d009ca2d4daecb69f42e0123','Bali',''),(210,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693573','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','c93a6a411cf11e5a83a8fb40cf56c222','Bali',''),(211,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693574','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','d279857147b27b7952c0d1eb11dd886c','Bali',''),(212,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693577','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','39f6681295f0c127c2dd2ba0d6f352d9','Bali',''),(213,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693579','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','8f786a2d0b1c183fcc18306657d3d62e','Bali',''),(214,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693586','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','a1e22ff7f0b94a78cb68525c1b0b10de','Bali',''),(215,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693588','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','492dde729ca52153e8d81bfcaed8a3a3','Bali',''),(216,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693589','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','e382f079962748977552c650f29e5931','Bali',''),(217,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693590','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','f7c099282670bff33c6dc2a2ff1b2b22','Bali',''),(218,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693593','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','09bd169b6abb8b3a1e6d2f9a9583e749','Bali',''),(219,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693596','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','276493fd35c14b54ed9c32ba92908f1e','Bali',''),(220,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693715','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(221,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693719','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(222,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693720','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(223,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693721','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(224,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693728','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(225,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693731','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(226,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693747','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(227,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693749','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(228,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693750','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(229,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693798','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(230,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693798','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(231,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693799','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(232,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693807','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(233,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693808','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(234,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693825','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(235,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693828','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(236,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693828','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(237,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693834','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(238,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693836','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(239,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693843','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(240,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693847','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(241,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693856','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(242,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693858','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(243,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693950','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(244,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693952','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(245,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693957','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(246,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693973','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(247,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693992','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(248,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693993','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(249,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693993','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(250,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693994','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(251,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693994','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(252,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693995','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(253,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693999','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(254,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694025','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(255,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694030','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(256,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694037','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(257,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694041','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(258,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694143','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(259,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694144','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(260,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694144','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(261,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694250','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(262,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694277','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(263,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694313','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(264,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694331','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(265,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694341','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(266,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694350','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali','');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_formid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_friend`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_friend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_friend` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `card_id` int(11) unsigned NOT NULL,
  `all_img` text NOT NULL,
  `is_card` tinyint(11) NOT NULL DEFAULT '0',
  `content_card` text NOT NULL,
  `title` varchar(300) NOT NULL,
  `time` int(10) NOT NULL,
  `head_img` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_friend`
--

LOCK TABLES `ims_dbs_masclwlcard_friend` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_friend` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_friend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_member`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_member` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '1',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatar_url` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_member`
--

LOCK TABLES `ims_dbs_masclwlcard_member` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_member` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_member` VALUES (3,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','13832495474','1540691778','',1,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_nav`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_nav` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `images` varchar(300) NOT NULL,
  `path` varchar(350) NOT NULL,
  `title` varchar(350) NOT NULL,
  `newid` varchar(350) NOT NULL,
  `linkType` varchar(350) NOT NULL,
  `appid` varchar(350) NOT NULL,
  `path_web` varchar(350) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_nav`
--

LOCK TABLES `ims_dbs_masclwlcard_nav` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_nav` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_news`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `title` varchar(300) NOT NULL,
  `time` int(10) NOT NULL,
  `head_img` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_news`
--

LOCK TABLES `ims_dbs_masclwlcard_news` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_news` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_news` VALUES (5,2,'test',0,'attachment/images/2019/4/15/20190415095147$1$waxprfY$jfFWQk6oGBHW4tDzCbmMM..jpg','<p>1111111</p><p>eryreyre<img src=\"http://localhost:8080/attachment/images/2019/4/15/20190415095125$1$Ld.wf.Qm$5HPeCKiwVpW2oLMtnVQ01.jpg\" title=\"WIab84077qQNiERrUR3q7geaPrRe7a.jpg\" alt=\"WIab84077qQNiERrUR3q7geaPrRe7a.jpg\"/></p><p><img src=\"http://localhost:8080/attachment/images/2019/4/15/20190415143455$1$5vA8dpl$048OF9WD1KzEwJk4DB.QW1.jpg\" title=\"uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\" alt=\"uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\"/></p>',0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_pl`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_pl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_pl` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `fid` int(11) NOT NULL DEFAULT '0',
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '1',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `content` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_pl`
--

LOCK TABLES `ims_dbs_masclwlcard_pl` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_pl` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_pl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_product`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_product` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `cp_bs_img` text NOT NULL,
  `cp_bs_content` text NOT NULL,
  `cp_bs_name` varchar(300) NOT NULL,
  `cp_bs_price` varchar(300) NOT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_product`
--

LOCK TABLES `ims_dbs_masclwlcard_product` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_product` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_product` VALUES (22,2,'a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','测试产品','0.01',0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_set`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_set` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `company_name` varchar(300) NOT NULL,
  `lat` varchar(300) NOT NULL,
  `lng` varchar(300) NOT NULL,
  `num` int(10) NOT NULL,
  `company_addr` varchar(300) NOT NULL,
  `template_id` varchar(300) NOT NULL,
  `open_shop` tinyint(1) NOT NULL DEFAULT '0',
  `company_tel` varchar(30) NOT NULL,
  `company_logo` varchar(300) NOT NULL,
  `shop_bg` varchar(350) NOT NULL,
  `open_redpack` tinyint(3) DEFAULT '0',
  `redpack_min` decimal(11,2) NOT NULL,
  `redpack_max` decimal(11,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_set`
--

LOCK TABLES `ims_dbs_masclwlcard_set` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_set` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_set` VALUES (4,0,'承德市众维广告有限公司','40.9684028503','117.9361003014',0,'河北省承德市双桥区文化娱乐中心1901-1','',1,'0314-0000000','attachment/images/2019/4/15/20190415143423$1$L2sgbE7X$UgSefRhug7D6Ej9GLmQgg..jpg','attachment/images/2019/4/15/20190415143423$1$whrbtc0$AYZDCnxlNZWFsiImiGAYZ..jpg',0,0.00,0.00);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_set_qy`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_set_qy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_set_qy` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `corpid` varchar(300) NOT NULL,
  `agentid` varchar(300) NOT NULL,
  `secret` varchar(300) NOT NULL,
  `secret_1` varchar(300) NOT NULL,
  `status` tinyint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_set_qy`
--

LOCK TABLES `ims_dbs_masclwlcard_set_qy` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_set_qy` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_set_qy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_shops`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_shops` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `cp_bs_img` text NOT NULL COMMENT '产品的详情',
  `top_pic` text NOT NULL COMMENT '产品的轮播图',
  `shop_name` text NOT NULL COMMENT '商品名称',
  `typeid` int(11) NOT NULL COMMENT '商品分类',
  `specid` int(11) NOT NULL COMMENT '商品属性',
  `sale_num` int(11) NOT NULL COMMENT '商品销售数量',
  `shops_num` int(11) NOT NULL COMMENT '商品库存数量',
  `sort` int(11) NOT NULL COMMENT '排序',
  `shop_spec` tinyint(1) NOT NULL COMMENT '商品规格',
  `is_show` tinyint(1) NOT NULL COMMENT '是否上架',
  `cp_bs_content` text NOT NULL,
  `cp_bs_name` varchar(300) NOT NULL,
  `addtime` varchar(12) NOT NULL,
  `gimg` varchar(300) NOT NULL COMMENT '商品缩略图',
  `price` decimal(11,2) NOT NULL,
  `fx_type` tinyint(3) DEFAULT '0',
  `fx_price` decimal(11,2) NOT NULL,
  `no_show_price` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_shops`
--

LOCK TABLES `ims_dbs_masclwlcard_shops` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_shops` VALUES (4,2,'[attachment/images/2019/3/28/20190328112122$1$EmySiaJH$X831Hj4eHFrlt3MnFaQ.g..png, attachment/images/2019/3/28/20190328112122$1$Xaah27JB$q3Si6oh4Jw8Vew5dDL9f.png, attachment/images/2019/3/28/20190328112122$1$qfajbPF$YfXDv7A2lVXC93tchYtDK0.png]','[attachment/images/2019/3/28/20190328112122$1$RSeEPd.V$XNM8xpeuRjcJ5UGuYCyW..png, attachment/images/2019/3/28/20190328112122$1$b70llX1$eIXpy01BuqS7qjbHiDEtL..png, attachment/images/2019/3/28/20190328112122$1$.17eAiij$Au2KYnxOgR2a3emx8bVRj..png]','测试',0,0,45,456,3,0,1,'','','','attachment/images/2019/3/28/20190328112122$1$gLwMHrcP$qat4Cpq51pw.uPCzfcdu.png',78.00,1,2.70,0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_shops_address`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_shops_address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '1',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `err_msg` varchar(300) NOT NULL DEFAULT '0',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `userName` varchar(30) NOT NULL DEFAULT '',
  `postal_code` varchar(30) NOT NULL DEFAULT '0',
  `province_name` varchar(30) NOT NULL DEFAULT '0',
  `city_name` varchar(30) NOT NULL DEFAULT '0',
  `county_name` varchar(300) NOT NULL DEFAULT '0',
  `detail_info` text NOT NULL,
  `national_code` varchar(100) NOT NULL,
  `tel_number` varchar(30) NOT NULL,
  `avatar_url` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `is_status` tinyint(1) NOT NULL DEFAULT '0',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_shops_address`
--

LOCK TABLES `ims_dbs_masclwlcard_shops_address` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_address` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_shops_address` VALUES (3,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','','',1,1,'','0','zh_CN','张三','0','北京市','北京市','东城区','测试','','1333333333','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',1,'');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_shops_category`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_shops_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `thumb` varchar(350) NOT NULL COMMENT '产品的详情',
  `parentid` int(10) NOT NULL COMMENT '产品的轮播图',
  `sort` int(10) NOT NULL COMMENT '产品的轮播图',
  `num` int(10) NOT NULL COMMENT '商品显示数量',
  `enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可用',
  `title` varchar(200) NOT NULL COMMENT '商品名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_shops_category`
--

LOCK TABLES `ims_dbs_masclwlcard_shops_category` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_category` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_shops_category` VALUES (11,2,'attachment/images/2019/3/28/20190328161429$1$tsCPLRPc$8YLiEr3aCygP7fOIrLiv..png',0,2345,12,0,'test111'),(12,2,'attachment/images/2019/3/28/20190328161929$1$AplVEnDe$nRgYh0RmBX903ZLx7WPXU.png',0,45,12,0,'test'),(13,2,'attachment/images/2019/3/28/20190328162031$1$.hSthtHn$4umKjBpAh2mGXRZjmgKM..png',0,435,56,0,'test'),(14,2,'attachment/images/2019/3/28/20190328162050$1$amDdfO6l$K2AOLGVnTMoeqcdEb5oZ51.png',0,56,3456,1,'56'),(15,2,'attachment/images/2019/3/28/20190328162513$1$qbiIPAit$AVVtcku1pVpsMxulnk5rL.png',0,88,88,1,'test'),(16,2,'attachment/images/2019/3/28/20190328162525$1$i9MArdvB$aH5bL0.LXF6OeoLVAvf0d.png',0,99,99,0,'99');
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_shops_order`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_shops_order` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `from_user` varchar(300) NOT NULL,
  `orderid` varchar(300) NOT NULL,
  `staffid` int(11) NOT NULL,
  `shops_id` int(11) NOT NULL DEFAULT '0',
  `card_id` int(11) NOT NULL DEFAULT '0',
  `shareid` int(11) NOT NULL DEFAULT '0',
  `tid` int(11) NOT NULL DEFAULT '0',
  `transaction_id` varchar(300) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `all_price` decimal(10,2) NOT NULL,
  `addtime` int(11) NOT NULL,
  `shops_num` int(11) NOT NULL,
  `paid` tinyint(1) NOT NULL,
  `hxstatus` tinyint(1) NOT NULL DEFAULT '0',
  `hxname` varchar(30) NOT NULL DEFAULT '0',
  `nickname` varchar(350) NOT NULL,
  `shop_name` varchar(300) NOT NULL,
  `tp_text` text NOT NULL,
  `name` varchar(350) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `new_spec` varchar(50) NOT NULL,
  `avatar` varchar(350) NOT NULL,
  `address` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`from_user`(255)) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_shops_order`
--

LOCK TABLES `ims_dbs_masclwlcard_shops_order` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_shops_spec`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_spec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_shops_spec` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `spec_content` text NOT NULL COMMENT '商品规格',
  `title` varchar(200) NOT NULL COMMENT '规格名称',
  `sort` int(11) NOT NULL COMMENT '规格名称',
  `enabled` tinyint(1) NOT NULL COMMENT '规格名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_shops_spec`
--

LOCK TABLES `ims_dbs_masclwlcard_shops_spec` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_spec` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_shops_spec` VALUES (2,2,'55,77','test33',56,0),(3,2,'ty,ui','test66',77,1);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_shops_spec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_web`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_web`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_web` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `video` varchar(380) NOT NULL,
  `cp_bs_content` text NOT NULL,
  `images` varchar(380) NOT NULL,
  `tx_video` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_web`
--

LOCK TABLES `ims_dbs_masclwlcard_web` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_web` DISABLE KEYS */;
INSERT INTO `ims_dbs_masclwlcard_web` VALUES (5,2,'attachment/images/2019/4/15/20190415143343$1$zXGnF.l$FWUE2DHTvnDTwVMB0pq8z.mp4','[attachment/images/2019/4/15/20190415143345$1$ueFzBi88$0tXo2DjmMdkBvR5Lqfh0P..jpg, attachment/images/2019/4/15/20190415143345$1$NxNQyls9$mDJpIzMixOw9dkw02Jy2K..jpg]','attachment/images/2019/4/15/20190415162243$1$Fli6TX8B$76o6yshZovUQNXck.xu3..jpg',0);
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_web` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_dbs_masclwlcard_zan`
--

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_zan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_dbs_masclwlcard_zan` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `fid` int(11) NOT NULL DEFAULT '0',
  `openId` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '1',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `avatarUrl` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`openId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_dbs_masclwlcard_zan`
--

LOCK TABLES `ims_dbs_masclwlcard_zan` WRITE;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_zan` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_dbs_masclwlcard_zan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_ims_dbs_masclwlcard_bank`
--

DROP TABLE IF EXISTS `ims_ims_dbs_masclwlcard_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_ims_dbs_masclwlcard_bank` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `open_id` varchar(100) NOT NULL,
  `nickname` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `addtime` varchar(30) NOT NULL,
  `updatetime` varchar(30) NOT NULL,
  `aid` int(11) NOT NULL DEFAULT '0',
  `gender` tinyint(11) NOT NULL DEFAULT '1',
  `city` varchar(30) NOT NULL DEFAULT '1',
  `err_msg` varchar(300) NOT NULL DEFAULT '0',
  `language` varchar(30) NOT NULL DEFAULT '1',
  `bank_card` varchar(50) NOT NULL DEFAULT '0',
  `user_name` varchar(30) NOT NULL DEFAULT '',
  `postal_code` varchar(30) NOT NULL DEFAULT '0',
  `province_name` varchar(30) NOT NULL DEFAULT '0',
  `city_name` varchar(30) NOT NULL DEFAULT '0',
  `county_name` varchar(300) NOT NULL DEFAULT '0',
  `detail_info` text NOT NULL,
  `national_code` varchar(100) NOT NULL,
  `tel_number` varchar(30) NOT NULL,
  `avatar_url` varchar(350) NOT NULL DEFAULT '1',
  `province` varchar(30) NOT NULL DEFAULT '1',
  `is_status` tinyint(1) NOT NULL DEFAULT '0',
  `avatar` varchar(350) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`uniacid`,`open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_ims_dbs_masclwlcard_bank`
--

LOCK TABLES `ims_ims_dbs_masclwlcard_bank` WRITE;
/*!40000 ALTER TABLE `ims_ims_dbs_masclwlcard_bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `ims_ims_dbs_masclwlcard_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ims_uni_account`
--

DROP TABLE IF EXISTS `ims_uni_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ims_uni_account` (
  `uniacid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `groupid` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL,
  `default_acid` int(10) unsigned NOT NULL,
  `rank` int(10) DEFAULT NULL,
  `title_initial` varchar(1) NOT NULL,
  PRIMARY KEY (`uniacid`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ims_uni_account`
--

LOCK TABLES `ims_uni_account` WRITE;
/*!40000 ALTER TABLE `ims_uni_account` DISABLE KEYS */;
INSERT INTO `ims_uni_account` VALUES (1,-1,'微擎团队','一个朝气蓬勃的团队',1,NULL,'W'),(6,0,'同城智慧名片','让营销变得简单',6,NULL,'T'),(3,0,'承德早教','学龄前儿童教育',3,NULL,'C'),(4,0,'承德小程序制作','小程序建站',4,NULL,'C'),(5,0,'众维互赢','名片名片',5,NULL,'Z'),(7,0,'彩艺美发','店内获客',7,NULL,'C'),(8,0,'新思路美发','店内员工个人名片',8,NULL,'X'),(9,0,'建材行业案例','名片获客工具',9,NULL,'J'),(10,0,'baby母婴馆','宝宝粮仓*我家贝贝 你身边的育英专家。销售的商品包括孕婴奶粉、婴儿辅食、营养品、婴儿玩具、服饰0-12岁、鞋帽、喂养系列等',10,NULL,'B'),(11,0,'承德通程泰合装饰工程有限公司','室内外装饰设计，施工。装饰材料，灯饰建材等，家具办公用品，日常百货等。凭取得的许可证从事普通运货；会议及展览展示服。',11,NULL,'C'),(12,0,'鱼乐baby婴幼儿水育馆','日常百货，服装鞋帽，玩具销售；儿童室内游泳娱乐服务（提法须经批准的项目，经相关部门批准后方可开展经营活动）',12,NULL,'Y'),(13,0,'终南独一方体验中心','智能名片',13,NULL,'Z'),(14,0,'承德嘉丽网络科技有限公司','企业名片',14,NULL,'C'),(15,0,'通程泰合商城','智慧商城',15,NULL,'T'),(16,0,'金色时光孕婴童连锁承德1店','智慧商城',16,NULL,'J'),(17,0,'承德门萨全脑教育','全脑潜能开发，平衡左右脑，提升学习',17,NULL,'C');
/*!40000 ALTER TABLE `ims_uni_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(256) NOT NULL COMMENT 'url',
  `resource_name` varchar(256) DEFAULT NULL COMMENT '资源名称',
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
INSERT INTO `resource` VALUES (1,'/index','主页面','interface'),(2,'/user/getUserList','用户管理-获取所有用户','interface'),(3,'/user/getRoles','用户管理-用户关联角色-获取角色','interface'),(4,'/user/saveRoles','用户管理-用户关联角色-保存','interface'),(5,'/user/edit','用户管理-打开新增或修改用户页面','interface'),(6,'/user/save','用户管理-新增或修改用户-保存','interface'),(7,'/user/delete','用户管理-删除用户','interface'),(8,'/role/getRoleList','角色管理-获取角色列表','interface'),(9,'/role/getResources','角色管理-角色关联资源-获取资源','interface'),(10,'/role/saveResources','角色管理-角色关联资源-保存','interface'),(11,'/role/edit','角色管理-打开新增或修改角色页面','interface'),(12,'/role/save','角色管理-新增或修改角色-保存','interface'),(13,'/role/delete','角色管理-删除角色','interface'),(14,'/account/getAccountList','商户管理-获取商户列表','interface'),(15,'/account/editAccount','商户管理-打开新增或修改商户页面','interface'),(16,'/account/saveAccount','商户管理-保存商户信息','interface'),(17,'/account/deleteAccount','商户管理-删除商户','interface'),(18,'/basic/getBasicSet','基础设置-获取基础设置信息','interface'),(19,'/basic/basicSetSave','基础设置-保存基础设置信息','interface'),(20,'/product/getProductList','产品管理-获取产品列表','interface'),(21,'/product/edit','产品管理-打开新增或修改产品信息页面','interface'),(22,'/product/save','产品管理-保存产品信息','interface'),(23,'/product/delete','产品管理-删除产品信息','interface'),(24,'/friendManage/getDynamicList','朋友圈管理-获取动态列表','interface'),(25,'/friendManage/dynamicEdit','朋友圈管理-打开新增或修改动态信息页面','interface'),(26,'/friendManage/dynamicSave','朋友圈管理-保存动态信息','interface'),(27,'/friendManage/dynamicDelete','朋友圈管理-删除动态信息','interface'),(28,'/friendManage/getReviewList','朋友圈管理-获取评论列表','interface'),(29,'/friendManage/reviewDelete','朋友圈管理-删除评论信息','interface'),(30,'/namecard/getNamecardList','名片管理-获取名片列表','interface'),(31,'/namecard/edit','名片管理-打开新增或修改名片信息页面','interface'),(32,'/namecard/save','名片管理-保存名片信息','interface'),(33,'/namecard/delete','名片管理-删除名片信息','interface'),(34,'/qywx/getBasicSet','企业微信设置-获取基础设置信息','interface'),(35,'/qywx/basicSetSave','企业微信设置-保存基础设置信息','interface'),(36,'/shopCategory/getCategoryList','商城商品类别管理-获取商品类别列表','interface'),(37,'/shopCategory/edit','商城商品类别管理-打开新增或修改商品类别信息页面','interface'),(38,'/shopCategory/save','商城商品类别管理-保存商品类别信息','interface'),(39,'/shopCategory/delete','商城商品类别管理-删除商品类别信息','interface'),(40,'/shop/getShopList','商城商品管理-获取商品列表','interface'),(41,'/shop/edit','商城商品管理-打开新增或修改商品信息页面','interface'),(42,'/shop/save','商城商品管理-保存商品信息','interface'),(43,'/shop/delete','商城商品管理-删除商品信息','interface'),(44,'/shopProperty/getPropertyList','商城商品属性管理-获取商品属性列表','interface'),(45,'/shopProperty/edit','商城商品属性管理-打开新增或修改商品属性信息页面','interface'),(46,'/shopProperty/save','商城商品属性管理-保存商品属性信息','interface'),(47,'/shopProperty/delete','商城商品属性管理-删除商品属性信息','interface'),(48,'/user/toUpdatePassword','打开修改密码页面','interface'),(49,'/user/updatePassword','保存修改密码','interface'),(50,'/user/resetPassword','重置密码','interface'),(51,'/website/getBasicSet','官网管理-获取基础设置信息','interface'),(52,'/website/getAdvList','官网管理-获取轮播列表','interface'),(53,'/website/advEdit','官网管理-打开新增或修改轮播信息页面','interface'),(54,'/website/advSave','官网管理-保存轮播信息','interface'),(55,'/website/advDelete','官网管理-删除轮播信息','interface'),(56,'/website/getNavList','官网管理-获取导航列表','interface'),(57,'/website/navEdit','官网管理-打开新增或修改导航信息页面','interface'),(58,'/website/navSave','官网管理-保存导航信息','interface'),(59,'/website/navDelete','官网管理-删除导航信息','interface'),(60,'/website/getNewsList','官网管理-获取活动列表','interface'),(61,'/website/newsEdit','官网管理-打开修改活动信息页面','interface'),(62,'/website/newsSave','官网管理-保存活动信息','interface'),(63,'/website/newsDelete','官网管理-删除活动信息','interface'),(64,'/website/basicSetSave','官网管理-保存基础设置信息','interface'),(65,'menu_user_manage','菜单权限-用户管理','menu'),(66,'menu_role_manage','菜单权限-角色管理','menu'),(67,'menu_account_manage','菜单权限-商户管理','menu'),(68,'menu_card_manage','菜单权限-名片管理','menu'),(69,'menu_shop_manage','菜单权限-商城管理','menu'),(70,'menu_product_manage','菜单权限-产品管理','menu'),(71,'menu_website_manage','菜单权限-官网管理','menu'),(72,'menu_basic_manage','菜单权限-基础设置','menu'),(73,'menu_qywx_manage','菜单权限-企业微信设置','menu'),(74,'menu_friend_manage','菜单权限-朋友圈管理','menu');
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_name` varchar(256) NOT NULL COMMENT '角色名',
  `role_name_zh` varchar(256) DEFAULT NULL COMMENT '角色名（中文）',
  `uniacid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN','超级管理员',0),(2,'ROLE_NORMAL','普通用户',0),(3,'ROLE_MANAGE','管理员',0);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_resource`
--

DROP TABLE IF EXISTS `role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `resource_id` bigint(20) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_resource`
--

LOCK TABLES `role_resource` WRITE;
/*!40000 ALTER TABLE `role_resource` DISABLE KEYS */;
INSERT INTO `role_resource` VALUES (2,2,65),(3,2,66),(4,2,67),(5,2,1),(6,2,2),(7,2,3),(8,2,4),(9,2,5),(10,2,6),(11,2,7),(12,2,8),(13,2,9),(14,2,10),(15,2,11),(16,2,12),(17,2,13),(18,2,14),(19,2,15),(20,2,16),(21,2,17),(22,3,67),(23,3,68),(24,3,1),(25,3,14),(26,3,15),(27,3,16),(28,3,17),(29,3,30),(30,3,31),(31,3,32),(32,3,33);
/*!40000 ALTER TABLE `role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,3,1),(11,4,1),(12,4,2),(13,4,3),(15,5,2),(16,5,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userName` varchar(32) NOT NULL COMMENT '用户名',
  `passWord` varchar(256) NOT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `uniacid` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,'admin','$2a$10$NoA54/Nxl/woF7a38cD7T.Md7Q2wxCvB.6rQnQpM8DvOhQNaAfrTW','男','YHT',NULL,NULL,6),(4,'yuhongtao','$2a$10$uiWiuLTqG16hq9iYIwXwNupNxGWmt8HMhmgApRCH7jM5Bpm06tpRK','男','YHT','15690095525','642047940@qq.com',6),(5,'zhanglili','$2a$10$5vbwxC11hfmcyOhuc8YhU.LxB6e0oe2cOqEDoNFAqrMEn.uaUO0a.','女','ZLL','18631486525','642047940@qq.com',6);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-18 16:56:47
