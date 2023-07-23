package com.service.cmn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.common.exception.SytException;
import com.model.yygh.vo.cmn.DictEeVo;
import com.service.cmn.listener.EasyExcelListener;
import com.service.cmn.mapper.DictMapper;
import com.model.yygh.model.cmn.Dict;
import com.service.cmn.service.DictService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 组织架构表(Dict)表服务实现类
 *
 * @author makejava
 * @since 2023-07-22 17:47:21
 */
@Service("dictService")
@RequiredArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

	private final EasyExcelListener easyExcelListener;


	@Override
	public List<Dict> findChildernData(Long id) {
		QueryWrapper<Dict> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id", id);
		List<Dict> dicts = baseMapper.selectList(wrapper);
		for (Dict dict : dicts) {
			Long dictId = dict.getId();
			boolean isChild = this.isChildren(dictId);
			dict.setHasChildren(isChild);
		}
		return dicts;
	}

	@Override
	public void exportData(HttpServletResponse response) {
		try {
			// 设置下载信息
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-disposition", "attachment;filename=dict.xls");
			List<Dict> list = this.list();
			List<DictEeVo> dictEeVos = BeanUtil.copyToList(list, DictEeVo.class);
			EasyExcel.write(response.getOutputStream(), Dict.class).sheet("dict").doWrite(dictEeVos);
		} catch (IOException e) {
			throw new SytException(500, e.getMessage());
		}
	}

	@Override
	public void importData(MultipartFile file) {
		try {
			EasyExcel.read(file.getInputStream(), DictEeVo.class, easyExcelListener).sheet().doRead();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Dict> getParentData() {
		return this.lambdaQuery().eq(Dict::getParentId, 1).list();
	}

	//判断id下面是否有子节点
	private boolean isChildren(Long id) {
		QueryWrapper<Dict> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id", id);
		Long count = baseMapper.selectCount(wrapper);
		return count > 0;
	}

//    @Override
//    public List<Dict> findChildernData(Long id) {
//        return this.lambdaQuery().eq(Dict::getParentId, id).list()
//                .stream().peek(dict -> {
//                    boolean hasChildren = this.lambdaQuery().eq(Dict::getParentId, dict.getId()).count() > 0;
//                    dict.setHasChildren(hasChildren);
//                }).toList();
//    }
}

