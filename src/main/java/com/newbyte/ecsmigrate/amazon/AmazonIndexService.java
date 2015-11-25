package com.newbyte.ecsmigrate.amazon;

import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchClient;
import com.amazonaws.services.cloudsearchv2.model.DefineIndexFieldRequest;
import com.amazonaws.services.cloudsearchv2.model.DescribeIndexFieldsRequest;
import com.amazonaws.services.cloudsearchv2.model.IndexField;

import java.util.List;
import java.util.stream.Collectors;

import static com.newbyte.ecsmigrate.properties.PropertyReader.PROPERTIES;

public class AmazonIndexService {

    private static final String DOMAIN_SUFFIX = ".domain";

    private AmazonCloudSearchClient client;

    private String domainName;

    public AmazonIndexService(String prefix) {
        client = new AmazonClientFactory(prefix).buildAmazonCloudSearchClient();
        domainName = PROPERTIES.getPropertyValue(prefix + DOMAIN_SUFFIX);
    }

    public List<IndexField> getIndexFields() {
        DescribeIndexFieldsRequest request = new DescribeIndexFieldsRequest().withDomainName(domainName);
        return client.describeIndexFields(request).getIndexFields().stream()
                .map(e -> e.getOptions())
                .collect(Collectors.toList());
    }

    public void defineIndexFields(List<IndexField> fields) {
        fields.stream().forEach(f -> defineIndexField(f));
    }

    private void defineIndexField(IndexField field) {
        DefineIndexFieldRequest request = new DefineIndexFieldRequest()
                .withDomainName(domainName).withIndexField(field);
        client.defineIndexField(request);
    }
}