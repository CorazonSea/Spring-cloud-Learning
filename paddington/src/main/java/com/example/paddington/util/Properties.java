package com.example.paddington.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "com.paddington")
public class Properties {

    private String title;

    private String description;
}
