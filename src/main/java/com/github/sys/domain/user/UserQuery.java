package com.github.sys.domain.user;

import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-16 21:22
 */
@Data
public class UserQuery {
    private String name;
    private String mail;

    /**
     * 页码，默认从1开始
     */
    private Integer pageNum = 1;
    /**
     * 页面大小，默认10
     */
    private Integer pageSize = 10;

    /**
     * 排序
     */
    private String orderBy;
}
