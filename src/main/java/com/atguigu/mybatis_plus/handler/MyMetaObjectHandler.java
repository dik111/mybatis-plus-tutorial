package com.atguigu.mybatis_plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Desription:
 *
 * @ClassName MyMetaObjectHandler
 * @Author Zhanyuwei
 * @Date 2019/10/3 21:01
 * @Version 1.0
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        System.out.println("插入时自动填充。。。。。。");
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        System.out.println("更新时自动填充。。。。。。");
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
