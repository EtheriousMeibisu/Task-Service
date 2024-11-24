package com.lyd.TodoTMS.TodoTMS.services;

import com.lyd.TodoTMS.TodoTMS.exceptions.TaskNotFoundException;
import com.lyd.TodoTMS.TodoTMS.models.Task;
import com.lyd.TodoTMS.TodoTMS.repositories.TaskRepository;
import com.lyd.TodoTMS.TodoTMS.services.interfac.TaskServiceInter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class TaskService implements TaskServiceInter {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService){
        this.taskRepository = taskRepository;
        this.userService = userService;
    }
    @Override
    public List<Task> listAllTask(String head) {
        if (head != null) return taskRepository.findByHead(head);
        return taskRepository.findAll();
    }
    @Override
    public void save(Task task) {
        task.setAuthor(userService.findByEmail(task.getAuthor().getEmail()));
        task.setExecutor(userService.findByEmail(task.getExecutor().getEmail()));
        task.setDateTime(LocalDateTime.now());
        log.info("Saving new Task. Head: {}; Author email: {}; Executor email: {}; Date: {}", task.getHead(), task.getAuthor(), task.getExecutor(), task.getDateTime());
    }
    @Override
    public Task findById(long id) throws TaskNotFoundException {
        return taskRepository.findById(id).orElseThrow(TaskNotFoundException::new);
    }
    @Override
    public void delete(long id) {
        taskRepository.deleteById(id);
    }
    @Override
    public List<Task> findByAuthor(long id) {
        return taskRepository.findByAuthorId(id);
    }
    @Override
    public List<Task> findByExecutor(long id) {
        return taskRepository.findByExecutorId(id);
    }
}
