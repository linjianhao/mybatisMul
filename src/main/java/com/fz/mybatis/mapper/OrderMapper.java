package com.fz.mybatis.mapper;

import com.fz.mybatis.domain.OrderDo;

import java.util.List;
/**
 * Created by Administrator on 2017/4/12.
 */
public interface OrderMapper {
    public List<OrderDo> queryOrder() throws Exception;
}
