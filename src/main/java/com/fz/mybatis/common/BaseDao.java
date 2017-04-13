package com.fz.mybatis.common;

import com.fz.mybatis.domain.Page;

import java.util.List;


/**
 * Created by Administrator on 2017/4/13.
 */
public interface BaseDao<T> {
    /**
     * 插入记录
     */
    public Integer insert(T t);

    /**
     * 批量插入
     */
    public Integer insertBatch(List<T> models);

    /**
     * 根据ID, 删除记录
     *
     * @return 是否操作成功. true:删除成功, false:删除失败
     */
    public Boolean deleteById(Integer id);


    /**
     * 更加记录对象, 删除记录
     *
     * @param t 对象
     * @return 是否操作成功. true:删除成功, false:删除失败
     */
    public Boolean deleteByCon(T t);

    /**
     * 更新对象
     * @param t 目标对象
     * @return 更新条数
     */
    public Integer updateById(T t, Integer id);

    /**
     * 更新对象
     *
     * @param source 原对象
     * @param target 目标对象
     * @return 更新条数
     */
    public Integer updateByCon(T source, T target);

    /**
     * 查找记录
     *
     * @return 查找结果, 未找到返回null
     */
    public T findOne(Integer id);

    /**
     * 查找记录
     *
     * @param t 查找条件
     * @return 查找结果, 未找到返回null
     */
    public T findOne(T t);

    /**
     * 查询记录
     *
     * @param t 查找条件
     * @return 查找结果, 未找到返回null
     */
    public List<T> findMany(T t);

    /**
     * 获取记录条数
     *
     * @return 记录条数
     */
    public Integer total();

    /**
     * 获取记录条数
     *
     * @param t 查找条件
     * @return 记录条数
     */
    public Integer total(T t);

    /**
     * 分页查询
     * @param page 分页对象
     * @return
     */
    public Page<T> queryPage(Page<T> page);
}
