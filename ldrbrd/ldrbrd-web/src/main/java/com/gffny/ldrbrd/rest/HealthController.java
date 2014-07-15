/**
 * 
 */
package com.gffny.ldrbrd.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gffny.ldrbrd.util.Constant;

/**
 * @author John D. Gaffney | gffny.com
 *
 */
@RestController
public class HealthController {

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/sayhello")
	public String sayHello() {
		return Constant.HELLO;
	}
}
