package com.example.hw_testing1.controller;

import com.example.hw_testing1.exception.IllegalNumberException;
import com.example.hw_testing1.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;


    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping("/")
    public String hello(){
        return "Hello, Stranger!";
    }
    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.plus(num1, num2);
        return String.format("%d + %d = %d", num1, num2, result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.minus(num1, num2);
        return String.format("%d - %d = %d", num1, num2, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.multiply(num1, num2);
        return String.format("%d * %d = %d", num1, num2, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        int result = calculatorService.divide(num1, num2);
        return String.format("%d / %d = %d", num1, num2, result);
    }

    @ExceptionHandler(value = IllegalNumberException.class)
    public ResponseEntity<String> illegalNumberException(IllegalNumberException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<String> MissingServletRequestParameterException(){
        return ResponseEntity.badRequest().body("Введены не все параметры");
    }
}
