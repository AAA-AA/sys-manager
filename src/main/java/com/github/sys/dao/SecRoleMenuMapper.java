package com.github.sys.dao;

import com.github.sys.model.SecRoleMenu;
import com.github.sys.model.SecRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecRoleMenuMapper {
    long countByExample(SecRoleMenuExample example);

    int deleteByExample(SecRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRoleMenu record);

    int insertSelective(SecRoleMenu record);

    List<SecRoleMenu> selectByExample(SecRoleMenuExample example);

    SecRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRoleMenu record, @Param("example") SecRoleMenuExample example);

    int updateByExample(@Param("record") SecRoleMenu record, @Param("example") SecRoleMenuExample example);

    int updateByPrimaryKeySelective(SecRoleMenu record);

    int updateByPrimaryKey(SecRoleMenu record);

    /** need allowMultiQueries=true support */
    int insertList(List<SecRoleMenu> records);

    /** need allowMultiQueries=true support */
    int insertListSelective(List<SecRoleMenu> records);
}