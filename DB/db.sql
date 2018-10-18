-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_address`
--

LOCK TABLES `db_address` WRITE;
/*!40000 ALTER TABLE `db_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `db_item`
--

DROP TABLE IF EXISTS `db_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `db_item` (
  `id` varchar(200) NOT NULL,
  `title` varchar(20) DEFAULT NULL COMMENT '商品名称',
  `sell_point` varchar(200) DEFAULT NULL COMMENT '卖点',
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(50) DEFAULT NULL COMMENT '库存',
  `limit_num` int(50) DEFAULT NULL COMMENT '限制售卖的数量',
  `image` varchar(2000) DEFAULT NULL COMMENT '商品图片',
  `c_id` int(11) DEFAULT NULL COMMENT '分类id',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL COMMENT '排序号码',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `description` text COMMENT '描述',
  PRIMARY KEY (`id`),
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
INSERT INTO `db_item` VALUES ('0833E101-A94B-32A4-4672-434A4097DC4D','at arcu.','ultricies ornare, elit elit fermentum risus, at fringilla purus mauris',-0.28,10,5,'auctor, velit eget laoreet posuere, enim nisl elementum purus, accumsan',2,1,'2018-07-15 00:47:38','2018-06-21 13:14:58',1,'ut eros','accumsan neque et nunc.'),('1B613ABE-3871-48B9-584C-177D88835B93','et, magna.','sagittis augue, eu tempor erat neque non quam. Pellentesque habitant',-0.13,6,5,'convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc',9,1,'2018-03-11 11:39:46','2019-03-29 02:40:03',1,'Quisque porttitor','varius orci, in consequat enim diam vel arcu. Curabitur ut'),('1BDDE63E-9CA7-F750-B503-554292B29006','dapibus gravida.','mauris elit, dictum eu, eleifend nec, malesuada ut, sem. Nulla',-0.03,7,1,'massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices',10,3,'2019-07-28 11:15:20','2018-04-04 11:48:09',1,'nonummy ultricies','parturient montes, nascetur ridiculus'),('1C7E8E86-92F0-C6D3-DED6-43BA459C3BC7','magna. Praesent','Fusce feugiat. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.',-0.25,5,6,'sem egestas blandit. Nam nulla magna, malesuada vel, convallis in,',6,3,'2017-12-23 07:25:34','2018-02-18 23:14:00',1,'sed libero.','Vivamus nibh dolor, nonummy ac, feugiat'),('1F67FE66-F5B0-4DF4-A00C-66CB3C80EF5B','Mauris molestie','lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis',-0.20,9,8,'arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing.',8,2,'2019-02-09 11:05:23','2017-10-22 22:56:31',2,'et nunc.','arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien,'),('23B64D8F-7853-AC85-F508-53300D83CDF6','lectus convallis','Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet',0.13,10,9,'lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras',6,1,'2019-07-24 20:17:36','2019-05-30 23:21:47',2,'sagittis semper.','pede ac'),('26FB95B1-50C0-8831-54EA-EF7F91EDEBA9','nunc. In','consequat purus. Maecenas libero est, congue a, aliquet vel, vulputate',0.04,6,4,'penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin',9,2,'2018-11-05 18:58:28','2018-12-06 15:33:37',2,'eros. Nam','et pede. Nunc sed orci'),('3093CBFE-553F-CC34-59A9-5B5AA81B0F59','velit. Aliquam','et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien,',0.37,4,3,'dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec,',7,1,'2018-03-24 14:05:14','2018-10-10 14:54:03',2,'consectetuer adipiscing','dictum magna. Ut tincidunt'),('33E8C729-207B-6CFD-F136-2148726715A8','scelerisque mollis.','Integer sem elit, pharetra ut, pharetra sed, hendrerit a, arcu.',-0.17,2,5,'nulla magna, malesuada vel, convallis in, cursus et, eros. Proin',8,1,'2018-05-03 11:02:23','2018-12-27 16:57:53',2,'pede sagittis','ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et'),('3FA1A71A-71C6-6DBA-B413-EB223BA18551','et magnis','sed orci lobortis augue scelerisque mollis. Phasellus libero mauris, aliquam',0.66,9,4,'ad litora torquent per conubia nostra, per inceptos hymenaeos. Mauris',7,2,'2018-12-05 04:44:33','2019-03-31 06:02:14',2,'at, nisi.','massa. Quisque porttitor eros nec'),('527E675C-2987-5274-8125-B61DAA89FD0B','hendrerit neque.','non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet,',-0.09,3,10,'felis. Nulla tempor augue ac ipsum. Phasellus vitae mauris sit',4,2,'2018-05-31 13:20:16','2019-05-05 21:53:08',1,'a sollicitudin','massa. Suspendisse eleifend. Cras sed leo. Cras vehicula aliquet libero.'),('5E381AB3-7BAF-6041-6FB3-CE1B6626B4C3','Morbi quis','montes, nascetur ridiculus mus. Proin vel nisl. Quisque fringilla euismod',0.45,6,2,'risus. Quisque libero lacus, varius et, euismod et, commodo at,',4,1,'2017-10-07 01:28:26','2019-06-28 05:14:23',1,'lobortis risus.','faucibus leo, in lobortis tellus justo sit amet nulla. Donec'),('622CEA9F-CCA4-F37C-34E3-D73C612F4E7B','In mi','est ac mattis semper, dui lectus rutrum urna, nec luctus',-0.33,10,10,'dictum placerat, augue. Sed molestie. Sed id risus quis diam',4,1,'2018-10-04 09:13:05','2019-03-02 15:03:15',1,'non enim.','non'),('66549065-710D-6EB9-1FE0-A602AD81D1E0','Sed nulla','Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus id,',-0.50,5,8,'placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante,',5,3,'2018-10-04 19:25:35','2017-12-08 10:20:28',1,'amet, consectetuer','montes, nascetur ridiculus mus. Aenean eget magna.'),('7A0E8219-5D34-1EB3-F2FD-EBD9955CE732','rhoncus id,','Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna',0.15,5,8,'Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor,',9,1,'2019-08-26 16:07:38','2017-12-02 08:44:30',2,'amet massa.','Morbi sit amet massa. Quisque porttitor eros nec'),('7EFF8091-94E3-A232-D49C-81BD62364DC2','risus a','cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet',-0.25,6,2,'nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula.',9,3,'2018-07-16 20:56:49','2018-02-11 23:51:46',2,'ultrices, mauris','in lobortis tellus justo sit amet nulla.'),('7F9A3C94-C77A-8B3B-AA7A-452B71DA7A77','pulvinar arcu','quam. Pellentesque habitant morbi tristique senectus et netus et malesuada',-0.60,10,1,'montes, nascetur ridiculus mus. Proin vel arcu eu odio tristique',2,2,'2018-02-18 06:35:04','2019-07-21 08:25:51',1,'mi. Duis','magna tellus faucibus leo, in lobortis tellus justo sit'),('82899CF5-8853-76D4-25CE-1CF8865EE529','facilisis eget,','elit. Aliquam auctor, velit eget laoreet posuere, enim nisl elementum',0.42,4,9,'pede. Praesent eu dui. Cum sociis natoque penatibus et magnis',3,1,'2019-04-20 00:04:06','2018-08-08 01:27:05',1,'Cras eu','quis massa. Mauris vestibulum, neque sed'),('85F73AB2-C461-83DB-FD8B-6A874C348864','Aenean massa.','molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis.',-0.20,10,1,'eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam',7,2,'2019-07-24 06:14:11','2017-09-25 16:20:07',1,'magna. Phasellus','ut eros non enim commodo hendrerit. Donec'),('8A667B77-8E7D-6CA1-E056-EBF2DAA42054','vitae mauris','Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas',-0.05,1,9,'eu augue porttitor interdum. Sed auctor odio a purus. Duis',4,2,'2017-12-02 05:34:07','2018-05-13 01:54:24',2,'venenatis a,','magna. Lorem'),('ADA2CC27-5897-76E0-0267-E1D0DAB454B9','id, mollis','tortor at risus. Nunc ac sem ut dolor dapibus gravida.',-0.18,10,6,'urna, nec luctus felis purus ac tellus. Suspendisse sed dolor.',9,1,'2017-12-17 09:53:08','2018-03-08 08:22:50',1,'ornare lectus','parturient montes, nascetur ridiculus mus. Proin vel arcu'),('B238F165-90CD-E56B-053C-889ED46BACF7','amet, consectetuer','pretium aliquet, metus urna convallis erat, eget tincidunt dui augue',-0.05,5,4,'egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta',5,1,'2018-05-30 06:52:18','2018-12-15 14:31:46',1,'tincidunt nibh.','sociosqu ad litora torquent per conubia'),('B5D49FAC-1763-E49C-A9E6-1513AB950545','bibendum fermentum','sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam',-0.20,5,5,'Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper viverra.',5,1,'2019-02-07 18:41:03','2018-01-03 10:31:48',1,'ipsum. Curabitur','quam dignissim pharetra. Nam'),('BCE59496-6E74-DB07-05B3-CF3CD61EF6AD','sit amet,','lacinia vitae, sodales at, velit. Pellentesque ultricies dignissim lacus. Aliquam',-0.06,8,9,'velit egestas lacinia. Sed congue, elit sed consequat auctor, nunc',3,2,'2019-03-20 17:17:42','2018-05-25 17:43:19',1,'pretium et,','mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis'),('C0A8D8CC-F20F-5C80-D9B7-F3808EB14819','nulla vulputate','ante dictum mi, ac mattis velit justo nec ante. Maecenas',-0.16,10,5,'diam vel arcu. Curabitur ut odio vel est tempor bibendum.',8,3,'2018-09-12 03:43:07','2018-09-07 19:57:57',2,'sem. Pellentesque','quam dignissim pharetra. Nam ac nulla. In tincidunt'),('C11B6657-A67A-B49D-49DA-D36927DCCCBD','malesuada ut,','non massa non ante bibendum ullamcorper. Duis cursus, diam at',-0.26,9,10,'Aliquam fringilla cursus purus. Nullam scelerisque neque sed sem egestas',5,2,'2019-04-28 12:04:00','2017-11-09 23:09:25',2,'mi fringilla','eu turpis. Nulla aliquet. Proin velit. Sed malesuada augue ut'),('C8004AF2-B240-55F8-B7E0-307D6DC7D89E','in faucibus','Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor.',-0.34,8,4,'mattis. Cras eget nisi dictum augue malesuada malesuada. Integer id',4,3,'2017-10-14 14:55:34','2017-12-24 14:10:19',2,'nisl. Maecenas','nisi sem semper'),('D3C957A5-2E48-BD5F-90C9-20A9F6F389A0','nunc sit','sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam',0.15,4,6,'sit amet, dapibus id, blandit at, nisi. Cum sociis natoque',2,1,'2019-07-22 21:25:00','2017-12-08 12:04:31',1,'gravida non,','Cum sociis natoque penatibus et magnis dis parturient montes, nascetur'),('D963F47D-25F4-C0ED-C872-B050A7F389CF','volutpat. Nulla','ante. Maecenas mi felis, adipiscing fringilla, porttitor vulputate, posuere vulputate,',-0.07,8,3,'Cras pellentesque. Sed dictum. Proin eget odio. Aliquam vulputate ullamcorper',3,3,'2019-02-15 21:43:40','2018-07-20 20:21:06',2,'vitae purus','sed orci lobortis augue scelerisque'),('E227A86A-D342-9856-E4E2-5DBAD0474F0B','et, rutrum','risus. In mi pede, nonummy ut, molestie in, tempus eu,',-0.64,8,3,'neque pellentesque massa lobortis ultrices. Vivamus rhoncus. Donec est. Nunc',8,2,'2017-11-06 15:05:18','2018-03-28 20:20:09',2,'semper tellus','enim, condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec'),('icsdjcsd','title2','1',12.00,1,1,'cjlsdkcj',1,1,'0208-08-27 02:45:07','2018-08-27 02:45:12',1,'1','1'),('q','title3','1',12.00,1,1,'cjlsdkcj',1,1,'0208-08-27 02:45:07','2018-08-27 02:45:12',1,'1','1'),('test','title4','1',12.00,1,1,'cjsladc',1,1,'2018-08-28 03:23:03','2018-08-28 03:23:18',1,'1','1');
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
  `is_parent` tinyint(4) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sort_order` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`item_cat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item_cat`
--

LOCK TABLES `db_item_cat` WRITE;
/*!40000 ALTER TABLE `db_item_cat` DISABLE KEYS */;
/*!40000 ALTER TABLE `db_item_cat` ENABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_panel`
--

LOCK TABLES `db_panel` WRITE;
/*!40000 ALTER TABLE `db_panel` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_panel_content`
--

LOCK TABLES `db_panel_content` WRITE;
/*!40000 ALTER TABLE `db_panel_content` DISABLE KEYS */;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
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

-- Dump completed on 2018-10-15 20:28:45
