package com.everflow.io.news.service;

import com.everflow.io.news.constants.ErrorResponseCodes;
import com.everflow.io.news.exceptions.ServiceException;
import com.everflow.io.news.model.dao.News;
import com.everflow.io.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Suresh Chaudhari
 */
@Service
public class EverFlowService {

    @Autowired
    private NewsRepository newsRepository;

    /**
     * It gives the news data from database
     *
     * @return
     */
    public List<News> getNewsData() {
        return (List<News>) newsRepository.getAllNews();
    }


    /**
     * It gives the news data by news id from database
     *
     * @return
     */
    public News getNewsDataById(int newsId) {
        Optional<News> newsOptional = newsRepository.findById(newsId);
        if (!newsOptional.isPresent())
            throw new ServiceException(ErrorResponseCodes.BAD_REQUEST);
        return newsOptional.get();
    }
}
