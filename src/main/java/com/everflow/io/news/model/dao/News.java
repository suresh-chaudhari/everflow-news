package com.everflow.io.news.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Suresh Chaudhari
 *
 * Note: use the same object for response
 */
@Entity
@Table(name = "news")
@Data
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "news_id")
    @JsonProperty("news_id")
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String url;

    //taken this long instead of int as we need unix timestamp
    private long publishedAt;
}
