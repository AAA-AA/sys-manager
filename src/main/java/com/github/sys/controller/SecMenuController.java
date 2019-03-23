package com.github.sys.controller;

import com.github.sys.domain.common.PageResp;
import com.github.sys.domain.common.ResponseDto;
import com.github.sys.domain.menu.MenuAdd;
import com.github.sys.domain.menu.MenuQuery;
import com.github.sys.domain.menu.MenuUpdate;
import com.github.sys.domain.menu.MenuVo;
import com.github.sys.service.SecMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by renhongqiang on 2019-03-22 16:36
 */
@RestController
@RequestMapping(value = {"/security/menu"})
public class SecMenuController {

    @Autowired
    private SecMenuService menuService;

    @PostMapping(value = "/add")
    public ResponseDto addRole(@Valid @RequestBody MenuAdd add) {
        menuService.add(add);
        return ResponseDto.ok(null);
    }

    @PostMapping(value = "/list")
    public ResponseDto list(@RequestBody MenuQuery query) {
        PageResp<MenuVo> page = menuService.list(query);
        return ResponseDto.ok(page);
    }

    @PostMapping(value = "/update")
    public ResponseDto update(@Valid @RequestBody MenuUpdate update) {
        menuService.update(update);
        return ResponseDto.ok(null);
    }

    @PostMapping(value = "/delete")
    public ResponseDto delete(@RequestParam(value = "id") Integer id) {
        Assert.isTrue(id != null, "id can not be null!");
        menuService.delete(id);
        return ResponseDto.ok(null);
    }


}
