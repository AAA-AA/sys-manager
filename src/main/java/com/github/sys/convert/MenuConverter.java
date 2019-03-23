package com.github.sys.convert;

import com.github.sys.domain.menu.MenuAdd;
import com.github.sys.domain.menu.MenuUpdate;
import com.github.sys.domain.menu.MenuVo;
import com.github.sys.model.SecMenu;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-22 16:39
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    SecMenu fromAdd(MenuAdd add);

    MenuVo toVo(SecMenu menu);

    List<MenuVo> toVo(List<SecMenu> menus);

    SecMenu fromUpdate(MenuUpdate update);

}
