package com.jiekou.model;

public class LoginUser1 {
	private int id;
	private String username;
	private String password;
	private String expected;
	private String url;
	@Override
	public String toString() {
		return "LoginUser1 [id=" + id + ", username=" + username + ", password=" + password + ", expected=" + expected
				+ ", url=" + url + "]";
	}
	public String getUrl() {
		return url;
	}
	public String getexpected() {
		return expected;
	}
}
