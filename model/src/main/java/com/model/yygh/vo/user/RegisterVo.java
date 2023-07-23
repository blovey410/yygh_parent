package com.model.yygh.vo.user;


import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "注册对象")
public class RegisterVo {

	@Schema(description = "手机号")
	private String mobile;

	@Schema(description = "密码")
	private String password;

	@Schema(description = "验证码")
	private String code;
}
