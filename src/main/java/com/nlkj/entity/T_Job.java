package com.nlkj.entity;

import java.io.Serializable;

public class T_Job implements Serializable{
	private int jid;
	private String jname;
	private String choice;
	public T_Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public T_Job(int jid, String jname, String choice) {
		super();
		this.jid = jid;
		this.jname = jname;
		this.choice = choice;
	}
	

}
