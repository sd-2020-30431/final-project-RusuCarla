package com.project.business_layer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
public class Task implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @ManyToOne
    private Card cardFK;

    @NotNull
    private String description;

    private Timestamp due_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCardFK() {
        return cardFK;
    }

    public void setCardFK(Card cardFK) {
        this.cardFK = cardFK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDue_date() {
        return due_date;
    }

    public void setDue_date(Timestamp due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", cardFK=" + cardFK +
                ", description='" + description + '\'' +
                ", due_date=" + due_date +
                '}';
    }
}
