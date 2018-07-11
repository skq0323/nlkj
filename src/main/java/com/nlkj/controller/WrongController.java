package com.nlkj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nlkj.entity.Student;
import com.nlkj.entity.T_Job;
import com.nlkj.entity.T_Wrong;
import com.nlkj.entity.Time;
import com.nlkj.service.WrongService;
import com.nlkj.utils.RSACheckUtil;
import com.nlkj.utils.Result;
import com.nlkj.utils.ResultCode;

@RestController
@RequestMapping("/test")
public class WrongController{
	@Autowired
	private WrongService wrongService;
	
	@Resource
	private RedisTemplate<String, Object> redisTemplate;
	
	@RequestMapping(value="/getTime",method=RequestMethod.GET)
	public Result getTime(double[] time) {
		try {
			if(time!=null) {
				List<Time> list=new ArrayList<>();
				List<T_Job> jobs=wrongService.getJobList();
				int i=0;
				for (double d : time) {
					long time1=(long) (d*20000);
					Time time2 = new Time(time1);
					i++;
					for(int y =0;y<jobs.size();y++) {
						if(y==i-1) {
							time2.setJid(jobs.get(y).getJid());
							list.add(time2);
						}
					}
				}
				return new Result(ResultCode.SUCCESS, list);
			}
			return new Result(ResultCode.WARN);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(ResultCode.WARN);
		}
	
	}
	
	@RequestMapping(value="/queryWrong",method=RequestMethod.GET)
	public Result queryWrong(T_Job job) {
			try {
				int status=wrongService.queryWrong(job);
				Map<String, Integer> hash=new HashMap<>();
				hash.put("status", status);
					return new Result(ResultCode.SUCCESS, hash);
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(ResultCode.WARN);
			}
	}
	
	@RequestMapping(value="/getWrong",method=RequestMethod.GET)
	public Result getWrong() {
		try {
			List<T_Wrong> wrongs=wrongService.getWrongList();
			return new Result(ResultCode.SUCCESS,wrongs);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(ResultCode.WARN);
		}
	}
	
	@RequestMapping(value="/check",method=RequestMethod.POST)
	public Result checkSign(HttpServletRequest request,Student student) {
		String sign = request.getHeader("sign");
		String time=request.getHeader("time");
		String pubKey=request.getHeader("pubKey");
		//Object data = redisTemplate.opsForValue().get(student.getSid().toString());
		//if(data==null) {
			String status = RSACheckUtil.checkPublicKey(pubKey);
			if(status.equals("success")){
				//redisTemplate.opsForValue().set(student.getSid().toString(), sign+","+1+","+time,60*1,TimeUnit.SECONDS);
				//System.out.println("加入redis并成功设置过期时间");
				return new Result(ResultCode.SUCCESS, student);
			}else if(status.equals("error")) {
				return new Result(ResultCode.SUCCESS,"获得密钥出错");
			}else {
			 	return new Result(ResultCode.LOSEEFFICACY, status);
			}
		//}
		//return new Result(ResultCode.WRONGFUL);
		
	}


}
