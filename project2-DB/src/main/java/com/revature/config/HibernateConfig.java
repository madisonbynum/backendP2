package com.revature.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Guest;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.println("Configuring session factory");
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		
		// set annotated classes
		factoryBean.setAnnotatedClasses(Guest.class);
		factoryBean.setDataSource(getDataSource());
		
		return factoryBean;
	}

	@Bean(name="dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://anotherclassdb.cwgm7vdywa98.us-east-2.rds.amazonaws.com:5432/hibernate");
		dataSource.setUsername("hotel_role");
		dataSource.setPassword("project2");
		
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTreansactionManager() {
		System.out.println("Configuring Transaction Manager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
}
