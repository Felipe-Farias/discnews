/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service;

import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.ffarias.model.News;

public final class ContractsImplFaker implements Contracts{


    /**
     * Get the list of news.
     *
     * @param size
     * @return the List of news
     */
    @Override
    public List<News> retrieveNews(final Integer size) {
        return new ArrayList<>();
    }

    /**
     * Save one news to the System
     *
     * @param news
     */
    @Override
    public void save(final News news) {

    }
}
