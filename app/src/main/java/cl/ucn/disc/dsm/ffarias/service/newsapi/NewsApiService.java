/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service.newsapi;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.ucn.disc.dsm.ffarias.model.News;
import cl.ucn.disc.dsm.ffarias.model.newsapi.Article;
import cl.ucn.disc.dsm.ffarias.model.newsapi.NewsAPIResponse;
import cl.ucn.disc.dsm.ffarias.service.Contracts;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Te services of NewsAPI.
 *
 */
public class NewsApiService implements Contracts {


    /**
     * The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(NewsApiService.class);

    private final NewsAPI newsAPI;

    private static final ZoneId theZone = ZoneId.of("-4");

    /**
     * The Constructor: build the NewsAPI.
     */
    public NewsApiService(){
        this.newsAPI = new Retrofit.Builder()
                // The url used to connect
                .baseUrl(NewsAPI.BASE_URL)
                // JSON to POJO (java) converter
                .addConverterFactory(GsonConverterFactory.create())
                // Build rhe Retrofit
                .build()
                // Create the NewsAPI implementation
                .create(NewsAPI.class);
    }

    /**
     * Get the list of news.
     *
     * @param size
     * @return the List of news
     */
    @Override
    public List<News> retrieveNews(Integer size) {

        // The call to get the NewsAPI Response.
        Call<NewsAPIResponse> theCall = this.newsAPI.getTopHeadLines(size, NewsAPI.Category.science);


        try{
            // Connect and get the responses in synchrony way
            Response<NewsAPIResponse> theResponse = theCall.execute();

            // if not successful
            if (!theResponse.isSuccessful()){
                log.error("Can't get the news <{}> ", theResponse.errorBody());
                throw new RuntimeException("Can't get the news, response code: " + theResponse.code());
            }

            // read the NewsAPIResponse from the body of the call (JSON)
            NewsAPIResponse newsAPIResponse = theResponse.body();

            if (newsAPIResponse == null){

                throw new RuntimeException("Body of NewsAPI was null");

            }
            // The result
            List<News> theNews = new ArrayList<>();



            // iterate over the list the article
            for (Article article : newsAPIResponse.articles){

                News news = new News(
                        article.title,
                        article.source.name,
                        article.author,
                        article.url,
                        article.urlToImage,
                        article.description,
                        article.content,
                        parseDate(article.publishedAt)
                );

                theNews.add(news);

            }
            return theNews;

        } catch (IOException e){
            log.error("Can't get the news", e);
            throw new RuntimeException("can't get the news", e);
        }

    }

    private ZonedDateTime parseDate(String publishedAt) {

        return ZonedDateTime.
                parse(publishedAt).
                withZoneSameInstant(theZone);
    }

    /**
     * Save one news to the System
     *
     * @param news to save
     */
    @Override
    public void save(News news) {
        throw new NotImplementedException("Method not implemented!");
    }


    /**
     * The interface of NewsAPI
     */
    public interface NewsAPI{


        /**
         * The base URL
         */
        String BASE_URL  = "https://newsapi.org/v2/";

        /**
         * The API key.
         */
        String API_KEY = "378c4ef2a26240468ae08a464adfc30d";


        /**
         *
         *  @return the Call with the link {@link NewsAPIResponse}
         */
        @Headers("X-API-Key: "+API_KEY)
        @GET("everything")
        Call<NewsAPIResponse> getEverything();

        /**
         * https://newsapi.org/docs/endpoints/top-headlines
         *
         * @param pageSize The number of results to return per page (request). 20 is the default, 100 is the maximum.
         * @return The call to get NewsAPIResponse
         */

        @Headers("X-Api-Key: "+ API_KEY)
        @GET("top-headlines")
        Call<NewsAPIResponse> getTopHeadLines(@Query("PageSize") int pageSize);

        @Headers("X-Api-Key: "+ API_KEY)
        @GET("top-headlines")
        Call<NewsAPIResponse> getTopHeadLines(@Query("PageSize") int pageSize,
                                              @Query("category") Category category);

        /**
         * The category you want to get headlines for.
         * Possible options: business, entertainment,
         * general, health, science, sports, technology.
         */
        enum Category {
            business, entertainment, general, health, science, sports, technology
        }
    }
}
