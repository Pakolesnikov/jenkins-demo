package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {

    private static final Logger logger = LoggerFactory.getLogger(Calculator.class);

    public int add(int a, int b) {
        int result = a + b;
        logger.info("🔢 Сложение: {} + {} = {}", a, b, result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        logger.info("🔢 Вычитание: {} - {} = {}", a, b, result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        logger.info("🔢 Умножение: {} * {} = {}", a, b, result);
        return result;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            logger.error("❌ Попытка деления на ноль! a={}, b={}", a, b);
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        double result = (double) a / b;
        logger.info("🔢 Деление: {} / {} = {}", a, b, result);
        return result;
    }
}