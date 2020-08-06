package com.example.todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "todoitem")
public class TodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Integer status;

    public TodoItem() {
    }

    public TodoItem(String content, Integer status) {
        this.content = content;
        this.status = status;
    }

    public TodoItem(Integer id, String content, Integer status) {
        this.id = id;
        this.content = content;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
