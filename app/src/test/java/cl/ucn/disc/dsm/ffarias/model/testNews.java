/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;



import com.github.javafaker.Faker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;


public class testNews {

    /**
     *  The Logger
     */

    private static final Logger log = LoggerFactory.getLogger(testNews.class);

    /**
     *
     * @param obj to transform.
     * @return The string view of the object.
     */
    private static String toString(final Object obj){
        return ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE);
    }


    /**
     * Testing the constructor
     */

    @Test
    public void testConstructor(){


        //Generate test data
        Faker faker = new Faker();

        // Test: Valid data
    {
      News news =
          new News(
              faker.book().title(),
              faker.book().publisher(),
              faker.book().author(),
              faker.internet().url(),
              faker.internet().url(),
              faker.book().genre(),
              faker.dune().quote(),
              ZonedDateTime.now(ZoneId.of("-3")));

          // Testing the internal class
            Assertions.assertNotNull(news.getId());
            Assertions.assertEquals("The tittle", news.getTittle());
            Assertions.assertEquals("The Source", news.getSource());
            Assertions.assertEquals("The Author", news.getAuthor());
            Assertions.assertEquals("The url", news.getUrl());
            Assertions.assertEquals("The urlImage", news.getUrlImage());
            Assertions.assertEquals("The description", news.getDescription());
            Assertions.assertEquals("The content", news.getContent());
            Assertions.assertNotNull(news.getPublishedAt());
    }
        // Test: no valid data
        {

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //publishedAt
                    News news = new News(
                    null,
                    "The source",
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    null);

             // source
               new News(
                    "The tittle",
                    null,
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));


             // source size <= 4
                new News(
                    "The tittle",
                    "the",
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));
            });


            News news = new News(
                    null,
                    "The source",
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));
            Assertions.assertEquals("No tittle", news.getTittle());
        }
    }

}
