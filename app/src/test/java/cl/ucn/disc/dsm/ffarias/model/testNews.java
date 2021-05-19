/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.model;



import java.time.ZoneId;
import java.time.ZonedDateTime;


public class testNews {

    /**
     * Testing the constructor
     */


    public void testConstructor(){

        // Test: Valid data
    {
      News news =
          new News(
              "The Tittle",
              "The source",
              "The author",
              "The url",
              "The image url",
              "The description",
              "The content",
              ZonedDateTime.now(ZoneId.of("-3")));

          // Testing the internal class
          // Assertions.assertNotNull(news.getId());
          // Assertions.assertEquals("The tittle, news.getTittle()));
          // Assertions.assertEquals("The Source, news.getSource()));
          // Assertions.assertEquals("The Author, news.getAuthor()));
          // Assertions.assertEquals("The url, news.getUrl()));
          // Assertions.assertEquals("The urlImage, news.getUrlImage()));
          // Assertions.assertEquals("The description, news.getDescription()));
          // Assertions.assertEquals("The content, news.getContent()));
          // Assertions.assertNotNull(news.getPublishedAt());
    }
        // Test: no valid data
        {

         /*   Assertions.assertThrow(IllegalArgumentException.class, () --> {
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
               News news = new News(
                    "The tittle",
                    null,
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));


             // source size <= 4
               News news = new News(
                    "The tittle",
                    "the",
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));
            });
            */

            News news = new News(
                    null,
                    "The source",
                    "The author",
                    "The url",
                    "The image url",
                    "The description",
                    "The content",
                    ZonedDateTime.now(ZoneId.of("-3")));
           // Assertions.assertEquals("No tittle", news.getTittle());
        }
    }

}
