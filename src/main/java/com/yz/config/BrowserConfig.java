package com.yz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BrowserConfig {

    private static String location;
    private static String url;

    public static String getLocation() {
        return location;
    }
    @Value("${browser.def-location}")
    public void setLocation(String location) {
        BrowserConfig.location = location;
    }

    public static String getUrl() {
        return url;
    }
    @Value("${browser.init-url}")
    public void setUrl(String url) {
        BrowserConfig.url = url;
    }
}
