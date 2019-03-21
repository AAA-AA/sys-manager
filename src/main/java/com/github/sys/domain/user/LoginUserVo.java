package com.github.sys.domain.user;

import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-16 22:03
 */
@Data
public class LoginUserVo {
    private String username;
    private String password;
    private String name;
    private Integer id;
}
