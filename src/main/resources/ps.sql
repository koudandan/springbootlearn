USE ps;

DROP TABLE IF EXISTS ps_user;
DROP TABLE IF EXISTS ps_area;
DROP TABLE IF EXISTS ps_shop_category;
DROP TABLE IF EXISTS ps_shop;

CREATE TABLE IF NOT EXISTS ps_user(
  user_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  age INT(11),
  birthday DATETIME,
  gender VARCHAR(255),
  address VARCHAR(255),
  phone VARCHAR(255) NOT NULL ,
  create_time DATETIME NOT NULL ,
  last_update_time DATETIME NOT NULL ,
  state INT(11) NOT NULL ,
  role INT(11) NOT NULL ,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uk_ps_user` (`phone`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS ps_area(
  area_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  area_name VARCHAR(255) NOT NULL,
  area_desc VARCHAR(255),
  priority INT(11) NOT NULL,
  create_time DATETIME NOT NULL,
  last_update_time DATETIME NOT NULL,
  PRIMARY KEY (`area_id`),
  UNIQUE KEY `uk_ps_area` (`area_name`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS ps_shop_category(
  shop_category_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  shop_category_name VARCHAR(255) NOT NULL,
  shop_category_desc VARCHAR(255),
  priority INT(11) NOT NULL,
  create_time DATETIME NOT NULL,
  last_update_time DATETIME NOT NULL,
  parent_id BIGINT(20),
  PRIMARY KEY (`shop_category_id`),
  KEY `ps_shop_category_self` (`parent_id`),
  CONSTRAINT `ps_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `ps_shop_category` (`shop_category_id`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS ps_shop(
  shop_id BIGINT(20) NOT NULL AUTO_INCREMENT,
  owner_id BIGINT(20) NOT NULL,
  area_id BIGINT(20) NOT NULL,
  shop_category_id BIGINT(20) NOT NULL,
  shop_name VARCHAR(255) NOT NULL,
  phone VARCHAR(255),
  shop_desc VARCHAR(255),
  address VARCHAR(255),
  priority INT(11) NOT NULL,
  status INT(11) NOT NULL,
  create_time DATETIME NOT NULL,
  last_update_time DATETIME NOT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `ps_shop_owner` (`owner_id`),
  KEY `ps_shop_area` (`area_id`),
  KEY `ps_shop_shop_category` (`shop_category_id`),
  CONSTRAINT `ps_shop_owner` FOREIGN KEY (`owner_id`) REFERENCES `ps_user` (`user_id`),
  CONSTRAINT `ps_shop_area` FOREIGN KEY (`area_id`) REFERENCES `ps_area` (`area_id`),
  CONSTRAINT `ps_shop_shop_category` FOREIGN KEY (`shop_category_id`) REFERENCES `ps_shop_category` (`shop_category_id`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

