package com.jiekou.cases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.annotations.Until;
import com.jiekou.model.LoginUser1;
import com.jiekou.model.User;
import com.my.unitl.Unitl;

public class LoginCase {
	private LoginUser1 loginUser1;
	public CookieStore cookiestore;
	public String url;
	@BeforeTest
	public void before() throws IOException {
		SqlSession session=Unitl.getSqlsession();
		loginUser1=session.selectOne("UserList", 1);
		url=loginUser1.getUrl();
	}
	
	//��ʼ����ɣ���ʼ��������
	@Test(groups= {"logintrue"})
	public void getlogin() throws ParseException, IOException {
		//��һ����ʹ��Gson����ȡ�� loginuser��ת��Ϊ�ַ���
		Gson gson=new Gson();
		String json = gson.toJson(loginUser1);
		//�������󲢵õ����ؽ��
		HttpResponse postRequest = Unitl.PostRequest(url, json);
		String result=EntityUtils.toString(postRequest.getEntity(),"utf-8");
		//�ڶ�������֤���
		
		AssertJUnit.assertEquals(postRequest.getStatusLine().getStatusCode(), 200);
		AssertJUnit.assertEquals(result, loginUser1.getexpected());
		System.out.println("�������");
		
	}
}
