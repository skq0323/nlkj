/**
 * 
 */
package com.nlkj.entity;

/**
 * @author 石凯强
 *
 * @date 2018年7月6日
 */
public class Student {
	private Integer sid;
	private String sname;
	private String sex;
	private Integer age;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Student(Integer sid, String sname, String sex, Integer age) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sex = sex;
		this.age = age;
	}
	public Student() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
	

}
