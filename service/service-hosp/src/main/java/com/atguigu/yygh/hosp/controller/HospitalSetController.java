package com.atguigu.yygh.hosp.controller;


import com.atguigu.yygh.hosp.mapper.HospitalSetMapper;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")

public class HospitalSetController {
//    注入service
    @Autowired
    private HospitalSetService hospitalSetService;


//    1查询医院设置表的所有信息
    @GetMapping("findAll")
    public List<HospitalSet> findAllHospitalSet(){
//        调用service方法
        List<HospitalSet> list = hospitalSetService.list();
//        返回json数据
        return list;

    }


}
