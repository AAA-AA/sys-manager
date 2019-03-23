package com.github.sys.model;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * link table is sec_menu
 * Copyright © 2019, github and/or its affiliates. All rights reserved.
 **/
@Data
public class SecMenu {
    private Integer id;

    /**父菜单ID，一级菜单为0*/
    private Integer parentId;

    /**菜单名称*/
    private String name;

    /**菜单URL*/
    private String url;

    /**类型   0：目录   1：菜单   2：按钮*/
    private Integer type;

    /**菜单图标*/
    private String icon;

    /**备注*/
    private String mark;

    /**创建时间*/
    private LocalDateTime createTime;

    /**更新时间*/
    private LocalDateTime updateTime;
}