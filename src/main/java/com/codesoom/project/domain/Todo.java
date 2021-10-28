package com.codesoom.project.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private Date createAt;

    @Builder
    public Todo(Long id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }

    public void changeData(Todo unit) {
        this.title = unit.title;
        this.content = unit.content;
        this.createAt = unit.createAt;
    }


}
