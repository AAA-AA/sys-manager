package com.github.sys.dao;

import com.github.sys.model.SecRoleUser;
import com.github.sys.model.SecRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecRoleUserMapper {
    long countByExample(SecRoleUserExample example);

    int deleteByExample(SecRoleUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRoleUser record);

    int insertSelective(SecRoleUser record);

    List<SecRoleUser> selectByExample(SecRoleUserExample example);

    SecRoleUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRoleUser record, @Param("example") SecRoleUserExample example);

    int updateByExample(@Param("record") SecRoleUser record, @Param("example") SecRoleUserExample example);

    int updateByPrimaryKeySelective(SecRoleUser record);

    int updateByPrimaryKey(SecRoleUser record);

    /** need allowMultiQueries=true support */
    int insertList(List<SecRoleUser> records);

    /** need allowMultiQueries=true support */
    int insertListSelective(List<SecRoleUser> records);
}