package com.lyjsh.base.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author wl
 * @Date 2018/6/23 12:01
 * @Todo 登录日志记录
 */

@Data
public class LoginLog {

    private Long id;

    private Long userId;

    private Timestamp loginEnterTime;

    private Timestamp loginExistTime;

    private int loginWay;

    private String originIp;

}
