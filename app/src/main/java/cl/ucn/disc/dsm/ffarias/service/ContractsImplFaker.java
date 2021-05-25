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

        // Check the list
        if(size > this.listNews.size()){
            throw new IndexOutOfBoundsException("Size > the current size");
        }

        // Return the last size inside of unmodifiable list
        return Collections.unmodifiableList(
                this.listNews.subList(this.listNews.size()-size, this.listNews.size())
        );
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

        // Sort the list by publishedAt
        this.listNews.sort((a, b)-> b.getPublishedAt().compareTo(a.getPublishedAt()));

    }
}
