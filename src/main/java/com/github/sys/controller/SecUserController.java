package com.github.sys.controller;

import com.github.sys.domain.user.UserAdd;
import com.github.sys.domain.user.UserQuery;
import com.github.sys.domain.user.UserUpdate;
import com.github.sys.domain.user.UserVo;
import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.common.ResponseDto;
import com.github.sys.service.SecUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-16 21:07
 */
@RestController
@RequestMapping(value = {"/security/user"})
@Slf4j
public class SecUserController {

    @Autowired
    private SecUserService userService;


    @PostMapping(value = "/add")
    public ResponseDto addUser(@Valid @RequestBody UserAdd userAdd) {
        userService.addUser(userAdd);
        return ResponseDto.ok(null);
    }

    @GetMapping(value = "/getAll")
    public ResponseDto getAll() {
        List<UserVo> userVos = userService.getAll();
        return ResponseDto.ok(userVos);
    }

    @PostMapping(value = "/list")
    public ResponseDto list(@RequestBody UserQuery userQuery) {
        PageResp<UserVo> page = userService.list(userQuery);
        return ResponseDto.ok(page);
    }

    @PostMapping(value = "/update")
    public ResponseDto update(@Valid @RequestBody UserUpdate update) {
        userService.update(update);
        return ResponseDto.ok(null);
    }

    @GetMapping(value = "/delete")
    public ResponseDto delete(Integer userId) {
        userService.delete(userId);
        return ResponseDto.ok(null);
    }

}
