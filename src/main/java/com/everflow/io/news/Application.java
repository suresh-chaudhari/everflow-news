package com.everflow.io.news;

import com.everflow.io.news.model.dao.News;
import com.everflow.io.news.service.EverFlowService;
import com.everflow.io.news.service.NewsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@Slf4j
public class Application implements CommandLineRunner {

    @Autowired
    private NewsService newsService;

    @Autowired
    private EverFlowService everFlowService;

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Calling news api Service");
        newsService.getNewsApiData();

        // print this data in console or you can fetch by using rest controller end point
        List<News> newsListResponse = everFlowService.getNewsData();

        //printing news data from database in json pretty format
        log.info("\n\n");
        log.info("****************************************************\n\n\n");

//        log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(newsListResponse));

    }
}
