package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

public interface AddressService {

	void insert_address(T_MALL_ADDRESS address);

	List<T_MALL_ADDRESS> select_addresses_by_user_id(T_MALL_USER_ACCOUNT user);

}
