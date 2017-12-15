package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private TrelloConfig trelloConfig;

    @Before
    public void init() {
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(trelloConfig.getTrelloUserName()).thenReturn("vit136");
    }

    @Test
    public void shouldFetchTrelloBoards() throws URISyntaxException {
        //Given
/*
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("http://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
*/


        TrelloBoardDto[] trelloBoards = new TrelloBoardDto[1];
        trelloBoards[0] = new TrelloBoardDto("test_id", "test_board", new ArrayList<>());

        URI uri = new URI("http://test.com/members/vit136/boards?key=test&token=test&fields=name,id&lists=all");
//        URI uri = new URI("http://test.com/members/null/boards?key=test&token=test&fields=name,id&lists=all");

        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(trelloBoards);

        //When
        List<TrelloBoardDto> fetchTrelloBoards = trelloClient.getTrelloBoards();

        //Then

        assertEquals(1, fetchTrelloBoards.size());
        assertEquals("test_id", fetchTrelloBoards.get(0).getId());
        assertEquals("test_board", fetchTrelloBoards.get(0).getName());
        assertEquals(new ArrayList<>(), fetchTrelloBoards.get(0).getLists());
    }


    @Test
    public void shouldCreatedCard() throws URISyntaxException {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test description",
                "top",
                "test_id"
        );

        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20description&pos=top&idList=test_id");

        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto(
                "1",
                "Test task",
                "http://test.com"
        );

        when(restTemplate.postForObject(uri, null, CreatedTrelloCardDto.class)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto newCard = trelloClient.createdNewCard(trelloCardDto);

        //Then
        assertEquals("1", newCard.getId());
        assertEquals("Test task", newCard.getName());
        assertEquals("http://test.com", newCard.getShortUrl());

    }

    @Test
    public void shouldReturnEmptyList() throws URISyntaxException {
        //Given

        URI uri = new URI("http://test.com/cards?key=test&token=test&name=Test%20task&desc=Test%20description&pos=top&idList=test_id");

//        when(restTemplate.postForObject(uri, null, TrelloBoardDto[].class)).thenReturn(null);

        //When
        List<TrelloBoardDto> trelloBoardDto = trelloClient.getTrelloBoards();

        //Then
        assertEquals(0, trelloBoardDto.size());
    }

}