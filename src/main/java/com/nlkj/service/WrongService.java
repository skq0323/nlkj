package com.nlkj.service;

import java.util.List;

import com.nlkj.entity.T_Job;
import com.nlkj.entity.T_Wrong;

public interface WrongService {

	int queryWrong(T_Job job);

	/**
	 * @return
	 */
	List<T_Job> getJobList();

	/**
	 * @return
	 */
	List<T_Wrong> getWrongList();

}
