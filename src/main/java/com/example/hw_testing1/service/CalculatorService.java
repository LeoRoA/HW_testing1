package com.example.hw_testing1.service;

import com.example.hw_testing1.exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public int divide(int num1, int num2) {
        if (num2 == 0){
            throw  new IllegalNumberException("Нельзя делить на ноль");
        }
        return num1 / num2;
    }
}
