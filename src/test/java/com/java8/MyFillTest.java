package com.java8;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.java8.dao.UserMapper;
import com.java8.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 自动填充测试类
 *
 * @author itmrchen
 * @date 2019/9/20 0:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyFillTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("李海");
        user.setAge(21);
        user.setManagerId(1088248166370832385L);
        user.setEmail("3232323@qq.com");
        Integer rows = userMapper.insert(user);
        System.out.println("影响行数：" + rows);
    }

    @Test
    public void select() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void updateById() {
        User user = new User();
        user.setAge(89);
        user.setId(1088248166370832385L);
        user.setUpdateTime(new Date());
        Integer rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

    /**
     * 自定义的查询是不会自动过滤deleted=1的数据的
     */
    @Test
    public void mySelect() {
        //.eq(User::getDeleted,0)
        List<User> userList = userMapper.mySelectList(Wrappers.<User>lambdaQuery().gt(User::getAge, 30));
        userList.forEach(System.out::println);
    }
}
