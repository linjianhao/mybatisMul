package com.fz.mybatis.domain;

import lombok.Data;
/**
 * Created by Administrator on 2017/4/12.
 */
@Data
public class PicDo extends BaseDo {
    private Integer proId;
    private String picUri;
    private String isOrder;
}
