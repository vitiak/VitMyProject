package com.crud.tasks.domain;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class TrelloCardTest {

    @Test
    public void TrelloCardTest() throws URISyntaxException {
        //Given

        TrelloCard trelloCard =
                new TrelloCard("name1", "description1","pos1", "1");


        assertEquals("name1", trelloCard.getName());
        assertEquals("pos1", trelloCard.getPos());
        assertEquals("description1", trelloCard.getDescription());
        assertEquals("1", trelloCard.getListId());
    }


}
