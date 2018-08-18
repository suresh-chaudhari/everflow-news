package com.everflow.io.news.model.newsapi;

import lombok.Data;

import java.util.List;

/**
 * @author Suresh Chaudhari
 */
@Data
public class NewsData {

    private List<Articles> articles;
}
