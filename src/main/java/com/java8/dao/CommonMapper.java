package com.java8.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author itmrchen
 * @date 2019/9/23 0:29
 */
public interface CommonMapper<T> extends BaseMapper<T> {
    /**
     * 删除所有行
     * @return
     */
    int deleteAll();

    /**
     * 批量插入
     * @param list
     * @return
     */
    int insertBatchSomeColumn(List<T> list);

    /**
     * 逻辑删除 并变更其他字段
     * @param t
     * @return
     */
    int deleteByIdWithFill(T t);

    /**
     * 更新某些字段通过id 没设置时会设为null
     * @param t
     * @return
     */
    int alwaysUpdateSomeColumnById(@Param(Constants.ENTITY)T t);
}
