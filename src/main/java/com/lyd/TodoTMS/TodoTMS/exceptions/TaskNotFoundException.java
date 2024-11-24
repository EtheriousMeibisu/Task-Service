package com.lyd.TodoTMS.TodoTMS.exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(){
        super("Task with this id not found");
    }
}
