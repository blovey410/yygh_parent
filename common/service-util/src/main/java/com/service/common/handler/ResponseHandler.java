package com.service.common.handler;

import com.common.response.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/21 19:50
 */
@ControllerAdvice(basePackages = "com.service.**.controller")
public class ResponseHandler implements ResponseBodyAdvice<Object> {

	@Resource
	private ObjectMapper objectMapper;

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@SneakyThrows
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if ((body instanceof String) && !MediaType.APPLICATION_XML_VALUE.equals(selectedContentType.toString())) {
			response.getHeaders().set("Content-Type", "application/json");
			return objectMapper.writeValueAsString(Result.ok(body));
		}

		if (Objects.isNull(body) && MediaType.TEXT_HTML_VALUE.equals(selectedContentType.toString())) {
			response.getHeaders().set("Content-Type", "application/json");
			return objectMapper.writeValueAsString(Result.ok(body));
		}
		return objectMapper.writeValueAsString(Result.ok(body));
	}
}
