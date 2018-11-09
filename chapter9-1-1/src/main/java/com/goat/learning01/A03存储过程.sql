
-- ----------------------------
# 存储过程弊端
# 1.不同数据库，语法差别很大，移植困难，换了数据库，需要重新编写；
# 2.不好管理，把过多业务逻辑写在存储过程不好维护，不利于分层管理，容易混乱，一般存储过程适用于个别对性能要求较高的业务，其它的必要性不是很大；

# 存储过程优点
# 速度快，只有首次执行需经过编译和优化步骤，后续被调用可以直接执行，省去以上步骤；
-- ----------------------------



-- ----------------------------
-- 存储过程 求和
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_adder`;
DELIMITER ;;
CREATE PROCEDURE `proc_adder`(IN a int, IN b int, OUT sum int)
  BEGIN
    if a is null then set a = 0;
    end if;
    if b is null then set b = 0;
    end if;
    set sum  = a + b;
  END
;;
DELIMITER ;

-- ----------------------------
-- 调用存储过程  @s为返回值
-- ----------------------------

set @b=5;
call proc_adder(2,@b,@s);
select @s as sum;





-- ----------------------------
-- 调用存储过程  if语句
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_if`;
DELIMITER ;;
CREATE  PROCEDURE `proc_if`(IN type int)
  BEGIN
    DECLARE c varchar(500);
    IF type = 0 THEN
      set c = 'param is 0';
    ELSEIF type = 1 THEN
      set c = 'param is 1';
    ELSE
      set c = 'param is others, not 0 or 1';
    END IF;
    select c;
  END
;;
DELIMITER ;

-- ----------------------------
-- 调用存储过程  @s为返回值
-- ----------------------------
set @type=5;
call proc_if(@type);



-- ----------------------------
-- 循环while语句：
-- ----------------------------
DROP PROCEDURE IF EXISTS `proc_while`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_while`(IN n int)
  BEGIN
    DECLARE i int;
    DECLARE s int;
    SET i = 0;
    SET s = 0;
    WHILE i <= n DO
      set s = s + i;
      set i = i + 1;
    END WHILE;
    SELECT s;
  END
;;
DELIMITER ;

set @type=100;
call proc_while(@type);