package com.lyjsh.base.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author wl
 * @Date 2018/6/23 11:55
 * @Todo 系统用户详细信息
 */

@Data
public class SysUserInfo {

    private Long id;

    private Long userId;

    private String gender;

    private int age;

    private String headPortrait;

    private Timestamp createTime;

    private Timestamp updateTime;
}
