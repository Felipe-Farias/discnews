/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import cl.ucn.disc.dsm.ffarias.service.Contracts;
import cl.ucn.disc.dsm.ffarias.service.ContractsImplFaker;

/**
 *  The NewsViewModel
 * @author Felipe Farías Espinoza
 */
public class NewsViewModel extends AndroidViewModel {

    /**
     * The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(NewsViewModel.class);

    /**
     * The Contract.
     */
    private final Contracts contracts = new ContractsImplFaker();

    /**
     * The list of news.
     */
    private final MutableLiveData<List<News>> theNews;


    /**
     * The Constructor.
     *
     * @param application to use
     */
    public NewsViewModel(final Application application) {
        super(application);
        // TODO: call the new livedata constructor
        this.theNews = new MutableLiveData<>();
    }

    /**
     *
     * @return the list of news wrapped inside a LiveData
     */
    public LiveData<List<News>> getNews() {
        return this.theNews;
    }

    /**
     * Refresh (get) the news from the backend.
     */
    public void refresh(){

        // Show message if theNews are empty
        if (this.theNews.getValue() == null || this.theNews.getValue().size() == 0){
            log.warn("No news, fetching from contracts...");

        }
        // Get the news from the backend.

        this.theNews.setValue(this.contracts.retrieveNews(10));
    }
}
