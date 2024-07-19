package it.bigcolelo.todolist.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bigcolelo.todolist.todolist.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
