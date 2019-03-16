package com.github.sys.service;

import com.github.sys.domain.UserAdd;
import com.github.sys.domain.UserQuery;
import com.github.sys.domain.UserUpdate;
import com.github.sys.domain.UserVo;
import com.github.sys.domain.common.PageResp;
import org.springframework.context.annotation.Primary;

/**
 * Created by renhongqiang on 2019-03-16 21:08
 */
public interface SecUserService {

    /**
     * 新增用户
     * @param userAdd
     */
    void addUser(UserAdd userAdd);

    PageResp<UserVo> list(UserQuery userQuery);

    void update(UserUpdate update);

    void delete(Integer userId);
}
