/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service;

import java.util.List;

import cl.ucn.disc.dsm.ffarias.model.News;

public interface Contracts {
    /**
     * Get the list of news.
     * @param size
     * @return the List of news
     */
    List<News> retrieveNews(Integer size);

    /**
     * Save one news to the System
     * @param news
     */
    void save(News news);
}
