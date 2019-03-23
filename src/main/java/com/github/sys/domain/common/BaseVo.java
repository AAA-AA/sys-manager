package com.github.sys.domain.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by renhongqiang on 2019-03-22 21:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo {

    private String createBy;
    private String updateBy;
    /**创建时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createTime;

    /**更新时间*/
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updateTime;
}
