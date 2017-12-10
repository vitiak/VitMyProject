package com.crud.tasks.domain;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class BadgesTest {
    @Test
    public void TrelloCardTest() throws URISyntaxException {
        //Given

        Badges badges =
                new Badges(1,new AttachmentsByType(new Trello(1,2)));

        assertEquals(1, badges.getVotes());
        assertEquals(1, badges.getAttachmentsByType().getTrello().getBoard());
        assertEquals(2, badges.getAttachmentsByType().getTrello().getCard());
    }

}
