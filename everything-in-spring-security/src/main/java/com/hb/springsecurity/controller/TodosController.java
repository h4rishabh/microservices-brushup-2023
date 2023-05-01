package com.hb.springsecurity.controller;

import com.hb.springsecurity.entity.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodosController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static final List<Todo> TODO_LIST = List.of(new Todo("Learn JWT", "Tech"),
            new Todo("Learn Swimming", "Fitness"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosForASpecificUser(@PathVariable String username){
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    public void createTodosForASpecificUser(@PathVariable String username,
                                            @RequestBody Todo todo){

        logger.info("Creating {} for {}", todo, username);
        //TODO_LIST.add(todo);
    }
}
