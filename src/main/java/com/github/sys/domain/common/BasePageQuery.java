package com.github.sys.domain.common;

import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-21 16:18
 */
@Data
public class BasePageQuery {
    /**
     * 页码，默认从1开始
     */
    private Integer pageNum = 1;
    /**
     * 页面大小，默认10
     */
    private Integer pageSize = 10;

    private String orderColumn;

    private String direction;
}
