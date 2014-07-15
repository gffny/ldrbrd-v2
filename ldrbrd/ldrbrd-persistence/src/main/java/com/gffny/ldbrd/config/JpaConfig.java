/**
 * 
 */
package com.gffny.ldbrd.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gffny.ldrbrd.Application;

/**
 * @author John D. Gaffney | gffny.com
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
public class JpaConfig {
	
	/** */
	private static Logger LOG = LoggerFactory.getLogger(JpaConfig.class);

	/** */
	@Value("${dataSource.driverClassName}")
	private String driver;
	/** */
	@Value("${dataSource.url}")
	private String url;
	/** */
	@Value("${dataSource.username}")
	private String username;
	/** */
	@Value("${dataSource.password.encrypted}")
	private String encryptedPassword;
	/** */
	@Value("${hibernate.dialect}")
	private String dialect;
	/** */
	@Value("${hibernate.hbm2ddl.auto}")
	private String hbm2ddlAuto;
	/** */
	@Value("${hibernate.format_sql:true}")
	private String formatSql;
	/** */
	@Value("${instance}")
	private String instance;

	/**
	 * 
	 * @return
	 */
	@Bean
	public DataSource configureDataSource() {

		LOG.info("creating connection to database {}. using driver {}, with username {}", url, driver, username);
        DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(username);
		//ds.setPassword((new StringEncrypter("AES")).decrypt(encryptedPassword));
		return ds;
	}
}
