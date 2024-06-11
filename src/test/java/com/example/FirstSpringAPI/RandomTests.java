package com.example.FirstSpringAPI;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomTests {
    @Test
    void testOnePlusTwo(){
        int i = 1 + 1 ;

        assert i == 2;

        assertTrue(i == 2);
    }
}
