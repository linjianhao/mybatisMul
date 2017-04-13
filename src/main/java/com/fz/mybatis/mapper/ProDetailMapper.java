package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.ProDetailDo;
import com.fz.mybatis.domain.ProductDetailDo;

import java.util.List;

/**
 * Created by Administrator on 2016-12-03.
 */
public interface ProDetailMapper {

    public ProDetailDo findByIdProDet(Integer id) throws Exception;


    public List<ProDetailDo> queryProDetail() throws Exception;
}
