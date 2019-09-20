package com.java8;

import com.java8.dao.UserMapper;
import com.java8.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 乐观锁测试类
 *
 * @author itmrchen
 * @date 2019/9/20 0:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OptTest {
    @Resource
    private UserMapper userMapper;

    @Test
    public void updateById() {
        User user = new User();
        user.setAge(90);
        user.setId(1088248166370832385L);
        user.setUpdateTime(new Date());
        user.setVersion(3);
        Integer rows = userMapper.updateById(user);
        System.out.println("影响行数：" + rows);
    }

}
