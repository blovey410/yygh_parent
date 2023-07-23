package com.common.exception;

import com.common.response.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 12444
 * @version v1.0
 * @description 全局异常处理
 * @since 2023/7/22 12:07
 */
@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(SytException.class)
	public Result<?> error(SytException e) {
		e.printStackTrace();
		return Result.fail(e.getMsg());
	}



}
