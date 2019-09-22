package com.java8;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.java8.config.MybatisPlusConfiguration;
import com.java8.dao.UserMapper;
import com.java8.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * sql注入解析器
 *
 * @author itmrchen
 * @date 2019/9/20 0:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectorTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void deleteAll() {
        int rows = userMapper.deleteAll();
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void insertBatch() {
        List<User> list =new ArrayList<>();
        User user1 = new User();
        user1.setName("java8.com");
        user1.setAge(12);
        user1.setManagerId(1088248166370832385L);
        User user2 = new User();
        user2.setName("java");
        user2.setAge(24);
        user2.setManagerId(1088248166370832385L);
        list.add(user1);
        list.add(user2);
        int rows = userMapper.insertBatchSomeColumn(list);
        System.out.println("影响行数：" + rows);
    }

    /**
     * 需要在User实体的age属性上加 @TableField(fill = FieldFill.UPDATE)
     */
    @Test
    public void deleteByIdWithFill(){
        User user = new User();
        user.setId(1175814194107420675L);
        user.setAge(38);
        int rows = userMapper.deleteByIdWithFill(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void alwaysUpdateSomeColumnById(){
        User user = new User();
        user.setId(1175814194107420675L);
        user.setAge(49);
        user.setName("java777");
        int rows = userMapper.alwaysUpdateSomeColumnById(user);
        System.out.println("影响行数：" + rows);
    }

}
