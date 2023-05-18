package com.strangeye.dubalnebal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	// 스웨거를 위한 Docket 빈을 추가한다.


	@Bean
	public Docket api(){
		final ApiInfo apiInfo = new ApiInfoBuilder().title("두발네발 사용자 관리 API")
				.description()
	}
}
