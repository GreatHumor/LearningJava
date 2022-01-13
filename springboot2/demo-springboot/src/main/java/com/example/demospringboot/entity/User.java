package com.example.demospringboot.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author sso team
 * @description
 * @date 2022/1/11 4:25 下午
 */
@TableName("pi_user")
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
public class User extends BaseEntity{

    String name;

}
