package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TrelloCardDto {
    private String name;
    private String description;
    private String pos;
    private String listId;
    private Badges badges;
/*
    private AttachmentsByType attachmentsByType;
    private int votes;

    Badges badges = new Badges(votes, attachmentsByType);
    private int card = badges.getAttachments().getTrello().getCard();
    private int board = badges.getAttachments().getTrello().getBoard();
*/
}
