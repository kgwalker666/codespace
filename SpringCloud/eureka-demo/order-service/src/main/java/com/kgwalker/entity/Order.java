package com.kgwalker.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (Order)表实体类
 *
 * @author makejava
 * @since 2022-10-08 17:38:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    //订单id
    private Long id;
    //用户id
    private Long userId;
    //商品名称
    private String name;
    //商品价格
    private Long price;
    //商品数量
    private Integer num;

    // 用户详细信息
    @TableField(exist = false)
    private User user;
}
