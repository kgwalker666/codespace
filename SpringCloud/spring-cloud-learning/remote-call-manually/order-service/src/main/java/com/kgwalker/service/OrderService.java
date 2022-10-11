package com.kgwalker.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kgwalker.entity.Order;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-10-08 17:38:34
 */
public interface OrderService extends IService<Order> {

    Order getOrderAndUserById(Long id);
}

