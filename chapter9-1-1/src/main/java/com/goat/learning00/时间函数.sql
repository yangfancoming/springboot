
# 修改 表中 某时间字段 默认值为 系统当前时间戳  mysql默认事件
ALTER TABLE smms.c_step MODIFY CREATETIME DATETIME DEFAULT CURRENT_TIMESTAMP();
ALTER TABLE authority.sys_role MODIFY createtime DATETIME DEFAULT CURRENT_TIMESTAMP();


# <select id="datalistPage" parameterType="Page" resultType="pd">
# SELECT * FROM collect WHERE 1=1
#                             <if test="pd.METERID != null and pd.METERID != ''"> AND METERID LIKE CONCAT(CONCAT('%', #{pd.METERID}),'%') </if>
#
# <if test="pd.STARTTIME != null and pd.ENDTIME != ''">
# and DATE_FORMAT(#{pd.STARTTIME},'%Y-%m-%d') <![CDATA[ <= ]]> DATE_FORMAT(createtime,'%Y-%m-%d')
# and DATE_FORMAT(createtime,'%Y-%m-%d') <![CDATA[ <= ]]> DATE_FORMAT(#{pd.ENDTIME},'%Y-%m-%d')
# </if>
#
# order by CREATETIME ASC
# </select>

# 获取mysql系统时间的三种方法
select now();        # --yyyy-MM-dd HH:mm:ss  2018-12-10 11:34:34
select sysdate();    # --yyyy-MM-dd HH:mm:ss  2018-12-10 11:34:30
select current_date; # --yyyy-MM-dd           2018-12-10

# 利用系统当前日期 --yyyy-MM-dd 格式   匹配  表字段中的 日期  yyyy-MM-dd HH:mm:ss 格式
select code from test2.emp where delete_state = 0 and date_format(add_time,'%Y-%m-%d') = (select current_date);













