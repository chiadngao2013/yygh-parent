package com.atguigu.yygh.msm.service;

import com.atguigu.yygh.vo.msm.MsmVo;

import javax.xml.transform.Result;

public interface MsmService {

    //发送手机验证码
    boolean send(String phone, String code);

//    //mq使用发送短信
//    boolean send(MsmVo msmVo);
}
