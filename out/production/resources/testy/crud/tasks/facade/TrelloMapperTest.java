package com.crud.tasks.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TrelloMapperTest {


    @Test
    public void mapToBoardsTest() throws URISyntaxException {
        //Given

        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();

        trelloBoardsDto.add(new TrelloBoardDto("test_id", "test_board", new ArrayList<>()));

        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardsDto);
        //When
        //Then

        assertEquals(1, trelloBoard.size());
        assertEquals("test_id", trelloBoard.get(0).getId());
        assertEquals("test_board", trelloBoard.get(0).getName());
        assertEquals(new ArrayList<>(), trelloBoard.get(0).getLists());
    }

    @Test
    public void mapToBoardsDtoTest() throws URISyntaxException {
        //Given

        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloBoard> trelloBoards = new ArrayList<>();

        trelloBoards.add(new TrelloBoard("test_id", "test_board", new ArrayList<>()));

        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoards);
        //When
        //Then

        assertEquals(1, trelloBoardDto.size());
        assertEquals("test_id", trelloBoardDto.get(0).getId());
        assertEquals("test_board", trelloBoardDto.get(0).getName());
        assertEquals(new ArrayList<>(), trelloBoardDto.get(0).getLists());
    }

    @Test
    public void mapToListDtoTest() throws URISyntaxException {
        //Given

        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloList> trelloLists = new ArrayList<>();

        trelloLists.add(new TrelloList("test_id", "test_board", true));

        List<TrelloListDto> trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        //When
        //Then

        assertEquals(1, trelloListDtos.size());
        assertEquals("test_id", trelloListDtos.get(0).getId());
        assertEquals("test_board", trelloListDtos.get(0).getName());
        assertEquals(true, trelloListDtos.get(0).isClosed());
    }


    @Test
    public void mapToListTest() throws URISyntaxException {
        //Given

        TrelloMapper trelloMapper = new TrelloMapper();
        List<TrelloListDto> trelloListsDto = new ArrayList<>();

        trelloListsDto.add(new TrelloListDto("test_id", "test_board", true));

        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListsDto);
        //When
        //Then

        assertEquals(1, trelloList.size());
        assertEquals("test_id", trelloList.get(0).getId());
        assertEquals("test_board", trelloList.get(0).getName());
        assertEquals(true, trelloList.get(0).isClosed());
    }
}
