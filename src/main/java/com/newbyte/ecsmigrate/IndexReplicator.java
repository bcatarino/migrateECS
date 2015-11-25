package com.newbyte.ecsmigrate;

import com.amazonaws.services.cloudsearchv2.model.IndexField;
import com.newbyte.ecsmigrate.amazon.AmazonIndexService;

import java.util.List;

public class IndexReplicator {

    private AmazonIndexService sourceService = new AmazonIndexService("source");
    private AmazonIndexService targetService = new AmazonIndexService("target");

    public void copyIndexes() {
        List<IndexField> originalIndexes = sourceService.getIndexFields();
        targetService.defineIndexFields(originalIndexes);
    }

    public static void main(String... args) {
        new IndexReplicator().copyIndexes();
    }
}