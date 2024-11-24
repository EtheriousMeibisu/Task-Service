package com.lyd.TodoTMS.TodoTMS.repositories;

import com.lyd.TodoTMS.TodoTMS.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByAuthorId(long id);

    List<Task> findByExecutorId(long id);

    List<Task> findByHead(String head);
}
