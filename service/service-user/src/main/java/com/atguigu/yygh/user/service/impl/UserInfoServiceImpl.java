package com.atguigu.yygh.user.service.impl;

import com.atguigu.yygh.common.exception.YyghException;
import com.atguigu.yygh.common.helper.JwtHelper;
import com.atguigu.yygh.common.result.ResultCodeEnum;
import com.atguigu.yygh.model.user.UserInfo;
import com.atguigu.yygh.user.mapper.UserInfoMapper;
import com.atguigu.yygh.user.service.UserInfoService;
import com.atguigu.yygh.vo.user.LoginVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.type.TypeException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl extends
        ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    //用户手机号登录
    @Override
    public Map<String, Object> loginUser(LoginVo loginVo) {
        //1从loginvo获取输入手机号，和验证码
        String phone = loginVo.getPhone();
        String code = loginVo.getCode();

        //2判断手机号和验证码是否为空
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(code) ){
            throw new YyghException(ResultCodeEnum.PARAM_ERROR);
        }
        //todo 3判断手机验证码和输入的验证码是否一致


        //判断是否第一次登录：根据手机号查询数据库，如果不存在相同手机号就是第一次登录
        QueryWrapper<UserInfo> wrapper = new QueryWrapper();
        wrapper.eq("phone",phone);
        UserInfo userInfo = baseMapper.selectOne(wrapper);
        if(userInfo == null){//判断，如果为空。则表明是第一次登录
            //将信息添加到数据库
            userInfo = new UserInfo();
            userInfo.setName("");
            userInfo.setPhone(phone);
            userInfo.setStatus(1);//1表示可用
            this.save(userInfo);

            baseMapper.insert(userInfo);
        }
        //校验是否被禁用
        if(userInfo.getStatus() == 0) {
            throw new YyghException(ResultCodeEnum.LOGIN_DISABLED_ERROR);
        }

        //不是第一次，直接登录

        //返回登录信息
        //返回登录用户名
        //返回token信息
        //返回页面显示名称
        Map<String, Object> map = new HashMap<>();
        String name = userInfo.getName();
        if(StringUtils.isEmpty(name)) {
            name = userInfo.getNickName();
        }
        if(StringUtils.isEmpty(name)) {
            name = userInfo.getPhone();
        }
        map.put("name", name);

        // 调用 jwt，token生成
        String token = JwtHelper.createToken(userInfo.getId(), name);
        map.put("token", token);

        return map;
    }
}
