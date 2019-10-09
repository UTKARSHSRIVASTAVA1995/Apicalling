package com.example.apicalling;

import java.util.List;

public class ToDoListResponse {
    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void setToDoList(List<ToDo> toDoList) {
        this.toDoList = toDoList;
    }

    private List<ToDo> toDoList;

}
