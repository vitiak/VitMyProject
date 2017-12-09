package com.crud.tasks.config;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TrelloConfigTest {


    @Test
    public void mapToBoardsTest() throws URISyntaxException {
        //Given

        TrelloConfig trelloConfig = new TrelloConfig();

        assertEquals("vit136", trelloConfig.getTrelloUserName());
        assertNotNull( trelloConfig.getTrelloToken());
        assertNotNull( trelloConfig.getTrelloAppKey());
        assertNotNull( trelloConfig.getTrelloApiEndpoint());
    }
}
