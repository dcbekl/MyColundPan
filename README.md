# MyColundPan
# 项目配置

## 应用服务配置

```Properties
# 应用服务 
# WEB 访问端口
server.port=7090 
# 服务的根路径
server.servlet.context-path=/api
#session过期时间 60M 一个小时
server.servlet.session.timeout=PT60M
```

## Mysql数据库连接配置

```Properties
#数据库连接配置 
spring.datasource.url=jdbc:mysql://154.12.xx.xx:3306/easypan?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&autoReconnect=true&allowMultiQueries=true
spring.datasource.username=xxxxx
spring.datasource.password=xxxx
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Redis连接配置

```Properties
# Redis数据库索引（默认为0）
spring.redis.database=0
spring.redis.host=154.12.xx.xx
spring.redis.port=6379
spring.redis.password=xxxxxx
# 连接池最大连接数（使用负值表示没有限制）
spring.redis.jedis.pool.max-active=20
# 连接池最大阻塞等待时间（使用负值表示没有限制）
spring.redis.jedis.pool.max-wait=-1
# 连接池中的最大空闲连接
spring.redis.jedis.pool.max-idle=10
# 连接池中的最小空闲连接
spring.redis.jedis.pool.min-idle=0
# 连接超时时间（毫秒）
spring.redis.timeout=2000
```

## hikari连接池配置

springboot默认使用的连接池就是hikari连接池

```Properties
spring.datasource.hikari.pool-name=HikariCPDatasource
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=180000
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.auto-commit=true
spring.datasource.hikari.max-lifetime=1800000
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.connection-test-query=SELECT 1
```

## 邮件发送配置

```Properties
# 配置邮件服务器的地址 smtp.qq.com
spring.mail.host=smtp.qq.com
# 配置邮件服务器的端口（465或587）
spring.mail.port=465
# 配置用户的账号 (用于发送验证码的信息的qq邮箱账号)
spring.mail.username=xxxxx@qq.com
# 配置用户的授权码
spring.mail.password=xxxxxx
# 配置默认编码
spring.mail.default-encoding=UTF-8
# SSL 连接配置
spring.mail.properties.mail.smtp.socketFactory.class=javax.net.ssl.SSLSocketFactory
# 开启 debug，这样方便开发者查看邮件发送日志
spring.mail.properties.mail.debug=true
```

## QQ登陆服务配置

```Properties
##qq登陆相关##
qq.app.id=12333
qq.app.key=2222222
qq.url.authorization=https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s
qq.url.access.token=https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s
qq.url.openid=https://graph.qq.com/oauth2.0/me?access_token=%S
qq.url.user.info=https://graph.qq.com/user/get_user_info?access_token=%s&oauth_consumer_key=%s&openid=%s
qq.url.redirect=http://easypan.wuhancoder.com/qqlogincalback
```

## 日志服务配置

```Properties
#日志级别配置
log.root.level=debug
```

logback-spring.xml配置文件. 放置在resources目录下。

```XML
<?xml version="1.0" encoding="UTF-8" ?>
<configuration scan="true" scanPeriod="10 minutes">
    <appender name="stdot" class="ch.qos.logback.core.ConsoleAppender">
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>%d{yyyy-MM-dd HH:mm:ss,GMT+8} [%p][%c][%M][%L]-> %m%n</pattern>
        </layout>
    </appender>

    <springProperty scope="context" name="log.path" source="project.folder"/>
    <springProperty scope="context" name="log.root.level" source="log.root.level"/>

    <property name="LOG_FOLDER" value="logs"/>
    <property name="LOG_FILE_NAME" value="easypan.log"/>

    <appender name="file" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <file>${log.path}/${LOG_FOLDER}/${LOG_FILE_NAME}</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <FileNamePattern>${log.path}/${LOG_FOLDER}/${LOG_FILE_NAME}.%d{yyyyMMdd}.%i</FileNamePattern>
            <cleanHistoryOnStart>true</cleanHistoryOnStart>
            <TimeBasedFileNamingAndTriggeringPolicy class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <MaxFileSize>20MB</MaxFileSize>
            </TimeBasedFileNamingAndTriggeringPolicy>
            <maxHistory>30</maxHistory>
        </rollingPolicy>
        <encoder>
            <charset>utf-8</charset>
            <pattern>%d{yyyy-MM-dd HH:mm:ss,GMT+8} [%p][%c][%M][%L]-> %m%n</pattern>
        </encoder>
        <append>false</append>
        <prudent>false</prudent>
    </appender>

    <root level="${log.root.level}">
        <appender-ref ref="stdot"/>
        <appender-ref ref="file"/>
    </root>

</configuration>
```

## 其他配置

```Properties
#项目目录
project.folder=D:/MyCloudPan/easypan/
#超级管理员id
admin.emails=1557680091@qq.com
#是否是开发环境
dev=false
```

# 依赖管理

## 依赖版本控制

```XML
<properties>
  <java.version>1.8</java.version>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
  <skipTests>true</skipTests>

  <springboot.version>2.6.1</springboot.version>
  <mybatis.version>1.3.2</mybatis.version>
  <logback.version>1.2.10</logback.version>
  <mysql.version>8.0.23</mysql.version>
  <aspectjweaver.version>1.9.4</aspectjweaver.version>
  <fastjson.version>1.2.66</fastjson.version>
  <commons.lang3.version>3.4</commons.lang3.version>
  <commons.codec.version>1.9</commons.codec.version>
  <commons.io.version>2.5</commons.io.version>
</properties>
```

## 邮件发送依赖

```XML
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-mail</artifactId>
  <version>${springboot.version}</version>
</dependency>
```

## Mysql依赖

```XML
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>${mysql.version}</version>
</dependency>
```

## Mybatis依赖

```XML
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>${mybatis.version}</version>
</dependency>
```

## Redis依赖

```XML
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-redis</artifactId>
  <version>${springboot.version}</version>
</dependency>
```

## Aop切面依赖

```XML
<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>${aspectjweaver.version}</version>
</dependency>
```

## 日志管理依赖

```XML
<!-- 排除旧版本的依赖 -->
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
      <exclusion>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-classic</artifactId>
      </exclusion>
      <exclusion>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-core</artifactId>
      </exclusion>
    </exclusions>
  </dependency>

<!--使用新的版本的依赖-->
<dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>${logback.version}</version>
</dependency>
<dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-core</artifactId>
  <version>${logback.version}</version>
</dependency>
```

## 单元测试环境

```XML
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

## 其他工具依赖

```XML
<!--fastjson-->
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>fastjson</artifactId>
  <version>${fastjson.version}</version>
</dependency>

<!--apache common-->
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-lang3</artifactId>
  <version>${commons.lang3.version}</version>
</dependency>

<dependency>
  <groupId>commons-codec</groupId>
  <artifactId>commons-codec</artifactId>
  <version>${commons.codec.version}</version>
</dependency>

<dependency>
  <groupId>commons-io</groupId>
  <artifactId>commons-io</artifactId>
  <version>${commons.io.version}</version>
</dependency>
```

# 数据库建表

```SQL
SET FOREIGN_KEY_CHECKS=0;
```

## 用户信息表

```SQL
-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(10) NOT NULL COMMENT '用户ID',
  `nick_name` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(150) DEFAULT NULL COMMENT '邮箱',
  `qq_open_id` varchar(35) DEFAULT NULL COMMENT 'qqOpenID',
  `qq_avatar` varchar(150) DEFAULT NULL COMMENT 'qq头像',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `join_time` datetime DEFAULT NULL COMMENT '加入时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '0:禁用 1:正常',
  `use_space` bigint(20) DEFAULT '0' COMMENT '使用空间单位byte',
  `total_space` bigint(20) DEFAULT NULL COMMENT '总空间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `key_email` (`email`),
  UNIQUE KEY `key_nick_name` (`nick_name`),
  UNIQUE KEY `key_qq_open_id` (`qq_open_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息';

-- ----------------------------
-- 插入测试数据
-- ----------------------------
INSERT INTO `user_info` VALUES ('3178033358', '测试账号', 'test@qq.com', null, null, '47ec2dd791e31e2ef2076caf64ed9b3d', null, '2023-04-28 13:54:01', '1', '238302835', '10737418240');
```

## 邮箱验证表

```Properties
-- ----------------------------
-- Table structure for email_code
-- ----------------------------
DROP TABLE IF EXISTS `email_code`;
CREATE TABLE `email_code` (
  `email` varchar(150) NOT NULL COMMENT '邮箱',
  `code` varchar(5) NOT NULL COMMENT '编号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) DEFAULT NULL COMMENT '0:未使用  1:已使用',
  PRIMARY KEY (`email`,`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='邮箱验证码';
```

## 文件信息表

```Properties
-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `file_id` varchar(10) NOT NULL COMMENT '文件ID',
  `user_id` varchar(10) NOT NULL COMMENT '用户ID',
  `file_md5` varchar(32) DEFAULT NULL COMMENT 'md5值，第一次上传记录',
  `file_pid` varchar(10) DEFAULT NULL COMMENT '父级ID',
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `file_name` varchar(200) DEFAULT NULL COMMENT '文件名称',
  `file_cover` varchar(100) DEFAULT NULL COMMENT '封面',
  `file_path` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `folder_type` tinyint(1) DEFAULT NULL COMMENT '0:文件 1:目录',
  `file_category` tinyint(1) DEFAULT NULL COMMENT '1:视频 2:音频  3:图片 4:文档 5:其他',
  `file_type` tinyint(1) DEFAULT NULL COMMENT ' 1:视频 2:音频  3:图片 4:pdf 5:doc 6:excel 7:txt 8:code 9:zip 10:其他',
  `status` tinyint(1) DEFAULT NULL COMMENT '0:转码中 1转码失败 2:转码成功',
  `recovery_time` datetime DEFAULT NULL COMMENT '回收站时间',
  `del_flag` tinyint(1) DEFAULT '2' COMMENT '删除标记 0:删除  1:回收站  2:正常',
  PRIMARY KEY (`file_id`,`user_id`),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_md5` (`file_md5`) USING BTREE,
  KEY `idx_file_pid` (`file_pid`),
  KEY `idx_del_flag` (`del_flag`),
  KEY `idx_recovery_time` (`recovery_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文件信息';
```

## 文件分享信息表

```Properties
-- ----------------------------
-- Table structure for file_share
-- ----------------------------
DROP TABLE IF EXISTS `file_share`;
CREATE TABLE `file_share` (
  `share_id` varchar(20) NOT NULL COMMENT '分享ID',
  `file_id` varchar(10) NOT NULL COMMENT '文件ID',
  `user_id` varchar(10) NOT NULL COMMENT '用户ID',
  `valid_type` tinyint(1) DEFAULT NULL COMMENT '有效期类型 0:1天 1:7天 2:30天 3:永久有效',
  `expire_time` datetime DEFAULT NULL COMMENT '失效时间',
  `share_time` datetime DEFAULT NULL COMMENT '分享时间',
  `code` varchar(5) DEFAULT NULL COMMENT '提取码',
  `show_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  PRIMARY KEY (`share_id`),
  KEY `idx_file_id` (`file_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_share_time` (`share_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分享信息';
```

# 启动

## 启动redis

```Bash
# 1. 查看redis-server是否启动
redis-cli 

# 2. 如果没启动，则继续执行下面步骤启动
cd /redis-7.0.13/redis/bin
redis-server redis.conf
```

## 后台运行

```Shell
cd /webapp
nohup java -Xmx1024m -Xms1024m -jar easypan-1.0.jar  >/dev/null 2>&1 &
```

> - `>/dev/null 2>&1` 忽略控制台的标准输出和错误输出信息
> - `> log.file &` 将所有输出重定向到log.file文件中。 

其他辅助命令

```Shell
ls -lht  #查看文件的大小
```

关闭项目

```Bash
ps -aux | grep easypan
kill -9 pid
```

查看尾行

```Bash
tail -n 20 easypan.log
```

## 安装mvn

```Bash
# 1. 下载压缩包到 /download/ 目录下
# https://maven.apache.org/download.cgi
cd /download/
wget https://dlcdn.apache.org/maven/maven-3/3.8.8/binaries/apache-maven-3.8.8-bin.tar.gz

# 2. 解压压缩包到 /tools 目录下
mkdir /tools
mv apache-maven-3.8.8-bin.tar.gz /tools/

cd /tools/
tar -zxvf apache-maven-3.8.8-bin.tar.gz

# 3. 修改配置文件，添加环境变量
vi /etc/profile
# 尾部追加
#你的maven路径
MAVEN_HOME=/tools/apache-maven-3.8.8
export PATH=${MAVEN_HOME}/bin:${PATH}

# 4. 刷新配置文件
source /etc/profile

# 5. 查看 mvn 是否配置成功
mvn -version
```

## 配置java开发环境

卸载旧的java开发/运行环境 ： https://blog.csdn.net/fox_bert/article/details/113808508

安装配置新的java环境：

```Bash
 cd /usr/local/java
 tar -zxvf jdk-8u241-linux-x64.tar.gz
 
vim /etc/profile
 
export JAVA_HOME=/usr/local/java/jdk1.8.0_241
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HIOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

source /etc/profile

java -version
```

