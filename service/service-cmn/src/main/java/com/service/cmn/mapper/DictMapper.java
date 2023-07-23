package com.service.cmn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.model.yygh.model.cmn.Dict;
import org.apache.ibatis.annotations.Mapper;

/**
 * 组织架构表(Dict)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-22 17:49:03
 */
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

}

