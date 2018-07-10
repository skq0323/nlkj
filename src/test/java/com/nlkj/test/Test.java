/**
 * 
 */
package com.nlkj.test;

import java.util.Date;

import com.nlkj.entity.Student;
import com.nlkj.utils.AESUtil;

/**
 * @author 石凯强
 *
 * @date 2018年7月6日
 */
public class Test {
	public static void main(String[] args) {
		long time = new Date().getTime();
		
		System.out.println(new AESUtil().encrypt(time+"", "脑力科技"));
	}

}
