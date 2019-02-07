package com.goat.dao;


import com.goat.entity.JobAndTrigger;

import java.util.List;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Date:   2019/2/7
 *  fuck 这里的接口文件名 JobAndTriggerMapper  必须 对应其xml JobMapper.xml文件中 <mapper namespace="com.goat.dao.JobAndTriggerMapper"> 的 JobAndTriggerMapper
 *
*/
//@Mapper
public interface JobAndTriggerMapper {
	 List<JobAndTrigger> getJobAndTriggerDetails();
}
