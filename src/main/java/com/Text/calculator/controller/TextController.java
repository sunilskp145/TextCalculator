package com.Text.calculator.controller;

import com.Text.calculator.response.TextResponse;
import com.Text.calculator.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextController {
    @Autowired
    TextService textService;

    @GetMapping("textCalculator")
    public TextResponse response(@RequestParam String ftext, @RequestParam String stext){
        TextResponse response = textService.getResponse(ftext,stext);
        return response;
    }
}
