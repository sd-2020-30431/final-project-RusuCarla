package com.project.business_layer.decorator.UserBoardDecorator;

import com.project.business_layer.entity.UserBoard;

public class ViewDecorator extends UserBoard {
    UserBoard userBoard;

    public ViewDecorator(UserBoard userBoard) {
        this.userBoard = userBoard;
    }

    public void viewAccess() {
        userBoard.setAccess("View");
    }
}
