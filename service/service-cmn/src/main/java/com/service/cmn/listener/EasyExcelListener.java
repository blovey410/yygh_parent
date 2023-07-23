package com.service.cmn.listener;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.model.yygh.model.cmn.Dict;
import com.model.yygh.vo.cmn.DictEeVo;
import com.service.cmn.mapper.DictMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/22 19:13
 */

@Component
public class EasyExcelListener extends AnalysisEventListener<DictEeVo> {


	@Resource
	private DictMapper dictMapper;

	@Override
	public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {
		Dict dict = BeanUtil.copyProperties(dictEeVo, Dict.class);
		dictMapper.insert(dict);
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext analysisContext) {

	}
}
