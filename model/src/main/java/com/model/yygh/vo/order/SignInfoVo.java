package com.model.yygh.vo.order;


import lombok.Data;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 * HospitalSet
 * </p>
 *
 * @author qy
 */
@Data
@Schema(description = "签名信息")
public class SignInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Schema(description = "api基础路径")
	private String apiUrl;

	@Schema(description = "签名秘钥")
	private String signKey;

}

