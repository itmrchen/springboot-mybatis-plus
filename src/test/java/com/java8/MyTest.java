package com.java8;

import com.java8.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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
}
