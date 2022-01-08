package com.atguigu.yygh.hosp.controller;


import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.hosp.mapper.HospitalSetMapper;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.atguigu.yygh.vo.hosp.HospitalSetQueryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")

public class HospitalSetController {
    //    注入service
    @Autowired
    private HospitalSetService hospitalSetService;


    //    1查询医院设置表的所有信息
//    http://localhost:8201/admin/hosp/hospitalSet/findAll
    @GetMapping("/findAll")
    public Result findAllHospitalSet() {
//        调用service方法
        List<HospitalSet> list = hospitalSetService.list();
//        返回json数据
        return Result.ok(list);

    }

    //2逻辑删除医院设置
    @DeleteMapping("{id}")
    public Result removeHospSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        if (flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }

    }

    //    3条件查询带分页,查询医院信息
//    current：当前页。 limit：每页记录数字
    @PostMapping("findPageHospSet/{current}/{limit}")
    public Result findPageHospSet(@PathVariable Long current,
                                  @PathVariable Long limit,
                                  @RequestBody(required = false) HospitalSetQueryVo hospitalSetQueryVo) {
//        创建page对象，传递当前页，每页记录数
        Page<HospitalSet> page = new Page<>(current, limit);

//        构建条件
        QueryWrapper<HospitalSet> wrapper = new QueryWrapper<>();
        String hosname = hospitalSetQueryVo.getHosname();//获取医院编号
        String hoscode = hospitalSetQueryVo.getHoscode();//获取医院名称

//        判断传入的医院名称，或者编号是否为空
        if (!StringUtils.isEmpty(hosname)) {
            wrapper.like("hosname", hospitalSetQueryVo.getHosname());
        }
        if (!StringUtils.isEmpty(hoscode)) {
            wrapper.eq("hoscode", hospitalSetQueryVo.getHoscode());
        }


//        调用方法实现分页查询
        Page<HospitalSet> pageHospitalSet = hospitalSetService.page(page, wrapper);

//        返回结果
        return Result.ok(pageHospitalSet);

    }


//    4.添加医院设置
}
