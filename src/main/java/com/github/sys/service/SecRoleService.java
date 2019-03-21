package com.github.sys.service;

import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.role.RoleAdd;
import com.github.sys.domain.role.RoleQuery;
import com.github.sys.domain.role.RoleUpdate;
import com.github.sys.domain.role.RoleVo;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-19 20:30
 */
public interface SecRoleService {
    void addRole(RoleAdd roleAdd);

    List<RoleVo> getAll();

    PageResp<RoleVo> list(RoleQuery userQuery);

    void update(RoleUpdate update);

    void delete(Integer id);
}
