package com.service.hosp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.model.yygh.model.hosp.HospitalSet;
import com.model.yygh.vo.hosp.HospitalSetQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 12444
 * @version v1.0
 * @description
 * @since 2023/7/20 20:22
 */

public interface HospitalSetService extends IService<HospitalSet> {
    IPage<HospitalSet> getPage(HospitalSetQueryVo hospitalSetQueryVo);

    void lock(Long id, Integer status);

    void send(Long id);
}
