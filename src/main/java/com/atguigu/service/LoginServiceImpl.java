package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.LoginMapper;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper loginMapper;

	@Override
	public T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user) {
		
		return loginMapper.select_user(user);
	}
}
