package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MathTest {

    Math2 math;

    @BeforeEach
    void setUp() {
        math = new Math2();
    }

    //region sqrt method
    @Test
    void sqrt_PositiveNumber() {
        var actualResult = math.sqrt(25);
        var expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void sqrt_NegativeNumber() {
        var actualResult = math.sqrt(-25);
        var expectedResult = Double.NaN;
        assertEquals(expectedResult, actualResult);
    }
    //endregion

    //region abs method
    @Test
    void abs_PositiveNumber() {
        var actualResult = math.abs(25);
        var expectedResult = -25;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void abs_NegativeNumber() {
        var actualResult = math.abs(-25);
        var expectedResult = 25;
        assertEquals(expectedResult, actualResult);
    }
    //endregion

    //region isPrime method
    @Test
    void isPrime_PrimeNumber() {
        var actualResult = math.isPrime(5);
        var expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPrime_NonPrimeNumber() {
        var actualResult = math.isPrime(24);
        var expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
    //endregion

    //region isPerfect method
    @Test
    void isPerfect_PerfectNumber() {
        var actualResult = math.isPerfect(6);
        var expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPerfect_NonPerfectNumber() {
        var actualResult = math.isPerfect(10);
        var expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPerfect_NonPerfectNegativeNumber() {
        var actualResult = math.isPerfect(-25);
        var expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPerfect_PerfectNegativeZeroNumber() {
        var actualResult = math.isPerfect(-0);
        var expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }
    //endregion

    //region bubbleSort method
    @Test
    void bubbleSort_ValidArray() {
        var actualResult = math.bubbleSort(new int[]{5,1,9,6,7,3});
        var expectedResult = new int[]{9,7,6,5,3,1};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void bubbleSort_EmptyArray() {
        var actualResult = math.bubbleSort(new int[]{});
        var expectedResult = new int[]{};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void bubbleSort_NullArray() {
        var exception = assertThrows(NullPointerException.class, () -> math.bubbleSort(null));
        assertNotNull(exception);
        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
    //endregion

    //region selectionSort method
    @Test
    void selectionSort_ValidArray() {
        var actualResult = math.selectionSort(new int[]{5,1,9,6,7,3});
        var expectedResult = new int[]{1,3,5,6,7,9};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void selectionSort_EmptyArray() {
        var actualResult = math.selectionSort(new int[]{});
        var expectedResult = new int[]{};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void selectionSort_NullArray() {
        var exception = assertThrows(NullPointerException.class, () -> math.selectionSort(null));
        assertNotNull(exception);
        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
    //endregion

    //region lastZero method
    @Test
    void lastZero_NonZeroArray() {
        var actualResult = Math2.lastZero(new int[]{5,1,9,6,7,3});
        var expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastZero_SingleZeroArray() {
        var actualResult = Math2.lastZero(new int[]{5,1,1,6,0,3});
        var expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastZero_MultipleZeroArray() {
        var actualResult = Math2.lastZero(new int[]{5,1,0,6,0,3});
        var expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastZero_EmptyArray() {
        var actualResult = Math2.lastZero(new int[]{});
        var expectedResult = -1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void lastZero_NullArray() {
        var exception = assertThrows(NullPointerException.class, () -> Math2.lastZero(null));
        assertNotNull(exception);
        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
    //endregion

    //region countPositive method
    @Test
    void countPositive_OnlyPositiveNumbers() {
        var actualResult = math.countPositive(new int[]{5,1,9,6,7,3});
        var expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countPositive_WithNegativeNumbers() {
        var actualResult = math.countPositive(new int[]{5,1,-3,6,0,3,-9});
        var expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countPositive_EmptyArray() {
        var actualResult = math.countPositive(new int[]{});
        var expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void countPositive_NullArray() {
        var exception = assertThrows(NullPointerException.class, () -> math.countPositive(null));
        assertNotNull(exception);
        assertEquals("java.lang.NullPointerException", exception.getClass().getName());
    }
    //endregion
}

