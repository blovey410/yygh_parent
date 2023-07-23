package com.model.yygh.vo.msm;


import lombok.Data;

import java.io.Serializable;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "短信实体")
public class MsmVo {

	@Schema(description = "phone")
	private String phone;

	@Schema(description = "短信模板code")
	private String templateCode;

	@Schema(description = "短信模板参数")
	private Map<String, Object> param;
}
