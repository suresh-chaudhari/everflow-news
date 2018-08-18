package com.everflow.io.news.rest;

import com.everflow.io.news.model.dao.News;
import com.everflow.io.news.service.EverFlowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author Suresh Chaudhari
 */
@RestController
@RequestMapping(value = "/v1/everflow")
@Slf4j
public class EverFlowRestController {

    @Autowired
    private EverFlowService everFlowService;

    /**
     * To get all news
     *
     * Note: First time it will hit the database to fetch the news by news id and when you make request again it will fetch the data from
     * redis cache
     *
     */
    @Cacheable(value = "getAllNews")
    @GetMapping(value = "/news", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<News> getAllNews() {
        return everFlowService.getNewsData();
    }


    /**
     * It gets the news by news Id
     *
     * Note: First time it will hit the database to fetch the news by news id and when you make request again it will fetch the data from
     * redis cache
     *
     */
    @Cacheable(value = "getNewsById")
    @GetMapping(value = "/news/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public News getNewsById(@PathVariable int id) {
        return everFlowService.getNewsDataById(id);
    }

}