package com.java8.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.additional.AlwaysUpdateSomeColumnById;
import com.baomidou.mybatisplus.extension.injector.methods.additional.InsertBatchSomeColumn;
import com.baomidou.mybatisplus.extension.injector.methods.additional.LogicDeleteByIdWithFill;
import com.java8.method.DeleteMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author itmrchen
 * @date 2019/9/23 0:14
 */
@Component
public class MySqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new DeleteMethod());
        methodList.add(new InsertBatchSomeColumn(t ->!t.isLogicDelete()));
        methodList.add(new LogicDeleteByIdWithFill());
        //永远不更新name字段
        methodList.add(new AlwaysUpdateSomeColumnById(t->!t.getColumn().equals("name")));
        return methodList;
    }

}
