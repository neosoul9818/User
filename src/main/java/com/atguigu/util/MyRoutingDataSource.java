package com.atguigu.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MyRoutingDataSource extends AbstractRoutingDataSource {
	/**
	 * 通过key，key对应spring配置文件中的MyRoutingDataSource的bean中的
	 * <property name="targetDataSources">
		<map key-type="java.lang.String">
			<entry key="1" value-ref="dataSource1"></entry>
			<entry key="2" value-ref="dataSource2"></entry>
		</map>
	</property>
	 */
//	private static String  key;
	
	/**
	 * 针对每个线程在jvm中的内存开辟一个内存空间
	 * Threadlocal底层是ThreadLocalMap，本质是每个线程在内存中该线程的的临时内存空间
	 */
	private static ThreadLocal<String> key = new ThreadLocal<String>();
	
	@Override
	protected Object determineCurrentLookupKey() {
		
		return getKey();
	}

	public static String getKey() {
		return key.get();
	}
	/**
	 * 每个线程，各自有一个key_in
	 * @param key_in
	 */
	public static void setKey(String key_in) {
//		this.key = key_locale.set(key);
		MyRoutingDataSource.key.set(key_in);
	}
}
