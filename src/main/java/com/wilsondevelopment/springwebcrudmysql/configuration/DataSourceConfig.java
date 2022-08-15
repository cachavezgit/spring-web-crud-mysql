package com.wilsondevelopment.springwebcrudmysql.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
			dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
			dataSourceBuilder.url("jdbc:mysql://localhost:33060/spring_web_db?useSLL=false&serverTimezone=UTC&useLegacyDateTimeCode=false");
			dataSourceBuilder.username("root");
			dataSourceBuilder.password("secret");
		return dataSourceBuilder.build();
	}
}
