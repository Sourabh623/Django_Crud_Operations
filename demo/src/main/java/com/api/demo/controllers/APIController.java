package com.api.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class APIController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/student")
    public String getStudent()
    {
        String jsonString = "";
        String uri = "http://127.0.0.1:8000/api/student/";
        jsonString=restTemplate.getForObject(uri, String.class);
        return jsonString;
    }
}
