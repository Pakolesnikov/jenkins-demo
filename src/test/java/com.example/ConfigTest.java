package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ConfigTest {

    @Test
    void testBrowserFromParameter() {
        String browser = System.getProperty("browser", "chrome");
        System.out.println("==================================");
        System.out.println("🚀 Запуск тестов в браузере: " + browser);
        System.out.println("==================================");

        assertNotNull(browser);
        assertFalse(browser.isEmpty());
    }
}