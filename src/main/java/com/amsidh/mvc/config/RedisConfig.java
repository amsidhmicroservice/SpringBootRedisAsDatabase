package com.amsidh.mvc.config;

import com.amsidh.mvc.consumer.PersonConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.*;

@Configuration
public class RedisConfig {

	@Value("${spring.redis.host:localhost}")
	private String hostName;
	@Value("${spring.redis.port:6379}")
	private Integer portNumber;

	@Bean
	public JedisConnectionFactory getJedisConnectionFactory() {
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(hostName, portNumber);
		return new JedisConnectionFactory(config);
	}

	@Bean
	public RedisTemplate<String, Object> getRedisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(getJedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));

		return template;
	}

	@Bean
	public ChannelTopic channelTopic(){
		return new ChannelTopic("pubsub:redis_topic");
	}

	@Bean
	public MessageListenerAdapter messageListenerAdapter(){
		return new MessageListenerAdapter(new PersonConsumer());
	}

	@Bean
	public RedisMessageListenerContainer redisMessageListenerContainer(){
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.setConnectionFactory(getJedisConnectionFactory());
		container.addMessageListener(messageListenerAdapter(), channelTopic());
		return container;
	}

}
