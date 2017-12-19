package com.atguigu.test;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.server.UserServer;

public class WsTest {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean jaxws = new JaxWsProxyFactoryBean();
		jaxws.setAddress("http://localhost:28080/User/user?wsdl");
		jaxws.setServiceClass(UserServer.class);
		
		UserServer create = (UserServer) jaxws.create();
		T_MALL_USER_ACCOUNT user = new T_MALL_USER_ACCOUNT();
		user.setYh_mch("lilei");
		user.setYh_mm("123");
		//rest风格
		String json_user = create.login_REST_FUL(user);
		System.out.println(json_user);
		//soap风格
		T_MALL_USER_ACCOUNT login = create.login(user);
		System.out.println(login);
	}
}
