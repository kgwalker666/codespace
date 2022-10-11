package com.kgwalker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kgwalker.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * (Order)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-08 17:38:34
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
