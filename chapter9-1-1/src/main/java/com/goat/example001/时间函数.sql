

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