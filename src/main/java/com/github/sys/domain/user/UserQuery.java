package com.github.sys.domain.user;

import com.github.sys.domain.common.BasePageQuery;
import lombok.Data;

/**
 * Created by renhongqiang on 2019-03-16 21:22
 */
@Data
public class UserQuery extends BasePageQuery {
    private String name;
    private String mail;
    /**
     * 排序
     */
    private String orderBy;
}
