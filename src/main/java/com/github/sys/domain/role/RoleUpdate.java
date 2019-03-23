package com.github.sys.domain.role;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by renhongqiang on 2019-03-19 20:35
 */
@Data
public class RoleUpdate {

    @NotNull(message = "id不能为空！")
    private Integer id;
    /**角色名*/
    private String name;

    private String roleKey;

    /**角色描述*/
    private String mark;
}
