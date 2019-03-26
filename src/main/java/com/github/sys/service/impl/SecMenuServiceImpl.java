package com.github.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sys.convert.MenuConverter;
import com.github.sys.dao.SecMenuMapper;
import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.menu.*;
import com.github.sys.model.SecMenu;
import com.github.sys.model.SecMenuExample;
import com.github.sys.service.SecMenuService;
import com.github.sys.utils.QueryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by renhongqiang on 2019-03-22 16:37
 */
@Service
@Slf4j
public class SecMenuServiceImpl implements SecMenuService {

    private static final int DEFAULT_ROOT_MENU_ID = 0;

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
        List<MenuVo> menuVos = converter.toVo(menus);
        fillInfo(menuVos);
        return new PageResp<>(page.getPageSize(), page.getPageNum(), page.getTotal(), menuVos);
    }

    private void fillInfo(List<MenuVo> menuVos) {
        if (!CollectionUtils.isEmpty(menuVos)) {
            List<Integer> parentIds = menuVos.stream().map(e -> e.getParentId()).collect(Collectors.toList());
            SecMenuExample example = new SecMenuExample();
            example.createCriteria().andIdIn(parentIds);
            List<SecMenu> parentMenus = menuMapper.selectByExample(example);
            Map<Integer, SecMenu> secMenuMap = parentMenus.stream().collect(Collectors.toMap(e -> e.getId(), SecMenu -> SecMenu));
            menuVos.parallelStream().forEach(e -> {
                SecMenu menu = secMenuMap.get(e.getParentId());
                if (menu != null) {
                    e.setParentMenuName(menu.getName());
                }
            });
        }
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
        example.setOrderByClause("update_time desc");
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

    @Override
    public List<MenuTree> selectMenuTree(Integer parentId) {
        if (parentId == null) {
            parentId = DEFAULT_ROOT_MENU_ID;
        }
        List<MenuTree> list = new ArrayList<>();
        List<SecMenu> menus = findByParentId(parentId);
        if (!CollectionUtils.isEmpty(menus)) {
            List<MenuTree> menuTrees = converter.toTree(menus);
            list.addAll(menuTrees);
            for (MenuTree tree : menuTrees) {
                recursive(tree);
            }
        }
        return list;
    }

    private List<SecMenu> findByParentId(Integer parentId) {
        SecMenuExample example = new SecMenuExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List<SecMenu> menus = menuMapper.selectByExample(example);
        return menus;
    }

    private MenuTree recursive(MenuTree tree) {
        List<SecMenu> menus = findByParentId(tree.getId());
        if (!CollectionUtils.isEmpty(menus)) {
            List<MenuTree> childTrees = converter.toTree(menus);
            tree.setRootFlag(true);
            tree.getChildren().addAll(childTrees);
            for (MenuTree next : childTrees) {
                recursive(next);
            }
        }
        return tree;
    }
}
