package com.java8;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.java8.dao.UserMapper;
import com.java8.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author itmrchen
 * @date 2019/9/20 0:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void deleteById() {
        Integer rows = userMapper.deleteById(1094592041087729666L);
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
        user.setAge(88);
        user.setId(1088248166370832385L);
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
