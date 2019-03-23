package com.github.sys.dao.ext;

import com.github.sys.model.SecRole;

/**
 * Created by renhongqiang on 2019-03-21 18:13
 */
public interface ExtSecRoleMapper {
    int saveSelective(SecRole record);
}
