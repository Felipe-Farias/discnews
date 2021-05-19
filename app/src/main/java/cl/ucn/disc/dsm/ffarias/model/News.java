/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;

import java.time.ZonedDateTime;


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
    public News(String tittle, String source, String author, String url, String urlImage, String description, String content, ZonedDateTime publishedAt) {
        // FIXME: add the hash (tittle + source + author)
        this.id = 0L;
        this.tittle = tittle;
        this.source = source;
        this.author = author;
        this.url = url;
        this.urlImage = urlImage;
        this.description = description;
        this.content = content;
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
