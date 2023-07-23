package com.model.yygh.vo.hosp;

import com.baomidou.mybatisplus.annotation.TableField;

import com.model.yygh.vo.BasePageVo;
import lombok.Data;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class HospitalSetQueryVo extends BasePageVo {

	@Schema(description = "医院名称")
	private String hosname;

	@Schema(description = "医院编号")
	private String hoscode;
}
