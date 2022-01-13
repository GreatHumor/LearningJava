package com.gh.redis;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author sso team
 * @description
 * @date 2021/10/27 11:44 上午
 */
public class CustomDateSerializer extends JsonSerializer {
    @Override public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {

    }
}
