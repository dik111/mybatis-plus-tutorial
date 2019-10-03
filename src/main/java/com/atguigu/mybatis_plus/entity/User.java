package com.atguigu.mybatis_plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * Desription:
 *
 * @ClassName User
 * @Author Zhanyuwei
 * @Date 2019/10/3 18:29
 * @Version 1.0
 **/
@Data
public class User {

    //@TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableLogic
    private Integer deleted;
}
