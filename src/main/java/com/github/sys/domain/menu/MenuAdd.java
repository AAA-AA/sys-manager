package com.github.sys.domain.menu;

import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-22 16:40
 */
@Data
public class MenuAdd {

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
}
