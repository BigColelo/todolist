package it.bigcolelo.todolist.todolist.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bigcolelo.todolist.todolist.model.Item;
import it.bigcolelo.todolist.todolist.repositories.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public Iterable<Item> getAll()
    {
        return repo.findAll();
    }

    public Optional<Item> getById(Long id)
    {
        return repo.findById(id);
    }

    public Item save(Item item)
    {
        if(item.getId() == null)
        {
            item.setCreatedAt(Instant.now());
        }
        item.setUpdatedAt(Instant.now());

        return repo.save(item);
    }

    public void delete(Item item)
    {
        repo.delete(item);
    }
}
