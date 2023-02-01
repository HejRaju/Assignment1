package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void getProducts() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get( "/api/v1/products")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()) .andDo(print())
                .andExpect(status().isOk());


    }
}