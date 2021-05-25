/*
 * Copyright (c) Felipe Farias Espinoza
 */

package cl.ucn.disc.dsm.ffarias.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import cl.ucn.disc.dsm.ffarias.model.News;

public final class TestContracts {



    /**
     * Testing the constructor
     */
    //@Test
    public void testConstructor(){

        // Call the constructor
        Contracts contracts = new ContractsImplFaker();
        // Assertions.assertNotNull(contracts, "Contracts null!");

    }

    @Test
    public void testSave(){

        // The contracts implementation
        Contracts contracts = new ContractsImplFaker();

       // 1 news
        News news = new News(
                "The tittle",
                "The source",
                "The author",
                "The url",
                "The image url",
                "The description",
                "The content",
                ZonedDateTime.now(ZoneId.of("-3")));
        //save into the backend
        contracts.save(news);

        // null news
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contracts.save(null);
        });

        // verify the size of the list
            Assertions.assertEquals(1, contracts.retrieveNews(10).size());


        // Save into the backend v2.0
         Assertions.assertThrows(IllegalArgumentException.class, () ->{
              contracts.save(news);
          });
    }
}
