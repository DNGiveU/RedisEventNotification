package com.mdxd.modules.business.util;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

/**
 * 在{@link com.mdxd.common.utils.JedisUtils#getResource()}处订阅
 * @author: gaz
 * @data:2017年11月20日
 */
public class RedisMsgPubSubListener extends JedisPubSub  {
	
	@Override
	public int getSubscribedChannels() {
		// TODO Auto-generated method stub
		return super.getSubscribedChannels();
	}

	@Override
	public boolean isSubscribed() {
		// TODO Auto-generated method stub
		return super.isSubscribed();
	}

	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
		super.onMessage(channel, message);
	}

	/**
	 * 先运行一波测试:
	 * $ redis-cli config set notify-keyspace-events KEA
	 * $ redis-cli --csv psubscribe '__key*__:*'
	 * CTRL+C退出
	 * 
	 * 或者在redis.conf
	 * 中设置
	 * notify-keyspace-events Ex
	 * 重启redis服务
	 * 
	 * 过期事件通知 keyevent
	 * channel = __keyevent@0__:event_name
	 * message = value
	 * 
	 * keyspace
	 * channel = __keyspace@0__:value
	 * message = event_name
	 * 
	 * Ex:
	 * __keyevent@0__:expired
	 * hello
	 * 
	 * __keyspace@0__:hello
	 * expired
	 */
	@Override
	public void onPMessage(String pattern, String channel, String message) {
		// TODO Auto-generated method stub
		// do something..
		System.out.println("channel" + channel);
		System.out.println("message=" + message);
		super.onPMessage(pattern, channel, message);
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPSubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onPUnsubscribe(pattern, subscribedChannels);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onSubscribe(channel, subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		super.onUnsubscribe(channel, subscribedChannels);
	}

	@Override
	public void proceed(Client client, String... channels) {
		// TODO Auto-generated method stub
		super.proceed(client, channels);
	}

	@Override
	public void proceedWithPatterns(Client client, String... patterns) {
		// TODO Auto-generated method stub
		super.proceedWithPatterns(client, patterns);
	}

	@Override
	public void psubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.psubscribe(patterns);
	}

	@Override
	public void punsubscribe() {
		// TODO Auto-generated method stub
		super.punsubscribe();
	}

	@Override
	public void punsubscribe(String... patterns) {
		// TODO Auto-generated method stub
		super.punsubscribe(patterns);
	}

	@Override
	public void subscribe(String... channels) {
		// TODO Auto-generated method stub
		super.subscribe(channels);
	}

	@Override
	public void unsubscribe() {
		// TODO Auto-generated method stub
		super.unsubscribe();
	}

	@Override
	public void unsubscribe(String... channels) {
		// TODO Auto-generated method stub
		super.unsubscribe(channels);
	}
}
