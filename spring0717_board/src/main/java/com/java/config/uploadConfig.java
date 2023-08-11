//파일 업로드 할때 있어야함

package com.java.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //WebMvcConfigurer 구현해야 함.
public class uploadConfig implements WebMvcConfigurer {
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("upload/**")
		.addResourceLocations("file:///c:/upload/");
	}

}
