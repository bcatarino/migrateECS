package com.newbyte.ecsmigrate;

import com.newbyte.ecsmigrate.amazon.AmazonIndexService;
import com.newbyte.ecsmigrate.json.JsonDeserializer;

public class IndexDescriber {

    private AmazonIndexService sourceService = new AmazonIndexService("source");

    private JsonDeserializer deserializer = new JsonDeserializer();

    public String describe() {
        return deserializer.deserialize(sourceService.getIndexFields());
    }

    public static void main(String... args) {
        System.out.println(new IndexDescriber().describe());
    }
}
