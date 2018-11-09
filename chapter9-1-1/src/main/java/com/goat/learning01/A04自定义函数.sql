


-- ----------------------------
# 存储过程与函数的区别:
# 1.SQL语句中不可用存储过程，而可以使用函数。
# 2.存储过程可以有多个返回值,而自定义函数只有一个返回值;
# 3.存储过程一般独立的来执行,而函数往往是作为其他SQL语句的一部分来使用;

-- ----------------------------



set global log_bin_trust_function_creators=TRUE;
-- 最简单的仅有一条sql的函数
create function myselect2() returns int return 666;
select myselect2(); -- 调用函数

--
create function myselect3() returns int
  begin
    declare c int;
    select EMPNO from emp where ENAME="ALLEN" into c;
    return c;
  end;
select myselect3();

-- 带传参的函数
drop function IF EXISTS myselect5;
create function myselect5(name varchar(15) ) returns int
  begin
    declare c int;
    select EMPNO from emp where ENAME = name into c;
    return c;
  end;
select myselect5("ALLEN");


