package com.model.yygh.vo.order;


import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@Schema(description = "OrderCountQueryVo")
public class OrderCountQueryVo {

	@Schema(description = "医院编号")
	private String hoscode;

	@Schema(description = "医院名称")
	private String hosname;

	@Schema(description = "安排日期")
	private String reserveDateBegin;
	private String reserveDateEnd;

}

