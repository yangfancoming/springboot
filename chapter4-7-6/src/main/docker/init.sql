
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
                     id bigint(64) not null,
                     city varchar(20) not null,
                     name varchar(20) not null,
                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `sphere`.`user`(`id`, `city`, `name`) VALUES (101, 'beijing', 'dalaoyang1');
