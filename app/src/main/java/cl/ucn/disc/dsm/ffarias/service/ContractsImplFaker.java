/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cl.ucn.disc.dsm.ffarias.model.News;

public final class ContractsImplFaker implements Contracts{

    private final List<News> listNews = new ArrayList<>();

    /**
     * The constructor.
     */
    public ContractsImplFaker() {
        // Nothing here.
    }

    /**
     * Get the list of news.
     *
     * @param size
     * @return the List of news
     */
    @Override
    public List<News> retrieveNews(final Integer size) {
        // Preconditions
        if(size <= 0){
            throw new IllegalArgumentException("Size cannot be zero or negative");
        }
        // Return the unmodifiable list
        return Collections.unmodifiableList(this.listNews);
    }

    /**
     * Save one news to the System.
     *
     * @param news
     */
    @Override
    public void save(final News news) {

        // Nullity test
        if(news == null){
            throw new IllegalArgumentException("Need news != null");
        }

        // No duplicate allowed
        for(News n : this.listNews){

            if(n != null && n.getId().equals(news.getId())){
                throw new IllegalArgumentException("News is already in the list");
            }
        }

        this.listNews.add(news);

    }
}
