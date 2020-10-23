package com.github.springbootjackson.pojo.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 石少东
 * @date 2020-10-23 15:20
 * @since 1.0
 */


public class MobileDeserializer extends JsonDeserializer<Set<String>> {

    @Override
    public Set<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getValueAsString();
        if (StringUtils.isBlank(value)) {
            return Collections.emptySet();
        }
        return Arrays.stream(StringUtils.split(value, ";")).collect(Collectors.toSet());
    }
}