package com.example.demospringboot.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.paraview.uid.core.UidGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author sso team
 * @description
 * @date 2021/12/30 10:00 上午
 */
@Slf4j
@Component
public class BaseEntityAssembleHandler implements MetaObjectHandler {

    private static final String ID = "id";

    @Autowired
    @Lazy
    private UidGenerator uidGenerator;

    @Override
    public void insertFill(MetaObject metaObject) {

        if (metaObject.hasGetter(ID)) {
            this.strictInsertFill(metaObject, ID, Long.class, uidGenerator.getUid());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
