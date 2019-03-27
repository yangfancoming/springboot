# FIND_IN_SET 函数
# 语法：FIND_IN_SET(str,strlist)
# 定义：
# 1. 假如字符串str在由N子链组成的字符串列表strlist中，则返回值的范围在1到N之间。
# 2. 一个字符串列表就是一个由一些被‘,’符号分开的自链组成的字符串。
# 3. 如果第一个参数是一个常数字符串，而第二个是typeSET列，则FIND_IN_SET()函数被优化，使用比特计算。
# 4. 如果str不在strlist或strlist为空字符串，则返回值为0。
# 5. 如任意一个参数为NULL，则返回值为NULL。这个函数在第一个参数包含一个逗号(‘,’)时将无法正常运行。
# strlist：一个由英文逗号“,”链接的字符串，例如："a,b,c,d"，该字符串形式上类似于SET类型的值被逗号给链接起来。
# 示例：SELECT FIND_IN_SET('b','a,b,c,d'); //返回值为2，即第2个值


select * from t_inout_storage_detail where FIND_IN_SET('dtds03',all_code);
select id from t_inout_storage_detail where FIND_IN_SET('dtds03',all_code);