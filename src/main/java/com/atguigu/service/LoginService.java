package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;

public interface LoginService {

	T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user);
	
	
}
