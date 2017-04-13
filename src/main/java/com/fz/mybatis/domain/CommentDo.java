package com.fz.mybatis.domain;

import lombok.Data;

/**评论模型类
 * Created by Administrator on 2017/4/12.
 */
@Data
public class CommentDo extends BaseDo {
    private Integer proId;
    private Integer userId;
    private String comTitle;
    private String comDesc;
    private Double proScore;

    private String userName;
}
