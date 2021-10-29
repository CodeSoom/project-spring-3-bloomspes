package com.codesoom.project.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Getter
@Entity
public class Todo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Date createAt;

    @Builder
    public Todo(Long id, String title, String content, Date createAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Todo [ id = " + id +
                ", content = " + content +
                ", createAt = " + createAt +"]";
    }

    public void changeData(Todo unit) {
        this.title = unit.title;
        this.content = unit.content;
        this.createAt = unit.createAt;
    }


}
