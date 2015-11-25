package com.newbyte.ecsmigrate.amazon;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudsearchv2.AmazonCloudSearchClient;

import static com.newbyte.ecsmigrate.properties.PropertyReader.PROPERTIES;

public final class AmazonClientFactory {

    private static final String KEY_SUFFIX = ".key";
    private static final String SECRET_SUFFIX = ".secret";
    private static final String REGION_SUFFIX = ".region";

    private String prefix;

    public AmazonClientFactory(String prefix) {
        this.prefix = prefix;
    }

    public AmazonCloudSearchClient buildAmazonCloudSearchClient() {

        AmazonCloudSearchClient client = new AmazonCloudSearchClient(new AWSCredentials() {
            public String getAWSAccessKeyId() {
                return getKey();
            }

            public String getAWSSecretKey() {
                return getSecret();
            }
        });
        client.setRegion(Region.getRegion(Regions.fromName(getRegion())));

        return client;
    }

    private String getKey() {
        return PROPERTIES.getPropertyValue(prefix + KEY_SUFFIX);
    }

    private String getSecret() {
        return PROPERTIES.getPropertyValue(prefix + SECRET_SUFFIX);
    }

    private String getRegion() {
        return PROPERTIES.getPropertyValue(prefix + REGION_SUFFIX);
    }
}