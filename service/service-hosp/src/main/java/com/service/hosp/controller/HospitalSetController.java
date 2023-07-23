package com.service.hosp.controller;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.model.yygh.model.hosp.HospitalSet;
import com.model.yygh.vo.hosp.HospitalSetQueryVo;
import com.service.common.utils.MD5;
import com.service.hosp.service.HospitalSetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/20 20:24
 */
@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@RequiredArgsConstructor
@Tag(name = "医院设置管理")
public class HospitalSetController {

	private final HospitalSetService hospitalSetService;

	@PostMapping("/findAll")
	@Operation(summary = "获取所有医院设置")
	public IPage<HospitalSet> getAll(@RequestBody HospitalSetQueryVo hospitalSetQueryVo) {
		return hospitalSetService.getPage(hospitalSetQueryVo);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "删除医院设置")
	public void delete(@PathVariable Long id) {
		hospitalSetService.removeById(id);
	}


	@PostMapping("/save")
	@Operation(summary = "添加医院设置")
	public void save(@RequestBody HospitalSet hospitalSet) {
		// 设置状态
		hospitalSet.setStatus(1);
		// 签名密钥
		hospitalSet.setSignKey(MD5.encrypt("" + System.currentTimeMillis() + RandomUtil.randomInt(1000)));
		hospitalSetService.save(hospitalSet);
	}


	@PutMapping("/update")
	@Operation(summary = "修改医院设置")
	public void updateById(@RequestBody HospitalSet hospitalSet) {
		hospitalSetService.updateById(hospitalSet);
	}

	@GetMapping("/get/{id}")
	@Operation(summary = "根据id获取医院设置")
	public HospitalSet getById(@PathVariable Long id) {
		return hospitalSetService.getById(id);
	}

	@DeleteMapping("/batchRemove")
	@Operation(summary = "批量删除医院设置")
	public void batchRemove(@RequestBody List<Long> idList) {
		hospitalSetService.removeByIds(idList);
	}

	@PutMapping("/lock/{id}/{status}")
	@Operation(summary = "锁定和解锁医院设置")
	public void lock(@PathVariable Long id, @PathVariable Integer status) {
		hospitalSetService.lock(id, status);
	}

	@PutMapping("/send/{id}")
	@Operation(summary = "发送签名密钥")
	public void send(@PathVariable Long id) {
		hospitalSetService.send(id);
	}
}
