package com.example.hw_testing1;

import com.example.hw_testing1.exception.IllegalNumberException;
import com.example.hw_testing1.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {
    public final CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource ("plusTestSuites")
    public void plusTest(int num1, int num2, int result){
        Assertions.assertEquals(result, calculatorService.plus(num1, num2));
    }

    public static List<Arguments> plusTestSuites(){
        return List.of(
                Arguments.of(7,3,10),
                Arguments.of(12,15,27),
                Arguments.of(1,5,6),
                Arguments.of(11,8,19)
        );
    }
    @ParameterizedTest
    @MethodSource ("minusTestSuites")
    public void minusTest(int num1, int num2, int result){
        Assertions.assertEquals(result, calculatorService.minus(num1, num2));
    }

    public static List<Arguments> minusTestSuites(){
        return List.of(
                Arguments.of(7,3,4),
                Arguments.of(12,15,-3),
                Arguments.of(6,1,5),
                Arguments.of(11,8,3)
        );
    }

    @ParameterizedTest
    @MethodSource ("multiplyTestSuites")
    public void multiplyTest(int num1, int num2, int result){
        Assertions.assertEquals(result, calculatorService.multiply(num1, num2));
    }

    public static List<Arguments>multiplyTestSuites(){
        return List.of(
                Arguments.of(1,5,5),
                Arguments.of(11,8,88)
        );
    }

    @ParameterizedTest
    @MethodSource ("divideTestSuites")
    public void divideTest(int num1, int num2, int result){
        Assertions.assertEquals(result, calculatorService.divide(num1, num2));
    }

    public static List<Arguments>divideTestSuites(){
        return List.of(
                Arguments.of(10,5,2),
                Arguments.of(11,8,1)
        );
    }

    @Test
    public void divideByZeroThrowsException(){
        Assertions.assertThrows(IllegalNumberException.class,()-> calculatorService.divide(1,0));
    }
}
