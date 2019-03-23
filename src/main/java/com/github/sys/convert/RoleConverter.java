package com.github.sys.convert;

import com.github.sys.domain.role.RoleAdd;
import com.github.sys.domain.role.RoleUpdate;
import com.github.sys.domain.role.RoleVo;
import com.github.sys.model.SecRole;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-21 15:43
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    SecRole fromAdd(RoleAdd roleAdd);

    List<RoleVo> toVo(List<SecRole> secRoles);

    SecRole fromUpdate(RoleUpdate update);

}
