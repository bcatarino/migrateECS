package com.newbyte.ecsmigrate.properties;

import java.util.ResourceBundle;

public enum PropertyReader {

    PROPERTIES;

    private ResourceBundle bundle = ResourceBundle.getBundle("application");

    public String getPropertyValue(String key) {
        return bundle.getString(key);
    }
}
