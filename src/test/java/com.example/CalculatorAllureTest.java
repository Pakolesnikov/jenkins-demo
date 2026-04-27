package com.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("Калькулятор")
@Feature("Арифметические операции")
@DisplayName("🧮 Тесты калькулятора с Allure")
class CalculatorAllureTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        Allure.step("Создан новый экземпляр Calculator");
    }

    @Test
    @Story("Сложение")
    @Description("Проверка сложения двух положительных чисел")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("➕ Сложение 3 + 5 = 8")
    void testAddition() {
        Allure.step("Выполняем сложение 3 + 5");
        int result = calculator.add(3, 5);

        Allure.step("Проверяем результат");
        assertEquals(8, result);

        // Добавляем данные в отчёт
        Allure.addAttachment("Входные параметры", "a=3, b=5");
        Allure.addAttachment("Результат", String.valueOf(result));
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("➖ Вычитание 10 - 4 = 6")
    void testSubtraction() {
        Allure.step("Выполняем вычитание 10 - 4");
        int result = calculator.subtract(10, 4);

        Allure.step("Проверяем результат");
        assertEquals(6, result);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("✖️ Умножение 3 * 7 = 21")
    void testMultiplication() {
        Allure.step("Выполняем умножение 3 * 7");
        int result = calculator.multiply(3, 7);
        assertEquals(21, result);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("➗ Деление 10 / 2 = 5")
    void testDivision() {
        Allure.step("Выполняем деление 10 / 2");
        double result = calculator.divide(10, 2);
        assertEquals(5.0, result, 0.001);
    }

    @Test
    @Story("Деление на ноль")
    @Description("Проверка, что деление на ноль выбрасывает исключение")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("🚫 Деление на ноль → исключение")
    void testDivisionByZero() {
        Allure.step("Пытаемся разделить 10 на 0");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        Allure.step("Проверяем сообщение исключения");
        Allure.addAttachment("Сообщение исключения", exception.getMessage());

        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @Test
    @Story("Сложение с отрицательным числом")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("➕ Сложение -3 + 7 = 4")
    void testAdditionWithNegative() {
        Allure.step("Выполняем сложение -3 + 7");
        int result = calculator.add(-3, 7);
        assertEquals(4, result);
    }

    // Параметризованный тест с браузером
    @Test
    @Story("Конфигурация")
    @Description("Проверяет, что параметр браузера передаётся корректно")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("🌐 Проверка параметра browser")
    void testBrowserParameter() {
        String browser = System.getProperty("browser", "chrome");

        Allure.parameter("Браузер", browser);
        Allure.step("Запуск тестов в браузере: " + browser);

        assertNotNull(browser);
        assertFalse(browser.isEmpty());
    }
}