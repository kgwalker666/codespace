package com.kgwalker.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kgwalker.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-08 17:15:50
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

