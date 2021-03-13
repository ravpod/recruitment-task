package com.rafalpodgorski.decertotask;

import com.rafalpodgorski.decertotask.config.properties.RandomProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RandomProperties.class)
public class DecertoTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecertoTaskApplication.class, args);
    }

}
