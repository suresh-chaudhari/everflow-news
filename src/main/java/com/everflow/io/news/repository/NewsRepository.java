package com.everflow.io.news.repository;

import com.everflow.io.news.model.dao.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Suresh Chaudhari
 */
public interface NewsRepository extends CrudRepository<News, Integer> {

    @Query("FROM News n ORDER BY n.publishedAt DESC")
    public List<News> getAllNews();

}
