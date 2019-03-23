package com.github.sys.service;

import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.menu.MenuAdd;
import com.github.sys.domain.menu.MenuQuery;
import com.github.sys.domain.menu.MenuUpdate;
import com.github.sys.domain.menu.MenuVo;

/**
 * Created by renhongqiang on 2019-03-22 16:37
 */
public interface SecMenuService {

    void add(MenuAdd add);

    PageResp<MenuVo> list(MenuQuery query);

    void update(MenuUpdate update);

    void delete(Integer id);
}
