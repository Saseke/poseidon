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
  `c_id` int(11) DEFAULT NULL COMMENT '分类id',
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `db_item_cat`
--

LOCK TABLES `db_item_cat` WRITE;
/*!40000 ALTER TABLE `db_item_cat` DISABLE KEYS */;
INSERT INTO `db_item_cat` VALUES (1,'2018-10-26 09:29:21',NULL,1,'手机',0,NULL,0,1,'2018-10-26 09:29:35'),(3,'2018-10-26 09:29:44',NULL,1,'电话卡',0,NULL,0,1,'2018-10-26 09:29:59'),(4,'2018-10-26 09:30:06',NULL,1,'电视',0,'nav',3,1,'2018-10-26 09:30:19'),(5,'2018-10-26 09:30:29',NULL,1,'盒子',0,NULL,0,1,'2018-10-26 09:30:38'),(6,'2018-10-26 09:31:34',NULL,1,'笔记本',0,'nav',4,1,'2018-10-26 09:31:57'),(7,'2018-10-26 09:32:05',NULL,1,'平板',0,NULL,0,1,'2018-10-26 09:32:18'),(8,'2018-10-26 09:32:28',NULL,1,'家电',0,NULL,0,1,'2018-10-26 09:32:46'),(9,'2018-10-26 09:32:51',NULL,1,'插线板',0,NULL,0,1,'2018-10-26 09:33:09'),(10,'2018-10-26 09:33:17',NULL,1,'出行',0,NULL,0,1,'2018-10-26 09:33:30'),(11,'2018-10-26 09:34:11',NULL,1,'穿戴',0,NULL,0,1,'2018-10-26 09:34:24'),(12,'2018-10-26 09:34:39',NULL,1,'智能',0,'nav',7,1,'2018-10-26 09:34:54'),(13,'2018-10-26 09:35:00',NULL,1,'路由器',0,'nav',6,1,'2018-10-26 09:35:12'),(14,'2018-10-26 09:37:24',NULL,1,'电源',0,NULL,0,1,'2018-10-26 09:37:34'),(15,'2018-10-26 09:37:38',NULL,1,'配件',0,NULL,0,1,'2018-10-26 09:37:48'),(16,'2018-10-26 09:37:55',NULL,1,'健康',0,NULL,0,1,'2018-10-26 09:38:04'),(17,'2018-10-26 09:38:07',NULL,1,'儿童',0,NULL,0,1,'2018-10-26 09:38:15'),(18,'2018-10-26 09:38:23',NULL,1,'耳机',0,NULL,0,1,'2018-10-26 09:38:33'),(19,'2018-10-26 09:38:43',NULL,1,'音箱',0,NULL,0,1,'2018-10-26 09:38:54'),(20,'2018-10-26 09:39:02',NULL,1,'生活',0,NULL,0,1,'2018-10-26 09:39:13'),(21,'2018-10-26 09:39:16',NULL,1,'箱包',0,NULL,0,1,'2018-10-26 09:39:25'),(22,'2018-10-26 11:05:33',NULL,0,'小米手机',1,'nav',1,1,'2018-10-26 11:05:56'),(23,'2018-10-26 11:06:01',NULL,0,'红米手机',1,'nav',2,1,'2018-10-26 11:06:21'),(24,'2018-10-26 11:09:51',NULL,0,'空调',7,'nav',1,1,'2018-10-26 11:10:16'),(25,'2018-10-26 11:11:12',NULL,1,'新品',0,'nav',5,1,'2018-10-26 11:11:44'),(26,'2018-10-27 07:17:47',NULL,1,'服务',0,'nav',8,1,'2018-10-27 07:18:09'),(27,'2018-10-27 07:18:12',NULL,1,'社区',0,'nav',9,1,'2018-10-27 07:18:25');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
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

-- Dump completed on 2018-10-27 15:23:27
