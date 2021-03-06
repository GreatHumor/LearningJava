package com.gh.redis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sso team
 * @description
 * @date 2021/9/13 3:24 上午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {

    private String name;

    private Integer age;

    List<Teacher> teachers;
}
