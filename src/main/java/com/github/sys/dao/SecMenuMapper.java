package com.github.sys.dao;

import com.github.sys.model.SecMenu;
import com.github.sys.model.SecMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecMenuMapper {
    long countByExample(SecMenuExample example);

    int deleteByExample(SecMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecMenu record);

    int insertSelective(SecMenu record);

    List<SecMenu> selectByExample(SecMenuExample example);

    SecMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecMenu record, @Param("example") SecMenuExample example);

    int updateByExample(@Param("record") SecMenu record, @Param("example") SecMenuExample example);

    int updateByPrimaryKeySelective(SecMenu record);

    int updateByPrimaryKey(SecMenu record);

    /** need allowMultiQueries=true support */
    int insertList(List<SecMenu> records);

    /** need allowMultiQueries=true support */
    int insertListSelective(List<SecMenu> records);
}