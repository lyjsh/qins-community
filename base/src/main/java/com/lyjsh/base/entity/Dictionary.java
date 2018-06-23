package com.lyjsh.base.entity;

import lombok.Data;

/**
 * @Author wl
 * @Date 2018/6/23 11:59
 * @Todo 数据字典
 */

@Data
public class Dictionary {

    private Long id;

    private String dicName;

    private String description;

    private Long parentId;
}
