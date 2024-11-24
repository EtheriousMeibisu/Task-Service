package com.lyd.TodoTMS.TodoTMS.models;

import com.lyd.TodoTMS.TodoTMS.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_name" )
    private String userName;

    @Column(name = "email", unique = true, updatable = false)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author")
    @Column(name = "created_task")
    private List<Task> createdTask;  //созданные задачи

    @OneToMany(mappedBy = "executor")
    @Column(name = "executor_task" )
    private List<Task> executorTask; //исполняемые задачи
}
