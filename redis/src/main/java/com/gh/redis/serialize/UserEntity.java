package com.gh.redis.serialize;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 3:53 下午
 */
@Data
@NoArgsConstructor
public class UserEntity {

    /**
     * 用户ID
     */
    private String username;

    public UserEntity(String username) {
        this.username = username;
    }
}
