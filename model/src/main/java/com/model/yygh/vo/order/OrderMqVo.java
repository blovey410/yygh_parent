package com.model.yygh.vo.order;

import com.model.yygh.vo.msm.MsmVo;

import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "OrderMqVo")
public class OrderMqVo {

	@Schema(description = "可预约数")
	private Integer reservedNumber;

	@Schema(description = "剩余预约数")
	private Integer availableNumber;

	@Schema(description = "排班id")
	private String scheduleId;

	@Schema(description = "短信实体")
	private MsmVo msmVo;

}

