/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service;

import com.github.javafaker.Faker;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;

import cl.ucn.disc.dsm.ffarias.BaseTest;
import cl.ucn.disc.dsm.ffarias.model.News;
import cl.ucn.disc.dsm.ffarias.model.testNews;

public final class TestContracts extends BaseTest {

    /**
     * The Logger.
     */
    private static final Logger log = LoggerFactory.getLogger(testNews.class);


    /**
     * Testing the constructor
     */
    //@Test
    public void testConstructor(){

        // Call the constructor
        Contracts contracts = new ContractsImplFaker();
        Assertions.assertNotNull(contracts, "Contracts null!");


    }

    /**
     * Testing the save.
     */
    @Test
    public void testSave(){

        log.debug("Testing the save.");

        // The contracts implementation
        Contracts contracts = new ContractsImplFaker();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contracts.save(null);
        });

        //
        Faker faker = new Faker();


        final int N =20;

        // Add 20 news to the backend.
        for (int i = 0; i < N; i++){
       // 1 news
        News news = new News(
                faker.book().title(),
                faker.book().publisher(),
                faker.book().author(),
                faker.internet().url(),
                faker.internet().url(),
                faker.book().genre(),
                faker.dune().quote(),
                ZonedDateTime.now(ZoneId.of("-3")));


        log.info("News {}: {}.",i, toString(news));

        //save into the backend
        contracts.save(news);
        }
        // null news


        // verify the size of the list
            Assertions.assertEquals(10, contracts.retrieveNews(10).size());
            Assertions.assertEquals(1, contracts.retrieveNews(1).size());

            // The size > the real size
           Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
                Assertions.assertEquals(100, contracts.retrieveNews(100).size());
            });


           // Negative or zero size
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                contracts.retrieveNews(-100);
                contracts.retrieveNews(0);
            });

            // Test the duplicates
            News news = contracts.retrieveNews(1).get(0);
            Assertions.assertNotNull(news);

            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                contracts.save(news);
            });


        // Save into the backend v2.0
        /*
         Assertions.assertThrows(IllegalArgumentException.class, () ->{
              contracts.save(news);
          });
         */
        log.debug("Done.");
    }
}
