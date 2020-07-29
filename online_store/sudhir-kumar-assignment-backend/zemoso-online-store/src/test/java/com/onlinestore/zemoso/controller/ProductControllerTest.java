package com.onlinestore.zemoso.controller;


import com.onlinestore.zemoso.ZemosoOnlineStoreApplication;
import com.onlinestore.zemoso.ZemosoOnlineStoreApplicationTests;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations = "/application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest extends ZemosoOnlineStoreApplicationTests {

    private WebApplicationContext webApplicationContext;
    ProductControllerTest(WebApplicationContext webApplicationContext){
        this.webApplicationContext = webApplicationContext;
    }


    private MockMvc mockMvc;
    private static String userToken;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @Order(1)
    public void checkProductList() {
        boolean isProductListisEmpty = MockMvcResultMatchers.content().equals(List.class);
        try {
            mockMvc.perform(get("/products/")).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
