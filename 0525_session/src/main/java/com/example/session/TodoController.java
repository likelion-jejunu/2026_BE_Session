package com.example.session;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    // Todo 저장용 리스트
    private List<Todo> todos = new ArrayList<>();

    // 전체 Todo 조회
    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    // 새로운 Todo 추가
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {

        todos.add(todo);

        return todo;
    }
}