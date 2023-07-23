package com.model.yygh.vo.order;


import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "OrderCountVo")
public class OrderCountVo {

	@Schema(description = "安排日期")
	private String reserveDate;

	@Schema(description = "预约单数")
	private Integer count;

}

