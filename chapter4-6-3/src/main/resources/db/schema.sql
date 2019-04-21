
-- ----------------------------
-- Table structure for `user`
-- ----------------------------

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id int NOT NULL auto_increment,
    age int ,
    userName varchar(64) NOT NULL,
    passWord varchar(64) NOT NULL,
    createTime timestamp NOT NULL default CURRENT_TIMESTAMP,
    updateTime timestamp NOT NULL default CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
)