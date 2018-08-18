package com.everflow.io.news.service;

import com.everflow.io.news.configuration.NewsApiProperties;
import com.everflow.io.news.model.newsapi.Articles;
import com.everflow.io.news.model.newsapi.NewsData;
import com.everflow.io.news.model.dao.News;
import com.everflow.io.news.repository.NewsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * NewsService class is used for fetch the data from newsapi and persist into mysql database.
 *
 * @author Suresh Chaudhari
 */
@Service
@Slf4j
public class NewsService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private NewsApiProperties newsApiProperties;

    @Autowired
    private NewsRepository newsRepository;

    /**
     * It gets the news data from provided news api url
     */
    public void getNewsApiData() {

        NewsData newsData = restTemplate.getForObject(newsApiProperties.getUrl(), NewsData.class);
        log.info("Fetched News Data from news api: "+ newsData);

        List<News> newsList = new ArrayList<>();

        for (Articles article : newsData.getArticles()) {
            News news = new News();
            news.setTitle(article.getTitle());
            news.setDescription(article.getDescription());
            news.setUrl(article.getUrl());
            news.setPublishedAt(getUTCTime(article.getPublishedAt()));

            newsList.add(news);
        }

        newsRepository.saveAll(newsList);
        log.info("Persisted news data in database");

    }

    /**
     * It will convert into unix timestamp
     *
     * @param publishedAt
     * @return
     */
    private long getUTCTime(String publishedAt) {
        return Instant.parse(publishedAt).toEpochMilli();
    }
}
