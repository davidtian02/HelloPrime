package com.example.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathUtilsTest {

    @Test
    public void isPrime_withPrimeNumber_shouldReturnTrue() {
        // inputs
        int number = 2;

        // execution
        boolean result = MathUtils.isPrime(number);

        // assertions
        assertTrue(result);
    }
}