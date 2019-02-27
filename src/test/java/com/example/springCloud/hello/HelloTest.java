package com.example.springCloud.hello;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.print.attribute.standard.Media;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/** 
* @author yj 
* @date 2019-02-27 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloTest {
	
	/**
	 * MockMvc对象：用于模拟调用controller的接口发起请求，在@Test定义的hello测试用例中，perform函数
	 * 执行一次请求调用，accept用于执行接收的数据类型，andExcept用于判断接口返回的期望值
	 */
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	
	@Test
	public void hello() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("hello spring cloud")));
	}

}
