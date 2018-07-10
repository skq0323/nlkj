package com.nlkj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nlkj.entity.T_Job;
import com.nlkj.entity.T_Wrong;

@Mapper
public interface WrongMapper {
	
	T_Wrong queryWrong(T_Job job);

	T_Job getJob(T_Job job);

	void insertWrong(T_Job job3);

	T_Job queryJob(T_Job job);

	/**
	 * @return
	 */
	List<T_Job> getJobList();

	/**
	 * @return
	 */
	List<T_Wrong> getWrongList();


}
