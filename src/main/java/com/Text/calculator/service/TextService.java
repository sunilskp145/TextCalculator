package com.Text.calculator.service;

import com.Text.calculator.response.TextResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class TextService {
    @Value("${X-RapidAPI-Key}")
    private String apiKey;

    @Value("${X-RapidAPI-Host}")
    private String hostKey;

    @Value("${Url}")
    private String textCalculator;
    public TextResponse getResponse(String ftext,String stext){


        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host",hostKey);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<TextResponse> response = new RestTemplate().exchange(textCalculator +ftext +stext, HttpMethod.GET, entity, TextResponse.class);
        TextResponse textResponse = response.getBody();

        return textResponse;

    }
}
