package com.ada.aerolinea.aerolineaAdaV1.service.impl;

import com.ada.aerolinea.aerolineaAdaV1.service.ICalculator;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class CalculatorImplTest {

    ICalculator calculator = new CalculatorImpl();

    @Test
    void sumarTest() {
        int a = 3;
        int b = 5;

        int c = calculator.suma(a, b);

        assertTrue(c > 0);
        assertEquals(c, 8);
        assertEquals(c, a + b);


    }
}
