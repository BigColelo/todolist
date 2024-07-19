package it.bigcolelo.todolist.todolist.model;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;

    private Boolean isCompleted;

    private Instant createdAt;

    private Instant updatedAt;

    @Override
    public String toString()
    {
        return String.format("Todo list {id=%d, description= '%s', isCompleted= '%s', createdAt='%s', updateAt= '%s'}",id, description, isCompleted, createdAt, updatedAt);
    }
}
