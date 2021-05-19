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
        News news = new News(
                "The Tittle",
                "The source",
                "The author",
                "The url",
               "The image url",
                 "The description",
                "The content",
                //FIXME: Check the current zone in Chile
                ZonedDateTime.now(ZoneId.of("-3")));

        // Testing the internal class


    }

}
