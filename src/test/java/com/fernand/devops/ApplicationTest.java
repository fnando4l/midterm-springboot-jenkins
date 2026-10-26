package com.fernand.devops;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTest {
    @Autowired MockMvc mvc;
    @Test void homeReturnsGreeting() throws Exception {
        mvc.perform(get("/")).andExpect(status().isOk())
            .andExpect(content().string("Hello from my Spring Boot Jenkins project!"));
    }
    @Test void healthIsUp() throws Exception {
        mvc.perform(get("/health")).andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("UP"));
    }
    @Test void missingRouteReturns404() throws Exception {
        mvc.perform(get("/missing")).andExpect(status().isNotFound());
    }
}
