package com.atguigu.server;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

public class TestServiceImp implements TestServiceInf {

	@Override
	@Path("ping")
	@GET
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public String ping(@FormParam("hello") String hello) {

		System.err.println("你好：" + hello);

		return "pong";
	}

}
