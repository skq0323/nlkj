package com.nlkj.entity;

import java.io.Serializable;

public class T_Wrong implements Serializable{
	private Integer wid;
	private String wname;
	private String choice;
	public T_Wrong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public T_Wrong(Integer wid, String wname, String choice) {
		super();
		this.wid = wid;
		this.wname = wname;
		this.choice = choice;
	}
	public Integer getWid() {
		return wid;
	}
	public void setWid(Integer wid) {
		this.wid = wid;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	

}
