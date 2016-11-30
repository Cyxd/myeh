package com.cyxd.demo.redis;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import org.redisson.Config;
import org.redisson.Redisson;

public class RedissonExample {

	public static void test1() {
		// 1.初始化
		Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("120.24.217.254:6079");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids连接成功...");

		// 2.测试concurrentMap,put方法的时候就会同步到redis中
		ConcurrentMap<String, Object> map = redisson.getMap("FirstMap");
		map.put("wuguowei", "男");
		map.put("zhangsan", "nan");
		map.put("lisi", "女");

		ConcurrentMap<String, Object> resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());

		// 2.测试Set集合
		Set<String> mySet = redisson.getSet("MySet");
		mySet.add("wuguowei");
		mySet.add("lisi");

		Set<String> resultSet = redisson.getSet("MySet");
		System.out.println("resultSet===" + resultSet.size());

		// 3.测试Queue队列
		Queue<String> myQueue = redisson.getQueue("FirstQueue");
		myQueue.add("wuguowei");
		myQueue.add("lili");
		myQueue.add("zhangsan");
		myQueue.peek();
		myQueue.poll();

		Queue<String> resultQueue = redisson.getQueue("FirstQueue");
		System.out.println("resultQueue===" + resultQueue);

		// 关闭连接
		redisson.shutdown();
	}
	
	public static void test2() {
		// 1.初始化
		Config config = new Config();
		config.setConnectionPoolSize(10);
		config.addAddress("120.24.217.254:6079");
		Redisson redisson = Redisson.create(config);
		System.out.println("reids连接成功...");
		
		//测试从test1 中获取的map数据

		ConcurrentMap<String, Object> resultMap = redisson.getMap("FirstMap");
		System.out.println("resultMap==" + resultMap.keySet());

		// 关闭连接
		redisson.shutdown();
	}

	public static void main(String[] args) {
//		test1();
		test2();
	}

}
