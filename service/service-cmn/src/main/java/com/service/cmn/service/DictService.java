package com.service.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.model.yygh.model.cmn.Dict;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 组织架构表(Dict)表服务接口
 *
 * @author makejava
 * @since 2023-07-22 17:47:17
 */
public interface DictService extends IService<Dict> {

    List<Dict> findChildernData(Long id);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);

    List<Dict> getParentData();
}

