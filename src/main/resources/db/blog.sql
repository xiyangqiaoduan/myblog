/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-05-21 12:56:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` varchar(64) DEFAULT NULL,
  `article_title` varchar(200) DEFAULT NULL,
  `article_keywords` varchar(200) DEFAULT NULL,
  `article_abstract` tinytext,
  `article_content` text,
  `article_create_date` datetime DEFAULT NULL,
  `article_update_date` datetime DEFAULT NULL,
  `article_tags` tinytext,
  `article_comment_count` int(11) DEFAULT NULL,
  `article_view_count` int(11) DEFAULT NULL,
  `article_sign_id` varchar(200) DEFAULT NULL,
  `article_perma_link` varchar(200) DEFAULT NULL,
  `article_status` tinyint(1) DEFAULT '1',
  `article_puttop` tinyint(1) DEFAULT NULL,
  `article_is_published` tinyint(1) DEFAULT '0',
  `article_had_been_published` tinyint(1) DEFAULT NULL,
  `article_random_double` double DEFAULT NULL,
  `article_commentable` tinyint(1) DEFAULT NULL,
  `article_view_pwd` varchar(64) DEFAULT NULL,
  `article_editor_type` varchar(200) DEFAULT NULL,
  `article_author_rmail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('50550978524479488', '第一篇测试文章', '第一篇测试文章', '第一篇测试文章', '<p>第一篇测试文章第一篇测试文章<br></p><p>第一篇测试文章<br></p><p>第一篇测试文章<br></p><p>第一篇测试文章<br></p>', '2017-05-20 11:51:32', '2017-05-17 11:51:32', '测试', '0', '0', '12700000000120175120115132473524', 'aaa.html', '1', '0', '0', '0', '0', '0', 'aaa', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50551130295369728', 'assa', 'sasasa', 'sasasas', '<p>sasasasss</p>', '2017-05-20 11:52:08', '2017-05-20 11:52:08', 'asa', '0', '0', '12700000000120175220115208658757', 'asssss', '1', '0', '0', '0', '0', '0', 'ass', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50551197186129920', 'ssss', 'sssssssss', 'sssss', '<p>sssssssssssssssssssss</p>', '2017-05-20 11:52:24', '2017-05-20 11:52:24', 'sssss', '0', '0', '12700000000120175220115224606664', 'sss', '1', '0', '0', '0', '0', '0', 'sss', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50551248687988736', 'asssss', 'sssss', 'ssss', '<p>sssssssss</p>', '2017-05-20 11:52:36', '2017-05-20 11:52:36', 'ssssss', '0', '0', '12700000000120175220115236884994', 'sss', '1', '0', '0', '0', '0', '0', 'ssss', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50551498551066624', 'aadassssssssssssssssss', 'sssssssssssssssssssssssssssssssss', 'ssssssssssssssssssssssssssssss', '<p>asas</p>', '2017-05-20 11:53:36', '2017-05-20 11:53:36', 'asss', '0', '0', '12700000000120175320115336456779', 'ssa', '1', '0', '0', '0', '0', '0', 'sasas', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50551890961760256', '呵呵呵呵呵', '黄金分割登记时间让客户给客人个角度思考和个角度和国家队看不惯你们的风景狂热的防护软件的改变女的', '郭德纲让人改变', '<p>梵蒂冈特惠央行公布</p>', '2017-05-20 11:55:10', '2017-05-20 11:55:10', '订单 打个 打个', '0', '0', '12700000000120175520115510014237', '计划的防护服', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552197523439616', '的合法的身份', '疯狂举动个核计划规范粮食价格肯定更好附近的开始了环比降幅可达力所能及的开发的健康结过婚打开了时间内热加工开放领空公斤的开发了所在诶我但是给几个', '降低功耗 多开几个 点击 ', '<p>反对三个黑金佛寺口大老婆更好附近的凯萨琳归还部分继往开来更好附近的开始个分别获得技术开发不会的尖酸刻薄繁华的宁静更好附近的更换发动机锁孔hi家饿哦无法基地华国锋iso附近的开始个妇女节的快乐呢人也ideuighjrkdlgjuireielvnkghureigjdl</p>', '2017-05-20 11:56:23', '2017-05-20 11:56:23', '的呼叫 大结局 基督教国', '0', '0', '12700000000120175620115623104099', '大华股份', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552308974485504', '使得法国', '使得法国红酒', '微软不敢干', '<p>请问日体育i哦培训的法国红酒看示范推广和围绕太阳犬瘟热we日体育</p>', '2017-05-20 11:56:49', '2017-05-20 11:56:49', '微软  额头以后', '0', '0', '12700000000120175620115649676340', '是的', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552459453530112', '企鹅王', '二万人 而过会儿儿童', '儿童', '<p>破例科技化股份均有不过vfcyhtbrvdcb</p>', '2017-05-20 11:57:25', '2017-05-20 11:57:25', '儿童 韦尔特保', '0', '0', '12700000000120175720115725553255', '均有不过', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552601380388864', '阿瑟的风格', '卫生部副', '当局可能', '<p>其二补贴机具开股份股份将于苦闷</p>', '2017-05-20 11:57:59', '2017-05-20 11:57:59', '的个分别', '0', '0', '12700000000120175720115759392591', '耳钉', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552704363134976', '为', '违反他偷偷干过', '我恨日本', '<p>发热月锐利哦基本功不规范</p>', '2017-05-20 11:58:23', '2017-05-20 11:58:23', '地方的', '0', '0', '12700000000120175820115823944344', '对对对', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552889533267968', '热热热', '而发表更改', '高耗能高地价', '<p>为五个半日报符不符合如何</p>', '2017-05-20 11:59:08', '2017-05-20 11:59:08', '打个', '0', '0', '12700000000120175920115908092612', '而发也一样', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50552975843655680', '阿朵岁的王菲', '阿斯该如何俄亥俄', '恶搞', '<p>有hi哦鎏金银棺他范德萨巨化股份的事</p>', '2017-05-20 11:59:28', '2017-05-20 11:59:28', '让人', '0', '0', '12700000000120175920115928670890', '去污粉', '1', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50553036069666816', '分割', '个人归园田居kit募集吗', '荣高棠', '<p>干扰他人hi可i本人</p>', '2017-05-20 11:59:43', '2017-05-21 12:54:41', '非法人', '0', '0', '12700000000120175920115943030133', '更换', '0', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50553166663516160', '愚人节吧发病高峰', '否认环境', '发', '<p>土壤突兀仍然会如果</p>', '2017-05-20 12:00:14', '2017-05-21 12:54:36', '纷纷回调后', '0', '0', '12700000000120170020120014165982', '额', '0', '0', '0', '0', '0', '0', '', 'simditor', null);
INSERT INTO `blog_article` VALUES ('50553334536339456', '若非供热办', '非供热发天天跟他沟通', '方法打个', '<p>供热办个人山人海研究院统计一条具有推荐一套基于特价</p>', '2017-05-20 12:00:54', '2017-05-21 11:58:11', '恶非供热个人', '0', '0', '12700000000120170020120054189235', '热管突然', '1', '0', '1', '0', '0', '0', '', 'simditor', null);

-- ----------------------------
-- Table structure for blog_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `id` varchar(64) NOT NULL,
  `article_id` varchar(64) NOT NULL,
  `tag_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_article_tag
-- ----------------------------
INSERT INTO `blog_article_tag` VALUES ('50550979237511168', '50550978524479488', '50550979212345344');
INSERT INTO `blog_article_tag` VALUES ('50551130362478592', '50551130295369728', '50551130337312768');
INSERT INTO `blog_article_tag` VALUES ('50551197240655872', '50551197186129920', '50551197219684352');
INSERT INTO `blog_article_tag` VALUES ('50551248746708992', '50551248687988736', '50551248734126080');
INSERT INTO `blog_article_tag` VALUES ('50551498597203968', '50551498551066624', '50551498584621056');
INSERT INTO `blog_article_tag` VALUES ('50551891028869120', '50551890961760256', '50551891007897600');
INSERT INTO `blog_article_tag` VALUES ('50552197582159872', '50552197523439616', '50552197569576960');
INSERT INTO `blog_article_tag` VALUES ('50552309058371584', '50552308974485504', '50552309041594368');
INSERT INTO `blog_article_tag` VALUES ('50552459495473152', '50552459453530112', '50552459482890240');
INSERT INTO `blog_article_tag` VALUES ('50552601439109120', '50552601380388864', '50552601426526208');
INSERT INTO `blog_article_tag` VALUES ('50552704438632448', '50552704363134976', '50552704421855232');
INSERT INTO `blog_article_tag` VALUES ('50552889583599616', '50552889533267968', '50552889571016704');
INSERT INTO `blog_article_tag` VALUES ('50552975898181632', '50552975843655680', '50552975885598720');
INSERT INTO `blog_article_tag` VALUES ('50553036128387072', '50553036069666816', '50553036111609856');
INSERT INTO `blog_article_tag` VALUES ('50553166713847808', '50553166663516160', '50553166701264896');
INSERT INTO `blog_article_tag` VALUES ('50553334616031232', '50553334536339456', '50553334595059712');

-- ----------------------------
-- Table structure for blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `blog_comment`;
CREATE TABLE `blog_comment` (
  `id` varchar(64) NOT NULL,
  `comment_content` tinytext,
  `comment_name` varchar(200) DEFAULT NULL,
  `comment_email` varchar(100) DEFAULT NULL,
  `comment_sharp_url` varchar(200) DEFAULT NULL,
  `comment_url` varchar(200) DEFAULT NULL,
  `comment_date` datetime DEFAULT NULL,
  `comment_ip` varchar(200) DEFAULT NULL,
  `comment_thumbnail_url` varchar(200) DEFAULT NULL,
  `comment_on_id` varchar(64) DEFAULT NULL,
  `comment_on_type` varchar(200) DEFAULT NULL,
  `comment_original_comment_id` varchar(64) DEFAULT NULL,
  `comment_original_comment_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_comment
-- ----------------------------

-- ----------------------------
-- Table structure for blog_option
-- ----------------------------
DROP TABLE IF EXISTS `blog_option`;
CREATE TABLE `blog_option` (
  `option_key` varchar(200) NOT NULL,
  `option_value` tinytext,
  `option_category` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_option
-- ----------------------------
INSERT INTO `blog_option` VALUES ('website_title', 'dadadsdasd', null);
INSERT INTO `blog_option` VALUES ('website_keywords', 'dsadsadasd', null);
INSERT INTO `blog_option` VALUES ('website_description', 'aa', null);
INSERT INTO `blog_option` VALUES ('website_uploadfile', 'asasass', null);
INSERT INTO `blog_option` VALUES ('website_copyright', 'aa', null);
INSERT INTO `blog_option` VALUES ('website_icp', 'dasdadasd', null);
INSERT INTO `blog_option` VALUES ('website_statscode', 'aa', null);
INSERT INTO `blog_option` VALUES ('website_smtptype', 'dsdsd', null);
INSERT INTO `blog_option` VALUES ('website_smtp', 'sadsad', null);
INSERT INTO `blog_option` VALUES ('website_smtpport', '25', null);
INSERT INTO `blog_option` VALUES ('website_emailname', '5', null);
INSERT INTO `blog_option` VALUES ('website_emailpassword', 'adsadas', null);
INSERT INTO `blog_option` VALUES ('website_emailaddress', 'addasd', null);

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` varchar(64) NOT NULL,
  `tag_title` varchar(200) DEFAULT NULL,
  `tag_reference_count` int(11) DEFAULT NULL,
  `tag_published_refCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('50550979212345344', '测试', '1', '1');
INSERT INTO `blog_tag` VALUES ('50551130337312768', 'asa', '1', '1');
INSERT INTO `blog_tag` VALUES ('50551197219684352', 'sssss', '1', '1');
INSERT INTO `blog_tag` VALUES ('50551248734126080', 'ssssss', '1', '1');
INSERT INTO `blog_tag` VALUES ('50551498584621056', 'asss', '1', '1');
INSERT INTO `blog_tag` VALUES ('50551891007897600', '订单 打个 打个', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552197569576960', '的呼叫 大结局 基督教国', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552309041594368', '微软  额头以后', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552459482890240', '儿童 韦尔特保', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552601426526208', '的个分别', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552704421855232', '地方的', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552889571016704', '打个', '1', '1');
INSERT INTO `blog_tag` VALUES ('50552975885598720', '让人', '1', '1');
INSERT INTO `blog_tag` VALUES ('50553036111609856', '非法人', '1', '0');
INSERT INTO `blog_tag` VALUES ('50553166701264896', '纷纷回调后', '1', '0');
INSERT INTO `blog_tag` VALUES ('50553334595059712', '恶非供热个人', '1', '1');

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `id` varchar(64) NOT NULL,
  `user_email` varchar(200) DEFAULT NULL,
  `user_name` varchar(200) DEFAULT NULL,
  `user_url` varchar(200) DEFAULT NULL,
  `user_password` varchar(64) DEFAULT NULL,
  `user_role` varchar(100) DEFAULT NULL,
  `user_article_count` int(11) DEFAULT NULL,
  `user_published_article_count` int(11) DEFAULT NULL,
  `user_vatar` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1', '1@123.com', '1', '1', '1', '1', '1', '1', '1');
