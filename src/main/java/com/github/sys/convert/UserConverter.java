package com.github.sys.convert;

import com.github.sys.domain.user.UserAdd;
import com.github.sys.domain.user.UserUpdate;
import com.github.sys.domain.user.UserVo;
import com.github.sys.model.SecUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-16 21:30
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    List<UserVo> toVo(List<SecUser> userList);

    SecUser fromAdd(UserAdd userAdd);

    SecUser fromUpdate(UserUpdate update);

    UserVo toVo(SecUser user);
}
