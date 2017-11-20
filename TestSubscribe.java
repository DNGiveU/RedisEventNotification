package com.mdxd.modules.article.service;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.mdxd.modules.business.util.RedisMsgPubSubListener;

/**
 * 
 * @author: gaz
 * @data:2017年11月20日
 */ 
public class TestSubscribe {

	/**
	 * 为了简化key 操作在redis-cli中进行
	 * @author gaz
	 * @throws Exception
	 */
	@Test  
    public void testSubscribe() throws Exception{  
        Jedis jedis = new Jedis("localhost");  
        RedisMsgPubSubListener listener = new RedisMsgPubSubListener();  
        // jedis.psubscribe(listener, "__keyevent@0__:del");  
        // jedis.psubscribe(listener, "__keyspace@0__:del");  
        // jedis.psubscribe(listener, "__key*__:*");  
        // 监听并阻塞
        jedis.psubscribe(listener, "__keyevent@0__:expired");  
        //other code  
    }  
}
