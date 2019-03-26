package com.github.sys.service;

import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.menu.*;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-22 16:37
 */
public interface SecMenuService {

    void add(MenuAdd add);

    PageResp<MenuVo> list(MenuQuery query);

    void update(MenuUpdate update);

    void delete(Integer id);

    List<MenuTree> selectMenuTree(Integer parentId);
}
