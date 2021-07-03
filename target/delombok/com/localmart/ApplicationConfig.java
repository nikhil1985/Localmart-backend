package com.localmart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableMongoRepositories
@ComponentScan("com")
public class ApplicationConfig  implements WebMvcConfigurer{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	    final ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
	    final List<MediaType> list = new ArrayList<>();
	    list.add(MediaType.IMAGE_JPEG);
	    list.add(MediaType.APPLICATION_OCTET_STREAM);
	    arrayHttpMessageConverter.setSupportedMediaTypes(list);
	    converters.add(arrayHttpMessageConverter);
	}
}
