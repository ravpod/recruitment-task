package com.rafalpodgorski.decertotask.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JoinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetNumberValue() throws Exception {
        mockMvc.perform(get("/api/join"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(Matchers.isA(Number.class)));

    }
}
