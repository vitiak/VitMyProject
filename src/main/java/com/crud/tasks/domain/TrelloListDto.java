package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties
public class TrelloListDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("closed")
    private boolean isClosed;

    @JsonProperty("badges")
    private Badges badges;

    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

    @JsonProperty("votes")
    private String votes;

}
