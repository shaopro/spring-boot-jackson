package com.github.springbootjackson.controller;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimeEnumControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Disabled
    @Test
    void save() throws Exception {
        String data = getData();
        mockMvc.perform(MockMvcRequestBuilders.post("/time").content(data))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @NotNull
    private String getData() {
        return "{\n" +
                "  \"desc\": \"desc\",\n" +
                "  \"integer\": 2,\n" +
                "  \"timeUnit\": \"NANOSECONDS\"\n" +
                "}\n";
    }
}