package com.ch06.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class User1ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/user1/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("/user1/list"))
                .andDo(print());
    }

    @Test
    void register() throws Exception {
        for(int i=0 ; i<10 ; i++){

            mockMvc.perform(
                            post("/user1/register")
                                    .param("uid","a30"+i)
                                    .param("name","테스트")
                                    .param("birth","1992-03-0"+i)
                                    .param("hp","010-0301-030"+i)
                                    .param("age","2"+i)
                    )
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user1/list"))
                    .andDo(print());
        }
    }

    @Test
    void delete() throws Exception {
        for(int i=0 ; i<10 ; i++){

            mockMvc.perform(
                            get("/user1/delete")
                                    .param("uid","a30"+i)
                    )
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/user1/list"))
                    .andDo(print());
        }
    }
}