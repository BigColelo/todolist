package it.bigcolelo.todolist.todolist.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.bigcolelo.todolist.todolist.model.Item;
import it.bigcolelo.todolist.todolist.services.ItemService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/api/v1")
public class ToDoFormController {
    
    @Autowired
    private ItemService service;

    @GetMapping("/create-todo")
    public String showCreateForm(Item item)
    {
        
        return "itemForm";
    }

    @PostMapping("/todo")
    public String createToDoIitem(@Valid Item todoItem, BindingResult result, Model model)
    {
        Item item = new Item();
        item.setDescription(todoItem.getDescription());
        item.setIsCompleted(todoItem.getIsCompleted());

        service.save(item);

        return "redirect:/api/v1/home";
    }

    @GetMapping("/delete/{id}")
    public String deleteToDoItem(@PathVariable("id") long id, Model model)
    {
        Item item = service.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo item id: " + id + "not found"));

        service.delete(item);
        

        return "redirect:/api/v1/home";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model)
    {
        Item item = service.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo item id: " + id + "not found"));

        model.addAttribute("todo", item);
        return "editItemForm";
    }

    @PostMapping("/todo/{id}")
    public String uypdateToDoItem(@PathVariable("id") Long id, @Valid Item toDoItem, BindingResult result, Model model)
    {
        Item item = service.getById(id).orElseThrow(() -> new IllegalArgumentException("Todo item id: " + id + "not found"));

        item.setIsCompleted(toDoItem.getIsCompleted());
        item.setDescription(toDoItem.getDescription());

        service.save(item);

        return "redirect:/api/v1/home";
    }
}
