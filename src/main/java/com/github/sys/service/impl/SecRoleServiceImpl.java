package com.github.sys.service.impl;

import com.github.sys.convert.RoleConverter;
import com.github.sys.dao.SecRoleMapper;
import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.role.RoleAdd;
import com.github.sys.domain.role.RoleQuery;
import com.github.sys.domain.role.RoleUpdate;
import com.github.sys.domain.role.RoleVo;
import com.github.sys.model.SecRole;
import com.github.sys.service.SecRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-19 20:38
 */
@Slf4j
@Service
public class SecRoleServiceImpl implements SecRoleService {

    @Autowired
    private SecRoleMapper roleMapper;

    @Autowired
    private RoleConverter converter;

    @Override
    public void addRole(RoleAdd roleAdd) {
        SecRole secRole = converter.fromAdd(roleAdd);
        roleMapper.insertSelective(secRole);
    }


    @Override
    public List<RoleVo> getAll() {
        return null;
    }

    @Override
    public PageResp<RoleVo> list(RoleQuery userQuery) {
        return null;
    }

    @Override
    public void update(RoleUpdate update) {

    }

    @Override
    public void delete(Integer id) {

    }
}
