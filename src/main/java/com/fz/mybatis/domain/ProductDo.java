package com.fz.mybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * 产品模型类
 * Created by zhangls on 2016/10/27 0027.
 */
@Data
public class ProductDo extends BaseDo {

    private String proName; //产品名称
    private Double proRealPrice;//原价
    private Double proNowPrice;//现价
    private String isStock;//是否有库存  1：有 0：没有
    private String proDesc;//简述
    private String proSize;//规格
    private String proColor;//颜色
    private Double proScore;//评分 1-5分
    private String proTypeId;//所属类型
    private Integer proPicId;//默认图片Id
    private String proPicUri;//默认图片Uri

    private List<PicDo> picLs;//图片列表

    private List<CommentDo> commentLs;

    private ProDetailDo proDetailDo;

}
