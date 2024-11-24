package com.lyd.TodoTMS.TodoTMS.services.interfac;

import com.lyd.TodoTMS.TodoTMS.models.Task;

import java.security.Principal;
import java.util.List;

public interface TaskServiceInter {

    List<Task> listAllTask(String head);

    void save (Task task);

    Task findById(long id);

    void delete(long id);

    List<Task> findByAuthor(long id);

    List<Task> findByExecutor(long id);
}
