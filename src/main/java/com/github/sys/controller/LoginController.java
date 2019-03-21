package com.github.sys.controller;

import com.github.sys.domain.user.LoginUserVo;
import com.github.sys.domain.common.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renhongqiang on 2019-03-16 22:00
 */
@RestController
@RequestMapping(value = { "/security" })
public class LoginController {

    @PostMapping(value = "/login")
    public ResponseDto login() {
        LoginUserVo loginUserVo = new LoginUserVo();
        loginUserVo.setUsername("admin");
        loginUserVo.setPassword("123456");
        loginUserVo.setName("renhongqiang");
        return ResponseDto.ok(loginUserVo);
    }



}
