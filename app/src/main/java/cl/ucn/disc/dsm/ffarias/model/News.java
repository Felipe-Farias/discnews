/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;

import net.openhft.hashing.LongHashFunction;


import org.threeten.bp.ZonedDateTime;

/**
 * The class.
 *
 * @author felip
 */
public final class News {
    /**
     * unique id.
     */
    private final Long id;

    /**
     * The tittle.
     * Restrictions:
     *  - not null
     *  - size > 2
     */
    private final String tittle;
    /**
     * The source.
     */
    private final String source;
    /**
     * The author.
     */
    private final String author;
    /**
     * The url.
     */
    private final String url;
    /**
     * the url image.
     */
    private final String urlImage;
    /**
     * The description.
     */
    private final String description;
    /**
     * the content.
     */
    private final String content;
    /**
     * the date of publish.
     */
    private final ZonedDateTime publishedAt;

    /**
     * The constructor.
     * @param tittle
     * @param source
     * @param author
     * @param url
     * @param urlImage
     * @param description
     * @param content
     * @param publishedAt
     */
    public News(final String tittle,
                final String source,
                final String author,
                final String url,
                final String urlImage,
                final String description,
                final String content,
                ZonedDateTime publishedAt) {

        // Tittle replace
        this.tittle = ( tittle != null && tittle.length() > 0) ? tittle : "No tittle";


        //Source validation
        if(source == null ){
            throw new IllegalArgumentException("Source no valid");

        }
        if(source.length() < 2){
            throw new IllegalArgumentException("Source size was < 2 [" + source + "]");
        }
        this.source = source;

        // Hash xx (Tittle + source + author)
        this.id = LongHashFunction.xx().hashChars(
                this.getTittle() + "|" + this.getSource() + "|" + this.getAuthor()
        );

        // Author
        this.author = (author != null && author.length() > 0) ? author : "No author";

        this.url = url;
        this.urlImage = urlImage;
        this.description = description;
        this.content = content;

        // publishedAt
        if(publishedAt == null){
            throw new IllegalArgumentException("The publishedAt needed!");
        }
        this.publishedAt = publishedAt;
    }




    public Long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getSource() {
        return source;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }
}
