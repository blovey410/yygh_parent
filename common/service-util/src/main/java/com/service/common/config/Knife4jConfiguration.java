package com.service.common.config;

import cn.hutool.core.util.RandomUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/21 11:20
 */
@Configuration
public class Knife4jConfiguration {

	@Bean
	public GlobalOpenApiCustomizer openApiCustomizer() {
		return openApi -> {
			if (openApi.getTags() != null) {
				openApi.getTags().forEach(tag -> {
					Map<String, Object> map = new HashMap<>();
					map.put("x-order", RandomUtil.randomInt(0, 100));
					tag.setExtensions(map);
				});
			}
			if (openApi.getPaths() != null) {
				openApi.addExtension("yeb", "1234");
				openApi.getPaths().addExtension("x-yeb", RandomUtil.randomInt(0, 100));
			}
		};
	}


	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("尚医通")
						.version("1.0").description("尚医通接口文档")
						.termsOfService("http://127.0.0.1:8081/doc.html")
						.license(new License().name("Apache 2.0")
								.url("http://127.0.0.1:8081/doc.html")
						)
				).info(new Info().title("尚医通")
						.version("1.0").description("尚医通接口文档")
						.termsOfService("http://127.0.0.1:8082/doc.html")
						.license(new License().name("Apache 2.0")
								.url("http://127.0.0.1:8082/doc.html")
						)
				);
	}

	@Bean
	public GroupedOpenApi groupedOpenApi() {
		return GroupedOpenApi.builder().group("default")
				.addOpenApiMethodFilter(it -> it.getAnnotation(Operation.class) != null).build();
	}
}
