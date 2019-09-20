package com.java8.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author itmrchen
 * @date 2019/9/21 1:35
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //存在这个属性才自动填充
        boolean hasSetter = metaObject.hasSetter("createTime");
        if (hasSetter) {
            setInsertFieldValByName("createTime", new Date(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object obj = getFieldValByName("updateTime", metaObject);
        if (null == obj) {
            System.out.println("updateTime自动填充");
            setUpdateFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}
