package com.project.business_layer.mediator.request.query;

import com.project.business_layer.mediator.request.TRequest;

public class GetBoardsQuery implements TRequest {
    int id;

    public GetBoardsQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
