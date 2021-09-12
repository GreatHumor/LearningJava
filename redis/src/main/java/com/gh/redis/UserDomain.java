package com.gh.redis;

import lombok.Builder;
import lombok.Data;

/**
 * @author sso team
 * @description
 * @date 2021/9/13 3:24 上午
 */
@Data
@Builder
public class UserDomain {

    private String name;

    private Integer age;

}
