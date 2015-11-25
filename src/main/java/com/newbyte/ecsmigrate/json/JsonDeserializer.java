package com.newbyte.ecsmigrate.json;

import com.amazonaws.services.cloudsearchv2.model.IndexField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonDeserializer {

    private ObjectMapper mapper;

    public JsonDeserializer() {
        mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public String deserialize(List<IndexField> fields) {

        StringBuilder builder = new StringBuilder("[");

        fields.forEach(f -> builder.append(deserializeOne(f)));

        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        return builder.toString();
    }

    public String deserializeOne(IndexField field) {
        try {
            return mapper.writeValueAsString(field) + ",";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
