package com.example.springCloud.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
* @author yj 
* @date 2019-02-27 
*/
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		return "hello spring cloud";
	}
}
