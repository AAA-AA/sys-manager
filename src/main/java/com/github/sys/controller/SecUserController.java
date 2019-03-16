package com.github.sys.controller;

import com.github.sys.domain.UserUpdate;
import com.github.sys.domain.UserAdd;
import com.github.sys.domain.UserQuery;
import com.github.sys.domain.UserVo;
import com.github.sys.domain.common.PageResp;
import com.github.sys.service.SecUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by renhongqiang on 2019-03-16 21:07
 */
@RestController
@RequestMapping(value = { "/security/user" })
@Slf4j
public class SecUserController {

    @Autowired
    private SecUserService userService;


    @PostMapping(value = "/add")
    public ResponseEntity addUser(@Valid @RequestBody UserAdd userAdd) {
        userService.addUser(userAdd);
        return ResponseEntity.ok(null);
    }



    @PostMapping(value = "/list")
    public ResponseEntity list(@RequestBody UserQuery userQuery) {
        PageResp<UserVo> page =  userService.list(userQuery);
        return ResponseEntity.ok(page);
    }

    @PostMapping(value = "/update")
    public ResponseEntity update(@Valid @RequestBody UserUpdate update) {
        userService.update(update);
        return ResponseEntity.ok(null);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity delete(Integer userId) {
        userService.delete(userId);
        return ResponseEntity.ok(null);
    }

}
