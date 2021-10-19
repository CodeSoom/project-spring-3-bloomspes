package com.codesoom.project.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public void changeData(String title) {
        this.title = title;
    }
}
