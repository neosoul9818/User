package com.atguigu.server;

import javax.jws.WebService;

@WebService
public interface TestServiceInf {

	public String ping(String hello);

}
