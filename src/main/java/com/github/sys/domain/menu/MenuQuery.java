package com.github.sys.domain.menu;

import com.github.sys.domain.common.BasePageQuery;
import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-22 21:38
 */
@Data
public class MenuQuery extends BasePageQuery {
    /**菜单名称*/
    private String name;

    /**菜单URL*/
    private String url;

    /**类型   0：目录   1：菜单   2：按钮*/
    private Integer type;
}
