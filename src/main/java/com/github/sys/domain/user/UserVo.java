package com.github.sys.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by renhongqiang on 2019-03-16 21:19
 */
@Data
public class UserVo {

    /**主键*/
    private Integer id;

    private String name;

    /**邮箱*/
    private String mail;

    /**密码*/
    private String password;

    /**男：1 女：0*/
    private Integer sex;

    /**年龄*/
    private Integer age;

    /**年龄*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime birth;

    /**地址*/
    private String address;

    /**状态*/
    private Integer status;

    /**创建时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**更新时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;

}
