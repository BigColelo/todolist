package it.bigcolelo.todolist.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import it.bigcolelo.todolist.todolist.services.ItemService;

@Controller
@RequestMapping("/api/v1")
public class HomeController {
    
    @Autowired
    private ItemService service;

    @GetMapping("/home")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("items", service.getAll());

        return modelAndView;
    }
}
