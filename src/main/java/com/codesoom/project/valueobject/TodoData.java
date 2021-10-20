package com.codesoom.project.valueobject;

import com.github.dozermapper.core.Mapping;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class TodoData {
    private Long id;

    @NotBlank
    @Mapping("title")
    private String title;

    @NotBlank
    @Mapping("content")
    private String content;

    @NotBlank
    @Mapping("createdAt")
    private Date createdAt;

    @Builder
    public TodoData(Long id, String title, String content, Date createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

}
