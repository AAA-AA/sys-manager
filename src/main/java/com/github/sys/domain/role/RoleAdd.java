package com.github.sys.domain.role;

import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-19 20:35
 */
@Data
public class RoleAdd {
    /**角色名*/
    private String name;

    private String roleKey;

    /**角色描述*/
    private String mark;
}
