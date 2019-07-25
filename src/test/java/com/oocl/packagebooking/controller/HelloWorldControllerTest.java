package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.service.HelloWorldService;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HelloWorldService helloWorldService;

    @Test
    public void should_get_message_when_add_message() throws Exception {
        // GIVEN
        MvcResult mvcResult = mockMvc.perform(post("/HelloWorld").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\n" +
                        "  \"number\": \"201907240001\",\n" +
                        "  \"name\": \"李亚娥\",\n" +
                        "  \"tel\": \"18912345678\",\n" +
                        "  \"status\": \"已预约\",\n" +
                        "  \"time\": \"2019-07-25 18:20:00\",\n" +
                        "}")).andReturn();

        // WHEN
        String helloWorld = HelloWorldController.getAllHelloWorld();
        JSONObject jsonObject = new JSONObject(helloWorld);
        String number = jsonObject.getAsString("number");
        // THEN
        Assertions.assertEquals("201907240001", number);
    }

}