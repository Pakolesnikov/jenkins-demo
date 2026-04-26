package com.example;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("🧮 Calculator Tests")
class CalculatorTest {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        logger.info("✅ Создан новый экземпляр Calculator");
    }

    @Test
    @DisplayName("➕ Сложение двух положительных чисел")
    void testAddition() {
        logger.info("▶️ Запуск теста: сложение");
        int result = calculator.add(3, 5);
        assertEquals(8, result);
        logger.info("🏁 Тест сложения пройден");
    }

    @Test
    @DisplayName("➖ Вычитание")
    void testSubtraction() {
        logger.info("▶️ Запуск теста: вычитание");
        int result = calculator.subtract(10, 4);
        assertEquals(6, result);
        logger.info("🏁 Тест вычитания пройден");
    }

    @Test
    @DisplayName("✖️ Умножение")
    void testMultiplication() {
        logger.info("▶️ Запуск теста: умножение");
        int result = calculator.multiply(3, 7);
        assertEquals(21, result);
        logger.info("🏁 Тест умножения пройден");
    }

    @Test
    @DisplayName("➗ Деление")
    void testDivision() {
        logger.info("▶️ Запуск теста: деление");
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.001);
        logger.info("🏁 Тест деления пройден");
    }

    @Test
    @DisplayName("🚫 Деление на ноль — исключение")
    void testDivisionByZero() {
        logger.info("▶️ Запуск теста: деление на ноль (ожидается исключение)");
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        logger.info("🏁 Исключение успешно перехвачено");
    }

    @Test
    @DisplayName("➕ Сложение с отрицательными числами")
    void testAdditionWithNegative() {
        logger.info("▶️ Запуск теста: сложение с отрицательным числом");
        int result = calculator.add(-3, 7);
        assertEquals(4, result);
        logger.info("🏁 Тест пройден");
    }
}