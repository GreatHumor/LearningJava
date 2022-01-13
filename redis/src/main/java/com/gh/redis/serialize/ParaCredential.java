package com.gh.redis.serialize;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 3:51 下午
 */
@Data
@NoArgsConstructor
public class ParaCredential {

    /**
     * AccessToken
     */
    private String accesstoken;

    public ParaCredential(String accesstoken) {
        this.accesstoken = accesstoken;
    }
}
