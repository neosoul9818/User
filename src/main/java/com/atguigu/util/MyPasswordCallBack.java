package com.atguigu.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class MyPasswordCallBack implements CallbackHandler{

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		//callbacks[0],此处是因为，callbacks数组中只有一个数据。
		//public class WSPasswordCallback implements Callback {
		WSPasswordCallback pwdcb = (WSPasswordCallback)callbacks[0];
		String identifier = pwdcb.getIdentifier();
		//伪代码：模仿服务器端进行令牌的对比验证
//		if(identifier.equals("cxf")) {
////			pwdcb.setPassword("wss4j");
//			pwdcb.setPassword(MyPropertyUtil.getProperty("myUsernameToken.properties", "cxf"));
//		}
		//不安全，采用下面的方式
//		pwdcb.setPassword(MyPropertyUtil.getProperty("myUsernameToken.properties", identifier));
		
		pwdcb.setPassword(MD5Util.md5(MyPropertyUtil.getProperty("myUsernameToken.properties", identifier)+MyDataUtil.getMyDateString()));
		String md5 = MD5Util.md5(MyPropertyUtil.getProperty("myUsernameToken.properties", identifier)+MyDataUtil.getMyDateString());
		
		System.err.println(md5);
		System.err.println(identifier);
		
	}

}
