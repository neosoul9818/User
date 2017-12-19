package com.atguigu.server;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;
import com.atguigu.service.LoginService;
import com.atguigu.util.MyRoutingDataSource;

public class UserServerImpl implements UserServer {

	//因为要cxf中要用到事务，所以要创建@service service接口，再mapper注入到servcie中
	//	@Autowired
//	private LoginMapper loginMapper;
	@Autowired
	private LoginService loginService;
	/**
	 * 数据源1
	 */
	@Override
	public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user) {
		
		MyRoutingDataSource.setKey("1");
		
		return loginService.select_user(user);
	}

	@Override
	@Path("/loginrest")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public String login_REST_FUL(@BeanParam T_MALL_USER_ACCOUNT user) {
		T_MALL_USER_ACCOUNT select_user = loginService.select_user(user);
		String jsonString = JSON.toJSONString(select_user);
		return jsonString;
	}

	@Override
	public T_MALL_USER_ACCOUNT login_test(String dataSource_type,T_MALL_USER_ACCOUNT user) {
		//根据指定数据源，选择不同的DataSource数据库连接池
		MyRoutingDataSource.setKey(dataSource_type);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loginService.select_user(user);
	}
	/**
	 * 数据源2，线程睡了5秒
	 */
	@Override
	public T_MALL_USER_ACCOUNT login2(T_MALL_USER_ACCOUNT user) {
		
		MyRoutingDataSource.setKey("2");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return loginService.select_user(user);
	}

}
