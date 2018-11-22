-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: poseidon
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `db_address`
--

DROP TABLE IF EXISTS `db_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_default` tinyint(4) DEFAULT NULL,
  `street_name` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_address`
--

LOCK TABLES `db_address` WRITE;
/*!40000 ALTER TABLE `db_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_article`
--

DROP TABLE IF EXISTS `db_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_article`
--

LOCK TABLES `db_article` WRITE;
/*!40000 ALTER TABLE `db_article` DISABLE KEYS */;
INSERT INTO `db_article` VALUES (1,'cjasldjclsadjclsadjclsd','/pic/dataImg1.png'),(2,'jvoeajfvcdslfjvcldfikjv','/pic/dataImg2.png'),(3,'cjsaodcjisladcjsdl','/pic/dataImg3.png'),(4,'cjasldcjsadlcjsldkj','/pic/dataImg4.png');
/*!40000 ALTER TABLE `db_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_item`
--

DROP TABLE IF EXISTS `db_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_item` (
  `item_id` varchar(200) NOT NULL,
  `name` varchar(200) DEFAULT NULL COMMENT '商品名称',
  `sell_point` varchar(200) DEFAULT NULL COMMENT '卖点',
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(50) DEFAULT NULL COMMENT '库存',
  `limit_num` int(50) DEFAULT NULL COMMENT '限制售卖的数量',
  `image` varchar(2000) DEFAULT NULL COMMENT '商品图片',
  `c_id` bigint(20) DEFAULT NULL COMMENT '分类id',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL COMMENT '排序号码',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `description` text COMMENT '描述',
  PRIMARY KEY (`item_id`),
  KEY `db_item_c_id_index` (`c_id`),
  KEY `db_item_status_index` (`status`),
  KEY `db_item_updated_index` (`updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item`
--

LOCK TABLES `db_item` WRITE;
/*!40000 ALTER TABLE `db_item` DISABLE KEYS */;
INSERT INTO `db_item` VALUES ('BHTRTGVR','红米Note 5','迄今拍照最好的红米手机*，1.4μm超大像素，暗光拍照更清晰。Dual PD 双核对焦，\n让你更快地抓拍精彩瞬间。还有AI人像模式，让你拍出前景清晰背景虚化的人像大片。\n更有13MP前置柔光自拍，暗光下自动开启柔光灯，照亮面部每个细节。',1000.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/note5-80-80.png',22,1,'2018-11-06 15:19:34','2018-11-06 15:19:34',16,NULL,'desc'),('BMRTGVFSD','红米6 Pro','AI双摄，高颜值大容量',869.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/6pro140-140.png',22,1,'2018-11-06 15:15:03','2018-11-06 15:15:04',13,NULL,NULL),('BRGVDSVSD','红米S2','前置1600万 智能美拍｜后置1200万 AI 双摄\n骁龙625 八核处理器｜“杨柳腰” 纤薄机身\n\n',999.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/s2-80-80.png',22,1,'2018-11-06 15:21:14','2018-11-06 15:21:14',16,NULL,NULL),('BRTGFVSD','米粉卡 日租卡','「1元日租卡」每天800M，流量刚刚好\n\n「任性用日租卡」3元任性用，真正吃到饱',3.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/mifenka-1.jpg',22,1,'2018-11-06 15:23:04','2018-11-06 15:23:05',17,NULL,NULL),('BRWTGVRF','小米电视4C 50英寸','4K HDR 人工智能语音电视',1899.00,100,80,'//i1.mifile.cn/a1/pms_1522318330.86967810!220x220.jpg',8,1,'2018-11-03 12:55:40','2018-11-03 12:55:41',2,'',NULL),('BSDFVDSVFD','小米移动 电话卡','吃到饱 联通版：月使用流量达到20GB上网速率限速至1Mbps，累计达到100GB后，上网速率限速至256Kbps，次月恢复4G上网速率；\n吃到饱 电信版：可办理特惠语音包，国内拨打低至0.06元 / 分钟\n任我行 联通版：可办理特惠流量包，国内流量低至0.05元 / MB?',30.00,100,80,'//i1.mifile.cn/f/i/15/goods/sidebar/mimobile.jpg',22,1,'2018-11-06 15:23:52','2018-11-06 15:23:52',18,NULL,NULL),('GHROTGTWTW','小米8 屏幕指纹版','压感屏幕指纹,透明玻璃机身',3199.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/pingmu-320.png',22,1,'2018-10-27 11:55:23','2018-10-28 07:58:39',3,'新品',NULL),('GJROTGJROTIG','小米6X','轻薄美观的拍照手机 / 前置2000万“治愈系”自拍 / 后置2000万 AI双摄 / 标配骁龙660 AIE处理器',1649.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/80808080808080.jpg',22,1,'2018-11-03 12:33:07','2018-11-03 12:33:09',7,'',NULL),('GRJTOGVJRFGOV','小米笔记本Air 13.3\"','全新升级：第八代四核处理器\n',5399.00,100,80,'//i1.mifile.cn/a4/xmad_15350951136177_QUuVm.png',8,1,'2018-11-03 12:58:14','2018-11-03 12:58:18',4,NULL,NULL),('GROTIGJROTIGJROTI','小米MIX 3','磁动力滑盖全面屏',3299.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/mix3-320.png',22,1,'2018-10-27 08:59:22','2018-10-27 11:55:24',1,'新品',NULL),('GRTOGPADCS','小米8 SE','骁龙710全球首发',1699.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/pc-320-220-mi8se.png',22,1,'2018-10-27 11:59:07','2018-10-27 11:59:08',5,'',NULL),('HBNTHBGF','米家LED吸顶灯','Φ450mm 适合25m²以内 | 色温亮度可调 | 墙壁开关切换光线 | 蓝牙网关 | 防尘防虫 | 快速安装',399.00,100,80,'//i1.mifile.cn/a4/xmad_15281923207128_rOfDp.png',8,1,'2018-11-03 13:02:22','2018-11-03 13:02:23',7,NULL,NULL),('PBGRTBVFGD','红米6A','12nm高性能处理器｜5.45\"小巧全面屏｜1300万高清相机｜“小杨柳腰”机身',2300.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/6AAAA.png',22,1,'2018-11-06 15:18:08','2018-11-06 15:18:09',15,'',NULL),('PDCASDCSD','小米MIX 2','得益于不断进化的全面屏科技，使得屏幕底边革命性地再次缩短 12%，\n为 18:9 全面屏带来更纯粹的观看体验。点亮的瞬间，你会发现这就是全面屏真正的样子。',3000.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/mix2-80.png',22,1,'2018-11-06 15:13:47','2018-11-06 15:13:48',12,NULL,NULL),('PFREWRVE','米家电水壶','一杯水，是一家人的安心',99.00,100,80,'//i1.mifile.cn/a1/pms_1504498936.11861982!220x220.jpg',8,1,'2018-11-03 13:00:16','2018-11-03 13:00:18',6,NULL,NULL),('PHGRTEGRTG','小米电视4A 43英寸 青春版','老人小孩都会用的人工智能语音电视',1399.00,100,80,'//i1.mifile.cn/a1/pms_1524883847.49276938!220x220.jpg',8,1,'2018-11-03 12:54:27','2018-11-03 12:54:28',1,'',NULL),('PIJOIJOIJ','小米Max 3','巨无霸超级全面屏',1699.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/max3-320-220.png',22,1,'2018-10-27 12:00:10','2018-10-27 12:00:11',6,'',NULL),('PQRFERFEFVEDRF','黑鲨游戏手机 Helo','双液冷 更能打',2000.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/heishahelo-80.png',22,1,'2018-11-06 15:09:21','2018-11-06 15:09:22',10,NULL,NULL),('PTGBRVDFVDF','小米MIX 2S','骁龙 845 旗舰处理器 | AI 双摄相机 | 艺术品般的陶瓷机身',3900.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/mix2s80-80white.png',22,1,'2018-11-06 15:07:00','2018-11-06 15:07:01',9,NULL,NULL),('QEWQEDFDF','小米净水器','大流量直出纯净水，健康家庭必备',1999.00,100,80,'//i1.mifile.cn/a1/pms_1521634907.16181074!220x220.jpg',8,1,'2018-11-03 13:37:59','2018-11-03 13:38:00',8,NULL,NULL),('QEWRFRFERFER','小米8','超轻四曲面，前置2000万',2499.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/pc-320-220-mi8.png',22,1,'2018-10-27 11:56:59','2018-10-27 11:57:01',4,'',NULL),('QRERFRRFCAS','黑鲨游戏手机','液冷更快  一键战力觉醒',2300.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/heisha-80.png',22,1,'2018-11-06 15:12:21','2018-11-06 15:12:22',11,NULL,NULL),('TBHGRTGVRFV','红米6','红米6\nAI双摄 小屏高性能\n后置1200万 AI双摄 / 12nm八核处理器 / 5.45”高清全面屏 / AI 人脸解锁',2000.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/666666.png',22,1,'2018-11-06 15:16:19','2018-11-06 15:16:20',14,NULL,NULL),('TBRWTFVSDFV','云服务空间月卡','小米云服务空间月卡',100.00,100,80,'https://i1.mifile.cn/f/i/g/2015/yunfuwu.jpg',22,1,'2018-11-06 15:24:50','2018-11-06 15:24:51',19,NULL,NULL),('TBVRTGBVRVRF','小米笔记本 15.6','全面均衡的国民轻薄本\n第八代酷睿™ 四核处理器',4199.00,100,80,'//i1.mifile.cn/a4/xmad_15350951136177_QUuVm.png',8,1,'2018-11-03 12:57:07','2018-11-03 12:57:08',3,'新品',NULL),('TGTRGJRLTGJR','小米8 青春版','潮流镜面渐变色,AI裸妆美颜',1399.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/qingchun-320.png',22,1,'2018-10-27 11:37:52','2018-10-27 11:37:53',2,'新品',NULL),('TRTGRTGRTGR','小米MAX2','6.44\'\'大屏 / 5300mAh 充电宝级的大电量 / 大像素相机 / 轻薄全金属 / ​4GB 大内存 / 骁龙八核处理器',1699.00,100,80,'//i1.mifile.cn/f/i/g/2015/cn-index/max2_80.jpg',22,1,'2018-11-03 12:35:31','2018-11-03 12:35:32',7,'',NULL),('VAAAEFEFERF','米家空气净化器 Pro','澎湃动力，净化能力更快更强',1499.00,100,80,'//i1.mifile.cn/a4/xmad_14972549116226_tZpod.png',8,1,'2018-11-03 12:59:08','2018-11-03 12:59:09',5,NULL,NULL);
/*!40000 ALTER TABLE `db_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_item_cat`
--

DROP TABLE IF EXISTS `db_item_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_item_cat` (
  `item_cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `is_parent` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`item_cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item_cat`
--

LOCK TABLES `db_item_cat` WRITE;
/*!40000 ALTER TABLE `db_item_cat` DISABLE KEYS */;
INSERT INTO `db_item_cat` VALUES (1,'2018-10-26 09:29:21',NULL,_binary '','手机',0,'index',0,1,'2018-10-26 09:29:35'),(3,'2018-10-26 09:29:44',NULL,_binary '','电话卡',0,NULL,0,1,'2018-10-26 09:29:59'),(4,'2018-10-26 09:30:06',NULL,_binary '','电视',0,'nav',3,1,'2018-10-26 09:30:19'),(5,'2018-10-26 09:30:29',NULL,_binary '','盒子',0,NULL,0,1,'2018-10-26 09:30:38'),(6,'2018-10-26 09:31:34',NULL,_binary '','笔记本',0,'nav',4,1,'2018-10-26 09:31:57'),(7,'2018-10-26 09:32:05',NULL,_binary '','平板',0,NULL,0,1,'2018-10-26 09:32:18'),(8,'2018-10-26 09:32:28',NULL,_binary '','家电',0,'index',0,1,'2018-10-26 09:32:46'),(9,'2018-10-26 09:32:51',NULL,_binary '','插线板',0,NULL,0,1,'2018-10-26 09:33:09'),(10,'2018-10-26 09:33:17',NULL,_binary '','出行',0,NULL,0,1,'2018-10-26 09:33:30'),(11,'2018-10-26 09:34:11',NULL,_binary '','穿戴',0,NULL,0,1,'2018-10-26 09:34:24'),(12,'2018-10-26 09:34:39',NULL,_binary '','智能',0,'nav',7,1,'2018-10-26 09:34:54'),(13,'2018-10-26 09:35:00',NULL,_binary '','路由器',0,'nav',6,1,'2018-10-26 09:35:12'),(14,'2018-10-26 09:37:24',NULL,_binary '','电源',0,NULL,0,1,'2018-10-26 09:37:34'),(15,'2018-10-26 09:37:38',NULL,_binary '','配件',0,NULL,0,1,'2018-10-26 09:37:48'),(16,'2018-10-26 09:37:55',NULL,_binary '','健康',0,NULL,0,1,'2018-10-26 09:38:04'),(17,'2018-10-26 09:38:07',NULL,_binary '','儿童',0,NULL,0,1,'2018-10-26 09:38:15'),(18,'2018-10-26 09:38:23',NULL,_binary '','耳机',0,NULL,0,1,'2018-10-26 09:38:33'),(19,'2018-10-26 09:38:43',NULL,_binary '','音箱',0,NULL,0,1,'2018-10-26 09:38:54'),(20,'2018-10-26 09:39:02',NULL,_binary '','生活',0,NULL,0,1,'2018-10-26 09:39:13'),(21,'2018-10-26 09:39:16',NULL,_binary '','箱包',0,NULL,0,1,'2018-10-26 09:39:25'),(22,'2018-10-26 11:05:33',NULL,NULL,'小米手机',1,'nav',1,1,'2018-10-26 11:05:56'),(23,'2018-10-26 11:06:01',NULL,NULL,'红米手机',1,'nav',2,1,'2018-10-26 11:06:21'),(24,'2018-10-26 11:09:51',NULL,NULL,'空调',7,'nav',8,1,'2018-10-26 11:10:16'),(25,'2018-10-26 11:11:12',NULL,_binary '','新品',-1,'nav',5,1,'2018-10-26 11:11:44'),(26,'2018-10-27 07:17:47',NULL,_binary '','服务',-1,'nav',9,1,'2018-10-27 07:18:09'),(27,'2018-10-27 07:18:12',NULL,_binary '','社区',-1,'nav',10,1,'2018-10-27 07:18:25');
/*!40000 ALTER TABLE `db_item_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_item_cat_item`
--

DROP TABLE IF EXISTS `db_item_cat_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_item_cat_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(200) DEFAULT NULL,
  `item_cat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `db_item_cat_item_db_item_id_fk` (`item_id`),
  KEY `db_item_cat_item_db_item_cat_item_cat_id_fk` (`item_cat_id`),
  CONSTRAINT `db_item_cat_item_db_item_cat_item_cat_id_fk` FOREIGN KEY (`item_cat_id`) REFERENCES `db_item_cat` (`item_cat_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `db_item_cat_item_db_item_id_fk` FOREIGN KEY (`item_id`) REFERENCES `db_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item_cat_item`
--

LOCK TABLES `db_item_cat_item` WRITE;
/*!40000 ALTER TABLE `db_item_cat_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_item_cat_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_item_img`
--

DROP TABLE IF EXISTS `db_item_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_item_img` (
  `id` varchar(200) NOT NULL,
  `item_id` varchar(200) DEFAULT NULL,
  `size` varchar(200) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item_img`
--

LOCK TABLES `db_item_img` WRITE;
/*!40000 ALTER TABLE `db_item_img` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_item_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_log`
--

DROP TABLE IF EXISTS `db_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `ip_info` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `request_param` varchar(255) DEFAULT NULL,
  `request_type` varchar(255) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_log`
--

LOCK TABLES `db_log` WRITE;
/*!40000 ALTER TABLE `db_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_member`
--

DROP TABLE IF EXISTS `db_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `balance` decimal(19,2) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_member`
--

LOCK TABLES `db_member` WRITE;
/*!40000 ALTER TABLE `db_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_order`
--

DROP TABLE IF EXISTS `db_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_order` (
  `order_id` varchar(50) NOT NULL,
  `payment` decimal(10,2) DEFAULT NULL COMMENT '实付金额',
  `payment_type` int(1) DEFAULT NULL COMMENT '支付方式',
  `post_fee` decimal(10,2) DEFAULT NULL COMMENT '邮费',
  `status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `close_time` datetime DEFAULT NULL,
  `shipping_name` varchar(20) DEFAULT NULL COMMENT '物流名称',
  `shipping_code` varchar(20) DEFAULT NULL COMMENT '物流单号',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '买家id',
  `buyer_message` varchar(50) DEFAULT NULL COMMENT '买家留言',
  `buyer_nick` varchar(50) DEFAULT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  `seller_nick` varchar(20) DEFAULT NULL,
  `buyer_comment` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `db_order_buyer_nick_index` (`buyer_nick`),
  KEY `db_order_create_time_index` (`create_time`),
  KEY `db_order_payment_type_index` (`payment_type`),
  KEY `db_order_status_index` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_order`
--

LOCK TABLES `db_order` WRITE;
/*!40000 ALTER TABLE `db_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_order_shipping`
--

DROP TABLE IF EXISTS `db_order_shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_order_shipping` (
  `order_id` varchar(50) NOT NULL,
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货人名称',
  `receiver_mobile` varchar(20) DEFAULT NULL,
  `receiver_state` varchar(20) DEFAULT NULL COMMENT '省份',
  `receiver_city` varchar(20) DEFAULT NULL COMMENT '城市',
  `receiver_district` varchar(20) DEFAULT NULL COMMENT '区县',
  `receiver_address` varchar(20) DEFAULT NULL COMMENT '收货地址',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单运送表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_order_shipping`
--

LOCK TABLES `db_order_shipping` WRITE;
/*!40000 ALTER TABLE `db_order_shipping` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_order_shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_panel`
--

DROP TABLE IF EXISTS `db_panel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_panel` (
  `panel_id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `limit_num` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`panel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_panel`
--

LOCK TABLES `db_panel` WRITE;
/*!40000 ALTER TABLE `db_panel` DISABLE KEYS */;
INSERT INTO `db_panel` VALUES (1,'2018-11-21 03:38:15',100,'手机','index',1,1,NULL,'2018-11-21 03:38:38');
/*!40000 ALTER TABLE `db_panel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_panel_content`
--

DROP TABLE IF EXISTS `db_panel_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_panel_content` (
  `panel_content_id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `panel_id` int(11) DEFAULT NULL,
  `pic_url` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`panel_content_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_panel_content`
--

LOCK TABLES `db_panel_content` WRITE;
/*!40000 ALTER TABLE `db_panel_content` DISABLE KEYS */;
INSERT INTO `db_panel_content` VALUES (1,'2018-11-21 03:39:30',1,NULL,1,1,'2018-11-21 03:40:08');
/*!40000 ALTER TABLE `db_panel_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_permission`
--

DROP TABLE IF EXISTS `db_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_permission`
--

LOCK TABLES `db_permission` WRITE;
/*!40000 ALTER TABLE `db_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_role`
--

DROP TABLE IF EXISTS `db_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_role`
--

LOCK TABLES `db_role` WRITE;
/*!40000 ALTER TABLE `db_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_role_perm`
--

DROP TABLE IF EXISTS `db_role_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_role_perm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_role_perm`
--

LOCK TABLES `db_role_perm` WRITE;
/*!40000 ALTER TABLE `db_role_perm` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_role_perm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_user`
--

DROP TABLE IF EXISTS `db_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `file` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_user`
--

LOCK TABLES `db_user` WRITE;
/*!40000 ALTER TABLE `db_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` varchar(20) NOT NULL,
  `item_id` varchar(20) DEFAULT NULL,
  `order_id` varchar(20) DEFAULT NULL,
  `item_num` int(11) DEFAULT NULL COMMENT '商品购买的数量',
  `item_price` decimal(10,2) DEFAULT NULL COMMENT '商品单价',
  `item_total_price` decimal(10,2) DEFAULT NULL COMMENT '商品总金额',
  PRIMARY KEY (`id`),
  KEY `order_item_item_id_index` (`item_id`),
  KEY `order_item_order_id_index` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单商品关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-22 15:51:09
