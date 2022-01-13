package com.gh.redis.serialize;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 3:50 下午
 */
@Data
//@NoArgsConstructor
public class LoginContext {

    private List<ParaCredential> credentials;

    private List<ParaAuthentication> authentications;

    private UserEntity user;

    public LoginContext(List<ParaCredential> credentials, List<ParaAuthentication> authentications, UserEntity user) {
        this.credentials = credentials;
        this.authentications = authentications;
        this.user = user;
    }
}
