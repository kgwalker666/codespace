package com.kgwalker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kgwalker.entity.User;
import com.kgwalker.mapper.OrderMapper;
import com.kgwalker.entity.Order;
import com.kgwalker.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-10-08 17:38:34
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Order getOrderAndUserById(Long id) {
        Order order = this.getById(id);
        Long userId = order.getUserId();
        User user = this.restTemplate.getForObject("http://localhost:9000/user/{userId}", User.class, Map.of("userId", userId));
        order.setUser(user);
        return order;
    }
}

