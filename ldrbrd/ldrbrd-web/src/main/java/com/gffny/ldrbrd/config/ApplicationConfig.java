package com.gffny.ldrbrd.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import com.gffny.ldrbrd.Application;

/**
 * 
 * @author John D. Gaffney | gffny.com
 *
 */
@Configuration
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({
		Controller.class, Configuration.class }))
public class ApplicationConfig {

	/**
	 * 
	 * @return
	 */
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		Resource[] resourceArray = new Resource[2];
		resourceArray[0] = new ClassPathResource("/config/application.properties");
		resourceArray[1] = new ClassPathResource("/override.properties");
		ppc.setLocations(resourceArray);
		return ppc;
	}

}