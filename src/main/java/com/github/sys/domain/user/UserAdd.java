package com.github.sys.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by renhongqiang on 2019-03-16 21:11
 */
@Data
public class UserAdd {
    /**用户名，与dashboard名字一致*/
    private String name;

    /**邮箱*/
    private String mail;

    /**密码*/
    private String password;

    /**男：1 女：0*/
    private Integer sex;

    /**年龄*/
    private Integer age;

    private String address;

    /**年龄*/
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthDate;

    private LocalDateTime birth;

}
