package com.atguigu.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;
import com.atguigu.mapper.AddressMapper;
import com.atguigu.service.AddressService;
import com.atguigu.util.MyRoutingDataSource;

public class AddressServerImp implements AddressServer {
	
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private AddressService addressService;

	@Override
	public void insert_address(T_MALL_ADDRESS address) {
		System.out.println("fjaofaof");
		MyRoutingDataSource.setKey("2");
		addressService.insert_address(address);
	}

	@Override
	public List<T_MALL_ADDRESS> select_addresses_by_user_id(T_MALL_USER_ACCOUNT user) {
		return addressService.select_addresses_by_user_id(user);
	}

	@Override
	public T_MALL_ADDRESS select_addresses_by_id(int address_id) {
		return addressMapper.select_addresses_by_id(address_id);
	}

}
