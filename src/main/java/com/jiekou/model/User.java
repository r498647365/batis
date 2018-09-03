package com.jiekou.model;

public class User {
	public int id;
	public String username;
	public String password;
	public int age;
	public int six;
	public int quanxian;
	public int isdelete;
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", six=" + six
				+ ", quanxian=" + quanxian + ", isdelete=" + isdelete + "]";
	}
}
