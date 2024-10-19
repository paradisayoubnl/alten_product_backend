package com.alten.product.backend.controller;

import com.alten.product.backend.Application;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testProductsApis() throws Exception {
        String productJsonString = """
                {  "id": 1,           
                  "code": "code",
                  "name": "name",
                  "description": "description",
                  "image": "image",
                  "category": "category",
                  "price": 25,
                  "quantity": 3,
                  "internalReference": "internalReference",
                  "shellId": 123,
                  "inventoryStatus": "INSTOCK",
                  "rating": 5
                }
                """;
        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJsonString))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {     
                          "id": 1,         
                          "code": "code",
                          "name": "name",
                          "description": "description",
                          "image": "image",
                          "category": "category",
                          "price": 25,
                          "quantity": 3,
                          "internalReference": "internalReference",
                          "shellId": 123,
                          "inventoryStatus": "INSTOCK",
                          "rating": 5
                        }
                        """));

        mockMvc.perform(get("/products")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [{     
                          "id": 1,         
                          "code": "code",
                          "name": "name",
                          "description": "description",
                          "image": "image",
                          "category": "category",
                          "price": 25,
                          "quantity": 3,
                          "internalReference": "internalReference",
                          "shellId": 123,
                          "inventoryStatus": "INSTOCK",
                          "rating": 5
                        }]
                        """));


        mockMvc.perform(delete("/products/{id}", 1L))
                .andExpect(status().isOk());

        mockMvc.perform(get("/products")
                        .param("id", "1"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        []
                        """));

    }
}
