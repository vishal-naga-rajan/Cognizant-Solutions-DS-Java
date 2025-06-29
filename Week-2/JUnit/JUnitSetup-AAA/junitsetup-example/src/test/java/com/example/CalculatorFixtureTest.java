package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorFixtureTest {

    private Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator(); // Arrange
        System.out.println("setUp: Calculator created");
    }
    @After
    public void tearDown() {
        calculator = null;
        System.out.println("tearDown: Calculator cleaned up");
    }

    @Test
    public void testAddition() {
        // Act
        int result = calculator.add(10, 5);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        int result = calculator.subtract(10, 5);
        assertEquals(5, result);
    }
}
