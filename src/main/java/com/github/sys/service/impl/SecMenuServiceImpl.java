package com.github.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sys.convert.MenuConverter;
import com.github.sys.dao.SecMenuMapper;
import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.menu.MenuAdd;
import com.github.sys.domain.menu.MenuQuery;
import com.github.sys.domain.menu.MenuUpdate;
import com.github.sys.domain.menu.MenuVo;
import com.github.sys.model.SecMenu;
import com.github.sys.model.SecMenuExample;
import com.github.sys.service.SecMenuService;
import com.github.sys.utils.QueryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-22 16:37
 */
@Service
@Slf4j
public class SecMenuServiceImpl implements SecMenuService {

    @Autowired
    private MenuConverter converter;

    @Autowired
    private SecMenuMapper menuMapper;


    @Override
    public void add(MenuAdd add) {
        SecMenu menu = converter.fromAdd(add);
        menuMapper.insertSelective(menu);
    }

    @Override
    public PageResp<MenuVo> list(MenuQuery query) {
        SecMenuExample example = buildQuery(query);
        PageHelper.startPage(query.getPageNum(), query.getPageSize(), true);
        List<SecMenu> menus = menuMapper.selectByExample(example);
        Page<SecMenu> page = (Page<SecMenu>) menus;
        return new PageResp<>(page.getPageSize(), page.getPageNum(), page.getTotal(), converter.toVo(menus));
    }

    private SecMenuExample buildQuery(MenuQuery query) {
        SecMenuExample example = new SecMenuExample();
        SecMenuExample.Criteria criteria = example.createCriteria();
        if (query == null) {
            return example;
        }
        if (!StringUtils.isEmpty(query.getName())) {
            criteria.andNameLike(QueryUtils.fullLike(query.getName()));
        }
        if (!StringUtils.isEmpty(query.getUrl())) {
            criteria.andUrlLike(QueryUtils.fullLike(query.getUrl()));
        }
        if (query.getType() != null) {
            criteria.andTypeEqualTo(query.getType());
        }
        //todo 待完善
        if (!StringUtils.isEmpty(query.getOrderColumn())) {
            example.setOrderByClause("update_time desc");
        }
        return example;
    }

    @Override
    public void update(MenuUpdate update) {
        SecMenu menu = converter.fromUpdate(update);
        menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void delete(Integer id) {
        Assert.isTrue(id != null, "id can't be null");
        menuMapper.deleteByPrimaryKey(id);
    }
}
