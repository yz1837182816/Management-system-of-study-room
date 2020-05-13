package com.yz;

import com.yz.config.BrowserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws ClassNotFoundException {
        SpringApplication.run(DemoApplication.class, args);
        String cmd = BrowserConfig.getLocation() + " " + BrowserConfig.getUrl();
        Runtime run = Runtime.getRuntime();
        try {
            run.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
