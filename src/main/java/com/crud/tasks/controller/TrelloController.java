package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.service.TrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloService trelloService;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloService.fetchTrelloBoards();
/*        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
        List<TrelloBoardDto> list = trelloBoards.stream()
                .filter(x -> !x.getId().isEmpty() && !x.getName().isEmpty() && x.getName().contains("Kodilla"))
                .collect(Collectors.toList());
        list.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        // GET request
        trelloBoards.forEach(trelloBoardDto -> {
            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
            System.out.println("This board contains lists: ");
            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
            //trelloBoardDto.getBadges();

        });
        return trelloBoards;*/
    }


/*
    @RequestMapping(method = RequestMethod.GET, value = "getTrello")
    public void getTrello() {

36+28
        List<TrelloBoardDto> trelloBoards = trelloService.getTrelloBoards();
        trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
    }
*/

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createdTrelloCard(trelloCardDto);
    }
}