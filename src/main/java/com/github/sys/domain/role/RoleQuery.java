package com.github.sys.domain.role;

import com.github.sys.domain.common.BasePageQuery;
import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-19 20:35
 */
@Data
public class RoleQuery extends BasePageQuery {
    /**角色名*/
    private String name;

    /**角色key*/
    private String roleKey;
}
