package com.service.cmn.controller;

import com.model.yygh.model.cmn.Dict;
import com.service.cmn.service.DictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * 组织架构表(Dict)表控制层
 *
 * @author makejava
 * @since 2023-07-22 17:47:16
 */
@RestController
@RequestMapping("/admin/dict")
@RequiredArgsConstructor
@Tag(name = "字典管理")
public class DictController {
    /**
     * 服务对象
     */
    private final DictService dictService;

    /**
     * 父级数据
     *
     * @return 父级数据
     */
    @GetMapping
    @Operation(summary = "分页查询所有数据")
    public List<Dict> selectAll() {
        return this.dictService.getParentData();
    }

    /**
     * 根据id获取下级节点
     *
     * @param id id
     * @return 下级节点
     */
    @GetMapping("findChildernData/{id}")
    @Operation(summary = "根据id获取下级节点")
    public List<Dict> findChildernData(@PathVariable Long id) {
        return this.dictService.findChildernData(id);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @Operation(summary = "通过主键查询单条数据")
    public Dict selectOne(@PathVariable Serializable id) {
        return this.dictService.getById(id);
    }

    /**
     * 新增数据
     *
     * @param dict 实体对象
     */
    @PostMapping
    @Operation(summary = "新增数据")
    public void insert(@RequestBody Dict dict) {
        this.dictService.save(dict);
    }

    /**
     * 修改数据
     *
     * @param dict 实体对象
     */
    @PutMapping
    @Operation(summary = "修改数据")
    public void update(@RequestBody Dict dict) {
        this.dictService.updateById(dict);
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     */
    @DeleteMapping
    @Operation(summary = "删除数据")
    public void delete(@RequestParam("idList") List<Long> idList) {
        this.dictService.removeByIds(idList);
    }


    /**
     * 导出数据
     *
     * @param response 响应
     */
    @GetMapping("exportData")
    public void exportData(HttpServletResponse response) {
        dictService.exportData(response);
    }

    /**
     * 导入数据
     *
     * @param file 文件
     */
    @PostMapping("importData")
    public void importData(MultipartFile file) {
        dictService.importData(file);
    }
}

