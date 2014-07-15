/**
 * 
 */
package com.gffny.ldrbrd.config;
import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gffny.ldbrd.config.JpaConfig;

@Order(2)
/**
 * 
 * @author John D. Gaffney | gffny.com
 *
 * 	It is necessary to flag this class as "implements WebApplicationInitializer" even though it
 *  already implements this interface (because one of its superclasses implements the interface).
 *  Why? Because WebLogic has a bug related to the @HandlesTypes annotation where it only finds
 *  classes that implement an an interface or extend a class if they directly implement / extend
 *  (as opposed to doing it through a superclass). See JIRA ticket ACE-33.
 *
 */
public class WebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer implements
		WebApplicationInitializer {

	/**
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationConfig.class, SecurityConfig.class,
				JpaConfig.class};
	}

	/**
	 * 
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfig.class };
	}

	/**
	 * 
	 */
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}

	/**
	 * 
	 */
	@Override
	protected void customizeRegistration(
			ServletRegistration.Dynamic registration) {
		registration.setInitParameter("defaultHtmlEscape", "true");
		registration.setInitParameter("spring.profiles.active", "default");
	}
}