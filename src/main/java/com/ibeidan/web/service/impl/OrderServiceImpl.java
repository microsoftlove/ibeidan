package com.ibeidan.web.service.impl;

import com.ibeidan.web.model.Order;
import com.ibeidan.web.service.OrderService;

/**
 * @author lee
 * @DATE 2019/5/20 10:54
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public void queryOrderById(Long orderId) {
        System.out.println("我是OrderServiceImpl----queryOrderById方法"+orderId);
    }
    @Override
    public void queryOrderById2(Long orderId) {
        System.out.println("我是OrderServiceImpl2----queryOrderById方法"+orderId);
    }

   /* @Override
    public Order getOrder(Long orderId) {
        System.out.println("getOrder----查询数据库开始"+orderId);
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderNumber("DD290883-001");
        return order;
    }*/
}
