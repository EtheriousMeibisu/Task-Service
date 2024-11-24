package com.lyd.TodoTMS.TodoTMS.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "text")
    private String text;

    @Column(name = "author")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(name = "task")
    private Task task;

    @Column(name = "creation_Date")
    private LocalDateTime dateTime;
}
