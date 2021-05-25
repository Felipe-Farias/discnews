/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;



import com.github.javafaker.Faker;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import cl.ucn.disc.dsm.ffarias.BaseTest;


public final class testNews extends BaseTest {

    /**
     *  The Logger
     */
    private static final Logger log = LoggerFactory.getLogger(testNews.class);




    /**
     * Testing the constructor
     */

    @Test
    public void testConstructor(){

        log.debug("Starting the testConstructor");

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

       log.info("TheNews: " + toString(news));

          // Testing the internal class
            Assertions.assertNotNull(news.getId());
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
        log.debug("Done.");
    }

}
