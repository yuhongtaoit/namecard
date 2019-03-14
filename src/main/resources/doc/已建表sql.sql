DROP TABLE IF EXISTS `ims_dbs_masclwlcard`;

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_auth_user`;
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


INSERT INTO `ims_dbs_masclwlcard` VALUES (8,2,'','images/2/2018/10/PyZRVRBvsvcPr4BbIwK7CD9W7Bbsss.jpg','承德市众维广告有限公司','测试','','承德市众维广告有限公司','','','13333333333','a:1:{i:0;s:51:\"images/2/2018/10/PyZRVRBvsvcPr4BbIwK7CD9W7Bbsss.jpg\";}','',1,0,0,0,0,0,0,0,0,0,1000,1,0,'1540691926','13333333333','职员','13333333333','',0,0,0,'','承德市众维广告有限公司','','','',0,0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_adv`;

CREATE TABLE `ims_dbs_masclwlcard_adv` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `images` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `ims_dbs_masclwlcard_adv` VALUES (10,2,'images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg'),(11,2,'images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg');

-- 有修改 大写字母转为下划线分割
DROP TABLE IF EXISTS `ims_dbs_masclwlcard_card_member`;
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

INSERT INTO `ims_dbs_masclwlcard_card_member` VALUES (37,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691754','',8,0,0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','',0,0,0,0,0.00,0.00,0.00,0.00,0.00,0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_footer`;
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

INSERT INTO `ims_dbs_masclwlcard_footer` VALUES (1,2,'','','名片','商城','动态','官网','','','','','','',0,0,0,0,'','','','','','','','','','','');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_formid`;
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


INSERT INTO `ims_dbs_masclwlcard_formid` VALUES (127,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691753','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(128,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691789','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(129,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691790','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(130,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691791','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(131,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691792','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(132,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691793','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(133,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691794','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(134,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691795','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(135,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(136,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(137,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691801','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(138,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691817','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(139,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691817','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(140,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691818','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(141,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691821','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(142,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691833','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(143,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691882','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(144,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540691995','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b133c61ddc6dc36c147c715ab03f7f1b','Bali',''),(145,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692023','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','d484f0b3b77b5fa2022cdf521fbb416a','Bali',''),(146,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692029','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','2e56a3dc8015a1c34345aa69e26ba0a6','Bali',''),(147,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692030','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','aa808e24a81b4314b684e0648ceb0bb6','Bali',''),(148,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692031','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','2de52ebc935949c717aec860e18c223b','Bali',''),(149,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692033','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','0d59caca3ed9e65d2af13fd3bb4c2664','Bali',''),(150,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692035','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','9d7875038221fe8115c9425604c39e5f','Bali',''),(151,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692041','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','61e0e2337d3b9d5af7a3d5e2be8132d5','Bali',''),(152,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692250','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(153,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692254','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(154,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692255','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(155,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692393','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','c502e1e278823087fb9ac8cba2df50e3','Bali',''),(156,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692394','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','1497428b17111997e05cc1fd6aac24fe','Bali',''),(157,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692410','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','48331f44125ea88848e2574d0db58a7e','Bali',''),(158,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692413','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','0a80df6bf035fae388bf2de1e1760e55','Bali',''),(159,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692416','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','62369e1f357f5ac60698ddf866935c3b','Bali',''),(160,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692418','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','364a619b9430516d6e140e1b4729e3b1','Bali',''),(161,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692419','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b813ffe6d5f35c22e20bdccf2374dcfb','Bali',''),(162,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692420','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','3f30f7c388521eee783de88c8a98fa5b','Bali',''),(163,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692586','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(164,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692587','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(165,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692588','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(166,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692589','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(167,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692602','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(168,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692603','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(169,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692623','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(170,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692630','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(171,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692633','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(172,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692634','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(173,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692712','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(174,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692716','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(175,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692745','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(176,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692748','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(177,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692768','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(178,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692771','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(179,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692800','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(180,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692827','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(181,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692831','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(182,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692849','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(183,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692852','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(184,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692862','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(185,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692863','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(186,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692863','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(187,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692866','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(188,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692869','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(189,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692871','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(190,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692872','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(191,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692973','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(192,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692977','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(193,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692986','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(194,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692986','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(195,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540692987','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(196,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693137','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(197,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693140','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(198,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693358','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(199,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693361','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(200,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693394','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(201,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693397','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(202,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693398','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(203,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693409','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(204,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693410','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(205,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693560','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','28b420ac85ebf2dba211720db9f4dee3','Bali',''),(206,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693561','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','b3a4efb07850f80536fbc1358f3e89ce','Bali',''),(207,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693563','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','ea08e72cfb3c72bae8ec43a482f5949f','Bali',''),(208,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693565','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','4db1b073a0bce9475df3f627653171b2','Bali',''),(209,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693571','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','76d03567d009ca2d4daecb69f42e0123','Bali',''),(210,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693573','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','c93a6a411cf11e5a83a8fb40cf56c222','Bali',''),(211,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693574','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','d279857147b27b7952c0d1eb11dd886c','Bali',''),(212,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693577','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','39f6681295f0c127c2dd2ba0d6f352d9','Bali',''),(213,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693579','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','8f786a2d0b1c183fcc18306657d3d62e','Bali',''),(214,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693586','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','a1e22ff7f0b94a78cb68525c1b0b10de','Bali',''),(215,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693588','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','492dde729ca52153e8d81bfcaed8a3a3','Bali',''),(216,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693589','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','e382f079962748977552c650f29e5931','Bali',''),(217,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693590','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','f7c099282670bff33c6dc2a2ff1b2b22','Bali',''),(218,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693593','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','09bd169b6abb8b3a1e6d2f9a9583e749','Bali',''),(219,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693596','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','276493fd35c14b54ed9c32ba92908f1e','Bali',''),(220,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693715','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(221,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693719','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(222,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693720','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(223,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693721','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(224,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693728','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(225,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693731','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(226,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693747','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(227,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693749','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(228,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693750','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(229,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693798','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(230,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693798','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(231,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693799','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(232,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693807','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(233,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693808','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(234,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693825','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(235,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693828','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(236,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693828','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(237,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693834','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(238,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693836','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(239,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693843','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(240,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693847','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(241,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693856','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(242,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693858','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(243,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693950','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(244,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693952','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(245,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693957','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(246,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693973','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(247,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693992','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(248,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693993','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(249,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693993','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(250,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693994','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(251,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693994','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(252,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693995','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(253,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540693999','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(254,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694025','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(255,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694030','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(256,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694037','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(257,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694041','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(258,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694143','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(259,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694144','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(260,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694144','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(261,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694250','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(262,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694277','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(263,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694313','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(264,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694331','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(265,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694341','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali',''),(266,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','1540694350','',0,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','the formId is a mock one','Bali','');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_friend`;
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


INSERT INTO `ims_dbs_masclwlcard_friend` VALUES (4,2,0,'',0,'','测试动态',1540693389,'images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg','&lt;p&gt;测试动态测试动态测试动态测试动态测试动态测试动态测试动态测试动态测试动态测试动态测试动态&lt;/p&gt;',0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_nav`;
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


DROP TABLE IF EXISTS `ims_dbs_masclwlcard_news`;
CREATE TABLE `ims_dbs_masclwlcard_news` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `title` varchar(300) NOT NULL,
  `time` int(10) NOT NULL,
  `head_img` varchar(300) NOT NULL,
  `content` text NOT NULL,
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


INSERT INTO `ims_dbs_masclwlcard_news` VALUES (3,2,'公司活动',1540692844,'images/2/2018/10/WIab84077qQNiERrUR3q7geaPrRe7a.jpg','&lt;p&gt;公司活动公司活动公司活动公司活动公司活动公司活动&lt;/p&gt;',0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_pl`;
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

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_product`;
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


INSERT INTO `ims_dbs_masclwlcard_product` VALUES (22,2,'a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','测试产品','0.01',0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_set`;
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


INSERT INTO `ims_dbs_masclwlcard_set` VALUES (4,2,'承德市众维广告有限公司','','',0,'河北省承德市双桥区文化娱乐中心1901-1','',1,'0314-0000000','images/2/2018/10/WIab84077qQNiERrUR3q7geaPrRe7a.jpg','images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg',0,0.00,0.00);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops`;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


INSERT INTO `ims_dbs_masclwlcard_shops` VALUES (3,2,'a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','测试产品',4,0,100,1000,0,0,1,'','','1540693125','images/2/2018/10/WIab84077qQNiERrUR3q7geaPrRe7a.jpg',0.01,0,0.00,0);


DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_category`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


INSERT INTO `ims_dbs_masclwlcard_shops_category` VALUES (4,2,'images/2/2018/10/WIab84077qQNiERrUR3q7geaPrRe7a.jpg',0,0,0,1,'分类一'),(5,2,'images/2/2018/10/WIab84077qQNiERrUR3q7geaPrRe7a.jpg',0,0,0,1,'分类2');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_web`;
CREATE TABLE `ims_dbs_masclwlcard_web` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `video` varchar(380) NOT NULL,
  `cp_bs_content` text NOT NULL,
  `images` varchar(380) NOT NULL,
  `tx_video` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;


INSERT INTO `ims_dbs_masclwlcard_web` VALUES (4,2,'','a:1:{i:0;s:51:\"images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg\";}','images/2/2018/10/uL18TBEBS6ZjbSSeZ3tLa86bA6aaJT.jpg',0);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_zan`;
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

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_chat`;
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


INSERT INTO `ims_dbs_masclwlcard_chat` VALUES (34,2,0,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692053','',8,0,0,1,0,1,0,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','3725ed9a11daa3fc12821522654a1f2e','！','Bali',''),(35,2,0,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692150','',8,0,0,1,0,1,0,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','40a9a794c0822560f76e93092156cafb','这么着','Bali','');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_act_report`;
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


INSERT INTO `ims_dbs_masclwlcard_act_report` VALUES (653,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691754','0','0','',8,1,656,0,1,1,'','难得糊涂第1次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(654,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691778','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(655,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691789','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(656,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691790','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(657,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691791','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(658,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691793','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(659,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691793','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(660,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691794','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(661,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691795','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(662,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(663,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(664,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691801','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(665,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691817','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(666,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691817','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(667,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691818','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(668,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691833','0','0','',8,2,656,0,1,1,'','难得糊涂第2次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(669,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691846','0','0','',8,0,103,0,1,1,'','难得糊涂分享了名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(670,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691859','0','0','',8,0,659,0,1,1,'','难得糊涂生成了您的海报','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(671,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540691995','0','0','',8,3,656,0,1,1,'','难得糊涂第3次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(672,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692023','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(673,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692029','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(674,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692029','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(675,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692031','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(676,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692033','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(677,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692035','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(678,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692036','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(679,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692039','0','0','',8,4,656,0,1,1,'','难得糊涂第4次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(680,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692041','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(681,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692044','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(682,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692089','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(683,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692240','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(684,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692251','0','0','',8,5,656,0,1,1,'','难得糊涂第5次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(685,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692254','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(686,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692255','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(687,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692256','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(688,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692393','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(689,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692394','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(690,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692413','0','0','',8,6,656,0,1,1,'','难得糊涂第6次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(691,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692416','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(692,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692418','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(693,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692419','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(694,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692420','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(695,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692581','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(696,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692584','0','0','',8,7,656,0,1,1,'','难得糊涂第7次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(697,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692586','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(698,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692587','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(699,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692588','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(700,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692589','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(701,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692590','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(702,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692599','0','0','',8,8,656,0,1,1,'','难得糊涂第8次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(703,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692602','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(704,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692603','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(705,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692604','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(706,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692621','0','0','',8,9,656,0,1,1,'','难得糊涂第9次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(707,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692623','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(708,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692630','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(709,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692633','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(710,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692634','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(711,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692713','0','0','',8,10,656,0,1,1,'','难得糊涂第10次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(712,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692716','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(713,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692746','0','0','',8,11,656,0,1,1,'','难得糊涂第11次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(714,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692748','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(715,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692769','0','0','',8,12,656,0,1,1,'','难得糊涂第12次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(716,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692771','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(717,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692801','0','0','',8,13,656,0,1,1,'','难得糊涂第13次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(718,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692828','0','0','',8,14,656,0,1,1,'','难得糊涂第14次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(719,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692831','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(720,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692850','0','0','',8,15,656,0,1,1,'','难得糊涂第15次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(721,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692852','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(722,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692862','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(723,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692863','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(724,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692863','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(725,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692866','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(726,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692869','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(727,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692871','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(728,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692872','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(729,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692974','0','0','',8,16,656,0,1,1,'','难得糊涂第16次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(730,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692977','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(731,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692986','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(732,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692987','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(733,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540692987','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(734,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693138','0','0','',8,17,656,0,1,1,'','难得糊涂第17次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(735,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693140','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(736,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693143','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(737,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693153','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(738,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693359','0','0','',8,18,656,0,1,1,'','难得糊涂第18次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(739,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693361','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(740,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693395','0','0','',8,19,656,0,1,1,'','难得糊涂第19次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(741,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693397','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(742,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693398','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(743,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693407','0','0','',8,20,656,0,1,1,'','难得糊涂第20次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(744,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693409','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(745,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693410','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(746,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693411','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(747,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693560','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(748,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693561','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(749,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693565','0','0','',8,21,656,0,1,1,'','难得糊涂第21次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(750,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693568','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(751,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693571','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(752,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693573','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(753,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693574','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(754,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693577','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(755,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693579','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(756,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693586','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(757,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693588','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(758,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693589','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(759,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693590','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(760,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693593','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(761,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693596','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(762,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693716','0','0','',8,22,656,0,1,1,'','难得糊涂第22次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(763,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693719','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(764,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693720','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(765,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693721','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(766,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693728','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(767,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693731','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(768,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693747','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(769,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693749','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(770,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693750','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(771,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693798','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(772,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693798','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(773,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693799','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(774,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693807','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(775,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693808','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(776,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693825','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(777,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693828','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(778,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693828','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(779,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693834','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(780,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693836','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(781,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693843','0','0','',8,23,656,0,1,1,'','难得糊涂第23次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(782,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693847','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(783,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693856','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(784,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693858','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(785,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693950','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(786,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693952','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(787,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693957','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(788,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693973','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(789,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693992','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(790,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693993','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(791,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693993','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(792,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693994','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(793,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693994','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(794,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693995','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(795,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540693999','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(796,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694025','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(797,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694030','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(798,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694037','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(799,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694041','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(800,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694143','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(801,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694144','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(802,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694144','0','0','',8,0,657,0,1,1,'','难得糊涂正在查看名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(803,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694277','0','0','',8,24,656,0,1,1,'','难得糊涂第24次打开你的名片','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(804,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694313','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(805,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694322','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(806,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694331','0','2','',8,0,657,0,1,1,'','难得糊涂正在查看动态','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(807,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694341','0','3','',8,0,657,0,1,1,'','难得糊涂正在进入官网','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(808,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694350','0','1','',8,0,657,0,1,1,'','难得糊涂正在查看商城','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(809,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694353','0','0','',8,0,301,0,1,1,'','难得糊涂 正在浏览 商品:测试产品','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',''),(810,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','1540694356','0','0','',8,0,701,0,1,1,'','难得糊涂正在进入对话框,赶紧去看看吧!\n','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_set_qy`;
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

-- avatar_url 字段名坐了修改
DROP TABLE IF EXISTS `ims_dbs_masclwlcard_member`;
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


INSERT INTO `ims_dbs_masclwlcard_member` VALUES (3,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','13832495474','1540691778','',1,1,'','zh_CN','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali','');

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_spec`;
CREATE TABLE `ims_dbs_masclwlcard_shops_spec` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `uniacid` int(10) unsigned NOT NULL,
  `spec_content` text NOT NULL COMMENT '商品规格',
  `title` varchar(200) NOT NULL COMMENT '规格名称',
  `sort` int(11) NOT NULL COMMENT '规格名称',
  `enabled` tinyint(1) NOT NULL COMMENT '规格名称',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_address`;
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


INSERT INTO `ims_dbs_masclwlcard_shops_address` VALUES (3,2,'oJvjW5XupnkKVRCgXsA9pHY4GG7E','难得糊涂','','','','',1,1,'','0','zh_CN','张三','0','北京市','北京市','东城区','测试','','1333333333','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJ2NVHLIh93pRpm3ibeibYSaGC6YDGdnfcdU9Vbt2DQ9VECYKHBcS0ciaM2bd3VxKibMzgmjiaiaaxOFLnA/132','Bali',1,'');


DROP TABLE IF EXISTS `ims_dbs_masclwlcard_shops_order`;
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

DROP TABLE IF EXISTS `ims_ims_dbs_masclwlcard_bank`;
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