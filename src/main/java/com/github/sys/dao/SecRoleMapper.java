package com.github.sys.dao;

import com.github.sys.model.SecRole;
import com.github.sys.model.SecRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecRoleMapper {
    long countByExample(SecRoleExample example);

    int deleteByExample(SecRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecRole record);

    int insertSelective(SecRole record);

    List<SecRole> selectByExample(SecRoleExample example);

    SecRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecRole record, @Param("example") SecRoleExample example);

    int updateByExample(@Param("record") SecRole record, @Param("example") SecRoleExample example);

    int updateByPrimaryKeySelective(SecRole record);

    int updateByPrimaryKey(SecRole record);

    /** need allowMultiQueries=true support */
    int insertList(List<SecRole> records);

    /** need allowMultiQueries=true support */
    int insertListSelective(List<SecRole> records);
}