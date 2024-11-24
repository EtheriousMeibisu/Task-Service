package com.lyd.TodoTMS.TodoTMS.models;

import com.lyd.TodoTMS.TodoTMS.enums.TaskPriority;
import com.lyd.TodoTMS.TodoTMS.enums.TaskStatus;
import com.lyd.TodoTMS.TodoTMS.models.Comment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

//Каждая задача должна содержать заголовок, описание, статус ("в ожидании", "в процессе", "завершено"),
// приоритет ("высокий", "средний", "низкий")
// и комментарии, а также автора задачи и исполнителя.
@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  long id;

    @Column(name = "head")
    private String head;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status)")
    private TaskStatus taskStatus;  //Enum

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority")
    private TaskPriority taskPriority; //Enum

    @OneToMany(mappedBy = "task", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comment;

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;

    @ManyToOne
    @JoinColumn(name = "executor")
    private User executor;

    @Column(name = "creation_date")
    private LocalDateTime dateTime;
}
