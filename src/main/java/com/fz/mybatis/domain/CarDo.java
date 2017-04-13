package com.fz.mybatis.domain;

import lombok.Data;

/**购物车模型类
 * Created by Administrator on 2017/4/12.
 */
@Data
public class CarDo extends BaseDo {
    private Integer userId;
    private Integer prodId;
    private String proSize;
    private String proColor;
    private Integer proNum;
    private Double proPrice;
    private Double talPrice;

    private ProductDo pro;

}
