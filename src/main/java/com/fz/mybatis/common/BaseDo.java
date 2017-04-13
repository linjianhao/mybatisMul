package com.fz.mybatis.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/13.
 */
@Data
public class BaseDo implements Serializable {
    private Integer id;

    private String state;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;
}
