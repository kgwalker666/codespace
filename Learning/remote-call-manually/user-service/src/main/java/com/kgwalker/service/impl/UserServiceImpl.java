package com.kgwalker.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kgwalker.mapper.UserMapper;
import com.kgwalker.entity.User;
import com.kgwalker.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-10-08 17:15:50
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
