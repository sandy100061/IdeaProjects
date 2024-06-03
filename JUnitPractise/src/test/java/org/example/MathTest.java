package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {

    Math2 math;

    @BeforeEach
    void setUp() {
        math = new Math2();
    }

    @Test
    void sqrt() {
        var actualResult = math.sqrt(25);
        var expectedResult = 5;
        assertEquals(expectedResult, actualResult);

        actualResult = math.sqrt(-25);
        assertEquals(Double.NaN, actualResult);
    }

    @Test
    void abs() {
        var actualResult = math.abs(25);
        var expectedResult = -25;
        assertEquals(expectedResult, actualResult);

        actualResult = math.abs(-25);
        expectedResult = 25;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPrime() {
        var actualResult = math.isPrime(24);
        var expectedResult = false;
        assertEquals(expectedResult, actualResult);

        actualResult = math.isPrime(5);
        expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPerfect() {
        var actualResult = math.isPerfect(6);
        var expectedResult = true;
        assertEquals(expectedResult, actualResult);

        actualResult = math.isPerfect(-25);
        expectedResult = false;
        assertEquals(expectedResult, actualResult);

        actualResult = math.isPerfect(10);
        expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void bubbleSort() {
        var actualResult = math.bubbleSort(new int[]{5,1,9,6,7,3});
        var expectedResult = new int[]{9,7,6,5,3,1};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void selectionSort() {
        var actualResult = math.selectionSort(new int[]{5,1,9,6,7,3});
        var expectedResult = new int[]{1,3,5,6,7,9};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void lastZero() {
        var actualResult = Math2.lastZero(new int[]{5,1,9,6,7,3});
        var expectedResult = -1;
        assertEquals(expectedResult, actualResult);

        actualResult = Math2.lastZero(new int[]{5,1,0,6,0,3});
        expectedResult = 4;
        assertNotEquals(expectedResult, actualResult);

        actualResult = Math2.lastZero(new int[]{5,1,1,6,0,3});
        expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countPositive() {
        var actualResult = math.countPositive(new int[]{5,1,9,6,7,3});
        var expectedResult = 6;
        assertEquals(expectedResult, actualResult);

        actualResult = math.countPositive(new int[]{5,1,-3,6,0,3,-9});
        expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}