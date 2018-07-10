package com.nlkj.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlkj.entity.T_Job;
import com.nlkj.entity.T_Wrong;
import com.nlkj.exception.CustomException;
import com.nlkj.mapper.WrongMapper;

@Service
public class WrongServiceImpl implements WrongService{
	@Autowired
	private WrongMapper wrongMapper;

	@Override
	public int queryWrong(T_Job job) {
		Logger logger = LoggerFactory.getLogger(WrongServiceImpl.class);
		if(job.getChoice()!=null&job.getJid()!=0) {
			//检查是否是错题
			T_Job job2=wrongMapper.queryJob(job);
			if(job2!=null) {
				return 200;
			}else {
				System.out.println(new CustomException("回答错误"));
				//将题目拿过来
				T_Job job3=wrongMapper.getJob(job);
				//查看错题本存在不添加
				T_Wrong wrong=wrongMapper.queryWrong(job3);
				if(wrong==null) {
					//添加到错题本
					wrongMapper.insertWrong(job3);
					logger.info("添加到错题本");
				}
				return 400;
			}
		}
		return 400;
		
	}

	/* (non-Javadoc)
	 * @see com.nlkj.service.WrongService#getJobList()
	 */
	@Override
	public List<T_Job> getJobList() {
		return wrongMapper.getJobList();
	}

	/* (non-Javadoc)
	 * @see com.nlkj.service.WrongService#getWrongList()
	 */
	@Override
	public List<T_Wrong> getWrongList() {
		return wrongMapper.getWrongList();
	}

}
