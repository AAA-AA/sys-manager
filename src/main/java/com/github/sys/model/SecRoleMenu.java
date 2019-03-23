package com.github.sys.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * link table is sec_role_menu
 * Copyright © 2019, github and/or its affiliates. All rights reserved.
 **/
@Data
public class SecRoleMenu {
    /**主键*/
    private Integer id;

    /**菜单id*/
    private Integer menuId;

    /**角色id*/
    private Integer roleId;

    /**创建时间*/
    private LocalDateTime createTime;

    /**更新时间*/
    private LocalDateTime updateTime;
}