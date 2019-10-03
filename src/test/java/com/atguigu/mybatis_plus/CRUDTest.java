package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.entity.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Desription:
 *
 * @ClassName CRUDTest
 * @Author Zhanyuwei
 * @Date 2019/10/3 20:22
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){

        User user = new User();

        user.setName("Helen");
        user.setAge(18);
        user.setEmail("123123@qq.com");

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testUpdateById(){

        User user = new User();
        user.setId(2L);
        user.setAge(28);
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testSelectPage(){

        Page<User> userPage = new Page<>(1,5);
        IPage<User> userIPage = userMapper.selectPage(userPage, null);

        long current = userIPage.getCurrent();
        long pages = userIPage.getPages();
        long size = userIPage.getSize();
        long total = userIPage.getTotal();
        List<User> records = userIPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }

        System.out.println("current: "+current);
        System.out.println("pages: "+pages);
        System.out.println("size: "+size);
        System.out.println("total: "+total);
    }

    @Test
    public void testLogicDetele(){


        int i = userMapper.deleteById(1L);
        System.out.println(i);
    }
}
