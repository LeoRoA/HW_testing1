package com.example.hw_testing1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/plus")
public int sum(int num1, int num2){
        return num1+num2;
    }
}
