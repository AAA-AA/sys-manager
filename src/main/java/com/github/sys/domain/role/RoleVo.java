package com.github.sys.domain.role;

import com.github.sys.domain.common.BaseVo;
import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-19 20:36
 */
@Data
public class RoleVo  extends BaseVo {

    private Integer id;

    /**角色名*/
    private String name;

    /**角色key*/
    private String roleKey;

    /**角色描述*/
    private String mark;

    /**状态*/
    private Integer status;
}
