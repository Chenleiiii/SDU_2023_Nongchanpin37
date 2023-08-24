/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : rongxiaotong

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 24/08/2023 22:12:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '属于哪个用户的地址',
  `consignee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `is_default` tinyint(4) NULL DEFAULT 0 COMMENT '是否默认，0，不是，默认是1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES (121, 'zwr', '张文瑞', '15030589961', '青岛市即墨区青岛湾琴湾C区', 1);
INSERT INTO `tb_address` VALUES (129, 'zhangxukun', '张绪昆', '18354648787', '山东省青岛市', 0);
INSERT INTO `tb_address` VALUES (146, 'zhangxu', '张绪昆', '18396833008', '山东省青岛市', 0);
INSERT INTO `tb_address` VALUES (147, 'zhangxukun', '张绪昆', '18354648787', '山东省济南市', 1);
INSERT INTO `tb_address` VALUES (153, 'gaoge', '高歌', '18977771439', '山东省枣庄市', 0);
INSERT INTO `tb_address` VALUES (154, 'gaoge', '高歌', '18977771439', '山东省德州市夏津县', 1);
INSERT INTO `tb_address` VALUES (171, 'gaoge', '高歌', '18977771439', '山东省德州市夏津县', 0);
INSERT INTO `tb_address` VALUES (172, 'admin', '成吉思汗', '18766661438', '山东青岛市崂山区', 1);
INSERT INTO `tb_address` VALUES (173, 'admin', '不朽大帝', '18766661438', '山东青岛市崂山区', 0);
INSERT INTO `tb_address` VALUES (178, 'lzh', '11', '11', '11', 1);
INSERT INTO `tb_address` VALUES (184, 'wyn3', '李增虎', '11111111111', '海信财智谷', 0);
INSERT INTO `tb_address` VALUES (186, 'lisi', '李四', '15623652365', '山东省临沂市河东区', 1);
INSERT INTO `tb_address` VALUES (187, 'lisi', '李四', '15623652365', '山东省青岛市崂山区', 0);
INSERT INTO `tb_address` VALUES (188, 'lisi', '李四', '15662352365', '山东省青岛市黄岛区', 0);
INSERT INTO `tb_address` VALUES (189, 'wangya', '王娅', '13792449255', '青岛市李沧区', 0);
INSERT INTO `tb_address` VALUES (190, 'dzk', '董照坤', '15275327869', '山东省济南市舜泰广场联通公司', 0);
INSERT INTO `tb_address` VALUES (192, 'dzk', '董照坤', '13233138362', '山东省济南市山东大学软件园校区', 1);

-- ----------------------------
-- Table structure for tb_bank
-- ----------------------------
DROP TABLE IF EXISTS `tb_bank`;
CREATE TABLE `tb_bank`  (
  `bank_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bank_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `money` decimal(65, 2) NOT NULL,
  `rate` decimal(65, 2) NOT NULL,
  `repayment` int(11) NOT NULL,
  PRIMARY KEY (`bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1011 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_bank
-- ----------------------------
INSERT INTO `tb_bank` VALUES (1001, '青岛银行', '“青易贷”，是青岛银行小微企业融资产品服务品牌。为助力小微企业成长发展，青岛银行为广大小微企业打造全面金融服务品牌体系——“青易贷”，紧贴小微企业融资需求特点，紧跟市场经济发展变化，不断创新完善融资产品，形成特色产品体系，力争全方位地满足不同行业、不同成长阶段的小微企业各类融资需求。', '96588', 100000.00, 1.10, 24);
INSERT INTO `tb_bank` VALUES (1002, '中国银行', '中国银行金融市场业务，包括国内、国际本外币金融市场相关交易、投资、理财、托管等业务，为公司、个人以及金融同业提供全面、完善、专业的各项金融市场服务。', '95566', 100000.00, 1.20, 36);
INSERT INTO `tb_bank` VALUES (1003, '中国农业银行', '　惠农e贷是中国农业银行专为广大农民量身打造的便捷高效线上贷款产品，一部手机实现在线申请、在线取款、在线还款，农民足不出户办理贷款', '95599', 170000.00, 4.35, 25);
INSERT INTO `tb_bank` VALUES (1004, '中国工商银行', '工商银行向小微企业主发放的，用于满足其生产经营资金需求或置换生产经营过程中产生的负债性资金的人民币贷款。', '95588', 150000.00, 1.10, 30);
INSERT INTO `tb_bank` VALUES (1005, '日照银行', '“阳光”系列个人消费贷款业务是日照银行向符合规定条件的自然人发放的用于个人消费用途的人民币贷款业务，旨在以快捷方便的审批流程和优质的服务满足客户在大件商品或服务消费等个人资金需求，如住房装修、购家具家电、购车、婚庆、学习进修、旅游等。“阳光”系列个人消费贷款业务包含“阳光贷”、“金领贷”、“阳光·房易贷”、“阳光·保易贷”、“阳光·车易贷”“阳光·出国贷”等。', '96588', 100000.00, 2.00, 24);
INSERT INTO `tb_bank` VALUES (1006, '华夏银行', '华夏银行作为债务融资工具全国首批主承销商之一，已从业十余载，连续十三年获“全国银行间同业拆借中心优秀交易成员”称号，承销团队经验丰富，专业高效，竭诚为广大企业服务。', '95577', 160000.00, 1.80, 36);
INSERT INTO `tb_bank` VALUES (1007, '中国建设银行', '“诚贷通”小额无抵押贷款“诚贷通”小额无抵押贷款是建设银行为小企业客户发放，由企业主或企业实际控制人提供个人连带责任保证，无需抵（质）押物，用于小企业客户生产经营资金周转的人民币循环额度贷款。', '95533', 200000.00, 3.60, 36);
INSERT INTO `tb_bank` VALUES (1008, '浦发银行', '点贷是我行面向符合条件的客户通过互联网在线受理、在线签约，并即时发放贷款的业务模式。', '95528', 150000.00, 1.10, 24);
INSERT INTO `tb_bank` VALUES (1009, '中国平安银行', '“数保贷”平安银行与担保公司、担保基金、保险公司等联合开发的面向诚信纳税的中小企业法人或企业主的互联网信用贷款', '95511', 160000.00, 1.20, 36);
INSERT INTO `tb_bank` VALUES (1010, '中国民生银行', '为进一步丰富金融服务乡村振兴的内涵，民生银行在持续迭代“农贷通”产品的基础上，通过与中国银联强强联合，将借记卡产品与贷款产品相融合，以科技赋能，将现代金融服务延伸到广大农村区域。“农贷通”卡满载10项特色涉农权益，为农户提供多样化增值服务。', '95568', 200000.00, 1.60, 24);

-- ----------------------------
-- Table structure for tb_discuss
-- ----------------------------
DROP TABLE IF EXISTS `tb_discuss`;
CREATE TABLE `tb_discuss`  (
  `discuss_id` int(11) NOT NULL AUTO_INCREMENT,
  `knowledge_id` int(11) NOT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`discuss_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 113 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_discuss
-- ----------------------------
INSERT INTO `tb_discuss` VALUES (100, 100, 'wyn', '评论内容123', '2022-03-29 14:35:06');
INSERT INTO `tb_discuss` VALUES (101, 22, 'zhangxukun', '1111', '2022-07-22 09:56:49');
INSERT INTO `tb_discuss` VALUES (102, 22, 'admin', '22', '2022-07-29 14:59:21');
INSERT INTO `tb_discuss` VALUES (103, 22, 'admin', '44444444', '2022-07-29 15:31:06');
INSERT INTO `tb_discuss` VALUES (104, 22, 'wyn3', '22', '2022-08-19 16:09:12');
INSERT INTO `tb_discuss` VALUES (105, 23, 'gaoge', '不错不错', '2022-08-31 16:24:10');
INSERT INTO `tb_discuss` VALUES (106, 23, 'gaoge', '学到了，感谢！', '2022-08-31 16:24:18');
INSERT INTO `tb_discuss` VALUES (107, 23, 'gaoge', '长知识了', '2022-08-31 16:26:02');
INSERT INTO `tb_discuss` VALUES (108, 22, 'wyn3', '太简单', '2022-09-06 16:19:37');
INSERT INTO `tb_discuss` VALUES (109, 26, 'dzk', '评论', '2023-07-08 20:45:06');
INSERT INTO `tb_discuss` VALUES (110, 23, 'dzk', '评论', '2023-07-14 20:03:40');
INSERT INTO `tb_discuss` VALUES (111, 26, 'dzk', '评论', '2023-07-15 10:20:22');
INSERT INTO `tb_discuss` VALUES (112, 26, 'dzk', '评论', '2023-07-15 10:35:52');

-- ----------------------------
-- Table structure for tb_expert
-- ----------------------------
DROP TABLE IF EXISTS `tb_expert`;
CREATE TABLE `tb_expert`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `belong` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_expert
-- ----------------------------
INSERT INTO `tb_expert` VALUES ('dry', '丁瑞旸', '13233138362', '生物学', '中级职称', '山东省农科院');
INSERT INTO `tb_expert` VALUES ('gaoge', '高歌', '15649599256', '生物学', '高级职称', '山东省农科院');
INSERT INTO `tb_expert` VALUES ('wyn', '王玉娜', '17892322499', '生物化学', '高级工程师', '青岛生物研究所');
INSERT INTO `tb_expert` VALUES ('wyn2', '王艳安', '13192924932', '生物化学', '高级工程师', '青岛生物研究所');
INSERT INTO `tb_expert` VALUES ('zhangxu', '张旭', '18224995956', '生物学', '中级职称', '山东省农科院');

-- ----------------------------
-- Table structure for tb_finance
-- ----------------------------
DROP TABLE IF EXISTS `tb_finance`;
CREATE TABLE `tb_finance`  (
  `finance_id` int(11) NOT NULL AUTO_INCREMENT,
  `bank_id` int(11) NOT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(11) NOT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` decimal(65, 2) NOT NULL,
  `rate` decimal(65, 2) NOT NULL,
  `repayment` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `combination_name1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `combination_phone1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `combination_idnum1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `combination_name2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `combination_phone2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `combination_idnum2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `file_info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`finance_id`) USING BTREE,
  INDEX `bank_id`(`bank_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 145 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_finance
-- ----------------------------
INSERT INTO `tb_finance` VALUES (100, 1001, 'wyn', '王亚楠', '22222222222', '222222222222222222', 1, 're', 100.00, 12.00, 1, '2022-03-28 17:14:32', '2022-03-28 17:14:36', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (102, 1001, 'wyn', '王亚楠', '22222222222', '222222222222222222', 2, 're', 109.00, 12.00, 1, '2022-03-28 17:14:32', '2022-03-28 17:14:36', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (103, 1004, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 160000.00, 1.80, 36, '2022-07-22 09:59:12', '2022-07-22 09:59:12', '张龙', NULL, NULL, '赵虎', '22222222222', '222222222222222222', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (104, 1006, 'zhangxukun', '张旭坤', '13176879739', '370827199001142213', 2, NULL, 150000.00, 1.10, 30, '2022-07-22 10:02:04', '2022-07-22 10:02:04', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg 45f9675d11a34dd3a6df296b8bc4b7e5.jpg dd4f92b790dc4f36964888c98169ce66.jpg dd4f92b790dc4f36964888c98169ce66.jpg dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (105, 1005, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 100000.00, 2.00, 24, '2022-07-22 10:02:29', '2022-07-22 10:02:29', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (106, 1004, 'zhangxukun', '张旭坤', '22222222222', '222222222222222222', 0, NULL, 150000.00, 1.10, 30, '2022-07-22 10:26:02', '2022-07-22 10:26:02', NULL, NULL, NULL, NULL, '', '', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (133, 1006, 'lzh', '李增虎', '15621367568', '373312199801032719', 2, NULL, 60000.00, 1.00, 6, '2022-08-17 17:18:14', '2022-08-17 17:18:14', '冯德林', '22222222222', '222222222222222222', '李思', '22222222222', '222222222222222222', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (137, 1007, 'lisi', '李思', '15623652365', '371323199601062719', 0, NULL, 100000.00, 1.20, 6, '2022-08-29 14:38:27', '2022-08-29 14:38:27', '李增虎', '17814382372', '372823199005162816', '何海涵', '13176852739', '373833198910073526', 'dd4f92b790dc4f36964888c98169ce66.jpg');
INSERT INTO `tb_finance` VALUES (141, 1006, 'wyn3', '王亚楠', '13696859685', '370201196501026352', 2, NULL, 120000.00, 1.80, 36, '2022-09-08 10:12:35', '2022-09-08 10:12:35', '沙发', '13754125623', '370203199802036513', '的撒', '13895212195', '370213199009160203', '47fc92e1068d4c20833e4e197aec0b0d.jpg 20e7a0d77ecf4731b28ebc1d6ca22587.jpg ');
INSERT INTO `tb_finance` VALUES (142, 1002, 'dzk', '张乾', '13233138362', '130172200007312546', 0, NULL, 100000.00, 1.20, 12, '2023-07-13 16:23:16', '2023-07-13 16:23:16', NULL, NULL, NULL, NULL, NULL, NULL, 'a6fbd06bc12d4810918f0bc696fa548b.jpg ');
INSERT INTO `tb_finance` VALUES (144, 1002, 'dzk', '张乾', '13233138362', '130182200208145731', 0, NULL, 60000.00, 1.20, 6, '2023-07-15 10:37:14', '2023-07-15 10:37:14', NULL, NULL, NULL, NULL, NULL, NULL, 'a727c54d70e64a40845469b278651adb.jpg ');

-- ----------------------------
-- Table structure for tb_financing_intention
-- ----------------------------
DROP TABLE IF EXISTS `tb_financing_intention`;
CREATE TABLE `tb_financing_intention`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `amount` int(11) NOT NULL,
  `application` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `item` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `repayment_period` int(11) NOT NULL,
  `area` int(11) NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_financing_intention
-- ----------------------------
INSERT INTO `tb_financing_intention` VALUES (5, 'zhangxukun', '张旭坤', '山东省菏泽市', 80000, '种植农作物', '苹果', 60, 90, '13176879739', '2022-08-09 14:56:31', '2022-08-10 14:56:35');
INSERT INTO `tb_financing_intention` VALUES (6, 'wyn3', '王亚楠', '威海市', 1000000, '芒果种植', '芒果', 36, 1, '13792499256', '2022-09-08 09:58:14', '2022-09-08 10:01:15');
INSERT INTO `tb_financing_intention` VALUES (7, 'dzk', '张乾', '山东省济南市', 10000, '种植', '西瓜', 6, 100, '13233138362', '2023-07-10 09:10:01', '2023-07-10 09:10:01');
INSERT INTO `tb_financing_intention` VALUES (8, 'dry', '丁瑞旸', '山东省济南市', 10000, '种植', '西瓜', 6, 10000, '18779437662', '2023-07-10 09:10:56', '2023-07-10 09:10:56');

-- ----------------------------
-- Table structure for tb_knowledge
-- ----------------------------
DROP TABLE IF EXISTS `tb_knowledge`;
CREATE TABLE `tb_knowledge`  (
  `knowledge_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pic_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布者名字',
  `create_time` time(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`knowledge_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_knowledge
-- ----------------------------
INSERT INTO `tb_knowledge` VALUES (22, '水稻种植全过程', '水稻种植第一步：晒种\n水稻种植第二步：选种\n水稻种植第三步：整秧版\n水稻种植第四步：播种\n水稻种植第五步：插秧\n水稻种植第六步：缓苗\n水稻种植第七步：田间管理（关键）', '2cc2479866734c8980d88c86db7dbdc7.webp', 'gaoge', '16:33:59', '2021-08-27 16:33:59');
INSERT INTO `tb_knowledge` VALUES (23, '玉米种植过程详解 ', '玉米一直都被誉为长寿食品，含有丰富的蛋白质、脂肪、维生素、微量元素、纤维素等，具有开发高营养、高生物学功能食品的巨大潜力。但由于其遗传性较为复杂，变异种类丰富，在常规的育种过程中存在着周期过长、变异系数过大、影响子代生长发育的缺点，而现代生物育种技术不但克服了上述缺点和不足，同时也提高了育种速度和质量。玉米出苗后，要及时检查出苗情况，发现缺苗断垄要及时补种、补栽。3叶期前缺苗，用饱满种子浸种催芽后浇水补种。3叶期后缺苗用带土移栽法补苗(播种时可在行间播预备苗)，另外，缺苗处也可在附近留双株补救。', 'cb0d06358f8c40628b6dca273f881875.jpeg', 'gaoge', '09:31:37', '2021-08-30 09:31:37');
INSERT INTO `tb_knowledge` VALUES (24, '大豆种植', '大豆可分为黄豆、青豆和黑豆。可大家都认为大豆只是黄豆。富含蛋白质,大豆磷脂由大豆提取出来的精华,大豆中提取的纯磷脂精华物质,对人体健康有着极大的帮助，并无副作用。对于黄大豆，它需要较长的生产时间，也非常得能耐寒冷，北方地区的气候条件适合种植;然而青豆的生长时间较短，适宜把', '12be19984e374bcfbf06561571365d07.jpg', 'gaoge', '09:37:43', '2021-08-30 09:37:43');
INSERT INTO `tb_knowledge` VALUES (25, '永泰李干的制作过程', '福州特色农产品，永泰李干的制作过程，100％还原！暑期在家帮父母晒李干，永泰李干虽是福建名产，但是市场占有率很低，“养在深山人未识”。我家李干的口感、品质都是不错的，欢迎大家购买品尝！', '7765f8705bc54a2086bc295f3bd7217c.jpg', 'zhangxukun', '09:39:56', '2021-08-30 09:39:56');
INSERT INTO `tb_knowledge` VALUES (26, '葡萄种植', '葡萄是我们生活中最常见的水果之一。如今，市场上出现了许多葡萄品种，一些葡萄正处于管理的关键阶段。这种葡萄管理说简单其实也简单，说复杂也复杂，会者不难，难者不会。掌握基本要点，就能实现“一年树，两年果，三年高产”的愿望。', 'd50a95115e7d4b2d832fbcc50e35944b.jpg', 'gaoge', '09:44:24', '2021-08-30 09:44:24');
INSERT INTO `tb_knowledge` VALUES (27, '【农业种植 • 园艺】《天天学农（农技知识）》', '天天学农创始团队在过去的数年中走遍中国广大农村，与农民深入交谈，了解越多就越觉得必须要去为农民做点实事。我们中很多人是农民的孩子，知道中国农民真是一群非常勤劳的人，但缺乏生产技术，往往事倍功半，他们也渴望学习。农民是朴实的，像庄稼地一样，种下什么就收获什么。视频涵盖了大棚草莓、猕猴桃、苹果树等方方面面，是农民朋友切实需要的教学视频，我们将提供大量的农业技术教学视频，方便大家学习，不断提高农业技术，创造美好生活。', '5722cfcd93c84a9083720d2cb072c5a0.jpg', 'zhangxukun', '09:46:37', '2021-08-30 09:46:37');
INSERT INTO `tb_knowledge` VALUES (28, '西瓜种植', '西瓜露地早春栽培，一般以地温稳定在15℃左右时为露地播种的适宜时间。播种的最佳时间，还应根据品种、栽培季节、栽培方式以及消费季节等条件来确定。一般月中下旬播种育苗，4月中下旬定植，6月下旬开始收获上市；秋西瓜7月上中旬播种，9月下旬开始采收上市。', 'da482ad921d64a798140138a0607eb76.jpg', 'gaoge', '09:54:19', '2021-08-30 09:54:19');
INSERT INTO `tb_knowledge` VALUES (29, '生姜的一生｜现代农业种植和收获生姜', '两千多年来生姜一直活跃在餐桌上。一般做酱菜和小吃用嫩姜，做调料和药用以老姜为佳。传说，神农氏四处尝百草。有一次，误食毒蘑菇，吃了一株长着尖细叶子的青草，神农氏一阵腹泻，感觉死而复生。神农氏姓姜，他将这株救命的植物，叫做生姜。', '4265868e71a44832a3e39a4547dc307c.jpg', 'zhangxukun', '09:55:54', '2021-08-30 09:55:54');
INSERT INTO `tb_knowledge` VALUES (30, '人工种植蘑菇', '黄伞伞，白杆杆，吃完一起开厂厂！一天卖2吨蘑菇的奥地利现代种植工厂赚钱全过程', '1aff704b6fa94e91b58bdda36f9db166.jpg', 'zhangxukun', '10:00:02', '2021-08-30 10:00:02');
INSERT INTO `tb_knowledge` VALUES (33, '草莓', '草莓', '5fe8fbf29a24484dab19ff992aa97c23.jpg', 'gaoge', '16:21:54', '2022-09-07 16:21:54');
INSERT INTO `tb_knowledge` VALUES (35, '蘑菇种植', '使用优质菌种，培养期间保持良好的通风换气。防治高温，高湿。并提前做好虫害防治', 'c506e17375184114aa5afda9ccbac985.jpg', 'dry', '10:38:23', '2023-07-15 10:38:23');

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '需求标题',
  `price` decimal(65, 2) NULL DEFAULT NULL COMMENT '期望价格',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `order_status` int(11) NOT NULL DEFAULT 0 COMMENT '订单状态，0表示待合作，1表示待发货，2表示完成，3表示完成但未评价',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '1销售订单，2需求订单',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发起订单人',
  `cooperation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合作人名字',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单收货地址',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 153 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES (66, '地瓜粉红薯淀粉', 123.00, '福建闽南泉州官桥正宗农家手工自制地瓜粉红薯淀粉番薯粉无添加剂', 0, 'goods', '6c1c2f5b38ac4be190dfc4a421d65f73.jpg', 'wyn3', NULL, '2021-08-27 16:15:00', '2021-08-27 16:15:00', '高歌 18977771439 山东省德州市夏津县');
INSERT INTO `tb_order` VALUES (67, '新疆小红杏吊干杏', 45.00, '新疆小红杏吊干杏新鲜杏子农产品应季1斤装水果特甜小白杏净重4斤', 1, 'goods', 'a5ffef69b838400695cf8f4203e6626a.jpg', 'wyn3', NULL, '2021-08-27 16:17:10', '2021-08-27 16:17:10', '张绪昆 18354648787 山东省济南市');
INSERT INTO `tb_order` VALUES (68, '云南特产大香蕉', 23.00, '云南特产冬季水果大香蕉新鲜当季10斤农产品直销土特产农家孕妇水', 1, 'goods', 'a4418dc8694a4c51875e18c045169697.jpg', 'wyn3', NULL, '2021-08-27 16:19:03', '2021-08-27 16:19:03', '山东省威海市');
INSERT INTO `tb_order` VALUES (69, '山东大葱', 34.00, '山东大葱新鲜5斤时令蔬菜东北香葱包邮蘸酱铁杆章丘10号助农产品', 1, 'goods', '8781c37f24d24376bfd037fcbcb44dc5.jpg', 'wyn3', NULL, '2021-08-27 16:20:15', '2021-08-27 16:20:15', '山东省威海市');
INSERT INTO `tb_order` VALUES (70, '大别山野生羊肚菌', 345.00, '高端消费人群厨房食材 大别山野生羊肚菌干货煲汤菌菇类特产50克', 1, 'goods', '2004039df5b64028bec5d06bdad06f6b.jpg', 'wyn3', NULL, '2021-08-27 16:28:52', '2021-08-27 16:28:52', '张绪昆 18354648787 山东省济南市');
INSERT INTO `tb_order` VALUES (71, '苹果', 22.81, '东北鸡心果5斤锦绣海棠果特产玫瑰小苹果花红沙果孕妇新鲜水果。原产地直发，酸甜可口', 0, 'goods', '4f9d706af7be455cb246c6615a56b631.jpg', 'wyn3', NULL, '2021-08-27 16:30:06', '2022-07-22 10:01:19', '山东省威海市');
INSERT INTO `tb_order` VALUES (72, '白溪豆腐干香', 56.00, '白溪豆腐干香干湖南新化特产农家石磨手工风味柴火烟熏非武冈豆干', 1, 'goods', 'c1300fb2e1a34873a8f0ff6274df5dd8.jpg', 'wyn3', NULL, '2021-08-27 16:30:43', '2021-08-27 16:30:43', '山东省威海市');
INSERT INTO `tb_order` VALUES (73, '红柚', 23.80, '福建平和红心柚子9斤红肉蜜柚水果新鲜密柚当季琯溪孕妇整箱包邮', 1, 'goods', '3b39708a162f4e6881e3e4e502a2e3a6.jpg', 'wyn3', NULL, '2021-08-27 16:30:48', '2021-08-27 16:30:48', '张绪昆 18396833008 山东省青岛市');
INSERT INTO `tb_order` VALUES (74, '百香果', 14.90, '广西百香果9斤特大果新鲜水果紫皮百果香果酱白香果5一级10包邮', 1, 'goods', '905b6a28de85432c9c969c6d3e06fff7.jpg', 'wyn3', NULL, '2021-08-27 16:31:51', '2021-08-27 16:31:51', '山东省威海市');
INSERT INTO `tb_order` VALUES (76, '白葡萄', 79.00, '新疆无核白葡萄无籽水果新鲜当季整箱马奶提子青吐鲁番小葡萄5斤', 1, 'goods', '1dd2029058a547419b32814b9abf2969.jpg', 'wyn3', NULL, '2021-08-27 16:33:11', '2021-08-27 16:33:11', '山东省威海市');
INSERT INTO `tb_order` VALUES (77, '榴莲', 65.80, '顺丰空运 泰国a级金枕头榴莲新鲜带壳巴掌当季进口水果整箱包邮', 0, 'goods', '6734e3ec36bd4ebc8348a358603de955.jpg', 'wyn3', NULL, '2021-08-27 16:33:36', '2021-08-27 16:33:36', '山东省威海市');
INSERT INTO `tb_order` VALUES (78, '石榴', 15.80, '突尼斯软籽石榴水果新鲜10斤包邮无籽应季特大果会理甜红石榴一级', 0, 'goods', '87fabaebe89f4a66a3e29f1ada41c92b.jpg', 'zhangxukun', NULL, '2021-08-27 16:34:54', '2021-08-27 16:34:54', '山东省威海市');
INSERT INTO `tb_order` VALUES (79, '车厘子', 138.00, '新鲜车厘子5斤装高端进口大樱桃包邮山东整箱一箱10当季孕妇水果', 0, 'goods', '4218be16396a44718fc8ed79d3fdfbfa.jpg', 'zhangxukun', NULL, '2021-08-27 16:35:15', '2021-08-27 16:35:15', '成吉思汗 18766661438 山东青岛市崂山区');
INSERT INTO `tb_order` VALUES (80, '芋头新鲜小芋头', 324.00, '芋头新鲜小芋头江西农家蔬菜包邮毛芋仔梗芋子滑糯芋艿净重10斤', 0, 'goods', '5c888733b8ff4cb3a6ac2628b2492665.jpg', 'wyn3', NULL, '2021-08-27 16:35:17', '2021-08-27 16:35:17', '山东省威海市');
INSERT INTO `tb_order` VALUES (81, '水蜜桃', 109.00, '正宗无锡水蜜桃湖景桃子旗舰店软桃新鲜水果礼盒装特产顺丰', 0, 'goods', '0dbd668be84a482ba2749eef5d141424.jpg', 'zhangxukun', NULL, '2021-08-27 16:35:53', '2021-08-27 16:35:53', '山东省威海市');
INSERT INTO `tb_order` VALUES (82, '西梅', 69.00, '新疆法兰西西梅甜孕妇水果新鲜当季整箱特级李子正宗喀什西梅便秘', 0, 'goods', 'ef6dae3bb936415e849c208336537e0b.jpg', 'zhangxukun', NULL, '2021-08-27 16:37:42', '2021-08-27 16:37:42', '山东省威海市');
INSERT INTO `tb_order` VALUES (83, '求购100斤大米', 123.00, '求购100斤大米，质量佳的优先考虑', 1, 'needs', '35b21d2ca3b1402f9ca67f917ce006c1.gif', 'lzh', NULL, '2021-08-27 16:38:29', '2021-08-27 17:27:49', '山东省威海市');
INSERT INTO `tb_order` VALUES (84, '黄桃', 27.80, '正宗锦绣黄桃9斤桃子新鲜当季水果露天脆蜜桃带毛砀山整箱10包邮。收藏下单 拍下17.8元起 精选好果 香甜多汁~', 0, 'goods', 'd75dc206b22a48c6b9e50d81afa51cac.jpg', 'zhangxukun', NULL, '2021-08-27 16:38:58', '2021-08-27 16:38:58', '山东省威海市');
INSERT INTO `tb_order` VALUES (86, '求购一千斤玉米', 2323.00, '急需，价低者来，请联系17826782782', 1, 'needs', '71ea0e08a7ce4bb697b1d6b87a113379.webp', 'lzh', NULL, '2021-08-27 16:40:28', '2021-08-27 16:40:28', '山东省威海市');
INSERT INTO `tb_order` VALUES (87, '潮汕蓝姜', 25.00, '新鲜南姜蓝姜潮汕姜潮州姜野生山姜满包邮免运费芦苇姜 5斤25元', 0, 'goods', '8361828ce6a54b48832cf6b880961f3e.jpg', 'wyn3', NULL, '2021-08-27 16:41:43', '2021-08-27 16:41:43', '山东省威海市');
INSERT INTO `tb_order` VALUES (88, '小香薯', 22.80, '求购临安天目山现挖小香薯', 1, 'needs', 'a70954af69094cbf9c72f6d15eb24509.jpg', 'zhangxukun', NULL, '2021-08-27 16:45:03', '2021-08-27 16:45:03', '山东省威海市');
INSERT INTO `tb_order` VALUES (89, '青龙脆瓜', 98.00, '青龙瓜脆瓜稍瓜菜瓜烧瓜酱瓜边梁烧瓜低糖水果非八棱脆瓜三斤装', 0, 'goods', '43489c0d4a164f539fec75cfb8467de7.jpg', 'zwr', NULL, '2021-08-27 16:45:11', '2021-08-27 16:46:16', '成吉思汗 18766661438 山东青岛市崂山区');
INSERT INTO `tb_order` VALUES (90, '求购90斤苹果', 2332.00, '甘甜可口，不要青苹果', 0, 'needs', 'eee99f060b4843909db360a346ddc18f.webp', 'lzh', NULL, '2021-08-27 16:45:29', '2021-08-27 16:45:29', '山东省威海市');
INSERT INTO `tb_order` VALUES (91, '安徽特产米糖小吃', 30.00, '传统农家手工花生炒米糖米花糖安徽特产米糖休闲食品老式小吃零食', 0, 'goods', 'ac7937d4ff8f4eff9faf7dc25f6c2f20.jpg', 'zwr', NULL, '2021-08-27 16:48:05', '2021-08-27 16:53:21', '山东省威海市');
INSERT INTO `tb_order` VALUES (92, '求购5斤红辣椒', 39.90, '求购5斤红辣椒，变态辣', 0, 'needs', 'e21080ff8f0c47ffb1dee3e236d6a5eb.jpg', 'zhangxukun', NULL, '2021-08-27 16:48:34', '2021-08-27 16:48:34', '山东省威海市');
INSERT INTO `tb_order` VALUES (93, '求购新疆西瓜', 324.00, '要甜的，昼夜温差大的环境中种植的', 0, 'needs', '38d1cf5c26ee444aa709ac2e94730812.webp', 'wyn3', NULL, '2021-08-27 16:51:02', '2021-08-30 13:18:15', '山东省威海市');
INSERT INTO `tb_order` VALUES (94, '求购10斤小紫薯', 48.80, '是小土豆，长不大，乒乓球大小的，但是要口感粉糯。有意者联系18396833838', 0, 'needs', '26820e36e2c449479a34b25c8a647f40.jpg', 'zhangxukun', NULL, '2021-08-27 16:51:11', '2021-08-27 16:51:11', '山东省威海市');
INSERT INTO `tb_order` VALUES (95, '来100斤茄子', 23321.00, '有的MM，价钱合理哦', 0, 'needs', 'd18b7b37555a4bbda1020d56a0626ed5.jpg', 'lzh', NULL, '2021-08-27 16:53:20', '2021-08-27 16:53:20', '山东省威海市');
INSERT INTO `tb_order` VALUES (96, '甘蔗', 35.80, '广西黑皮甘蔗新鲜水果包邮当季特产脆甜杆孕妇果蔗批发整箱9-10斤', 0, 'goods', 'cf5cb1460b71490b97c3a95c71d6d5f6.jpg', 'zhangxukun', NULL, '2021-08-27 16:54:31', '2021-08-27 16:54:31', '山东省威海市');
INSERT INTO `tb_order` VALUES (97, '铁棍山药粉条', 69.00, '怀道居铁棍山药粉条河南焦作山药粉皮红薯正宗手工铁棍山药粉丝', 0, 'goods', '53fd61682e224f3abb96bff64afbd04f.jpg', 'zwr', NULL, '2021-08-27 16:55:10', '2021-08-27 16:55:10', '山东省威海市');
INSERT INTO `tb_order` VALUES (98, '收100斤羊肉', 2333.00, '价钱给够，带价来，咩咩咩', 0, 'needs', '609b8a1aeef9473ca1bfd5f93098ce8f.jpg', 'wyn3', NULL, '2021-08-27 16:55:57', '2021-08-27 16:55:57', '山东省威海市');
INSERT INTO `tb_order` VALUES (99, '野生阳荷新鲜', 26.00, '湖北恩施现挖现新鲜阳荷姜现摘现发新鲜直达500克买2包邮送一野生', 0, 'goods', 'a258efae882540bb910f167aa1c43a8f.jpg', 'zwr', NULL, '2021-08-27 16:57:08', '2021-08-27 16:57:08', '山东省威海市');
INSERT INTO `tb_order` VALUES (100, '求购青苹果', 120.00, '求购40斤青苹果，有意者私聊', 0, 'needs', 'effaf0126a2541c4a18f8431051743ac.jpg', 'zhangxukun', NULL, '2021-08-27 16:57:29', '2021-08-27 16:57:29', '山东省威海市');
INSERT INTO `tb_order` VALUES (101, '杨梅', 159.00, '求购浮宫杨梅新鲜当季孕妇水果应季非仙居东魁杨梅', 0, 'needs', 'd65fa5bfb94a4270b1e3265e34d83214.jpg', 'zwr', NULL, '2021-08-27 16:59:45', '2021-08-27 16:59:45', '山东省威海市');
INSERT INTO `tb_order` VALUES (102, '洋芋蛋蛋', 12.40, '诚信求购新鲜洋芋蛋蛋', 0, 'needs', '0cb58391ab754653abe7958c6b4febc4.jpg', 'zhangxukun', NULL, '2021-08-27 17:00:07', '2021-08-27 17:00:07', '山东省威海市');
INSERT INTO `tb_order` VALUES (103, '人参果', 96.00, '求购云南人参果圆果5斤精品中果应季孕妇圆水果新鲜当季', 0, 'needs', '8e5a53c441794395b84076fa2e457f40.jpg', 'zwr', NULL, '2021-08-27 17:01:49', '2021-08-27 17:01:49', '山东省威海市');
INSERT INTO `tb_order` VALUES (104, '求购葡萄', 89.00, '求购福安象环葡萄巨峰产地大葡萄5斤', 0, 'needs', '08ea2a0040674d6098b426ad96715fd1.jpg', 'zwr', NULL, '2021-08-27 17:10:07', '2021-08-27 17:10:07', '山东省威海市');
INSERT INTO `tb_order` VALUES (105, '甘蓝', 26.80, '求购羽衣甘蓝新鲜沙拉西餐蔬菜食材即食健身有机蔬菜2斤', 0, 'needs', 'f3705c3686944a5bb3843d842f4f37d8.jpg', 'zwr', NULL, '2021-08-27 17:14:26', '2021-08-27 17:14:26', '山东省威海市');
INSERT INTO `tb_order` VALUES (106, '佛手瓜', 19.90, '求购新鲜云南佛手瓜5斤', 0, 'needs', '566ae2891bf24952874058b86051f4a2.jpg', 'zwr', NULL, '2021-08-27 17:28:37', '2021-08-27 17:28:37', '山东省威海市');
INSERT INTO `tb_order` VALUES (113, '芒果', 12.00, '芒果芒果芒果芒果芒果', 0, 'goods', '2ab1041c64d64575a51d6eafa4dfcc4e.jpg', 'lzh', NULL, '2021-08-31 10:18:31', '2021-08-31 10:18:31', '山东省威海市');
INSERT INTO `tb_order` VALUES (139, '西瓜', 11.00, '烟台红富士本地苹果', 0, 'goods', 'e3b03f632c4241e2addb8f56378f0aed.jpg', 'lisi', NULL, '2022-09-01 09:38:24', '2022-09-01 09:39:36', '山东省临沂市');
INSERT INTO `tb_order` VALUES (141, '求购水蜜桃', 20.00, '求购水蜜桃', 0, 'needs', 'ff485f0e71684f6fb48c23021ebf1408.jpg', 'lzh', NULL, '2022-09-01 11:54:29', '2022-09-01 11:54:29', '山东省临沂市');
INSERT INTO `tb_order` VALUES (142, '西瓜', 30.00, '新疆大西瓜，又甜又脆', 1, 'goods', 'c43dcae086e34c80900885c11f0a9e4d.jpg', 'lisi', NULL, '2022-09-01 17:00:46', '2022-09-01 17:00:46', '山东省青岛市');
INSERT INTO `tb_order` VALUES (143, '小麦', 2.00, '出售小麦，质量好，价格低', 0, 'goods', '49e7ded3704b45aab65e2b26a1202a89.gif', 'wangya', NULL, '2022-09-08 10:37:27', '2022-09-08 10:37:27', '山东省青岛市');
INSERT INTO `tb_order` VALUES (152, '烟薯，烤薯品种', 30.00, '山东烟薯25 甜软流油 口感软糯 甜度高 坏果包赔 售后无忧 极速发货 品质保证', 0, 'goods', '8fbb22b39479495a9e24315f36366b53.jpg', 'dzk', NULL, '2023-07-15 10:25:22', '2023-07-15 10:25:22', '山东省济南市');

-- ----------------------------
-- Table structure for tb_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase`;
CREATE TABLE `tb_purchase`  (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_type` int(11) NOT NULL,
  `total_price` decimal(65, 2) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单收货地址',
  `purchase_status` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 133 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase
-- ----------------------------
INSERT INTO `tb_purchase` VALUES (120, 'wyn3', 1, 15.80, '184', 1, '2022-09-07 16:09:34', '2022-09-07 16:09:34');
INSERT INTO `tb_purchase` VALUES (121, 'wyn3', 1, 265.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55');
INSERT INTO `tb_purchase` VALUES (122, 'zhangxukun', 1, 324.00, '147', 1, '2022-09-08 10:13:44', '2022-09-08 10:13:44');
INSERT INTO `tb_purchase` VALUES (130, 'dzk', 1, 11.00, '190', 1, '2023-07-15 10:01:44', '2023-07-15 10:01:44');
INSERT INTO `tb_purchase` VALUES (131, 'dzk', 1, 123.00, '190', 1, '2023-07-15 10:19:07', '2023-07-15 10:19:07');
INSERT INTO `tb_purchase` VALUES (132, 'dzk', 1, 123.00, '190', 1, '2023-07-15 10:34:48', '2023-07-15 10:34:48');

-- ----------------------------
-- Table structure for tb_purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_purchase_detail`;
CREATE TABLE `tb_purchase_detail`  (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `unin_price` decimal(65, 2) NOT NULL,
  `sum_price` decimal(65, 2) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`detail_id`) USING BTREE,
  INDEX `purchase_id`(`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_purchase_detail
-- ----------------------------
INSERT INTO `tb_purchase_detail` VALUES (123, 120, 78, 15.80, 15.80, 1);
INSERT INTO `tb_purchase_detail` VALUES (124, 121, 97, 69.00, 69.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (125, 121, 89, 98.00, 196.00, 2);
INSERT INTO `tb_purchase_detail` VALUES (126, 122, 80, 324.00, 324.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (134, 130, 139, 11.00, 11.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (135, 131, 66, 123.00, 123.00, 1);
INSERT INTO `tb_purchase_detail` VALUES (136, 132, 66, 123.00, 123.00, 1);

-- ----------------------------
-- Table structure for tb_question
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `expert_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专家',
  `questioner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `plant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '农作物名称',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '问题标题',
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问题',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回答',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 115 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question` VALUES (101, 'zhangxu', 'wyn3', '13792499999', '玉米', '玉米苗灌溉', '专家您好，我想请问玉米苗新技术灌溉，对玉米苗有没有影响', '', 0);
INSERT INTO `tb_question` VALUES (103, 'zhangxu', 'wyn3', '13792499999', '新疆哈密瓜', '新疆哈密瓜甜度控制', '新疆哈密瓜甜度是否跟日晒有关', '哈密瓜性喜充足的阳光和较大的昼夜温差,白天可以充分发挥光合作用,而夜晚的呼吸消耗较小,有利于养分沉淀', 1);
INSERT INTO `tb_question` VALUES (108, 'gaoge', 'lzh', '15621367568', '苹果树', '苹果果树种植方法', '苹果果树种植多久浇一次水比较好呀', NULL, 0);
INSERT INTO `tb_question` VALUES (110, 'gaoge', 'wyn3', '13596488256', '这是测试提问', '这是测试提问', '这是测试提问', NULL, 0);
INSERT INTO `tb_question` VALUES (111, 'gaoge', 'wyn3', '13792499275', '草莓', '北方草莓种植品种', '北方草莓种植品种有哪些', '红颜，甜宝', 1);

-- ----------------------------
-- Table structure for tb_reserve
-- ----------------------------
DROP TABLE IF EXISTS `tb_reserve`;
CREATE TABLE `tb_reserve`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `expert_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专家',
  `questioner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '咨询者',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '面积',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '土地地址',
  `plant_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '农作物名称',
  `soil_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '土壤条件',
  `plant_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物条件',
  `plant_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作物详细信息',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回答',
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 214 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_reserve
-- ----------------------------
INSERT INTO `tb_reserve` VALUES (210, 'gaoge', 'wyn3', '2', '青岛崂山区北宅', '草莓', '沙地', '越冬植物', '红颜草莓', '13785964152', NULL, '已处理', 1);

-- ----------------------------
-- Table structure for tb_sell_purchase
-- ----------------------------
DROP TABLE IF EXISTS `tb_sell_purchase`;
CREATE TABLE `tb_sell_purchase`  (
  `sell_purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_id` int(11) NOT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `purchase_type` int(11) NOT NULL,
  `unin_pricee` decimal(65, 2) NOT NULL,
  `sum_price` decimal(65, 2) NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单收货地址',
  `purchase_status` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`sell_purchase_id`) USING BTREE,
  INDEX `purchase_id`(`purchase_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_sell_purchase
-- ----------------------------
INSERT INTO `tb_sell_purchase` VALUES (15, 120, 'zhangxukun', 2, 15.80, 15.80, '184', 1, '2022-09-07 16:09:34', '2022-09-07 16:09:34', 78);
INSERT INTO `tb_sell_purchase` VALUES (16, 121, 'zwr', 2, 69.00, 69.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55', 97);
INSERT INTO `tb_sell_purchase` VALUES (17, 121, 'zwr', 2, 98.00, 196.00, '184', 1, '2022-09-07 16:09:55', '2022-09-07 16:09:55', 89);
INSERT INTO `tb_sell_purchase` VALUES (18, 122, 'wyn3', 2, 324.00, 324.00, '147', 1, '2022-09-08 10:13:44', '2022-09-08 10:13:44', 80);
INSERT INTO `tb_sell_purchase` VALUES (26, 130, 'lisi', 2, 11.00, 11.00, '190', 1, '2023-07-15 10:01:44', '2023-07-15 10:01:44', 139);
INSERT INTO `tb_sell_purchase` VALUES (27, 131, 'wyn3', 2, 123.00, 123.00, '190', 1, '2023-07-15 10:19:07', '2023-07-15 10:19:07', 66);
INSERT INTO `tb_sell_purchase` VALUES (28, 132, 'wyn3', 2, 123.00, 123.00, '190', 1, '2023-07-15 10:34:48', '2023-07-15 10:34:48', 66);

-- ----------------------------
-- Table structure for tb_shoppingcart
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoppingcart`;
CREATE TABLE `tb_shoppingcart`  (
  `shopping_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `own_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  PRIMARY KEY (`shopping_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_shoppingcart
-- ----------------------------
INSERT INTO `tb_shoppingcart` VALUES (2, 143, 1, 'zqq', '2023-06-24 19:07:51', '2023-06-24 19:07:51');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'user' COMMENT 'user普通用户，expert专家，admin管理员',
  `create_time` datetime(0) NOT NULL,
  `update_time` datetime(0) NOT NULL,
  `integral` int(11) NULL DEFAULT 500 COMMENT '积分500',
  `credit` int(11) NULL DEFAULT 5 COMMENT '信誉1，2，3，4，5',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('abcdefg', '$2a$10$oVDMOTSpobCwLTuhT/JWMuOubvolGzz7NMUunmDt6ssdvuJJBhzK2', 'hijklmn', NULL, NULL, NULL, 'expert', '2023-07-08 23:15:01', '2023-07-14 20:10:00', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('admin', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', '管理员', '17894286579', '370343199612012718', '山东省青岛市', 'admin', '2021-09-01 09:00:51', '2022-09-01 16:35:24', 0, 0, '2ae82e5cf7ca47c9ab516d37dccab5dd.jpg', '');
INSERT INTO `tb_user` VALUES ('dry', '$2a$10$.VkMB3FydehIXyrrktlc.ePQukX/6lhAmy2p9Q6Zw89zsSjEX8IXe', '丁瑞旸', '18779437662', NULL, '山东省济南市', 'expert', '2023-06-25 16:51:44', '2023-07-10 09:16:33', 0, 0, 'rongxiaotong.gif', '丁瑞旸');
INSERT INTO `tb_user` VALUES ('dzk', '$2a$10$gt6wirjlVFTjnB/NmFW8UOc241GSv6PIR2mQVrH/JM7nTtX.vpCOi', 'dong', '15275327869', '130182200208145731', '山东省济南市', 'user', '2023-06-25 16:48:58', '2023-07-15 09:52:39', 0, 0, 'de0f96ffe9514bf1a162bf1ec48f4e59.png', '董照坤');
INSERT INTO `tb_user` VALUES ('gaoge', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', '高歌', '18766661439', '370343199612016352', '山东省临沂市', 'expert', '2021-08-27 16:05:20', '2022-09-01 11:21:11', 0, 0, 'f1bd96ecafba46cca7a0c6af92d84fbd.jpg', '高歌');
INSERT INTO `tb_user` VALUES ('lisi', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'lisi', '15623652365', '371323199601062719', '山东省临沂市', 'user', '2022-08-19 16:39:11', '2022-09-01 17:20:04', 0, 0, '2ae82e5cf7ca47c9ab516d37dccab5d2.jpg', '李思');
INSERT INTO `tb_user` VALUES ('lzh', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'llllzzzzhhhh', '15621367568', '373312199801032719', '山东省威海市', 'user', '2022-07-22 11:05:54', '2022-09-07 16:45:53', 0, 0, 'ac10c6dc98d14afda5f09ba81f286197.jpg', '李增虎');
INSERT INTO `tb_user` VALUES ('pys', '$2a$10$FSfmmsSmhtHJgy7magEBXu1zDHgVjcuLAswkbGAKvfaezLsqHoMHC', 'pys', NULL, NULL, NULL, 'admin', '2023-07-14 19:56:41', '2023-07-14 19:56:41', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('tyy', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', '帅气的小公举', '15236983695', '370343199613652415', '山东省青岛市', 'user', '2021-08-30 09:59:50', '2022-08-10 15:44:36', 0, 0, '39557b8fb7a54f81833c8d4a7309b05c.jpg', '唐艳艳');
INSERT INTO `tb_user` VALUES ('wangya', '$2a$10$nLKfTbJqrA5IoRdY.PsZBOACe2s4H3k2NPKLy5LdWL0wKWno0.oDG', 'wangya', '13792449255', '370213198911120506', '山东省青岛市', 'user', '2022-09-08 10:14:22', '2022-09-08 10:19:34', 0, 0, 'rongxiaotong.gif', '王娅');
INSERT INTO `tb_user` VALUES ('wyn', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'wanayuna', '18711236658', '370123200008123456', '山东省威海市', 'expert', '2021-08-27 16:05:20', '2022-09-01 11:21:11', 0, 0, 'f1bd96ecafba46cca7a0c6af92d84fbd.jpg', '李玉娜');
INSERT INTO `tb_user` VALUES ('wyn3', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'wyn3', '15630429628', '324624861233056852', '山东省青岛市', 'user', '2022-04-11 11:36:03', '2022-08-18 15:04:18', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff448.jpg', '王亚楠');
INSERT INTO `tb_user` VALUES ('yyy', '$2a$10$wmVjkH/w5WGpUp5XXQNAJubXBnIJ94RSm9Hpg3ZRnsjKxNlEKcOvq', 'yyyy', NULL, NULL, NULL, 'user', '2023-07-14 20:02:09', '2023-07-14 20:02:09', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('za081444', '$2a$10$k0yr2M5HHe2YwBRv2mBd5Ozh5Z3UY9zEeG/kSuhV.3Hzj1REb68FC', '222', NULL, NULL, NULL, 'user', '2023-07-06 15:40:44', '2023-07-06 15:40:44', 0, 0, 'rongxiaotong.gif', NULL);
INSERT INTO `tb_user` VALUES ('zhangsan', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'zhangsan', '13792499274', '370343199609176060', '山东省青岛市', 'user', '2022-08-19 16:37:10', '2022-08-19 16:37:10', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff448.jpg', '张三');
INSERT INTO `tb_user` VALUES ('zhangxu', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', '张旭', '13456567878', '370123200001012233', '山东省青岛市', 'expert', '2021-08-31 10:13:42', '2022-08-10 15:43:58', 0, 0, '2ae82e5cf7ca47c9ab516d37dccab5dd.jpg', '张旭');
INSERT INTO `tb_user` VALUES ('zhangxukun', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', 'kelven', '13544545454', '370123200008083422', '山东省临沂市', 'user', '2021-08-27 16:05:25', '2022-08-23 15:19:28', 0, 0, '2ae82e5cf7ca47c9ab516d37dccab5dd.jpg', '张旭坤');
INSERT INTO `tb_user` VALUES ('zqq', '$2a$10$89oh4FAsXnw2.SgPliPfVe/fVJir1m7VeyWZkfqhT.HAG11r24DCW', 'zqq', '13233138362', '130182200208145731', '山东省济南市', 'admin', '2023-06-24 13:20:35', '2023-06-24 13:20:35', 0, 0, 'rongxiaotong.gif', '张乾');
INSERT INTO `tb_user` VALUES ('zwr', '$2a$10$AC1gCsk1V5Ov7n.zvkxxvuMM4f3BnWmJqr4jNNYtVAm8j4nBdxIUq', '张文瑞', '15623652222', '111111111111111111', '山东省威海市', 'user', '2021-08-30 09:20:24', '2022-08-23 15:23:34', 0, 0, 'bd12eba3a9a24d89845ebbdb7fbff449.jpg', '张文瑞');

SET FOREIGN_KEY_CHECKS = 1;
