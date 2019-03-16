package com.github.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sys.convert.UserConverter;
import com.github.sys.dao.SecUserMapper;
import com.github.sys.domain.UserAdd;
import com.github.sys.domain.UserQuery;
import com.github.sys.domain.UserUpdate;
import com.github.sys.domain.UserVo;
import com.github.sys.domain.common.PageResp;
import com.github.sys.model.SecUser;
import com.github.sys.model.SecUserExample;
import com.github.sys.service.SecUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-16 21:15
 */
@Service
@Primary
@Slf4j
public class SecUserServiceImpl implements SecUserService {

    @Autowired
    private SecUserMapper secUserMapper;

    @Autowired
    private UserConverter userConverter;

    @Override
    public void addUser(UserAdd userAdd) {
        SecUser secUser = new SecUser();
        BeanUtils.copyProperties(userAdd, secUser);
        secUser.setBirth(LocalDateTime.parse(userAdd.getBirthDay(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        secUserMapper.insertSelective(secUser);
    }

    @Override
    public PageResp<UserVo> list(UserQuery userQuery) {
        SecUserExample example = buildQuery(userQuery);
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize(), true);
        List<SecUser> secUsers = secUserMapper.selectByExample(example);
        Page<SecUser> page = (Page<SecUser>) secUsers;
        return new PageResp<>(page.getPageSize(), page.getPageNum(), page.getTotal(), userConverter.toVo(secUsers));
    }

    @Override
    public void update(UserUpdate update) {
        SecUser secUser = userConverter.fromUpdate(update);
        secUserMapper.updateByPrimaryKeySelective(secUser);
    }

    @Override
    public void delete(Integer userId) {
        secUserMapper.deleteByPrimaryKey(userId);
    }

    private SecUserExample buildQuery(UserQuery userQuery) {
        SecUserExample example = new SecUserExample();
        SecUserExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(userQuery.getName() + "%");
        return example;
    }
}
