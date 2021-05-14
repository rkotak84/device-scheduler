package com.omnitracs.platform.device.scheduler.spring;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.omnitracs.platform.device.scheduler.repository.device", entityManagerFactoryRef = "deviceEntityManagerFactory", transactionManagerRef = "deviceTransactionManager")
public class DeviceDataBaseConfiguration {

	@Bean(name = "deviceDataSource", destroyMethod = "")
	@ConfigurationProperties(prefix = "spring.datasource-device")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "deviceEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.implicit_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy");
		properties.put("hibernate.physical_naming_strategy",
				"org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy");
		return builder.dataSource(dataSource()).packages("com.omnitracs.platform.device.scheduler.entity.device")
				.persistenceUnit("device").properties(properties).build();
	}

	@Bean(name = "deviceTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("deviceEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
