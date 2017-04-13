package com.fz.mybatis.domain;

import lombok.Data;

/**产品详表模型类
 * Created by Administrator on 2017/4/12.
 */
@Data
public class ProDetailDo extends BaseDo {
    private Integer proId;
    private String detLength;
    private String detWidth;
    private String detHeight;
    private String detMate;//质地
    private String detAddr;//产地
    private String detDate;//生产日期
    private String detDesc;

    /*引入javabean*/
    private ProductDo prod;
}
