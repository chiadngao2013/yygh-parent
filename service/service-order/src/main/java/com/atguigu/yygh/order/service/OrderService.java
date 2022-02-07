package com.atguigu.yygh.order.service;

import com.atguigu.yygh.model.order.OrderInfo;
import com.atguigu.yygh.vo.order.OrderCountQueryVo;
import com.atguigu.yygh.vo.order.OrderQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

public interface OrderService extends IService<OrderInfo> {
    //保存订单
    Long saveOrder(String scheduleId, Long patientId);
    //根据订单ID查询订单详情
    OrderInfo getOrder(String orderId);
    //订单列表（条件查询带分页）
    IPage<OrderInfo> selectPage(Page<OrderInfo> pageParam, OrderQueryVo orderQueryVo);
    /**
     * 取消订单
     * @param orderId
     */
    Boolean cancelOrder(Long orderId);

    /**
     * 订单统计
     */
    Map<String, Object> getCountMap(OrderCountQueryVo orderCountQueryVo);

}

