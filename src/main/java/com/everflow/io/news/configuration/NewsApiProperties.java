package com.everflow.io.news.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Suresh Chaudhari
 */
@Configuration
@ConfigurationProperties("news-api")
@Getter
@Setter
public class NewsApiProperties {

    private String url;
}
