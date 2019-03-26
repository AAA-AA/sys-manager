package com.github.sys.domain.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-25 19:57
 */
@Data
public class MenuTree {

    private Integer id;

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

    /** 页面显示的树结构 */
    private List<MenuTree> children = new ArrayList<>();

    /** 是否有子节点 */
    private Boolean rootFlag = false;
}
