package com.github.sys.controller;

import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.common.ResponseDto;
import com.github.sys.domain.role.RoleAdd;
import com.github.sys.domain.role.RoleQuery;
import com.github.sys.domain.role.RoleUpdate;
import com.github.sys.domain.role.RoleVo;
import com.github.sys.service.SecRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by renhongqiang on 2019-03-19 20:30
 */
@RestController
@RequestMapping(value = {"/security/role"})
@Slf4j
public class SecRoleController {

    @Autowired
    private SecRoleService roleService;

    @PostMapping(value = "/add")
    public ResponseDto addRole(@Valid @RequestBody RoleAdd roleAdd) {
        roleService.addRole(roleAdd);
        return ResponseDto.ok(null);
    }

    @GetMapping(value = "/getAll")
    public ResponseDto getAll() {
        List<RoleVo> vos = roleService.getAll();
        return ResponseDto.ok(vos);
    }

    @PostMapping(value = "/list")
    public ResponseDto list(@RequestBody RoleQuery query) {
        PageResp<RoleVo> page = roleService.list(query);
        return ResponseDto.ok(page);
    }

    @PostMapping(value = "/update")
    public ResponseDto update(@Valid @RequestBody RoleUpdate update) {
        roleService.update(update);
        return ResponseDto.ok(null);
    }

    @GetMapping(value = "/delete")
    public ResponseDto delete(Integer id) {
        roleService.delete(id);
        return ResponseDto.ok(null);
    }
}
