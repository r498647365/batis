package com.my.unitl;

import java.io.IOException;
import java.io.Reader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Unitl {
	public static CookieStore cookieStore;
	//mybatis读取数据库的方法
public static SqlSession getSqlsession() throws IOException {
	Reader reader=Resources.getResourceAsReader("batis.xml");
	SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession session=sessionFactory.openSession();
	return session;
}

	//封装发送请求
	public static HttpResponse  PostRequest(String url,String jsonString) throws ClientProtocolException, IOException {
		HttpPost httpPost=new HttpPost(url);
		DefaultHttpClient defaultHttpClient=new DefaultHttpClient();
		httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
		StringEntity stringEntity=new StringEntity(jsonString,"utf-8");
		httpPost.setEntity(stringEntity);
		/*
		 * 因为每个方法都要通过这个请求方法，所以设置cookie也要被封装，判断是否有cookie
		 * 所以以后的所有方法都不用再重复判断了*/
		//发送请求并得到结果并返回
		//获得cookie
		if(cookieStore!=null) {
			defaultHttpClient.setCookieStore(cookieStore);
			HttpResponse execute1 = defaultHttpClient.execute(httpPost);
			return execute1;
		}else {
			HttpResponse execute1 = defaultHttpClient.execute(httpPost);
			cookieStore = defaultHttpClient.getCookieStore();
			return execute1;
		}
	}
}
