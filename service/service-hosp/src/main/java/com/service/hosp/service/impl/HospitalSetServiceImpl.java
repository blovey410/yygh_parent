package com.service.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.model.yygh.model.hosp.HospitalSet;
import com.model.yygh.vo.hosp.HospitalSetQueryVo;
import com.service.hosp.mapper.HospitalSetMapper;
import com.service.hosp.service.HospitalSetService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/20 20:23
 */
@Service
public class HospitalSetServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {
    @Override
    public IPage<HospitalSet> getPage(HospitalSetQueryVo hospitalSetQueryVo) {
        Page<HospitalSet> page = new Page<>(hospitalSetQueryVo.getPageNum(), hospitalSetQueryVo.getPageSize());
        LambdaQueryWrapper<HospitalSet> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(!ObjectUtils.isEmpty(hospitalSetQueryVo.getHoscode()), HospitalSet::getHoscode, hospitalSetQueryVo.getHoscode())
                .eq(!ObjectUtils.isEmpty(hospitalSetQueryVo.getHosname()), HospitalSet::getHosname, hospitalSetQueryVo.getHosname());
        return this.baseMapper.selectPage(page, wrapper);
    }

	@Override
	public void lock(Long id, Integer status) {
		boolean update = this.lambdaUpdate().eq(HospitalSet::getId, id).set(HospitalSet::getStatus, status).update();
		if (update) throw new RuntimeException("修改失败");
	}

	@Override
	public void send(Long id) {
		HospitalSet hospitalSet = this.lambdaQuery().eq(HospitalSet::getId, id).one();
		String hoscode = hospitalSet.getHoscode();
		String signKey = hospitalSet.getSignKey();
		// TODO 发送短信
	}
}
