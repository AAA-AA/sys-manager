package com.github.sys.convert;

import com.github.sys.domain.role.RoleAdd;
import com.github.sys.model.SecRole;
import org.mapstruct.Mapper;

/**
 * Created by renhongqiang on 2019-03-21 15:43
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    SecRole fromAdd(RoleAdd roleAdd);
}
