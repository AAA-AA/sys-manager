package com.github.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sys.convert.RoleConverter;
import com.github.sys.dao.SecRoleMapper;
import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.role.RoleAdd;
import com.github.sys.domain.role.RoleQuery;
import com.github.sys.domain.role.RoleUpdate;
import com.github.sys.domain.role.RoleVo;
import com.github.sys.exception.ServiceException;
import com.github.sys.model.SecRole;
import com.github.sys.model.SecRoleExample;
import com.github.sys.model.SecUser;
import com.github.sys.model.SecUserExample;
import com.github.sys.service.SecRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.github.sys.exception.ResponseCode.ROLE_NOT_FOUND;

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
        SecRoleExample example = new SecRoleExample();
        return converter.toVo(roleMapper.selectByExample(example));
    }

    @Override
    public PageResp<RoleVo> list(RoleQuery query) {
        SecRoleExample example = buildQuery(query);
        PageHelper.startPage(query.getPageNum(), query.getPageSize(), true);
        List<SecRole> secRoles = roleMapper.selectByExample(example);
        Page<SecRole> page = (Page<SecRole>) secRoles;
        return new PageResp<>(page.getPageSize(), page.getPageNum(), page.getTotal(), converter.toVo(secRoles));
    }

    private SecRoleExample buildQuery(RoleQuery query) {
        SecRoleExample roleExample = new SecRoleExample();
        SecRoleExample.Criteria criteria = roleExample.createCriteria();
        if (!StringUtils.isEmpty(query.getRoleKey())) {
            criteria.andRoleKeyEqualTo(query.getRoleKey());
        }
        if (!StringUtils.isEmpty(query.getName())) {
            criteria.andNameEqualTo(query.getName());
        }
        roleExample.setOrderByClause(" update_time desc");
        return roleExample;
    }

    @Override
    public void update(RoleUpdate update) {
        SecRole secRole = converter.fromUpdate(update);
        roleMapper.updateByPrimaryKeySelective(secRole);
    }

    @Override
    public void delete(Integer id) {
        SecRole secRole = roleMapper.selectByPrimaryKey(id);
        if (secRole == null) {
            throw new ServiceException(ROLE_NOT_FOUND);
        }
        log.info("delete role {}",secRole);
        roleMapper.deleteByPrimaryKey(id);
    }
}
