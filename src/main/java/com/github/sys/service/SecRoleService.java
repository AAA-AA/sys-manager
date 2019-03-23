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

    /**
     * todo 待补充用户校验逻辑
     * 角色不可随意删除，要看角色下是否绑定了用户
     * @param id
     */
    void delete(Integer id);
}
