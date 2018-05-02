package _00_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableRedisHttpSession 
@ImportResource("file:**\\WEB-INF\\spring-beans.xml")
//@ImportResource("file:E:\\CTBC_workspace_Oxygen_3a\\SpringSessionTest\\src\\main\\webapp\\WEB-INF\\spring-beans.xml")
//@ComponentScan(basePackageClasses = { org.springframework.web.filter.DelegatingFilterProxy.class })
//@ComponentScan(basePackages= {"org.springframework.web.filter.*"})
public class RootConfig {

	@Bean
	public redis.clients.jedis.JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		return jedisPoolConfig;
	}

	@Bean
	@SuppressWarnings("deprecation")
	public org.springframework.data.redis.connection.jedis.JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		factory.setHostName("127.0.0.2");
		factory.setPort(6379);
		factory.setPassword("");
		factory.setTimeout(1800);
		factory.setPoolConfig(jedisPoolConfig);
		factory.setUsePool(true);
		return factory;
	}

	@Bean
	public org.springframework.data.redis.core.StringRedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

//	@Bean
//	public org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
//		RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
//		redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(1800);
//		return redisHttpSessionConfiguration;
//	}

}
