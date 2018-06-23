package com.lyjsh.base.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author wl
 * @Date 2018/6/23 11:57
 * @Todo 系统第三方登录帐号
 */

@Data
public class SysUserOtheraccount {

    private Long id;

    private int accountType;

    private String account;

    private Timestamp createTime;

    private Timestamp updateTime;

}
