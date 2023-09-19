package nl.timo.semester3week2demo.weapon;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

// Resources used week 3:
// spring boot testing setup structure docs: https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing.spring-boot-applications
// spring mvc testing docs: https://docs.spring.io/spring-framework/reference/testing/spring-mvc-test-framework/server.html
// -> how to perform requests: https://docs.spring.io/spring-framework/reference/testing/spring-mvc-test-framework/server-performing-requests.html
// -> how to check response: https://docs.spring.io/spring-framework/reference/testing/spring-mvc-test-framework/server-defining-expectations.html
// examples of different types of tests: https://www.baeldung.com/spring-boot-testing
// JsonPath explanation: https://github.com/json-path/JsonPath

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WeaponControllerTest {

    @Autowired
    private MockMvc webClient;

    @Test
    void Gets_all_the_weapons_from_the_arsenal_successfully() throws Exception {
        webClient.perform(
                        get("/weapons")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4))
                .andExpect(jsonPath("$.[0].name").value("axe"));

        // you could also write it as 😊
        webClient.perform(
                get("/weapons")
        ).andExpectAll(
                status().isOk(),
                jsonPath("$.length()").value(4),
                // unfortunately you cannot compare json objects in mockmvc,
                // so you have to do it like this :(
                jsonPath("$.[0].name").value("axe"));
    }
}