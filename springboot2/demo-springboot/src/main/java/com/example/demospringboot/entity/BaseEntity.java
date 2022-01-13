package com.example.demospringboot.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @description: entity基类
 * @author: sso-team
 * @date: 2021/7/30 11:53
 **/
@Data
public abstract class BaseEntity {

    @TableId(type = IdType.ASSIGN_ID)
    @TableField(value = "id", fill = FieldFill.INSERT)
    private Long id;

}
