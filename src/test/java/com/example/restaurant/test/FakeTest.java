package com.example.restaurant.test;

import com.example.restaurant.fake.FakeController;
import com.example.restaurant.fake.FakeObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class FakeTest {

   /* @InjectMocks
    private FakeController fakeController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void fakeParams_noParams() {
        String expected = "No name";
        String result = fakeController.fakeParams("");
        assertEquals(expected, result);
    }
    @Test
    void fakeParams() {
        String expected = "toto";
        String result = fakeController.fakeParams("toto");
        assertEquals(expected, result);
    }
    @Test
    void fakeCondition() {
        String expected = "YES";
        String result = fakeController.fakeCondition(true);
        assertEquals(expected, result);
    }
    @Test
    void fakeCondition_no() {
        String expected = "NO";
        String result = fakeController.fakeCondition(false);
        assertEquals(expected, result);
    }
    @Test
    void fakePost() {
        String expected = "Fake";
        String result = fakeController.fakePost(new FakeObject("Fake"));
        assertEquals(expected, result);
    }

    @Test
    void fake() throws Exception {
        String expected = "Fake";

        mockMvc.perform(MockMvcRequestBuilders.get("/fake"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expected));

    }

    @Test
    void fakeRPost() {
        String port ="8080";
        String url = "http://localhost:" + port + "/fake";
        FakeObject fakeObject = new FakeObject("Fake");
        ResponseEntity<FakeObject> response = restTemplate.postForEntity(url, fakeObject, FakeObject.class);
        assertEquals(200, response.getStatusCode().value());
        System.out.println(response);
        assertEquals(true,true);
    }*/
}