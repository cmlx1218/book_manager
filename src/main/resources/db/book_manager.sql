DROP TABLE IF EXISTS `user`;
CREATE TABLE user
(
    id       BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
    userName VARCHAR(20) NOT NULL COMMENT '用户名',
    nickName VARCHAR(20) NOT NULL COMMENT '真实姓名',
    password VARCHAR(20) NOT NULL COMMENT '密码',
    sex      VARCHAR(1)  NOT NULL COMMENT '性别',
    KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='用户表';



DROP TABLE IF EXISTS `book`;
CREATE TABLE book
(
    id        BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '图书id',
    name      VARCHAR(20) NOT NULL COMMENT '书名',
    price     DOUBLE      NOT NULL COMMENT '价格',
    author    VARCHAR(20) NOT NULL COMMENT '作者',
    publisher VARCHAR(20) NOT NULL COMMENT '出版社',
    KEY `id` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='图书表';