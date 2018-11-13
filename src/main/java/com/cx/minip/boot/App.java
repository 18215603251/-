package com.cx.minip.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

// 创建容器, 相当于tomcate
@SpringBootApplication
//spring-boot入口类必须实现SpringBootServletInitializer接口的configure方法才能让外部容器运行spring-boot项目
public class App extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(App.class);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);		// 运行此方法, 就相当于启动tomcate
	}
	
}
