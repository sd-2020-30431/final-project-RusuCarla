package com.project.presentation_layer.controller;

import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.query.GetBoardsHandler;
import com.project.business_layer.mediator.handler.query.GetCardsHandler;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.request.query.GetCardsQuery;
import com.project.business_layer.mediator.response.query.GetBoardsResponse;
import com.project.business_layer.mediator.response.query.GetCardsResponse;
import com.project.presentation_layer.dto.BoardDto;
import com.project.presentation_layer.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    Mediator mediator;

    @GetMapping(value = "/getCards")
    public ResponseEntity<List<CardDto>> getCards(@RequestHeader("boardId") String id) {

        GetCardsQuery getCardsQuery = new GetCardsQuery(Integer.parseInt(id));
        GetCardsHandler getCardsHandler = (GetCardsHandler) mediator.<GetCardsQuery, GetCardsResponse>getHandler(getCardsQuery);
        GetCardsResponse getCardsResponse = getCardsHandler.handle(getCardsQuery);

        return new ResponseEntity<>(getCardsResponse.getCardDtos(), HttpStatus.OK);
    }
}
