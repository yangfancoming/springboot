package com.goat.service;


import com.github.pagehelper.PageInfo;
import com.goat.entity.JobAndTrigger;


public interface IJobAndTriggerService {
	 PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);
}
