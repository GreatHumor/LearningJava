package com.gh.redis.serialize;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 3:52 下午
 */
@Data
@NoArgsConstructor
public class ParaAuthentication {

    private String username;

    public ParaAuthentication(String username) {
        this.username = username;
    }
}
