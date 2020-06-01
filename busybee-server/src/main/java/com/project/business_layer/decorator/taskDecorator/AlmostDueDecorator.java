package com.project.business_layer.decorator.taskDecorator;

import com.project.business_layer.entity.Task;

import java.sql.Timestamp;

public class AlmostDueDecorator extends Task {
    private Task task;

    public AlmostDueDecorator(Task task) {
        this.task = task;
    }

    @Override
    public void setDescription(String description) {
        task.setDescription("Almost due! " + description);
    }
}
