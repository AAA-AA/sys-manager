package com.github.sys.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * link table is sec_user
 * Copyright © 2019, github and/or its affiliates. All rights reserved.
 **/
@Data
public class SecUser {
    /**主键*/
    private Integer id;

    /**用户名，与dashboard名字一致*/
    private String name;

    /**邮箱*/
    private String mail;

    /**密码*/
    private String password;

    /**男：1 女：0*/
    private Integer sex;

    /**年龄*/
    private Integer age;

    /**年龄*/
    private LocalDateTime birth;

    /**地址*/
    private String address;

    /**状态*/
    private Integer status;

    /**创建时间*/
    private LocalDateTime createTime;

    /**更新时间*/
    private LocalDateTime updateTime;
}