package com.clothing.common.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;
import com.clothing.dao.interceptor.QueryInterceptor;
import com.github.pagehelper.PageHelper;

@ComponentScan
@Configuration
public class DataSourceConfig {
	
	private final static Logger logger=LoggerFactory.getLogger(DataSourceConfig.class);

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));

		return dataSource;
	}
	
	@Bean(name = "sqlSessionFactoryBean")
	public SqlSessionFactoryBean myGetSqlSessionFactory(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		// mapperLocations
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		try {
			sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/item/*.xml"));
		} catch (IOException e) {
			logger.info("sqlSessionFactoryBean的setMapperLocations有问题");
			e.printStackTrace();
		}
		// dataSource
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageHelper(),new QueryInterceptor()}); 
		// SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();

		return sqlSessionFactoryBean;

	}

	@Bean
	public QueryInterceptor query() {
		return new QueryInterceptor();
	}

	// 配置mybatis的分页插件pageHelper
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		properties.setProperty("dialect", "mysql"); // 配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}
}
