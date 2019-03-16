package com.github.sys.domain.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by renhongqiang on 2019-03-16 21:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResp<T> {

    @ApiModelProperty("每页最大记录数")
    private Integer pageSize;

    @ApiModelProperty("当前页码，从1开始")
    private Integer pageNum;

    @ApiModelProperty("总数量")
    private Long totalCount;

    @ApiModelProperty("数据集合")
    private List<T> list;

}
