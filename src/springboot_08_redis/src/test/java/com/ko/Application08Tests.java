package com.ko;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Application08Tests {
	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate; //常用

	@Test
	void contextLoads() {
	}

	@Test
	void testSet(){
		ValueOperations ops = redisTemplate.opsForValue();
		ops.set("age",18);
	}

	@Test
	void testGet(){
		ValueOperations ops = redisTemplate.opsForValue();
		Object var = ops.get("age");
		System.out.println(var);
	}

	@Test
	void testHset(){
		HashOperations ops = redisTemplate.opsForHash();
		ops.put("info","a",10);
	}

	@Test
	void testHget(){
		HashOperations ops = redisTemplate.opsForHash();
		Object var = ops.get("info","a");
		System.out.println(var);
	}

	//redis客户端默认使用的string类型
	@Test
	void testSet1(){
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		ops.set("age","18");
	}

	@Test
	void testGet1(){
		ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
		Object var = ops.get("age");
		System.out.println(var);
		Object var1 = ops.get("name");
		System.out.println(var1);
	}
}
