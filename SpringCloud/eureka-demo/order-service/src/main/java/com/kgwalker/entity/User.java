package com.kgwalker.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2022-10-08 17:15:50
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id
    private Long id;
    //收件人
    private String username;
    //地址
    private String address;
}
