package com.lyjsh.base.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author wl
 * @Date 2018/6/23 11:52
 * @Todo 系统用户对象
 */
@Data
public class SysUser {

    private Long id;

    private String userName;

    private String account;

    private String pwd;

    private Timestamp createTime;

    private Timestamp updateTime;
}
