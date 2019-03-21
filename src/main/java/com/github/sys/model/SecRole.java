package com.github.sys.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * link table is sec_role
 * Copyright © 2019, github and/or its affiliates. All rights reserved.
 **/
@Data
public class SecRole {
    private Integer id;

    /**角色名*/
    private String name;

    /**角色描述*/
    private String desc;

    /**状态*/
    private Integer status;

    /**创建时间*/
    private LocalDateTime createTime;

    /**更新时间*/
    private LocalDateTime updateTime;
}