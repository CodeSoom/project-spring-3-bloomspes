package com.codesoom.project.vo;

import com.github.dozermapper.core.Mapping;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class NewTask {

    private Long id;

    @NotBlank
    @Mapping("title")
    private String title;

}
