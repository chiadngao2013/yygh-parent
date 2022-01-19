package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.model.cmn.Dict;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {

   //根据ID查询子数据列表
    List<Dict> findChlidData(Long id);

    void exportDictData(HttpServletResponse response);

    void importDictData(MultipartFile file);
    //根据dictcode和value查询
    String getDictName(String dictCode, String value);
    //根据dictCode获取下级节点
    List<Dict> findByDictCode(String dictCode);
}
