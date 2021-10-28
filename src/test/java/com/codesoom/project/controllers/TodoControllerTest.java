package com.codesoom.project.controllers;

import com.codesoom.project.application.TodoService;
import com.codesoom.project.domain.Todo;
import com.codesoom.project.valueobject.TodoData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {
    private final MockMvc mvc;

    @MockBean
    private TodoService todoService;

    TodoControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @BeforeEach
    void 테스트_메소드가_실행될때_호출됩니다() {
        Todo todo = Todo.builder()
                .id(1L)
                .title("글쓰기1")
                .content("블라블라블라블라ㅏㅏㅏ")
                .build();

        given(todoService.getTodoList()).willReturn(List.of(todo));
        given(todoService.getTodo(1L)).willReturn(todo);
        given(todoService.createTodo(any(TodoData.class))).willReturn(todo);
        given(todoService.updateTodo(eq(1L), any(TodoData.class)))
                .will(
                        invocation -> {
                            Long id = invocation.getArgument(0);
                            TodoData todoData = invocation.getArgument(1);

                            return Todo.builder()
                                    .id(id)
                                    .title(todoData.getTitle())
                                    .content(todoData.getContent())
                                    .build();
                        });
    }

    @Test
    void 할일_목록_조회_요청에_응답하는가() throws Exception {
        mvc.perform(get("/tasks")).andExpect(status().isOk());
    }

    @Test
    void 할일_조회_요청에_응답하는가() throws Exception {
        mvc.perform(get("/tasks/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("글쓰기1")));
    }

    @Test
    void 할일_생성_요청에_응답하는가() throws Exception {
        mvc.perform(
                        post("/tasks")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\":\"글쓰기1\",\"content\":\"블라블라블라블라ㅏㅏㅏ\"}")
                )
                .andExpect(status().isCreated());
    }

    @Test
    void 할일_수정_요청에_응답하는가() throws Exception {
        mvc.perform(
                        patch("/tasks/1")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\"title\":\"수정\",\"content\":\"완료\"}")
                )
                .andExpect(status().isOk());
    }

    @Test
    void 할일_삭제_요청에_응답하는가() throws Exception {
        mvc.perform(delete("/tasks/1")).andExpect(status().isNoContent());
    }
}