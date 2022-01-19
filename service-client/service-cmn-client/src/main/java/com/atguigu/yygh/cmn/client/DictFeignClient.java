package com.atguigu.yygh.cmn.client;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
/**
 * 数据字典API接口
 */
@FeignClient(value = "service-cmn")
@Repository
public interface DictFeignClient {

    /**
     * 获取数据字典名称
     * @param parentDictCode
     * @param value
     * @return
     */
    @GetMapping(value = "/admin/cmn/dict/getName/{dictCode}/{value}")
     public String getName(@PathVariable("dictCode") String parentDictCode, @PathVariable("value") String value);

    /**
     * 获取数据字典名称
     * @param value
     * @return
     */
    @GetMapping(value = "/admin/cmn/dict/getName/{value}")
    public String getName(@PathVariable("value") String value);
}
