package com.goat.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.dao.JobAndTriggerMapper;
import com.goat.entity.JobAndTrigger;
import com.goat.service.IJobAndTriggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobAndTriggerImpl implements IJobAndTriggerService {

	@Autowired
	private JobAndTriggerMapper jobAndTriggerMapper;

    /**
     * sos 注意： List<JobAndTrigger> list  集合报错： All elements are null 异常  这是为什么？
     *   原因是 mybatis-config.xml 配置文件中 使用了 驼峰命名规范。。。 我草
         驼峰命名法 eg: javabean中的属性 lastName  数据库表中的字段 last_name 则 last_name 会被映射为 lastName
         <setting name="mapUnderscoreToCamelCase" value="true"/>
     */
	public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<JobAndTrigger> list = jobAndTriggerMapper.getJobAndTriggerDetails();
		PageInfo<JobAndTrigger> page = new PageInfo<>(list);
		return page;
	}

}