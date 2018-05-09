package _00_config;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
//@ImportResource("file:**\\WEB-INF\\spring-beans.xml")
//@EnableTransactionManagement
@EnableJdbcHttpSession
//@ImportResource("file:E:\\CTBC_workspace_Oxygen_3a\\SpringSessionTest\\src\\main\\webapp\\WEB-INF\\spring-beans.xml")
public class RootConfig {

//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setUrl("jdbc:sqlserver://172.24.17.52:1803;databaseName=ITOA_MAIN");
//		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		ds.setUsername("ITOA_MAIN_mod");
//		ds.setPassword("f3ru9cj4");
//		return ds; 
//	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setUrl("jdbc:sqlserver://127.0.0.1:1433;databaseName=SpringSessionTestDB");
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUsername("sa");
		ds.setPassword("sa123456");
		return ds; 
	}
	
//	@Bean
//    public EmbeddedDatabase embeddedDatabase() {
//            return new EmbeddedDatabaseBuilder() 
//                            .setType(EmbeddedDatabaseType.H2)
//                            .addScript("org/springframework/session/jdbc/schema-h2.sql").build();
//    }
	
	@Bean
	public DataSourceTransactionManager transactionManager(DataSource ds) {
	    return new DataSourceTransactionManager(ds); 
	}
	
//	@Bean
//	public redis.clients.jedis.JedisPoolConfig jedisPoolConfig() {
//		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//		return jedisPoolConfig;
//	}
//
//	@Bean
//	@SuppressWarnings("deprecation")
//	public org.springframework.data.redis.connection.jedis.JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		factory.setHostName("127.0.0.2");
//		factory.setPort(6379);
//		factory.setPassword("");
//		factory.setTimeout(1800);
//		factory.setPoolConfig(jedisPoolConfig);
//		factory.setUsePool(true);
//		return factory;
//	}
//
//	@Bean
//	public org.springframework.data.redis.core.StringRedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
//		StringRedisTemplate redisTemplate = new StringRedisTemplate();
//		redisTemplate.setConnectionFactory(connectionFactory);
//		return redisTemplate;
//	}

//	@Bean
//	public org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration redisHttpSessionConfiguration() {
//		RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
//		redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(1800);
//		return redisHttpSessionConfiguration;
//	}

	public static void main(String[] args) throws SQLException {
		
		// xml config
//		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("file:**\\WEB-INF\\spring-beans.xml");
//		DataSource ds = ctx.getBean("myDatasource", DataSource.class);
//		Connection conn = ds.getConnection();
//		System.out.println("ITOA_MAIN Datasource : " + conn.getMetaData().getDatabaseProductName());
//		ctx.close();
		 
		// annotation config
		ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println("Datasource : " + conn.getMetaData().getDatabaseProductName());
		ctx.close();
		
	}

}
